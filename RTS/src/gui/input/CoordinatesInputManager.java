package gui.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.order.MoveToPosition;
import gui.management.ShapeRepository;
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
	private Point point;
	private boolean debug = true;

	public CoordinatesInputManager(int button, int count, Point point) {
		this.button = button;
		this.count = count;
		this.point = point;
	}

	@Override
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
		Integer selectionId = screen.contains(point);
		// Only 1 shape can be selected using a simple click.
		r.deselectAll();
		if (selectionId != null) {
			r.select(selectionId);
		}

		// Prints debug messages in the console.
		if (debug) {
			if (selectionId != null) {
				System.out.println("selected!");
			} else {
				System.out.println("deselected!");

			}
		}
	}

	private void processRightClick() {
		ShapeRepository screen = ShapeRepository.getInstance();
		SelectableRepository r = SelectableRepository.getInstance();

		ArrayList<Integer> selectedCollection = r.getSelected();

		if (selectedCollection.size() > 0) {
			int x = point.x / 24;
			int y = point.y / 24;
			Coordinates coordinates = new Coordinates(x, y);
			MoveToPosition order = new MoveToPosition(coordinates, Constants.GO_AT_ALL_COST);
			for (Integer selectedId : selectedCollection) {
				r.getSelectableManager(selectedId).giveOrder(order);
			}
		}

		// Integer targetId = screen.contains(point);
		/*
		 * if (targetId != null) { ArrayList<Selectable> selectedCollection =
		 * r.getSelected(); if (SelectableTreatment.areUnits(selectedCollection)) { if
		 * (!target.getFaction().equals(selectedCollection.get(0).getFaction())) {
		 * Attack order = new Attack(Constants.STOP_TO_SHOOT,
		 * r.getSelectable(target.getPosition())); for (Selectable selected :
		 * selectedCollection) { OrderTreatment.giveOrderReplace(selected, order); } }
		 * else if (SelectableTreatment.isEmbarkable(target)) { Attack order = new
		 * Attack(Constants.STOP_TO_SHOOT, r.getSelectable(target.getPosition())); for
		 * (Selectable selected : selectedCollection) {
		 * OrderTreatment.giveOrderReplace(selected, order); } }
		 * 
		 * } } else { ArrayList<Selectable> selectedCollection = r.getSelected();
		 * Coordinates coordinates = new Coordinates((int) point.getX(), (int)
		 * point.getY()); MoveToPosition order = new MoveToPosition(coordinates,
		 * Constants.GO_AT_ALL_COST); for (Selectable selected : selectedCollection) {
		 * OrderTreatment.giveOrderReplace(selected, order); } }
		 */

	}

	public int getButton() {
		return button;
	}

	public int getCount() {
		return count;
	}

	public Point getPoint() {
		return point;
	}

}