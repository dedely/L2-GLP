package process;

import data.Constants;
import data.building.ResearchBuilding;
import data.faction.Faction;
import data.tree.BinaryTree;

public class TreeTreatment {
		/*
		 * 
		 */
		 public Boolean startResearch (Faction faction, int indice) {
		  if (faction.getCurrentResearch().equals(false)){
			  for(int i = 0 ; i < faction.getBuildingList().size(); i++) {
				  if (faction.getBuildingList().get(i).getName() == Constants.LABORATORY ) {
					  if (faction.getResearchTree().getResearches().get(indice).isUnlocked() == true) {
						 if(faction.getResources().get(1).getResourceCount() >= faction.getResearchTree().getResearches().get(indice).getCost()) {
							 faction.getResources().get(1).setResourceCount(faction.getResources().get(1).getResourceCount()-faction.getResearchTree().getResearches().get(indice).getCost());
							 faction.setCurrentResearch(true);
							// Lance le timer.
					  }
					  }
				  }
		  	}
		  }
		  }
	}
