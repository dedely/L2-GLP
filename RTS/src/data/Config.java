package data;

import java.util.ArrayList;

public class Config {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int difficulty;

	public Config(int difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * This constructor is used to construct a default config to perform our tests.
	 * @param difficulty
	 * @param player1
	 * @param player2
	 */
	public Config(int difficulty, Player player1, Player player2) {
		this.difficulty = difficulty;
		players.add(player1);
		players.add(player2);
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		// We'll add conditions to this method later, as difficulty levels will be
		// caped.
		this.difficulty = difficulty;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player) {
		// A new player can only be added to the ArrayList if it's not in the list yet.
		if (!players.contains(player)) {
			players.add(player);
		}
	}

	public void removePlayer(Player player) {
		if (players.contains(player)) {
			players.remove(player);
		}
	}

	@Override
	public String toString() {
		String tmp = "";
		for (Player player : players) {
			tmp += player.toString() + "\n";
		}
		return tmp;
	}
}