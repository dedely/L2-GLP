package cli.process;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import cli.data.Constants;
import cli.data.faction.Faction;

public class Engine {
	
	public static void main(String args[]) {
		boolean NoErrorsCondition = true;
		boolean NoStopCondition = true;
		
		String playerFaction = Constants.UNION;
		
		HashMap<String,Faction> factionList = new HashMap<String,Faction>();
		factionList.put(Constants.PLAYER, new Faction(playerFaction,Constants.PLAYER, null, "The Union"));
		
		while(NoErrorsCondition && NoStopCondition ) {
			
			/*inputs treatment*/
			
			/*updating the game*/
			Set<Entry<String, Faction>> factionListSet = factionList.entrySet();
			Iterator<Entry<String, Faction>> factionListIterator = factionListSet.iterator();
			
			while(factionListIterator.hasNext()) {
				Entry<String, Faction> factionEntry = factionListIterator.next();
			       System.out.println("Key is: "+factionEntry.getKey() + 
			       " & " + 
			       " value is: "+factionEntry.getValue().getPlayerName());
			}
			
			/*generate outputs*/
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
