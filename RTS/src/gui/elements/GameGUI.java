package gui.elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import data.Config;
import data.Constants;
import data.Coordinates;
import data.faction.Faction;
import process.Game;
import process.GameUtility;
import process.SelectableRepository;
import process.factory.UnitFactory;

/**
 * @author Adel
 *
 */
public class GameGUI extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private Game game;
	private Dashboard dashboard;

	/**
	 * To create the game frame, we need to specify the game configuration.
	 * 
	 * @param config the config the user chose for the game (i.e. his faction, the
	 *               AI's faction, the difficulty level...) The user will later be
	 *               able to create the config using a graphical interface.
	 */
	public GameGUI(Config config) {
		super("War Never Dies");
		game = new Game(config);
		dashboard = new Dashboard(game);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(BorderLayout.CENTER, dashboard);

		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * The entry point of a game.
	 */
	public void run() {
		//System.out.println("VRAI");
		
		//int time = 0;
		//game.start();
		dashboard.repaint();
		/*
		 * while (game.isRunning()) {
		 * 
		 * if (time >= SimuPara.SIMULATION_DURATION) { game.stop(); }
		 * 
		 * GameUtility.unitTime();
		 * 
		 * 
		 * ArrayList<Faction> factions = game.getState().getFactions();
		 * Iterator<Faction> factionIterator = factions.iterator();
		 * SelectableRepository.getInstance().register(
		 * UnitFactory.create(Constants.TEST_GROUND, new Coordinates(0, 0, 0),
		 * factionIterator.next()));
		 * 
		 * dashboard.repaint(); time++;
		 * 
		 * }
		 */

		// We need a little more time for avoiding printing delay issue.
		//GameUtility.windowRefreshTime();

	}
}