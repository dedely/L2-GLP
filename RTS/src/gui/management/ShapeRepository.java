package gui.management;

import java.awt.Shape;
import java.awt.geom.Point2D;
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
	private HashMap<Selectable, Shape> shapes = new HashMap<Selectable, Shape>();

	private static ShapeRepository instance = new ShapeRepository();

	private ShapeRepository() {
	}

	public static ShapeRepository getInstance() {
		return instance;
	}

	public void addShape(Selectable selectable, Shape shape) {
		shapes.put(selectable, shape);
	}

	public void removeShape(Selectable selectable) {
		shapes.remove(selectable);
	}

	/**
	 *
	 * @param point : the mouse input.
	 * @return The corresponding selectable object or null if the point isn't
	 *         included in any {@link Shape}.
	 * 
	 *         We had to iterate over entries in order to get the Selectable key.
	 */
	public Selectable contains(Point2D point) {
		Selectable selection = null;
		for (Entry<Selectable, Shape> s : shapes.entrySet()) {
			if (s.getValue().contains(point)) {
				selection = s.getKey();
			}
		}
		return selection;
	}
}