package cli.process;

import cli.data.Config;
import cli.data.GameState;
import cli.data.Player;
import cli.data.map.Map;
import cli.process.builder.MapBuilder;
import cli.process.factory.FactionFactory;
import cli.tests.input.InputParameter;

/**
 * This class is responsible for building a GameState using the provided Config information.
 * 
 * @author Adel
 * 
 */
public class GameLauncher {

	private Config config;

	public GameLauncher(Config config) {
		this.config = config;
	}

	/**
	 * @return the constructed GameState.
	 */
	public GameState buildGame() {
		GameState state = new GameState();

		initMap(state);
		initFactions(state);
		// We'll add a initDifficulty(state) method once the AI is supported.

		return state;
	}

	private void initFactions(GameState state) {
		for (Player player : config.getPlayers()) {
			state.addFaction(FactionFactory.createFaction(player.getFactionName(), player.getName(),0));
		}

	}

	private void initMap(GameState state) {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		state.setMap(map);
	}

}