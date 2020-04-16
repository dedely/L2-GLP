package gui.elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import data.Config;
import gui.management.Camera;
import process.Game;
import process.GameUtility;

/**
 * @author Adel
 *
 */
public class GameGUI extends JFrame implements Runnable {

	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(1920, 900);

	private Game game;
	private Dashboard dashboard;
	private Camera camera;

	private boolean debug = true;
	private long lastFpsCheck = 0;
	private int currentFps = 0;
	private int totalFrames = 0;

	public GameGUI(Config config) {
		super("War Never Dies");

		// We split the work in different private methods and call them in the
		// constructor.
		game = new Game();
		camera = new Camera(new Point(0, 79));
		initLayout();
		initActions();

	}

	private void initLayout() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);

		// We first display the title screen.
		dashboard = new TitleScreenTest(game);
		//dashboard = new TitleScreen(game);
		dashboard.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);

		contentPane.add(BorderLayout.CENTER, dashboard);

		// Uncomment the following instructions to make the game full screen.

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initActions() {

	}

	/**
	 * The entry point of our application.
	 */
	public void run() {

		while (!game.isStopped()) {
			GameUtility.unitTime();
			// fps counter:
			if (debug) {
				totalFrames++;
				if (System.nanoTime() > lastFpsCheck + 1000000000) {
					lastFpsCheck = System.nanoTime();
					currentFps = totalFrames;
					totalFrames = 0;
					System.out.println("FPS: " + currentFps);
				}
			}

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
		// The dashboard needs have to have the focus for key events.
		dashboard.requestFocusInWindow();
		contentPane.revalidate();
		contentPane.repaint();
	}

}