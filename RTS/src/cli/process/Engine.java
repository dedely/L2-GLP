package cli.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import cli.data.Constants;
import cli.data.building.Building;
import cli.data.faction.Faction;
import cli.data.unit.Unit;
import cli.data.Selectable;

public class Engine {
	
	public static void main(String args[]) {
		boolean NoErrorsCondition = true;
		boolean NoStopCondition = true;
		
		String playerFaction = Constants.UNION;
		
		HashMap<String,Faction> factionList = new HashMap<String,Faction>();
		factionList.put(Constants.PLAYER, new Faction(playerFaction,Constants.PLAYER, null, "The Union"));
		
		ArrayList<Selectable> deadSelectables = new ArrayList<Selectable>();
		
		
		
		
		while(NoErrorsCondition && NoStopCondition ) {
			
			/*inputs treatment*/
			
			/*updating the game*/
			Set<Entry<String, Faction>> factionListSet = factionList.entrySet();
			Iterator<Entry<String, Faction>> factionListIterator = factionListSet.iterator();
			
			while(factionListIterator.hasNext()) {
				Entry<String, Faction> factionEntry = factionListIterator.next();
			      for(Building currentBuilding :factionEntry.getValue().getBuildingList()) {
			    	  /*SelectableTreatment.executeNextOrder()*/
			    	  
			    	  /*if(Selectable unitattacked.isdead()){
			    	   * deadSelectables.add(unitattacked);
			    	   * }
			    	   */
			    	  
			    	  /*if(currentBuilding.isAReparationBuilding){
			    	   * healUnitsAround(currentBuilding)
			    	   */
			    	  
			    	  /*if(currentBuilding.isAnAttackBuilding){
			    	   * if(currentBuilding.getOrders().isEmpty()){
			    	   * 	Selectable closestEnnemy = SelectableTreatment.closestEnnemy();
			    	   * 	if(closestEnnemy!=null){
			    	   * 		SelectableTreatment.giveOrderReplace(currentBuilding, new AttackBuilding(closestEnnemy));
			    	   * 	}
			    	   */
			      }
			      for(Unit currentUnit :factionEntry.getValue().getUnitsList()) {
			    	  /*SelectableTreatment.executeNextOrder()*/
			    	  
			    	  /*if(Selectable unitattacked.isdead()){
			    	   * deadSelectables.add(unitattacked);
			    	   * }
			    	   * 
			    	   * Could be done perhaps via Visitor
			    	   */
			      }

			}
			
			/*generate outputs*/
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
