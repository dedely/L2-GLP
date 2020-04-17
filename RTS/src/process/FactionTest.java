package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import data.Constants;
import data.Cost;
import data.Player;
import data.Resource;
import process.managers.ResearchManager;
import process.managers.SelectableManager;
import process.repository.SelectableRepository;

public class FactionTest {

	private String player;
	private String name;
	private HashMap<String, Resource> resources = new HashMap<String, Resource>();
	private ResearchManager researcher = null;
	private HashMap<Integer, SelectableManager> managers = new HashMap<Integer, SelectableManager>();
	private ArrayList<Integer> selection = new ArrayList<Integer>();
	private HashMap<String, Cost> costs = new HashMap<String, Cost>();
	private HashMap<Integer, SelectableManager> newManagers = new HashMap<Integer, SelectableManager>();
	private Factory factory;

	private int buildings;

	public FactionTest(Player player) {
		this.player = player.getName();
		this.name = player.getFactionName();
	}

	public void update() {
		addAllNew();
		for (SelectableManager manager : managers.values()) {
			manager.update();
		}
	}

	private void addAllNew() {
		managers.putAll(newManagers);
		newManagers.clear();
	}

	public ArrayList<Integer> getSelection() {
		return selection;
	}

	public void setSelection(ArrayList<Integer> selection) {
		this.selection = selection;
	}

	public String getPlayer() {
		return player;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, Resource> getResources() {
		return resources;
	}

	public HashMap<Integer, SelectableManager> getManagers() {
		return managers;
	}

	public void addResource(Resource resource) {
		if (resource != null) {
			resources.put(resource.getType(), resource);
		}
	}

	public void addSelectableManager(SelectableManager manager) {
		if (manager != null) {
			managers.put(manager.getSelectableId(), manager);
		}
	}

	public void removeSelectableManager(Integer id) {
		if (managers.containsKey(id)) {
			managers.remove(id);
		}
	}

	public SelectableManager getSelectableManager(Integer id) throws NoSuchElementException {
		if (managers.containsKey(id)) {
			return managers.get(id);
		} else {
			throw new NoSuchElementException("Manager of id: " + id + " does not exist!");
		}
	}

	public void select(Integer id) {
		if (managers.containsKey(id)) {
			SelectableRepository r = SelectableRepository.getInstance();
			r.select(id);
			selection.add(id);
		}
	}

	public void deselectAll() {
		if (selection.size() > 0) {
			SelectableRepository r = SelectableRepository.getInstance();
			for (Integer id : selection) {
				r.deselect(id);
			}
			selection.clear();
		}
	}

	public HashMap<String, Cost> getCosts() {
		return costs;
	}

	public void setCosts(HashMap<String, Cost> costs) {
		this.costs = costs;
	}

	public Cost getCost(String name) throws NoSuchElementException {
		Cost cost = null;
		if (costs.containsKey(name)) {
			cost = costs.get(name);
		}
		if (cost != null) {
			return cost;
		} else {
			throw new NoSuchElementException("Undefined cost for " + name);
		}
	}

	public void updateResource(String name, int value) {
		if (resources.containsKey(name)) {
			resources.get(name).setResourceCount(value);
		}
	}

	public Resource getResource(String name) throws NoSuchElementException {
		Resource resource = null;
		if (resources.containsKey(name)) {
			resource = resources.get(name);
		}
		if (resource != null) {
			return resource;
		} else {
			throw new NoSuchElementException("Resource " + name + " does not exist!");
		}
	}

	public void addNew(SelectableManager manager) {
		if (manager != null) {
			newManagers.put(manager.getSelectableId(), manager);
		}
	}

	public void clearNew() {
		newManagers.clear();
	}

	public int getBuildings() {
		return buildings;
	}

	public void setBuildings(int buildings) {
		this.buildings = buildings;
	}

	public ResearchManager getResearcher() {
		return researcher;
	}

	public void setResearcher(ResearchManager researcher) {
		this.researcher = researcher;
	}

}