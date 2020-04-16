package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.NoSuchElementException;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import gui.input.AreaInputManager;
import gui.input.CoordinatesInputManager;
import gui.input.KeyInputManager;
import gui.management.Camera;
import gui.management.PaintVisitor;
import process.Game;
import process.GameUtility;
import process.SelectableRepository;

/**
 * @author Adel
 *
 */
public class GameDashboard extends Dashboard implements MouseListener, MouseMotionListener, KeyListener {

	private CoordinatesInputManager coordInput;
	private AreaInputManager areaInput;
	private KeyInputManager keyInput = new KeyInputManager();
	private ContextualMenu menu;
	private Camera camera;

	/**
	 * Showing the grid will make the debug easier.
	 */
	private boolean debugGrid = false;
	private boolean debugMouseInput = false;

	Rectangle currentRect = null;
	Rectangle rectToDraw = null;
	Rectangle previousRectDrawn = new Rectangle();

	public GameDashboard(Game game, Camera camera) {
		super(game);
		this.menu = new ContextualMenu(game);
		this.camera = camera;
		try {
			coordInput = new CoordinatesInputManager(game.getPlayer(Constants.PLAYER));
			areaInput = new AreaInputManager(game.getPlayer(Constants.PLAYER));
		} catch (NoSuchElementException nsee) {
			System.err.println(nsee.getMessage());
		}
		initLayout();
		initActions();
	}

	private void initLayout() {
		setFocusable(true);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		add(BorderLayout.SOUTH, menu);
	}

	private void initActions() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		if (debugGrid) {
			drawDebugGrid(g2);
		}
		processSelectionArea(g2);
		printMap(g2);
		printSelectables(g2);
	}

	private void processSelectionArea(Graphics2D g2) {
		if (currentRect != null) {
			g2.setXORMode(Color.white); // Color of line varies
										// depending on image colors
			g2.drawRect(rectToDraw.x, rectToDraw.y, rectToDraw.width - 1, rectToDraw.height - 1);
			areaInput.update(rectToDraw);
			areaInput.process();
			System.out.println("currentRect : " + currentRect + " rectToDrawn: " + rectToDraw);
		}
	}

	private void printMap(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

	/**
	 * It's faster to go through all the selectables and check if they're inside the
	 * viewport than check each map cell within the viewport.
	 * 
	 * @param g2
	 */
	private void printSelectables(Graphics2D g2) {
		SelectableRepository r = SelectableRepository.getInstance();
		PaintVisitor visitor = new PaintVisitor(g2, camera);
		for (Selectable selectable : r.getIds().values()) {
			if (isInBounds(selectable)) {
				selectable.accept(visitor);
			}
		}
	}

	/**
	 * @param selectable
	 * @return
	 */
	private boolean isInBounds(Selectable selectable) {
		Coordinates actualPosition = GameUtility.convert(selectable.getPosition());
		int x = actualPosition.getAbsciss();
		int y = actualPosition.getOrdinate();
		return (x >= camera.getMinX()) && (x < camera.getMaxX()) && (y >= camera.getMinY()) && (y < camera.getMaxY());
	}

	/**
	 * 
	 * @param g
	 */
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
			System.out.println("x: " + ((x / SimuPara.SCALE) + camera.getMinX()) + " y = "
					+ ((y / SimuPara.SCALE) + camera.getMinY()));
		}

		coordInput.update(button, count, point, camera);
		coordInput.process();
		menu.update();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			int x = e.getX();
			int y = e.getY();

			currentRect = new Rectangle(x, y, 0, 0);
			updateDrawableRect(getWidth(), getHeight());
			repaint();
		}
	}

	/**
	 * 
	 * @param compWidth
	 * @param compHeight
	 */
	private void updateDrawableRect(int compWidth, int compHeight) {
		int x = currentRect.x;
		int y = currentRect.y;
		int width = currentRect.width;
		int height = currentRect.height;

		// Make the width and height positive, if necessary.
		if (width < 0) {
			width = 0 - width;
			x = x - width + 1;
			if (x < 0) {
				width += x;
				x = 0;
			}
		}
		if (height < 0) {
			height = 0 - height;
			y = y - height + 1;
			if (y < 0) {
				height += y;
				y = 0;
			}
		}

		// The rectangle shouldn't extend past the drawing area.
		if ((x + width) > compWidth) {
			width = compWidth - x;
		}
		if ((y + height) > compHeight) {
			height = compHeight - y;
		}

		// Update rectToDraw after saving old value.
		if (rectToDraw != null) {
			previousRectDrawn.setBounds(rectToDraw.x, rectToDraw.y, rectToDraw.width, rectToDraw.height);
			rectToDraw.setBounds(x, y, width, height);
		} else {
			rectToDraw = new Rectangle(x, y, width, height);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setCurrentRect(null);
		setRectToDraw(null);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		updateSize(e);
	}

	private void updateSize(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		currentRect.setSize(x - currentRect.x, y - currentRect.y);
		updateDrawableRect(getWidth(), getHeight());
		Rectangle totalRepaint = rectToDraw.union(previousRectDrawn);
		repaint(totalRepaint.x, totalRepaint.y, totalRepaint.width, totalRepaint.height);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		int code = e.getKeyCode();
		keyInput.update(code, camera);
		keyInput.process();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		keyInput.update(code, camera);
		keyInput.process();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public void setCurrentRect(Rectangle currentRect) {
		this.currentRect = currentRect;
	}

	public void setRectToDraw(Rectangle rectToDraw) {
		this.rectToDraw = rectToDraw;
	}
	

}