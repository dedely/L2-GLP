package gui.management;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map.Entry;

import data.Selectable;

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
	
	public Selectable contains(Point2D point) {
		Selectable selection = null;
		for(Entry<Selectable, Shape> s: shapes.entrySet()) {
			if(s.getValue().contains(point)) {
				selection = s.getKey();
			}
		}
		return selection;
	}
}