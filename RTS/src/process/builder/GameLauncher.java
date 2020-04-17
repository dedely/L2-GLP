package process.builder;

import data.Config;
import data.GameState;
import data.Player;
import data.map.Map;
import gui.management.ButtonFactory;
import process.Faction;
import process.Game;
import process.repository.SelectableRepository;
import process.repository.TeamRepository;
import tests.input.InputParameter;

/**
 * This class is responsible for building a GameState using the provided Config
 * information.
 * 
 * @author Adel
 * 
 */
public class GameLauncher {

	private Config config;
	private Game game;
	private TeamRepository teams = TeamRepository.getInstance();
	private ButtonFactory factory = ButtonFactory.getInstance();

	public GameLauncher(Config config, Game game) {
		this.config = config;
		this.game = game;
	}

	public void buildGame() {
		initMap();
		initFactions();
		initAI();
		game.setState(GameState.READY);
	}

	private void initAI() {
		// TODO Auto-generated method stub
		
	}

	private void initFactions() {
		FactionBuilder builder = new FactionBuilder();
		for(Player player: config.getPlayers()) {
			Faction faction = builder.buildFaction(player);
			game.add(faction);
		}
	}

	private void initMap() {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		SelectableRepository r = SelectableRepository.getInstance();
		r.setMap(map);
	}

}