package data;


import java.util.HashMap;
import java.util.NoSuchElementException;

public class Team {
	private int id;
	private HashMap<String, Player> players = new HashMap<String, Player>();

	public Team(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(String name) throws NoSuchElementException {
		if(players.containsKey(name)) {
			return players.get(name);
		}else {
			throw new NoSuchElementException("Player : " + name + " does not exist!");
		}
	}

	public void add(Player player) {
		players.put(player.getName(), player);
	}

	public void remove(String player) {
		players.remove(player);
	}

}