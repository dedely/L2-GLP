package gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.HashMap;

import javax.swing.JPanel;
import data.Coordinates;
import data.Selectable;
import gui.input.CoordinatesInputManager;
import gui.input.InputManager;
import gui.management.PaintVisitor;
import process.Game;
import process.SelectableRepository;

/**
 * @author Adel
 *
 */
public class Dashboard extends JPanel implements MouseListener {

	private InputManager input;
	private Game game;

	/**
	 * Showing the grid will make the debug easier.
	 */
	private boolean debugGrid = true;
	private boolean debugMouseInput = true;

	public Dashboard(Game game) {
		this.game = game;
		setPreferredSize(new Dimension(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		if (debugGrid) {
			drawDebugGrid(g2);
		}

		printMap(g2);
		printSelectables(g2);
	}

	private void printMap(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method will be updated later, as we add camera support.
	 * 
	 * @param g2
	 */
	private void printSelectables(Graphics2D g2) {

		HashMap<Coordinates, Selectable> positions = SelectableRepository.getInstance().getPositions();
		PaintVisitor visitor = new PaintVisitor(g2, SimuPara.DEFAULT_CAMERA);
		for (Selectable selectable : positions.values()) {
			selectable.accept(visitor);
		}

	}

	public void drawDebugGrid(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.GRAY);

		for (int i = SimuPara.SCALE; i <= width; i += SimuPara.SCALE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = SimuPara.SCALE; i <= height; i += SimuPara.SCALE) {
			g.drawLine(1, i, width, i);
		}
	}

	/**
	 * This method provides the {@link CoordinatesInputManager} with the necessary
	 * information to process a mouse click.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int count = e.getClickCount();
		double x = e.getX();
		double y = e.getY();
		Point2D point = new Point2D.Double(x, y);
		int button = e.getButton();
		if (debugMouseInput) {
			System.out.println(point.toString());
			System.out.println("Mouse button: " + button);
			System.out.println("Click count: " + count);
		}
		input = new CoordinatesInputManager(button, count, point);
		input.process();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}