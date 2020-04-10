package process;

import java.util.ArrayList;
import java.util.HashMap;

import data.Coordinates;
import data.Selectable;
import data.map.Map;
import data.unit.Unit;
import process.executor.Executor;
import process.executor.Move;
import process.managers.SelectableManager;

/**
 * This class manages the positions of all known selectables on the map.
 * 
 * @author Adel
 *
 */

public class SelectableRepository {
	private int cpt = 0;
	
	private Executor currentExecutor = null;

	private HashMap<Integer, SelectableManager> ids = new HashMap<Integer, SelectableManager>();
	private ArrayList<Integer> selected = new ArrayList<Integer>();

	private Map map;

	/**
	 * The unique instance of the class prepared in an eager way (object created at
	 * beginning).
	 */
	private static SelectableRepository instance = new SelectableRepository();

	/**
	 * Private constructor ensuring no access from outside of the class.
	 */
	private SelectableRepository() {
	};

	/**
	 * Static method allows users to get the unique instance of the class.
	 * 
	 * @return the unique instance of the class.
	 */
	public static SelectableRepository getInstance() {
		return instance;
	}

	/**
	 * If no Selectable is registered for the given id the method returns null.
	 * 
	 * @param id
	 * @return the corresponding selectable.
	 */
	public Selectable getSelectable(Integer id) {
		Selectable selectable = null;
		if (ids.containsKey(id)) {
			selectable = ids.get(id).getSelectable();
		}
		return selectable;
	}
	
	public SelectableManager getSelectableManager(Integer id) {
		SelectableManager manager = null;
		if (ids.containsKey(id)) {
			manager = ids.get(id);
		}
		return manager;
	}

	/**
	 * @param selected is given an id and registered in the ids HashMap.
	 */
	public void register(SelectableManager manager) {
		Integer id = nextIdentity();
		manager.setId(id);
		ids.put(id, manager);
		map.add(manager.getSelectable().getPosition(), id);
	}

	/**
	 * Removes the mapping for the specified id if present.
	 * 
	 * @param id
	 */
	public void remove(Integer id) {
		Selectable selectable;
		if ((selectable = getSelectable(id)) != null) {
			map.delete(selectable.getPosition());
			ids.remove(id);
		}
	}

	public void select(Integer id) {
		if (ids.containsKey(id)) {
			ids.get(id).select();
			selected.add(id);
		}
	}

	public void deselect(Integer id) {
		if (ids.containsKey(id)) {
			ids.get(id).deselect();
		}
	}

	/**
	 * This method only deselects a {@link Selectable} if at least one selectable
	 * has been selected in the first place.
	 */
	public void deselectAll() {
		if (selected.size() > 0) {
			for (Integer id : selected) {
				deselect(id);
			}
			selected.clear();
		}
	}

	public ArrayList<Integer> getSelected() {
		return selected;
	}

	/**
	 * @return the ids
	 */
	public HashMap<Integer, SelectableManager> getIds() {
		return ids;
	}

	/**
	 * @return a new id.
	 */
	private Integer nextIdentity() {
		return ++cpt;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList<Selectable> getSelectables() {
		ArrayList<Selectable> selectables = new ArrayList<Selectable>();
		for (SelectableManager manager : ids.values()) {
			Selectable selectable = manager.getSelectable();
			if (selectable != null) {
				selectables.add(selectable);
			}
		}
		return selectables;
	}
	
	public synchronized void updatePosition(Move executor) {
		if(currentExecutor != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		currentExecutor = executor;
		Unit unit =  executor.getUnit();
		Coordinates newPosition = executor.getNewPosition();
		map.delete(unit.getPosition());
		unit.setPosition(newPosition);
		map.add(newPosition, unit.getId());
		exit();
	}
	
	public synchronized void exit() {
		currentExecutor = null;
		notifyAll();
	}

} 