package process;

import java.util.ArrayList;

import org.hamcrest.core.IsInstanceOf;

import data.Constants;
import data.Selectable;
import data.building.Building;
import data.building.DefenseBuilding;
import data.order.Order;
import data.unit.Unit;
import process.factory.UnitFactory;
import data.order.Attack;
import data.order.AttackPosition;
import data.order.CreateUnit;
import data.order.Embark;
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
		// System.out.println("\norder complete\n");

	}

	/*
	 * public void giveOrdre(String type, Unit receiver, Selectable target) {
		SelectableRepository repository = SelectableRepository.getInstance();
		switch (type) {
		case Constants.ATTACK_STS:
			giveOrderReplace(receiver,
					new Attack(Constants.STOP_TO_SHOOT, repository.getSelectable(target.getPosition())));
			break;
		case Constants.ATTACK_POS_AAC:
			giveOrderReplace(receiver,
					new Attack(Constants.GO_AT_ALL_COST, repository.getSelectable(target.getPosition())));
			break;
		case Constants.MOVE_TO_POSITION_STS:
			giveOrderReplace(receiver, new MoveToTarget(target, Constants.STOP_TO_SHOOT));
			break;
		case Constants.MOVE_TO_POSITION_AAC:
			giveOrderReplace(receiver, new MoveToTarget(target, Constants.GO_AT_ALL_COST));
			break;
		case Constants.EMBARK_STS:
			giveOrderReplace(receiver, new Embark(target, Constants.STOP_TO_SHOOT));
			break;
		case Constants.EMBARK_AAC:
			giveOrderReplace(receiver, new Embark(target, Constants.GO_AT_ALL_COST));
			break;
		}
	}*/

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
			// System.out.println("no order");
		} else {
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
			case Constants.MOVE_TO_TARGET_AAC:
				destination = ((MoveToPosition) currentOrder).getPosition();
				actualPosition = executor.getPosition();
				if (!destination.equals(actualPosition)) {
					MoveToTreatment.moveToward(executor, destination);
				} else {
					finishOrder(executor);
				}
				break;
			case Constants.MOVE_TO_TARGET_STS:
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
					} else {
						finishOrder(executor);
					}

				}
				break;
			case Constants.ATTACK_STS:

				Selectable target = ((Attack) currentOrder).getTarget();
				if (target != null) {
					if (target.getCurrentHealth() > 0) {

						AttackTreatment.attack(executor, target);
					}
				} else {
					System.out.println("unit is null");
					finishOrder(executor);
				}
			}
		}
	}

	public static boolean hasEnemyInRange(Unit unit) {
		if (CoordinatesTreatment.closestEnnemySelectable(unit) != null) {
			return true;
		} else {
			return false;
		}
	}

	public static Order nextOrder(Selectable orderReceiver) {
		if (!orderReceiver.getOrders().isEmpty()) {
			return orderReceiver.getOrders().get(0);
		} else {
			return null;
		}
	}

	public static void executeNextOrder(Building currentBuilding) {
		Order currentOrder = nextOrder(currentBuilding);
		if (currentOrder == null) {
			// System.out.println("no order");
		} else {
			//System.out.println("exec building");
			Coordinates destination = null;
			Coordinates actualPosition = null;

			switch (currentOrder.getType()) {
			case Constants.CREATE_UNIT:
				try{
					CreateUnit createOrder=((CreateUnit) currentOrder);
					int timeLeft=createOrder.getTimeUntilConstructed();
					if(timeLeft>0) {
					((CreateUnit) currentOrder).setTimeUntilConstructed(timeLeft-1);
					}
					else{
						System.out.println("creating unit!");
						String unitType=createOrder.getUnitToCreate();
						Coordinates spawnPoint = createOrder.getPosition();
						Unit newUnit = UnitFactory.createUnit(unitType,spawnPoint, currentBuilding.getFaction());
						MoveToPosition move = new MoveToPosition(new Coordinates(300, 300, 0), Constants.GO_AT_ALL_COST); 
						OrderTreatment.giveOrderStagger(newUnit, move);
						SelectableRepository.getInstance().addNewUnit(newUnit);
						currentBuilding.getFaction().getUnitsList().add(newUnit);
						finishOrder(currentBuilding);
					}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				

			}

		}
	}
		public static void executeNextOrder(Selectable selectable) {
			if (selectable instanceof Building) {
				executeNextOrder((Building)selectable);	
			}
			else {
				executeNextOrder((Unit)selectable);	
			}
		}
		


}
