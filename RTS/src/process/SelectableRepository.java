package process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import data.Coordinates;
import data.Selectable;


/**
 * This class manages the positions of all known selectables on the map.
 * 
 * @author Adel
 *
 */

public class SelectableRepository {
	private int cpt = 0;
	/**
	 * We don't want to be manipulating {@link Selectable} too much which is why
	 * we'll use ids instead.
	 */
	private HashMap<Integer, Selectable> ids = new HashMap<Integer, Selectable>();
	private HashMap<Coordinates, Selectable> positions = new HashMap<Coordinates, Selectable>();

	private HashMap<Coordinates, Integer> idsByPosition = new HashMap<Coordinates, Integer>();

	private ArrayList<Integer> selected = new ArrayList<Integer>();
	private ArrayList<Selectable> selectables = new ArrayList<Selectable>();
	private ArrayList<Selectable> deadUnits = new ArrayList<Selectable>();
	private ArrayList<Selectable> newUnits = new ArrayList<Selectable>();

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

	public Collection<Selectable> getSelectables() {
		return ids.values();
	}

	public HashMap<Coordinates, Selectable> getPositions() {
		return positions;
	}

	public HashMap<Coordinates, Integer> getIdsByPosition() {
		return idsByPosition;
	}

	public ArrayList<Integer> getSelectedIds() {
		return selected;
	}

	/**
	 * @return A collection of all the selected {@link Selectable}
	 */
	public ArrayList<Selectable> getSelected() {
		ArrayList<Selectable> selectedCollection = new ArrayList<Selectable>();
		for (Integer id : selected) {
			Selectable selectable = ids.get(id);
			if (selectable != null) {
				selectedCollection.add(selectable);
			}
		}
		return selectedCollection;
	}

	/**
	 * @param selected is given an id and registered in the ids HashMap.
	 */
	public void register(Selectable selected) {
		Integer id = nextIdentity();
		selected.setId(id);
		ids.put(id, selected);
	}

	/**
	 * Removes the mapping for the specified id if present.
	 * 
	 * @param id
	 */
	public void remove(Integer id) {
		ids.remove(id);
	}

	public void select(Integer id) {
		if (ids.containsKey(id)) {
			ids.get(id).setSelected(true);
			selected.add(id);
		}
	}

	public void deselect(Integer id) {
		if (ids.containsKey(id)) {
			ids.get(id).setSelected(false);
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

	/**
	 * If no Selectable is registered for the given id the method returns null.
	 * 
	 * @param id
	 * @return the corresponding selectable.
	 */
	public Selectable getSelectable(Integer id) {
		Selectable selectable = null;
		if (ids.containsKey(id)) {
			selectable = ids.get(id);
		}
		return selectable;
	}

	/**
	 * @return a new id.
	 */
	private Integer nextIdentity() {
		return ++cpt;
	}

	public void updatePosition() {

	}

	public ArrayList<Selectable> getDeadUnits() {
		return deadUnits;
	}

	public void addDeadUnits(Selectable deadUnit) {
		deadUnits.add(deadUnit);

	}

	public void removeDeadUnits() {
		for (Selectable unitToRemove : instance.getDeadUnits()) {
			System.out.println("unit " + unitToRemove.getName() + " is dead and should be removed");
			instance.getSelectables().remove(unitToRemove);
			unitToRemove.getFaction().getUnitsList().remove(unitToRemove);
			unitToRemove = null;

		}
		instance.getDeadUnits().clear();

	}

	public void addNewUnit(Selectable selectable) {
		newUnits.add(selectable);
	}

	public void addNewUnits() {
		for (Selectable newSelectable : newUnits) {
			register(newSelectable);
			addSelectable(newSelectable);
		}
		clearNewUnits();
	}

	public void addSelectable(Selectable newSelectable) {
		selectables.add(newSelectable);
	}

	public void clearNewUnits() {
		newUnits.clear();
	}

	public ArrayList<Selectable> getNewUnits() {
		return newUnits;
	}

}