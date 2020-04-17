package gui.elements;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import data.Constants;
import process.Game;

/**
 * @author Adel
 *
 */
public class InfoPanel extends JPanel {

	private Game game;

	private ContextualMenu menu;
	private ResearchOverview researchPanel;

	public InfoPanel(Game game) {
		this.game = game;
		init();
	}

	private void init() {
		setLayout(new GridLayout(1, 2));
		menu = new ContextualMenu(game.getPlayer(Constants.PLAYER));
		add(menu);
		researchPanel = new ResearchOverview(game.getPlayer(Constants.PLAYER).getResearcher());
		add(researchPanel);
	}

	public void update() {
		menu.update();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}