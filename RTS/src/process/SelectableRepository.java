package process;

import java.util.ArrayList;
import java.util.HashMap;

import data.Coordinates;
import data.Selectable;
import data.map.Map;
import data.map.Tile;

/**
 * This class manages the positions of all known selectables on the map.
 * 
 * @author Adel
 *
 */

public class SelectableRepository {
	private int cpt = 0;

	private HashMap<Integer, Selectable> ids = new HashMap<Integer, Selectable>();
	private ArrayList<Integer> deadSelectables = new ArrayList<Integer>();
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
			selectable = ids.get(id);
		}
		return selectable;
	}

	/**
	 * @param selected is given an id and registered in the ids HashMap.
	 */
	public void register(Selectable selectable) {
		Integer id = nextIdentity();
		selectable.setId(id);
		ids.put(id, selectable);
		Coordinates pixelPosition = selectable.getPosition();
		Coordinates actualPosition = GameUtility.convert(pixelPosition);
		map.add(actualPosition, id);
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
			ids.get(id).setSelected(true);
		}
	}

	public void deselect(Integer id) {
		if (ids.containsKey(id)) {
			ids.get(id).setSelected(false);
		}
	}

	/**
	 * @return the ids
	 */
	public HashMap<Integer, Selectable> getIds() {
		return ids;
	}

	/**
	 * @return a new id.
	 */
	private Integer nextIdentity() {
		return ++cpt;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void addDeadUnit(Integer id) {
		deadSelectables.add(id);
	}

	public ArrayList<Integer> getDeadSelectables() {
		return deadSelectables;
	}

	public void clearDead() {
		deadSelectables.clear();
	}

	public Integer getIdByPosition(Coordinates position) {
		Integer id = null;
		try {
			Tile tile = map.getTile(position.getAbsciss(), position.getOrdinate());
			if (position.getHeight() == 0) {
				id = tile.getGroundId();
			}
			if (position.getHeight() == 1) {
				id = tile.getAirId();
			}
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		}
		return id;
	}

	public void updatePosition(Integer id, Coordinates position, Coordinates newPosition) {
		map.delete(position);
		map.add(newPosition, id);
	}

}