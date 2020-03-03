package process;

import cli.data.Team;
import data.GameState;
import data.faction.Faction;
import data.map.Map;

public class GameStateTreatment extends GameState {
	
	public GameStateTreatment(Map map) {
		super(map);
		getTeams().add(new Team().getFactions().add(new Faction(name, playerName, researchTree, description)))
	}
	
	


}
