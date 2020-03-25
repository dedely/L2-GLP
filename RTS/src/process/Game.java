package process;

import data.Config;
import data.GameState;
import data.Selectable;
import data.faction.Faction;
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
		addNewUnits();
		clearDeadUnits();
		updatePositions();
		updateResearches();
	}

	private void addNewUnits() {
		SelectableRepository.getInstance().addNewUnits();
		//System.out.println(SelectableRepository.getInstance().getNewUnits().size());
		SelectableRepository.getInstance().clearNewUnits();
	}

	private void clearDeadUnits() {
		SelectableRepository.getInstance().removeDeadUnits();

	}

	private void updatePositions() {
		SelectableRepository r = SelectableRepository.getInstance();

		for (Selectable selected : r.getSelectables()) {
			OrderTreatment.executeNextOrder(selected);
		}
		r.updatePosition();

	}

	private void updateResearches() {
		for (Faction currentFaction : state.getFactions()) {

		}

	}
}