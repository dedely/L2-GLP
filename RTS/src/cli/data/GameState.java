package cli.data;

import java.util.ArrayList;

import cli.data.faction.Faction;
import cli.data.map.Map;
import cli.process.SelectableRepository;
import cli.process.observer.Observer;

public class GameState {

	private String playerFactionName;
	
	private Map map;

	protected ArrayList<Team> teams = new ArrayList<Team>();

	protected ArrayList<Faction> factions = new ArrayList<Faction>();
	
	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	
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

	public static ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for (Observer observer: observers) {
			observer.update();
		}
	}

	@Override
	public String toString() {
		return "GameState [map=" + map + ", teams=" + teams + "]";
	}

}