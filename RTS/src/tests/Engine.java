package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import data.Constants;
import data.Coordinates;
import data.building.Building;
import data.faction.Faction;
import data.order.MoveToPosition;
import data.order.Order;
import data.unit.Unit;
import process.CoordinatesTreatment;
import process.MoveToTreatment;
import process.OrderTreatment;
import process.SelectableTreatment;
import data.Selectable;

public class Engine {

	public static void main(String args[]) {
		boolean NoErrorsCondition = true;
		boolean NoStopCondition = true;

		String playerFaction = Constants.UNION;

		HashMap<String, Faction> factionList = new HashMap<String, Faction>();
		factionList.put(Constants.PLAYER, new Faction(playerFaction, Constants.PLAYER, null, "The Union",0));

		ArrayList<Selectable> deadSelectables = new ArrayList<Selectable>();

		while (NoErrorsCondition && NoStopCondition) {

			/* inputs treatment */

			/* updating the game */
			Set<Entry<String, Faction>> factionListSet = factionList.entrySet();
			Iterator<Entry<String, Faction>> factionListIterator = factionListSet.iterator();

			while (factionListIterator.hasNext()) {
				Entry<String, Faction> factionEntry = factionListIterator.next();
				for (Building currentBuilding : factionEntry.getValue().getBuildingList()) {
					OrderTreatment.executeNextOrder(currentBuilding);

					/*
					 * if(Selectable unitattacked.isdead()){ deadSelectables.add(unitattacked); }
					 */

					/*
					 * if(currentBuilding.isAReparationBuilding){ healUnitsAround(currentBuilding)
					 */

					/*
					 * if(currentBuilding.isAnAttackBuilding){
					 * if(currentBuilding.getOrders().isEmpty()){ Selectable closestEnnemy =
					 * SelectableTreatment.closestEnnemy(); if(closestEnnemy!=null){
					 * SelectableTreatment.giveOrderReplace(currentBuilding, new
					 * AttackBuilding(closestEnnemy)); }
					 */
				}
				for (Unit currentUnit : factionEntry.getValue().getUnitsList()) {
					Order currentOrder = OrderTreatment.nextOrder(currentUnit);
					if (currentOrder == null) {
						System.out.println("no order");
					}
					else {
						Coordinates destination = null;
						Coordinates actualPosition = null;
					
						switch (currentOrder.getType()) {
					
						case Constants.MOVE_TO_POSITION_AAC:
							destination = ((MoveToPosition) currentOrder).getPosition();
							actualPosition = currentUnit.getPosition();
							if (!destination.equals(actualPosition)) {
								MoveToTreatment.moveToward(currentUnit, destination);
							} else {
								OrderTreatment.finishOrder(currentUnit);
							}
							break;
						case Constants.MOVE_TO_POSITION_STS:
							if (OrderTreatment.hasEnemyInRange(currentUnit)) {
								if (SelectableTreatment.canShoot(currentUnit,
										CoordinatesTreatment.closestEnnemySelectable(currentUnit))) {
									SelectableTreatment.dealDamage(currentUnit,
											CoordinatesTreatment.closestEnnemySelectable(currentUnit));
									currentUnit.getWeapon().setTimeLeftToReload(currentUnit.getWeapon().getTimeBeetweenShots());
								}
							} else {
								destination = ((MoveToPosition) currentOrder).getPosition();
								actualPosition = currentUnit.getPosition();
								if (!destination.equals(actualPosition)) {
									MoveToTreatment.moveToward(currentUnit, destination);
								} else
									OrderTreatment.finishOrder(currentUnit);
							}
					
						}
					}

					/*
					 * if(Selectable unitattacked.isdead()){ deadSelectables.add(unitattacked); }
					 * 
					 * Could be done perhaps via Visitor
					 */
				}

			}

			/* generate outputs */

		}

	}

}