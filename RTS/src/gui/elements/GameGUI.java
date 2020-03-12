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
import data.unit.Unit;
import process.Game;
import process.GameUtility;
import process.SelectableRepository;
import process.factory.UnitFactory;

/**
 * @author Adel
 *
 */
public class GameGUI extends JFrame implements Runnable {

	private Game game;
	private Dashboard dashboard;
	private ContextualPanel contextPanel;

	/**
	 * To create the game frame, we need to specify the game configuration.
	 * 
	 * @param config the config the user chose for the game (i.e. his faction, the
	 *               AI's faction, the difficulty level...) The user will later be
	 *               able to create the config using a graphical interface.
	 */
	public GameGUI(Config config) {
		super("War Never Dies");

		// We split the work in different private methods and call them in the
		// constructor.
		initEngine(config);
		initStyle();
		initLayout();
		initActions();

	}

	private void initEngine(Config config) {
		game = new Game(config);
		dashboard = new Dashboard(game);
		contextPanel = new ContextualPanel();
		addTestUnits();
	}

	private void initStyle() {
		// TODO Auto-generated method stub

	}

	private void initLayout() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(BorderLayout.CENTER, dashboard);
		contentPane.add(BorderLayout.SOUTH, contextPanel);

		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		// Uncomment the following instructions to make the game full screen.

		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setUndecorated(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initActions() {
	}

	/**
	 * The entry point of a game.
	 */
	public void run() {
		long startTime = 0, endTime = 0, timeElapsed = 0;
		// int time = 0;

		game.start();
		int loopNumber = 0;
		while (game.isRunning()) {
			loopNumber++;
			startTime = System.nanoTime();
			GameUtility.unitTime();

			game.update();
			System.out.println("loop no " + loopNumber);
			dashboard.repaint();
			// time++;

			// We need a little more time for avoiding printing delay issue.
			GameUtility.windowRefreshTime();

			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			// System.out.println("Execution time in miliseconds : " + timeElapsed/1000000);
		}

	}

	/**
	 * This method is only used for testing purposes: it adds 1 unit to each
	 * faction. It will be deleted eventually.
	 */
	private void addTestUnits() {
		ArrayList<Faction> factions = game.getState().getFactions();
		Iterator<Faction> factionIterator = factions.iterator();
		SelectableRepository r = SelectableRepository.getInstance();
		Unit playerUnit = UnitFactory.createUnit(Constants.TEST_GROUND,
				new Coordinates(SimuPara.DEFAULT_CAMERA.getPositionX(), SimuPara.DEFAULT_CAMERA.getPositionY(), 0),
				factionIterator.next());
		r.register(playerUnit);
		r.addSelectable(playerUnit);
		Unit aiUnit = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(SimuPara.SCALE, SimuPara.SCALE, 0),
				factionIterator.next());
		r.register(aiUnit);
		r.addSelectable(aiUnit);
	}
}