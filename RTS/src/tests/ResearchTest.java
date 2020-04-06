package tests;

import data.faction.Faction;
import data.tree.BinaryTree;
import data.tree.Research;
import data.tree.Upgrade;

import java.util.ArrayList;
import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.building.Building;
import data.building.Size;
import process.TreeTreatment;
import process.factory.BuildingFactory;

public class ResearchTest {
	/*public static void main (String args[]) {
	Upgrade upgrade1 = new Upgrade(Constants.SPEED, 1);
	Upgrade upgrade2 = new Upgrade (Constants.DAMAGE, 1);
	Upgrade upgrade3 = new Upgrade (Constants.HEALTH, 1);
	Research research1 = new Research("level1", 2, upgrade1, 10, 2);	
	research1.getUpgrades().add(upgrade2);
	research1.getUpgrades().add(upgrade3);
	
	Upgrade upgrade4 = new Upgrade(Constants.SPEED, 2);
	Upgrade upgrade5 = new Upgrade(Constants.HEALTH, 2);
	Upgrade upgrade6 = new Upgrade(Constants.DAMAGE, 2);
	Research research2 = new Research("level2", 2, upgrade4, 20, 2);
	research2.getUpgrades().add(upgrade5);
	research2.getUpgrades().add(upgrade6);
	
	BinaryTree binaryTree = new BinaryTree();
	HashMap<Integer, Research> researches = new HashMap<Integer, Research>();
	researches.put(0, research1);
	researches.put(1, research2);
	binaryTree.setResearches (researches);
	System.out.println(binaryTree.toString());
	
	Faction faction = new Faction(Constants.REPUBLIC, "Awen", binaryTree, "description", 0);
	System.out.println(faction.toString());
	ArrayList<Building> buildingList = new ArrayList<Building>();
		Coordinates positionLab = new Coordinates(20, 20, Constants.GROUND);
		Size sizeLab = new Size(10, 10);
		buildingList.add(BuildingFactory.createBuilding(Constants.LABORATORY, positionLab, faction, sizeLab));
	
		Coordinates positionSentry = new Coordinates (30,30, Constants.GROUND);
		Size sizeSentry = new Size(10, 10);
		buildingList.add(BuildingFactory.createBuilding(Constants.SENTRY, positionSentry, faction, sizeSentry));
		
	faction.setBuildingList(buildingList);
	faction.getResearchTree().getResearches().get(0).setUnlocked(true);
	if (TreeTreatment.startResearch(faction, 0)) {
		System.out.println("research initialized");
		TreeTreatment.doResearch(faction);
	}
	else {
		System.out.println("research didn't work");
	}
	}*/
}
