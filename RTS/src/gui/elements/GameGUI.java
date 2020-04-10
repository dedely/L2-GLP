package gui.elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import data.Config;
import data.Constants;
import data.Coordinates;
import data.building.UnitBuilding;
import data.faction.Faction;
import data.unit.Unit;
import gui.input.InputManager;
import gui.input.KeyInputManager;
import process.Game;
import process.GameUtility;
import process.SelectableRepository;
import process.factory.BuildingFactory;
import process.factory.UnitFactory;
import process.managers.BuildingManager;
import process.managers.UnitManager;

/**
 * @author Adel
 *
 */
public class GameGUI extends JFrame implements Runnable, KeyListener {

	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(1920, 900);
	// private static final Dimension IDEAL_MENU_DIMENSION = new Dimension(1920,
	// 180);

	private Game game;
	private Dashboard dashboard;
	// private ContextualMenu menu;
	
	private InputManager input;

	/**
	 * 
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
		// menu = new ContextualMenu();
		addTestUnits();
		addTestBuildings();
	}

	private void initStyle() {
		// TODO Auto-generated method stub

	}

	private void initLayout() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		dashboard.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
		// menu.setPreferredSize(IDEAL_MENU_DIMENSION);
		contentPane.add(BorderLayout.CENTER, dashboard);
		// contentPane.add(BorderLayout.SOUTH, menu);

		// Uncomment the following instructions to make the game full screen.

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initActions() {
		addKeyListener(this);
	}

	/**
	 * The entry point of a game.
	 */
	public void run() {
		// long startTime = 0, endTime = 0;

		game.start();
		// int loopNumber = 0;
		while (game.isRunning()) {
			// loopNumber++;
			// startTime = System.nanoTime();
			GameUtility.unitTime();

			game.update();
			// menu.update();
			// System.out.println(SelectableRepository.getInstance().getPositions().values().size());

			dashboard.repaint();
			// endTime = System.nanoTime();
			// long timeElapsed = endTime - startTime;
			// System.out.println("Execution time in miliseconds : " + timeElapsed /
			// 1000000);
		}

		// We need a little more time for avoiding printing delay issue.
		GameUtility.windowRefreshTime();

	}

	/**
	 * This method is only used for testing purposes: it adds 1 unit to each
	 * faction. It will be deleted eventually.
	 */
	private void addTestUnits() {
		ArrayList<Faction> factions = game.getState().getFactions();
		Iterator<Faction> factionIterator = factions.iterator();
		SelectableRepository r = SelectableRepository.getInstance();
		Faction currentFaction = factionIterator.next();
		Unit playerUnit = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(40, 22, 0), currentFaction);
		UnitManager manager = new UnitManager(playerUnit);
		r.register(manager);
		manager.start();

		Unit aiUnit = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(SimuPara.SCALE, SimuPara.SCALE, 0),
				factionIterator.next());
		UnitManager managerAI = new UnitManager(aiUnit);
		r.register(managerAI);
		managerAI.start();

	}

	private void addTestBuildings() {
		ArrayList<Faction> factions = game.getState().getFactions();
		Iterator<Faction> factionIterator = factions.iterator();
		SelectableRepository r = SelectableRepository.getInstance();
		Faction currentFaction = factionIterator.next();
		UnitBuilding playerHQ = BuildingFactory.createHeadQuaters(new Coordinates(38, 38, 0), currentFaction);
		BuildingManager manager = new BuildingManager(playerHQ);
		r.register(manager);
		manager.start();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		input = new KeyInputManager(code, game.getCamera());
		input.process();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}