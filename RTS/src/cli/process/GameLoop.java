package cli.process;

import cli.data.GameState;

public class GameLoop {
	private GameState state;

	public GameLoop(GameState state) {
		this.state = state;
	}

	public void run() {
		processInputs();
		updateGameState();
		generateOutputs();
	}

	private void processInputs() {

	}

	private void updateGameState() {

	}

	private void generateOutputs() {

	}
}