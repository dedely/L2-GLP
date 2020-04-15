package process;

import data.faction.Faction;
import data.tree.Research;

public class TreeTreatment {
		 	 
	  public static Boolean startResearch (Faction faction, int indice) { 
		  if (faction.getCurrentResearch() == null){ 
				  if(faction.getResearchTree().getResearches().get(indice).getLaboratoriesNumber() != 0) { 
					  if(faction.getResearchTree().getResearches().get(indice).isUnlocked() == true){
						 if (faction.getResources() != null) {
					/*	 if(faction.getResources().get(0).getResourceCount() >=faction.getResearchTree().getResearches().get(indice).getCost()) {
							  faction.getResources().get(0).setResourceCount(faction.getResources().get(1).getResourceCount()-faction.getResearchTree().getResearches().get(indice).getCost()); 
							  addCurrentResearch(faction, indice);
							  */return true;
						  //}
						 }
					  }
				 }
		  }
		return false;
	}
	 
	  public void stopResearch (Faction faction, int indice) {
		  faction.setCurrentResearch(null);
		  		  
	  }
	  
	  public static void progress (Research research) {
		  int t = research.getTimeLeft();
		  while (t != 0) {
			  t--;
		  }
	  }
	  
	  public static void doResearch (Faction faction) {
		  if (faction.getCurrentResearch() != null){ 
			  progress(faction.getCurrentResearch());
		  }
	  }
	  
	  public static void addCurrentResearch (Faction faction, int indice) {
		  faction.setCurrentResearch(faction.getResearchTree().getResearches().get(indice));
	  }
	  
}