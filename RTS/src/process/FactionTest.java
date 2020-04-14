package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import data.Player;
import data.resource.Resource;
import process.managers.ResearchManager;
import process.managers.SelectableManager;

public class FactionTest {

	private String player;
	private String name;
	private HashMap<String, Resource> resources = new HashMap<String, Resource>();
	private ResearchManager researcher = null;
	private HashMap<Integer, SelectableManager> managers = new HashMap<Integer, SelectableManager>();
	private ArrayList<Integer> selection = new ArrayList<Integer>();

	public FactionTest(Player player) {
		this.player = player.getName();
		this.name = player.getFactionName();
	}

	public void update() {
		for (SelectableManager manager : managers.values()) {
			manager.update();
		}
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
}