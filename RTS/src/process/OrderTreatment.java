package process;

import java.util.ArrayList;

import data.Constants;
import data.Selectable;
import data.building.Building;
import data.building.DefenseBuilding;
import data.order.Order;
import data.unit.Unit;
import data.order.Attack;
import data.order.AttackPosition;
import data.order.MoveToPosition;
import data.order.MoveToTarget;
import data.Coordinates;

public class OrderTreatment {

	public static void giveOrderReplace(Selectable orderReceiver, Order order) {
		ArrayList<Order> orderList = orderReceiver.getOrders();
		orderList.clear();
		orderList.add(order);
		orderReceiver.setOrders(orderList);

	}

	public static void giveOrderStagger(Selectable orderReceiver, Order order) {
		ArrayList<Order> newOrderList = orderReceiver.getOrders();
		newOrderList.add(order);
		orderReceiver.setOrders(newOrderList);

	}

	public static void finishOrder(Selectable orderReceiver) {
		ArrayList<Order> orderList = orderReceiver.getOrders();
		orderList.remove(0);
		//System.out.println("\norder complete\n");

	}

	public void giveOrdre(String type, Unit receiver, Selectable target) {
		switch (type) {
		case Constants.ATTACK_STS:
			giveOrderReplace(receiver, new Attack(Constants.STOP_TO_SHOOT, target));
			break;
		case Constants.ATTACK_POS_AAC:
			giveOrderReplace(receiver, new Attack(Constants.GO_AT_ALL_COST, target));
			break;
		case Constants.MOVE_TO_POSITION_STS:
			giveOrderReplace(receiver, new MoveToTarget(target, Constants.STOP_TO_SHOOT));
			break;
		case Constants.MOVE_TO_POSITION_AAC:
			giveOrderReplace(receiver, new MoveToTarget(target, Constants.GO_AT_ALL_COST));
			break;
		}
	}

	public void giveOrdre(String type, DefenseBuilding receiver, Selectable target) {
		switch (type) {
		case Constants.ATTACK_POS_AAC:
			giveOrderReplace(receiver, new Attack(Constants.GO_AT_ALL_COST, target));
		}

	}

	public void giveOrdre(String type, Unit receiver, Coordinates target) {
		switch (type) {
		case Constants.ATTACK_POS_STS:
			giveOrderReplace(receiver, new AttackPosition(Constants.STOP_TO_SHOOT, target));
			break;

		case Constants.ATTACK_POS_AAC:
			giveOrderReplace(receiver, new AttackPosition(Constants.GO_AT_ALL_COST, target));
			break;

		case Constants.MOVE_TO_POSITION_STS:
			giveOrderReplace(receiver, new MoveToPosition(target, Constants.STOP_TO_SHOOT));
			break;

		case Constants.MOVE_TO_POSITION_AAC:
			giveOrderReplace(receiver, new MoveToPosition(target, Constants.GO_AT_ALL_COST));
			break;

		}

	}

	public static void executeNextOrder(Unit executor) {
		Order currentOrder = nextOrder(executor);
		if (currentOrder == null) {
			//System.out.println("no order");
		}
		else {
			Coordinates destination = null;
			Coordinates actualPosition = null;

			switch (currentOrder.getType()) {

			case Constants.MOVE_TO_POSITION_AAC:
				destination = ((MoveToPosition) currentOrder).getPosition();
				actualPosition = executor.getPosition();
				if (!destination.equals(actualPosition)) {
					MoveToTreatment.moveToward(executor, destination);
				} else {
					finishOrder(executor);
				}
				break;
			case Constants.MOVE_TO_POSITION_STS:
				if (hasEnemyInRange(executor)) {
					if (SelectableTreatment.canShoot(executor,
							CoordinatesTreatment.closestEnnemySelectable(executor))) {
						SelectableTreatment.dealDamage(executor,
								CoordinatesTreatment.closestEnnemySelectable(executor));
						executor.getWeapon().setTimeLeftToReload(executor.getWeapon().getTimeBeetweenShots());
					}
				} else {
					destination = ((MoveToPosition) currentOrder).getPosition();
					actualPosition = executor.getPosition();
					if (!destination.equals(actualPosition)) {
						MoveToTreatment.moveToward(executor, destination);
					} else
						finishOrder(executor);
				}

			}
		}

	}

	public static boolean hasEnemyInRange(Unit unit) {
		if (CoordinatesTreatment.closestEnnemySelectable(unit) != null) {
			return true;
		} else
			return false;

	}

	public static Order nextOrder(Selectable orderReceiver) {
		if (!orderReceiver.getOrders().isEmpty()) {
			return orderReceiver.getOrders().get(0);
		} else
			return null;
	}

	public static void executeNextOrder(Building currentBuilding) {
		// TODO Auto-generated method stub

	}

}
