package process;

import java.util.ArrayList;

import data.Config;
import data.GameState;
import data.Selectable;
import process.managers.SelectableManager;

public class Game {
	private GameState state;
	private boolean running = false;
	private ArrayList<SelectableManager> selectableManagers = new ArrayList<SelectableManager>();

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

	public void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}

	public void update() {

	}


	private void updatePositions() {


	}
}