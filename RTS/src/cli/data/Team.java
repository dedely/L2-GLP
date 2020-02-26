package cli.data;

import java.util.ArrayList;

public class Team {
	private ArrayList<String> players = new ArrayList<String>();

	public ArrayList<String> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [players=" + players + "]";
	}
	
}