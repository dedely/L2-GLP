package gui.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.order.Attack;
import data.order.MoveToPosition;
import gui.elements.SimuPara;
import gui.management.Camera;
import gui.management.ShapeRepository;
import process.Faction;
import process.repository.SelectableRepository;

/**
 * This class processes coordinates inputs, i.e. clicks on the map.
 * 
 * @authors Adel, Awen
 *
 */
public class CoordinatesInputManager implements InputManager {
	private Faction player;
	private int button;
	private int count;
	private Point point;
	private Camera camera;
	private boolean debug = false;

	public CoordinatesInputManager(Faction player) {
		this.player = player;
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
		Integer selectionId = screen.contains(point);
		// Only 1 shape can be selected using a simple click.
		player.deselectAll();
		if (selectionId != null) {
			player.select(selectionId);
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
		
		ArrayList<Integer> selectedCollection = player.getSelection();

		if (selectedCollection.size() > 0) {

			Integer targetId = screen.contains(point);

			if (targetId != null) { // Add ennemy check later.
				Attack order = new Attack(Constants.STOP_TO_SHOOT, r.getSelectable(targetId));
				for (Integer selectedId : selectedCollection) {
					try {
						player.getSelectableManager(selectedId).giveOrder(order);
					} catch (NoSuchElementException nsee) {
						System.err.println(nsee.getMessage());
					}
				}

			} else {
				int x = point.x + camera.getMinX() * SimuPara.SCALE;
				int y = point.y + camera.getMinY() * SimuPara.SCALE;
				Coordinates coordinates = new Coordinates(x, y);
				MoveToPosition order = new MoveToPosition(coordinates, Constants.GO_AT_ALL_COST);
				for (Integer selectedId : selectedCollection) {
					try {
						player.getSelectableManager(selectedId).giveOrder(order);
					} catch (NoSuchElementException nsee) {
						System.err.println(nsee.getMessage());
					}
					
				}
			}
		}

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

	/**
	 * We do not need to create a new CoordinatesInputManager every time, just update it.
	 * @param button
	 * @param count
	 * @param point
	 * @param camera
	 */
	public void update(int button, int count, Point point, Camera camera) {
		setButton(button);
		setCount(count);
		setPoint(point);
		setCamera(camera);
	}

}