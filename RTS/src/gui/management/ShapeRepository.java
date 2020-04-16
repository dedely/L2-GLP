package gui.management;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import data.Selectable;

/**
 * We use this singleton to manage on-screen {@link Selectable}. They are
 * represented using {@link Shape}.
 * 
 * @author Adel
 *
 */
public class ShapeRepository {
	private HashMap<Integer, Shape> shapes = new HashMap<Integer, Shape>();

	private static ShapeRepository instance = new ShapeRepository();

	private ShapeRepository() {
	}

	public static ShapeRepository getInstance() {
		return instance;
	}

	public void addShape(Selectable selectable, Shape shape) {
		shapes.put(selectable.getId(), shape);
	}

	public void removeShape(Integer id) {
		shapes.remove(id);
	}

	/**
	 *
	 * @param point : the mouse input.
	 * @return The corresponding selectable object or null if the point isn't
	 *         included in any {@link Shape}.
	 * 
	 *         We had to iterate over entries in order to get the Selectable key.
	 */
	public Integer contains(Point2D point) {
		Integer selection = null;
		for (Entry<Integer, Shape> s : shapes.entrySet()) {
			if (s.getValue().contains(point)) {
				selection = s.getKey();
			}
		}
		return selection;
	}
	
	public ArrayList<Integer> intersection(Rectangle2D r){
		ArrayList<Integer> selection = new ArrayList<Integer>();
		for (Entry<Integer, Shape> s : shapes.entrySet()) {
			if (s.getValue().intersects(r)) {
				selection.add(s.getKey());
			}
		}
		return selection;
	}
}