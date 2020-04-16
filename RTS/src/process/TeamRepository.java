package process;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import data.Player;
import data.Team;

/**
 * @author Adel
 *
 */
public class TeamRepository {

	private Map<Integer, Team> teams = new HashMap<Integer, Team>();
	private Map<String, Integer> playerTeam = new HashMap<String, Integer>();

	/**
	 * Private constructor for Singleton.
	 */
	private TeamRepository() {

	}

	/**
	 * Static unique instance for Singleton.
	 */
	private static TeamRepository instance = new TeamRepository();

	public static TeamRepository getInstance() {
		return instance;
	}

	public void add(Player player, int teamId) {
		if (teams.containsKey(teamId)) {
			teams.get(teamId).add(player);
		} else {
			Team newTeam = new Team(teamId);
			newTeam.add(player);
			teams.put(teamId, newTeam);
		}
	}

	public Integer getTeamId(String playerName) throws NoSuchElementException {
		if (playerTeam.containsKey(playerName)) {
			return playerTeam.get(playerName);
		}else {
			throw new NoSuchElementException("Player " + playerName + " does not exist!");
		}
	}
	
	public Player getPlayer(String playerName) {
		Player player = null;
		try {
			Integer teamId = getTeamId(playerName);
			player = teams.get(teamId).getPlayer(playerName);
		}catch (NoSuchElementException nsee) {
			System.err.println(nsee.getMessage());
		}
		return player;
	}
	
	public void reset() {
		teams.clear();
		playerTeam.clear();
	}

}