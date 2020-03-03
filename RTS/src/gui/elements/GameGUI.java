package gui.elements;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import data.Config;
import process.Game;
import process.GameUtility;

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
		int time = 0;

		while (game.isRunning()) {
			GameUtility.unitTime();

			dashboard.repaint();
			time++;
		}

		// We need a little more time for avoiding printing delay issue.
		GameUtility.windowRefreshTime();

	}
}