package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import data.Constants;
import data.building.Building;
import data.faction.Faction;
import data.unit.Unit;
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
					OrderTreatment.executeNextOrder(currentUnit);

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