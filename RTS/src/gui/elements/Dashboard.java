package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JPanel;
import data.Selectable;
import gui.elements.menu.ContextualMenu;
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
	private ContextualMenu menu;

	/**
	 * Showing the grid will make the debug easier.
	 */
	private boolean debugGrid = true;
	private boolean debugMouseInput = true;

	public Dashboard(Game game) {
		this.game = game;
		this.menu = new ContextualMenu();
		setBackground(Color.WHITE);
		addMouseListener(this);

		setLayout(new BorderLayout());
		add(BorderLayout.SOUTH, menu);
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
		SelectableRepository r = SelectableRepository.getInstance();
		PaintVisitor visitor = new PaintVisitor(g2, SimuPara.DEFAULT_CAMERA);
		// System.out.println(positions.values().size());
		for (Selectable selectable : r.getSelectables()) {
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
		int x = e.getX();
		int y = e.getY();
		Point point = new Point(x, y);
		int button = e.getButton();
		if (debugMouseInput) {
			System.out.println(point.toString());
			System.out.println("Mouse button: " + button);
			System.out.println("Click count: " + count);
			System.out.println("x: " + x / 24 + " y: " + y / 24);
		}

		input = new CoordinatesInputManager(button, count, point);
		input.process();
		menu.update();
	}

	@Override
	public void mousePressed(MouseEvent e) {
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