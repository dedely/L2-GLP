package cli.process;

import java.util.ArrayList;

import cli.data.Config;
import cli.data.Constants;
import cli.data.GameState;
import cli.data.faction.Faction;
import cli.data.map.Map;
import cli.process.builder.MapBuilder;
import cli.process.factory.*;
import cli.tests.input.InputParameter;

public class GameLauncher {
	
	private Config config;
	
	
	public GameLauncher(Config config) {
		this.config = config;
	}

	public void buildGame() {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		GameState state = new GameState(map);
		initializePlayerFaction(state);
		
		createFactions();
	}
	
	

	private void createFactions() {
		try {
			
		}
		
	}

	public void initializePlayerFaction(GameState state) {
		Faction playerFaction = new Faction(config.getPlayerFactionName(), Constants.PLAYER, null, "Player faction");
		state.getFactions().add(playerFaction);
		
	}
	
	
	
	
}