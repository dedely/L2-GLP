package process.input;

import java.awt.geom.Point2D;

import data.Coordinates;
import data.Selectable;
import gui.management.ShapeRepository;
import process.SelectableRepository;

/**
 * @author Adel
 *
 */
public class CoordinatesInputManager implements InputManager {
	Point2D point;

	public CoordinatesInputManager(Point2D point) {
		this.point = point;
	}

	public void process() {
		ShapeRepository instance = ShapeRepository.getInstance();
		Selectable selection = instance.contains(point);
		if(selection != null) {
			Coordinates position = selection.getPosition();
			SelectableRepository r = SelectableRepository .getInstance();
			if (r.getPositions().containsKey(position)) {
				r.getPositions().get(position).setSelected(true);
				System.out.println("selected!");
			}
		}
	}
}