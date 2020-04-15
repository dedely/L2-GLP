package gui.elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import data.Config;
import gui.input.InputManager;
import gui.input.KeyInputManager;
import process.Camera;
import process.Game;
import process.GameUtility;

/**
 * @author Adel
 *
 */
public class GameGUI extends JFrame implements Runnable, KeyListener {

	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(1920, 900);

	private Game game;
	private Dashboard dashboard;
	private Camera camera;

	private InputManager input;
	
	private boolean debug = true;
	private long lastFpsCheck = 0;
	private int currentFps = 0;
	private int totalFrames = 0;

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
		game = new Game();
		initStyle();
		initLayout();
		initActions();

	}

	private void initStyle() {
		// TODO Auto-generated method stub

	}

	private void initLayout() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		camera = new Camera(new Point(0, 79));
		
		// We first display the title screen.
		dashboard = new TitleScreen(game);
		dashboard.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);

		contentPane.add(BorderLayout.CENTER, dashboard);


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
	 * The entry point of our application.
	 */
	public void run() {

		while (!game.isStopped()) {
			//fps counter:
			if(debug) {
				totalFrames++;
				if(System.nanoTime() > lastFpsCheck + 1000000000) {
					lastFpsCheck = System.nanoTime();
					currentFps = totalFrames;
					totalFrames = 0;
					System.out.println("FPS: " + currentFps);
				}
			}
			GameUtility.unitTime();

			if (game.isReady()) {
				updateLayout();
				game.run();
			}

			if (game.isRunning()) {
				game.update();
				dashboard.repaint();
			}

		}

		// We need a little more time for avoiding printing delay issue.
		GameUtility.windowRefreshTime();

	}

	private void updateLayout() {
		Container contentPane = getContentPane();
		contentPane.removeAll();
		dashboard = new GameDashboard(game, camera);
		contentPane.add(BorderLayout.CENTER, dashboard);
		contentPane.revalidate();
		contentPane.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		input = new KeyInputManager(code, camera);
		input.process();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}