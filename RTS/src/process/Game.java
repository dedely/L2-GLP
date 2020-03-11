package process;

import data.Config;
import data.GameState;
import data.Selectable;
import data.unit.Unit;

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

	public void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}

	public void update() {
		SelectableRepository r = SelectableRepository.getInstance();

		for (Selectable selected : r.getSelectables()) {
			OrderTreatment.executeNextOrder((Unit) selected);
		}
		r.updatePosition();
	}
}