package cli.process;

import java.util.ArrayList;

import cli.data.Constants;
import cli.data.GameState;
import cli.data.Team;
import cli.data.faction.Faction;
import cli.data.map.Map;

public class GameStateTreatment extends GameState {
	
	public GameStateTreatment(Map map) {
		super(map);
		getTeams().add(new Team().getFactions().add(new Faction(name, playerName, researchTree, description)))
	}
	
	


}
