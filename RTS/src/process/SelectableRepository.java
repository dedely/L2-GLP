package process;

import java.util.ArrayList;
import java.util.HashMap;

import data.Coordinates;
import data.Selectable;
import data.unit.Unit;

/**
 * This class manages the positions of all known selectables on the map.
 * 
 * @author Adel
 *
 */

public class SelectableRepository {
	private HashMap<Coordinates, Selectable> positions = new HashMap<Coordinates, Selectable>();
	private ArrayList<Selectable> selected = new ArrayList<Selectable>();
	private ArrayList<Selectable> selectables = new ArrayList<Selectable>();

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

	public ArrayList<Selectable> getSelectables() {
		return selectables;
	}

	public HashMap<Coordinates, Selectable> getPositions() {
		return positions;
	}

	/**
	 * @param selected
	 */
	public void register(Selectable selected) {
		positions.put(selected.getPosition(), selected);
	}

	/**
	 * Removes the mapping for the specified position if present.
	 * 
	 * @param position
	 */
	public void remove(Coordinates position) {
		positions.remove(position);
	}

	/**
	 * This method updates the position of a selectable.
	 * 
	 * @param selected
	 * @param newPosition
	 */
	public void updatePosition(Selectable selected, Coordinates newPosition) {
		remove(selected.getPosition());
		selected.setPosition(newPosition);
		register(selected);
	}

	public void select(Coordinates position) {
		if (positions.containsKey(position)) {
			Selectable selectable = positions.get(position);
			selectable.setSelected(true);
			addSelected(selectable);
		}
	}

	private void addSelected(Selectable selectable) {
		selected.add(selectable);
	}

	public void addSelectable(Selectable selectable) {
		selectables.add(selectable);
	}

	/**
	 * This method only deselects a {@link Selectable} if at least one selectable
	 * has been selected in the first place.
	 */
	public void deselectAll() {
		if (selected.size() > 0) {
			for (Selectable selectable : positions.values()) {
				removeSelected(selectable);
				selectable.setSelected(false);
			}
		}
	}

	private void removeSelected(Selectable selectable) {
		selected.remove(selectable);
	}

	/**
	 * If no Selectable is registered for the given position the method returns
	 * null.
	 * 
	 * @param position
	 * @return the current selectable at a given position.
	 */
	public Selectable getSelectable(Coordinates position) {
		if (positions.containsKey(position)) {
			return positions.get(position);
		} else {
			return null;
		}
	}

	public ArrayList<Selectable> getSelected() {
		return selected;
	}

	/**
	 * We use this method for debug purposes.
	 * 
	 * @param position
	 * @return true if a selectable is registered at the given position.
	 */
	public boolean exists(Coordinates position) {
		return positions.containsKey(position);
	}

	public void updatePosition() {
		positions.clear();
		for (Selectable selected : selectables) {
			register(selected);
		}
	}

}