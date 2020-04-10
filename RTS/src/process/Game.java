package process;

import java.awt.Point;
import java.util.ArrayList;

import data.Config;
import data.GameState;
import process.managers.SelectableManager;

public class Game {
	private GameState state;
	private Camera camera;
	private boolean running = false;
	private ArrayList<SelectableManager> selectableManagers = new ArrayList<SelectableManager>();

	public Game(Config config) {
		GameLauncher launcher = new GameLauncher(config);
		state = launcher.buildGame();
		camera = new Camera(new Point(20, 40));
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

	public Camera getCamera() {
		return camera;
	}
	
}