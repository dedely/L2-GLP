package cli.data.faction;

import java.util.ArrayList;

import cli.data.Description;
import cli.data.building.Building;
import cli.data.resource.Resource;
import cli.data.tree.ResearchTree;
import cli.data.unit.Unit;

/**
 * The class representing a side, either the player or the AI
 * 
 * @author Awen
 *
 */
public class Faction {

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
	private ResearchTree researchTree;

	/**
	 * The resources that the faction possesses
	 */
	private ArrayList<Resource> resources;

	/**
	 * The description of the faction
	 */
	private Description description;

	public Faction(ArrayList<Building> buildingList, ArrayList<Unit> unitsList, ResearchTree researchTree,
			ArrayList<Resource> resources, Description description) {
		super();
		this.buildingList = buildingList;
		this.unitsList = unitsList;
		this.researchTree = researchTree;
		this.resources = resources;
		this.description = description;
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

	public ResearchTree getResearchTree() {
		return researchTree;
	}

	public void setResearchTree(ResearchTree researchTree) {
		this.researchTree = researchTree;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

}
