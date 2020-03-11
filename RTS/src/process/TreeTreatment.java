package process;

import data.faction.Faction;
import data.tree.Research;

public class TreeTreatment {
		 	 
	  public Boolean startResearch (Faction faction, int indice) { 
		  if (! faction.getCurrentResearch().equals(null)){ 
			  for(int i = 0 ; i <faction.getBuildingList().size(); i++) { 
				  if(faction.getResearchTree().getResearches().get(indice).getLaboratoriesNumber() != 0) { 
					  if(faction.getResearchTree().getResearches().get(indice).isUnlocked() == true){
						  if(faction.getResources().get(1).getResourceCount() >=faction.getResearchTree().getResearches().get(indice).getCost()) {
							  faction.getResources().get(1).setResourceCount(faction.getResources().get(1).getResourceCount()-faction.getResearchTree().getResearches().get(indice).getCost()); 
							  addCurrentResearch(faction, indice);
							  return true;
						  }
					  }
				  }
			  }
		}
		return false;
	}
	 
	  public void stopResearch (Faction faction, int indice) {
		  faction.setCurrentResearch(null);
		  		  
	  }
	  
	  public void progress (Research research) {
		  int t = research.getTimeLeft();
		  while (t != 0) {
			  t--;
		  }
	  }
	  
	  public void doResearch (Faction faction) {
		  if (! faction.getCurrentResearch().equals(null)){ 
			  progress(faction.getCurrentResearch());
		  }
	  }
	  
	  public void addCurrentResearch (Faction faction, int indice) {
		  faction.setCurrentResearch(faction.getResearchTree().getResearches().get(indice));
	  }
	  
}