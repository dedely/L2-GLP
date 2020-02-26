package cli.data;

import java.util.ArrayList;

import cli.data.faction.Faction;

public class Team {
	private ArrayList<Faction> factions = new ArrayList<Faction>();

	public ArrayList<Faction> getFactions() {
		return factions;
	}

	public void setFactions(ArrayList<String> factions) {
		this.factions = factions;
	}

	@Override
	public String toString() {
		return "Team [factions=" + factions + "]";
	}
	
}