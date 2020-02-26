package cli.process;

import java.util.ArrayList;

import cli.data.Config;
import cli.data.Constants;
import cli.data.GameState;
import cli.data.Team;
import cli.data.faction.Faction;
import cli.data.map.Map;
import cli.process.builder.MapBuilder;
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
	}
	
	public void newEnemyUnionFaction(Team team) {
		ArrayList<Faction> factions = team.getFactions();
		factions.add(new Faction(Constants.UNION, Constants.ENNEMY+factions.size(), null, "An ennemy Union faction"));
	}
	
	public void newEnemyFederationFaction(Team team) {
		ArrayList<Faction> factions = team.getFactions();
		factions.add(new Faction(Constants.FEDERATION, Constants.ENNEMY+factions.size(), null, "An ennemy Union faction"));
	}
	
	public void newEnemyRepublicFaction(Team team) {
		ArrayList<Faction> factions = team.getFactions();
		factions.add(new Faction(Constants.REPUBLIC, Constants.ENNEMY+factions.size(), null, "An ennemy Union faction"));
	}
	
	public void newEnemyUnionFaction(int teamNumber)throws IllegalArgumentException {
		if (teamNumber<1) {
			throw new IllegalArgumentException("must designate an ennemy team");
		}
		ArrayList<Faction> factions = getTeams().get(teamNumber).getFactions();
		factions.add(new Faction(Constants.UNION, Constants.ENNEMY+factions.size(), null, "An ennemy Union faction"));
	}
	
	public void newEnemyFederationFaction(int teamNumber)throws IllegalArgumentException {
		if (teamNumber<1) {
			throw new IllegalArgumentException("must designate an ennemy team");
		}
		ArrayList<Faction> factions = getTeams().get(teamNumber).getFactions();
		factions.add(new Faction(Constants.FEDERATION, Constants.ENNEMY+factions.size(), null, "An ennemy Union faction"));
	}
	
	public void newEnemyRepublicFaction(int teamNumber) {
		if (teamNumber<1) {
			throw new IllegalArgumentException("must designate an ennemy team");
		}
		ArrayList<Faction> factions = getTeams().get(teamNumber).getFactions();
		factions.add(new Faction(Constants.REPUBLIC, Constants.ENNEMY+factions.size(), null, "An ennemy Union faction"));
	}
	


	
	
	public void newAllyUnionFaction() {
		ArrayList<Faction> factions = getTeams().get(0).getFactions();
		factions.add(new Faction(Constants.UNION, Constants.ENNEMY+factions.size(), null, "An Ally Union faction"));
	}
	
	public void newAllyFederationFaction() {
		ArrayList<Faction> factions = getTeams().get(0).getFactions();
		factions.add(new Faction(Constants.FEDERATION, Constants.ENNEMY+factions.size(), null, "An Ally Union faction"));
	}
	
	public void newAllyRepublicFaction() {
		ArrayList<Faction> factions = getTeams().get(0).getFactions();
		factions.add(new Faction(Constants.REPUBLIC, Constants.ENNEMY+factions.size(), null, "An Ally Union faction"));
	}
	
	public Team  addNewEnemyTeam() {
		Team team = new Team();
		getTeams().add(team);
		return team;
	}
	
}