package data;

import java.util.ArrayList;

import data.faction.Faction;
import data.map.Map;
import process.SelectableRepository;

public class GameState {

	private Map map;

	private ArrayList<Faction> factions = new ArrayList<Faction>();

	private SelectableRepository selectableRepository = SelectableRepository.getInstance();

	public GameState() {
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList<Faction> getFactions() {
		return factions;
	}

	public void setFactions(ArrayList<Faction> factions) {
		this.factions = factions;
	}

	public void addFaction(Faction faction) {
		// A new faction can only be added to the ArrayList if it's not in the list yet.
		if (!factions.contains(faction)) {
			factions.add(faction);
		}
	}

	public void removeFaction(Faction faction) {
		if (factions.contains(faction)) {
			factions.remove(faction);
		}
	}
	@Override
	public String toString() {
		return "GameState [map=" + map + "]";
	}

}