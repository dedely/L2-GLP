package cli.process;

import cli.data.GameState;

public class GameLoop {
	private GameState state;

	public GameLoop(GameState state) {
		this.state = state;
	}

	private void processInputs() {

	}

	private void updateGameState() {
		state.notifyObservers();
	}

	private void generateOutputs() {

	}

	public void loop() {
		processInputs();
		updateGameState();
		generateOutputs();
	}

}