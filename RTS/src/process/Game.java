package process;

import data.Config;
import data.GameState;

public class Game {
	private GameState state;
	private boolean running;

	public Game(Config config) {
		GameLauncher launcher = new GameLauncher(config);
		state = launcher.buildGame();
	}

	public GameState getState() {
		return state;
	}

	public boolean isRunning() {
		return running;
	}

	public void stop() {
		running = false;
	}
}