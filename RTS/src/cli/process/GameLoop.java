package cli.process;

import cli.data.GameState;

public class GameLoop {
	private GameState state;
	private Input input;
	private boolean running;

	public GameLoop(GameState state) {
		this.state = state;
	}

	public void run() {
		while(isRunning()) {
			processInput(input);
			updateGameState();
			generateOutput();
		}
	}

	private void processInput(Input input) {
		
	}

	private void updateGameState() {

	}

	private void generateOutput() {

	}

	public boolean isRunning() {
		return running;
	}
	
	public void stop() {
		running = false;
	}

}