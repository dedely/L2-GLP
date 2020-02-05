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

	private String name;

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

	private ArrayList<Faction> allies = new ArrayList<Faction>();

	private ArrayList<Faction> ennemies = new ArrayList<Faction>();

	public Faction(String name, ArrayList<Building> buildingList, ArrayList<Unit> unitsList, ResearchTree researchTree,
			ArrayList<Resource> resources, Description description) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Faction> getAllies() {
		return allies;
	}

	public void setAllies(ArrayList<Faction> allies) {
		this.allies = allies;
	}

	public ArrayList<Faction> getEnnemies() {
		return ennemies;
	}

	public void setEnnemies(ArrayList<Faction> ennemies) {
		this.ennemies = ennemies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		return true;
	}

}
