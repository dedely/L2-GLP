package cli.data;

import java.util.ArrayList;

import cli.data.faction.Faction;
import cli.data.map.Map;
import cli.process.SelectableRepository;


public class GameState {

	private Map map;

	protected ArrayList<Faction> factions = new ArrayList<Faction>();

	protected SelectableRepository selectableRepository = SelectableRepository.getInstance();

	public GameState(Map map) {
		this.map = map;
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

	@Override
	public String toString() {
		return "GameState [map=" + map + "]";
	}

}