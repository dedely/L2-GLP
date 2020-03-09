package process.input;

import java.awt.geom.Point2D;

import data.Coordinates;
import data.Selectable;
import gui.management.ShapeRepository;
import process.SelectableRepository;

/**
 * This class processes coordinates inputs, i.e. clicks on the map.
 * 
 * @author Adel
 *
 */
public class CoordinatesInputManager implements InputManager {
	Point2D point;
	private boolean debug = true;

	public CoordinatesInputManager(Point2D point) {
		this.point = point;
	}

	/**
	 * This method changes the selected attribute of {@link Selectable} to true if
	 * the user clicked on its shape. If not, all the {@link Selectable} are
	 * deselected.
	 */
	public void process() {
		ShapeRepository screen = ShapeRepository.getInstance();
		SelectableRepository r = SelectableRepository.getInstance();
		Selectable selection = screen.contains(point);
		if (selection != null) {
			Coordinates position = selection.getPosition();
			r.select(position);
		} else {
			r.deselectAll();
		}

		// Prints debug messages in the console.
		if (debug) {
			if (selection != null) {
				System.out.println("selected!");
			} else {
				System.out.println("deselected!");

			}
		}
	}
}