package gui.input;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.order.Attack;
import data.order.MoveToPosition;
import gui.management.ShapeRepository;
import process.OrderTreatment;
import process.SelectableRepository;

/**
 * This class processes coordinates inputs, i.e. clicks on the map.
 * 
 * @author Adel
 *
 */
public class CoordinatesInputManager implements InputManager {
	private int button;
	private int count;
	private Point2D point;
	private boolean debug = false;

	public CoordinatesInputManager(int button, int count, Point2D point) {
		this.button = button;
		this.count = count;
		this.point = point;
	}

	public void process() {
		switch (button) {
		case MouseEvent.BUTTON1:
			processLeftClick();
			break;

		case MouseEvent.BUTTON3:
			processRightClick();
			break;
		default:
			System.err.println("button not recognized");
		}
	}

	/**
	 * This method changes the selected attribute of {@link Selectable} to true if
	 * the user clicked on its shape. If not, all the {@link Selectable} are
	 * deselected.
	 */
	private void processLeftClick() {
		ShapeRepository screen = ShapeRepository.getInstance();
		SelectableRepository r = SelectableRepository.getInstance();
		Selectable selection = screen.contains(point);
		// Only 1 shape can be selected using the a simple click.
		r.deselectAll();
		if (selection != null) {
			Coordinates position = selection.getPosition();
			r.select(position);
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

	private void processRightClick() {
		ShapeRepository screen = ShapeRepository.getInstance();
		SelectableRepository r = SelectableRepository.getInstance();
		Selectable target = screen.contains(point);
		if (target != null) {
			ArrayList<Selectable> selectedCollection = r.getSelected();
			Attack order = new Attack(Constants.STOP_TO_SHOOT, r.getSelectable(target.getPosition()));
			for (Selectable selected : selectedCollection) {
				OrderTreatment.giveOrderReplace(selected, order);
			}
			
		}else {
			ArrayList<Selectable> selectedCollection = r.getSelected();
			Coordinates coordinates = new Coordinates((int)point.getX(), (int)point.getY());
			MoveToPosition order = new MoveToPosition(coordinates, Constants.GO_AT_ALL_COST);
			for(Selectable selected: selectedCollection) {
				OrderTreatment.giveOrderReplace(selected, order);
			}
		}
		
	}

	public int getButton() {
		return button;
	}

	public int getCount() {
		return count;
	}

	public Point2D getPoint() {
		return point;
	}

}