package data.faction;

import java.util.ArrayList;

import data.building.Building;
import data.resource.Resource;
import data.tree.BinaryTree;
import data.tree.Research;
import data.unit.Unit;

/**
 * The class representing a side, either the player or the AI
 * 
 * @author Awen
 *
 */
public class Faction {

	private String name;

	private String playerName;

	/**
	 * the list of buildings belonging to the faction
	 */
	private ArrayList<Building> buildingList = new ArrayList<Building>();

	/**
	 * the list of units belonging to the faction
	 */
	private ArrayList<Unit> unitsList = new ArrayList<Unit>();

	/**
	 * the research tree specific to the faction
	 */
	private BinaryTree researchTree;

	/**
	 * The resources that the faction possesses
	 */
	private ArrayList<Resource> resources = new ArrayList<Resource>();

	/**
	 * The description of the faction
	 */
	private String description;

	private Research currentResearch;
	
	private int Team;

	public Faction(String name, String playerName, BinaryTree researchTree, String description, int Team) {
		super();
		this.name = name;
		this.playerName = playerName;
		this.researchTree = researchTree;
		this.description = description;
		currentResearch = null;
	}

	public ArrayList<Building> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(ArrayList<Building> buildingList) {
		this.buildingList = buildingList;
	}

	public ArrayList<Unit> getUnitsList() {
		return unitsList;
	}

	public void setUnitsList(ArrayList<Unit> unitsList) {
		this.unitsList = unitsList;
	}

	public BinaryTree getResearchTree() {
		return researchTree;
	}

	public void setResearchTree(BinaryTree researchTree) {
		this.researchTree = researchTree;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Research getCurrentResearch() {
		return currentResearch;
	}

	public void setCurrentResearch(Research currentResearch) {
		this.currentResearch = currentResearch;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public int getTeam() {
		return Team;
	}

	public void setTeam(int team) {
		Team = team;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faction other = (Faction) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Faction [name=" + name + ", playerName=" + playerName + ", buildingList=" + buildingList
				+ ", unitsList=" + unitsList + ", researchTree=" + researchTree + ", resources=" + resources
				+ ", description=" + description + ", currentResearch=" + currentResearch + ", Team=" + Team + "]";
	}
	
}
