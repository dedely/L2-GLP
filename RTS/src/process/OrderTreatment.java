package cli.process;

import java.util.ArrayList;

import cli.data.Constants;
import cli.data.Selectable;
import cli.data.building.Building;
import cli.data.building.DefenseBuilding;
import cli.data.order.Order;
import cli.data.unit.Unit;
import cli.data.order.Attack;
import cli.data.order.AttackPosition;
import cli.data.order.MoveToPosition;
import cli.data.order.MoveToTarget;
import cli.data.Coordinates;

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

	}

	public void giveOrdre(String type, Unit receiver, Selectable target) {
		if (type == Constants.ATTACK_STS) {
			giveOrderReplace(receiver, new Attack(Constants.STOP_TO_SHOOT, target));
		}
		if (type == Constants.ATTACK_POS_AAC) {
			giveOrderReplace(receiver, new Attack(Constants.GO_AT_ALL_COST, target));
		}
		if (type == Constants.MOVE_TO_POSITION_STS) {
			giveOrderReplace(receiver, new MoveToTarget(target, Constants.STOP_TO_SHOOT));
		}
		if (type == Constants.MOVE_TO_POSITION_AAC) {
			giveOrderReplace(receiver, new MoveToTarget(target, Constants.GO_AT_ALL_COST));
		}
	}

	public void giveOrdre(String type, DefenseBuilding receiver, Selectable target) {
		if (type == Constants.ATTACK_POS_AAC) {
			giveOrderReplace(receiver, new Attack(Constants.GO_AT_ALL_COST, target));
		}

	}

	public void giveOrdre(String type, Unit receiver, Coordinates target) {
		if (type == Constants.ATTACK_POS_STS) {
			giveOrderReplace(receiver, new AttackPosition(Constants.STOP_TO_SHOOT, target));
		}
		if (type == Constants.ATTACK_POS_AAC) {
			giveOrderReplace(receiver, new AttackPosition(Constants.GO_AT_ALL_COST, target));
		}
		if (type == Constants.MOVE_TO_POSITION_STS) {
			giveOrderReplace(receiver, new MoveToPosition(target, Constants.STOP_TO_SHOOT));
		}
		if (type == Constants.MOVE_TO_POSITION_AAC) {
			giveOrderReplace(receiver, new MoveToPosition(target, Constants.GO_AT_ALL_COST));
		}

	}

	public static void executeNextOrder(Unit executor) {
		Order currentOrder = nextOrder(executor);
		if (currentOrder != null) {
			if (currentOrder.getType() == Constants.MOVE_TO_POSITION_AAC) {
				Coordinates destination = ((MoveToPosition) currentOrder).getPosition();
				Coordinates actualPosition = executor.getPosition();
				if (!destination.equals(actualPosition)) {
					MoveToTreatment.moveToward(executor, destination);
				} else
					finishOrder(executor);
			} else if (currentOrder.getType() == Constants.MOVE_TO_POSITION_STS) {
				if (hasEnemyInRange(executor)) {
					if (SelectableTreatment.canShoot(executor,
							CoordinatesTreatment.closestEnnemySelectable(executor))) {
						SelectableTreatment.dealDamage(executor,
								CoordinatesTreatment.closestEnnemySelectable(executor));
						executor.getWeapon().setTimeLeftToReload(executor.getWeapon().getTimeBeetweenShots());
					}
				} else {
					Coordinates destination = ((MoveToPosition) currentOrder).getPosition();
					Coordinates actualPosition = executor.getPosition();
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
