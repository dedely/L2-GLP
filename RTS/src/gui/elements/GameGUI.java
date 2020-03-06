package gui.elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import process.input.CoordinatesInputManager;
import process.input.InputManager;

/**
 * @author Adel
 *
 */
public class GameGUI extends JFrame implements Runnable, MouseListener {
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

		//We split the work in different private methods and call them in the constructor.
		initEngine(config);
		initStyle();
		initLayout();
		initActions();

	}

	private void initEngine(Config config) {
		game = new Game(config);
		dashboard = new Dashboard(game);

	}

	private void initStyle() {
		// TODO Auto-generated method stub

	}

	private void initLayout() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(BorderLayout.CENTER, dashboard);

		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		// Uncomment the following instructions to make the game full screen.

		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setUndecorated(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initActions() {
		//We add a MouseListener to the frame.
		addMouseListener(this);
	}

	/**
	 * The entry point of a game.
	 */
	public void run() {

		int time = 0;
		game.start();
		while (game.isRunning()) {
			/*
			 * if (time >= SimuPara.SIMULATION_DURATION) { game.stop(); }
			 */

			GameUtility.unitTime();

			addTestUnits();

			dashboard.repaint();
			time++;

		}

		// We need a little more time for avoiding printing delay issue.
		GameUtility.windowRefreshTime();

	}

	/**
	 * This method is only used for testing purposes: it adds 1 unit to each faction. It will be deleted eventually.
	 */
	private void addTestUnits() {
		ArrayList<Faction> factions = game.getState().getFactions();
		Iterator<Faction> factionIterator = factions.iterator();
		SelectableRepository.getInstance().register(UnitFactory.createUnit(Constants.TEST_GROUND,
				new Coordinates(SimuPara.DEFAULT_CAMERA.getPositionX(), SimuPara.DEFAULT_CAMERA.getPositionY(), 0),
				factionIterator.next()));
		SelectableRepository.getInstance().register(UnitFactory.createUnit(Constants.TEST_GROUND,
				new Coordinates(SimuPara.SCALE, SimuPara.SCALE, 0), factionIterator.next()));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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