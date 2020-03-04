package gui.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JPanel;

import data.Coordinates;
import data.Selectable;
import gui.management.PaintVisitor;
import process.Game;
import process.SelectableRepository;

/**
 * @author Adel
 *
 */
public class Dashboard extends JPanel {
	private Game game;

	/**
	 * Showing the grid will make the debug easier.
	 */
	private boolean debugGrid = true;

	public Dashboard(Game game) {
		this.game = game;
		setBackground(Color.WHITE);

	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
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

	private void printSelectables(Graphics2D g2) {
		HashMap<Coordinates, Selectable> positions = SelectableRepository.getInstance().getPositions();
		PaintVisitor visitor = new PaintVisitor(g2, SimuPara.DEFAULT_CAMERA);
		for (Selectable selectable : positions.values()) {
			selectable.accept(visitor);
		}
	}

	private void drawDebugGrid(Graphics g) {
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
}