package cli.process;

import java.util.HashMap;

import cli.data.Coordinates;
import cli.data.Selectable;

/**
 * @author Adel
 *
 */

public class SelectableRepository {
	private HashMap<Coordinates, Selectable> positions = new HashMap<Coordinates, Selectable>();

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
	 * If no Selectable is registered for the given position the method returns
	 * null.
	 * 
	 * @param position
	 * @return the current Selectable at a given position.
	 */
	public Selectable getSelectable(Coordinates position) {
		if (positions.containsKey(position)) {
			return positions.get(position);
		} else {
			return null;
		}
	}
}