package gui.elements;

import javax.swing.JPanel;

import process.Game;

public abstract class Dashboard extends JPanel{

	private Game game;

	public Dashboard(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

}