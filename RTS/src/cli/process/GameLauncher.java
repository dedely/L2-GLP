package cli.process;

import cli.data.GameState;
import cli.data.map.Map;
import cli.process.builder.MapBuilder;
import cli.tests.input.InputParameter;

public class GameLauncher {
	
	
	public void buildGame() {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		GameState state = new GameState(map);
	}
	
}