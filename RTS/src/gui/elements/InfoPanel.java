package gui.elements;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import data.Constants;
import process.Faction;
import process.Game;

/**
 * @author Adel
 *
 */
public class InfoPanel extends JPanel {

	private Game game;

	private ContextualMenu menu;
	private JPanel generalPanel;
	//private ResearchOverview researchPanel;
	private ResourcePanel resourcePanel;

	public InfoPanel(Game game) {
		this.game = game;
		init();
	}

	private void init() {
		setLayout(new GridLayout(1, 2));
		menu = new ContextualMenu(game.getPlayer(Constants.PLAYER));
		add(menu);
		
		generalPanel = new JPanel();
		generalPanel.setLayout(new GridLayout(1, 2));
		
		Faction player = game.getPlayer(Constants.PLAYER);
		resourcePanel = new ResourcePanel(player);
		//researchPanel = new ResearchOverview(player.getResearcher());
		//generalPanel.add(researchPanel);
	}

	public void update() {
		menu.update();
		resourcePanel.updateValues();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}