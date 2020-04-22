package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import data.Config;
import data.GameState;
import data.Selectable;
import process.builder.GameLauncher;
import process.repository.SelectableRepository;
import process.repository.TeamRepository;

/**
 * @author Adel
 *
 */
public class Game {
	private int state;
	private HashMap<String, Faction> players = new HashMap<String, Faction>();
	private SelectableRepository repository = SelectableRepository.getInstance();

	public Game() {
		setState(GameState.NEW);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public HashMap<String, Faction> getPlayers() {
		return players;
	}

	public void add(Faction faction) {
		if (faction != null) {
			players.put(faction.getPlayer(), faction);
		}
	}

	public void launch(Config config) {
		GameLauncher launcher = new GameLauncher(config, this);
		launcher.buildGame();
		setState(GameState.READY);
	}

	public void run() {
		setState(GameState.RUNNING);
	}

	public void pause() {
		setState(GameState.PAUSED);
	}
	
	public void end() {
		setState(GameState.OVER);
	}

	public void reset() {
		players.clear();
		repository.setMap(null);
		state = GameState.NEW;
	}

	public void update() {
		if (isRunning()) {
			removeDead();
			addNew();
			for (Faction player : players.values()) {
				player.update();
				if(player.isLost()) {
					end();
				}
			}
		}
	}

	private void addNew() {
		for(Selectable selectable: repository.getNewSelectables()) {
			repository.register(selectable);
		}
		repository.clearNew();
	}

	private void removeDead() {
		for(Integer id: repository.getDeadSelectables()) {
			String player = repository.getSelectable(id).getPlayerName();
			try {
				getPlayer(player).removeSelectableManager(id);
				repository.remove(id);
			}catch(NoSuchElementException nsee) {
				System.err.println(nsee.getMessage());
			}
		}
		repository.clearDead();
	}

	public boolean isReady() {
		return state == GameState.READY;
	}

	public boolean isRunning() {
		return state == GameState.RUNNING;
	}

	public boolean isStopped() {
		return state == GameState.STOP;
	}
	
	public boolean isOver() {
		return state == GameState.OVER;
	}

	public static boolean isEnemy(String player1, String player2) {
		return !player1.equals(player2);
	}

	public ArrayList<Integer> getSelection(String name) {
		ArrayList<Integer> selection = new ArrayList<Integer>();
		if (players.containsKey(name)) {
			selection = players.get(name).getSelection();
		}
		return selection;
	}

	public void select(String name, Integer id) {
		if (players.containsKey(name)) {
			players.get(name).select(id);
		}
	}

	public void deselectAll(String name) {
		if (players.containsKey(name)) {
			players.get(name).deselectAll();
		}
	}

	public Faction getPlayer(String name) throws NoSuchElementException {
		if (players.containsKey(name)) {
			return players.get(name);
		} else {
			throw new NoSuchElementException("Player " + name + " does not exist!");
		}
	}
	
	public static String getFaction(String name) throws NoSuchElementException {
		String faction = TeamRepository.getInstance().getPlayer(name).getFactionName();
		if(faction != null) {
			return faction;
		}else {
			throw new NoSuchElementException("Player " + name + " does not exist!");
		}
	}
}