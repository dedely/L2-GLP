package gui.input;

import java.awt.Point;
import java.awt.event.MouseEvent;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.order.Attack;
import data.order.MoveToPosition;
import gui.elements.SimuPara;
import gui.management.ShapeRepository;
import process.Camera;
import process.Game;
import process.SelectableRepository;

/**
 * This class processes coordinates inputs, i.e. clicks on the map.
 * 
 * @authors Adel, Awen
 *
 */
public class CoordinatesInputManager implements InputManager {
	private Game game;
	private int button;
	private int count;
	private Point point;
	private Camera camera;
	private boolean debug = true;

	public CoordinatesInputManager(Game game) {
		this.game = game;
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
		game.deselectAll(Constants.PLAYER);
		if (selectionId != null) {
			game.select(Constants.PLAYER, selectionId);
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
		/*
		 * ShapeRepository screen = ShapeRepository.getInstance(); SelectableRepository
		 * r = SelectableRepository.getInstance();
		 * 
		 * ArrayList<Integer> selectedCollection = r.getSelected();
		 * 
		 * if (selectedCollection.size() > 0) {
		 * 
		 * Integer targetId = screen.contains(point);
		 * 
		 * if (targetId != null) { // Add ennemy check later. Attack order = new
		 * Attack(Constants.STOP_TO_SHOOT, r.getSelectable(targetId)); for (Integer
		 * selectedId : selectedCollection) {
		 * r.getSelectableManager(selectedId).giveOrder(order); }
		 * 
		 * } else { int x = (point.x / SimuPara.SCALE) + camera.getMinX(); int y =
		 * (point.y / SimuPara.SCALE) + camera.getMinY(); Coordinates coordinates = new
		 * Coordinates(x, y); MoveToPosition order = new MoveToPosition(coordinates,
		 * Constants.GO_AT_ALL_COST); for (Integer selectedId : selectedCollection) {
		 * r.getSelectableManager(selectedId).giveOrder(order); } } }
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

	public void setButton(int button) {
		this.button = button;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public void update(int button, int count, Point point, Camera camera) {
		setButton(button);
		setCount(count);
		setPoint(point);
		setCamera(camera);
	}

}