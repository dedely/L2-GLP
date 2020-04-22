package process.builder;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.Cost;
import data.Player;
import data.Resource;
import data.Selectable;
import data.building.Building;
import data.unit.Unit;
import gui.elements.SimuPara;
import process.Faction;
import process.factory.BuildingFactory;
import process.factory.UnitFactory;
import process.managers.SelectableManager;
import process.repository.SelectableRepository;
import process.visitor.selectable.ManagerVisitor;

/**
 * This utility class is responsible for creating each Faction object at the
 * beginning of a new game. It uses the player's faction choice. At the moment,
 * the spawn locations are based on hard coded rules.
 * 
 * @author Adel
 *
 */
public class FactionBuilder {

	private Player player;
	private Faction faction;

	private SelectableRepository r = SelectableRepository.getInstance();

	private BuildingFactory buildingFactory = BuildingFactory.getInstance();

	private UnitFactory unitFactory = UnitFactory.getInstance();

	private ManagerVisitor visitor;

	public Faction buildFaction(Player player) {
		this.player = player;
		faction = new Faction(player);
		visitor = new ManagerVisitor(faction);

		initResources();
		initResearch();
		initSelectable();
		initCosts();
		return faction;
	}

	private void initResearch() {
		// TODO Auto-generated method stub

	}

	private void initSelectable() {
		String name = player.getName();
		String faction = player.getFactionName();

		try {
			initHQ(name, faction);
			initMine(name, faction);
			initWorker(name, faction);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

	private void initResources() {
		faction.addResource(new Resource(1000, Constants.MATERIALS));
	}

	private void initCosts() {
		HashMap<String, Cost> costs = CostBuilder.buildCosts(player.getFactionName());
		faction.setCosts(costs);
	}

	private void initHQ(String name, String factionName) throws IllegalArgumentException {
		Coordinates hQSpawn = getHQSpawn();
		try {
			Building headquaters = null;
			switch (factionName) {
			case Constants.REPUBLIC:
				headquaters = buildingFactory.createBuilding(Constants.REPUBLIC_HQ, hQSpawn, name);
				break;
			case Constants.UNION:
				headquaters = buildingFactory.createBuilding(Constants.UNION_HQ, hQSpawn, name);
				break;
			case Constants.FEDERATION:
				headquaters = buildingFactory.createBuilding(Constants.FEDERATION_HQ, hQSpawn, name);
				break;
			default:
				throw new IllegalArgumentException("Unknow factionName: " + factionName);
			}
			register(headquaters);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private void register(Selectable selectable) {
		if (selectable != null) {
			r.register(selectable);
			SelectableManager manager = selectable.accept(visitor);
			faction.addSelectableManager(manager);
		}
	}

	private void initMine(String name, String factionName) {
		Coordinates mineSpawn = getMineSpawn();
		try {
			Building mine = null;
			switch (factionName) {
			case Constants.REPUBLIC:
				mine = buildingFactory.createBuilding(Constants.REPUBLIC_MINE, mineSpawn, name);
				break;
			case Constants.UNION:
				mine = buildingFactory.createBuilding(Constants.UNION_MINE, mineSpawn, name);
				break;
			case Constants.FEDERATION:
				mine = buildingFactory.createBuilding(Constants.FEDERATION_MINE, mineSpawn, name);
				break;
			default:
				throw new IllegalArgumentException("Unknow factionName: " + factionName);
			}
			register(mine);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private void initWorker(String name, String factionName) throws IllegalArgumentException {
		Coordinates workerSpawn = getWorkerSpawn();
		try {
			Unit worker = null;
			switch (factionName) {
			case Constants.REPUBLIC:
				worker = unitFactory.createUnit(Constants.REPUBLIC_WORKER, workerSpawn, name);
				break;
			case Constants.UNION:
				worker = unitFactory.createUnit(Constants.MCM, workerSpawn, name);
				break;
			case Constants.FEDERATION:
				worker = unitFactory.createUnit(Constants.TAPIR, workerSpawn, name);
				break;
			default:
				throw new IllegalArgumentException("Unknow factionName: " + factionName);
			}
			register(worker);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private Coordinates getHQSpawn() {
		Coordinates spawn = null;

		switch (player.getName()) {
		case Constants.PLAYER:
			spawn = new Coordinates(15 * SimuPara.SCALE, 105 * SimuPara.SCALE, 0);
			break;
		case Constants.AI:
			spawn = new Coordinates(105 * SimuPara.SCALE, 15 * SimuPara.SCALE, 0);
			break;
		default:
			throw new IllegalArgumentException("Unknown name: " + player.getName());
		}
		return spawn;
	}

	private Coordinates getWorkerSpawn() {
		Coordinates spawn = null;

		switch (player.getName()) {
		case Constants.PLAYER:
			spawn = new Coordinates(15 * SimuPara.SCALE, 100 * SimuPara.SCALE, 0);
			break;
		case Constants.AI:
			spawn = new Coordinates(105 * SimuPara.SCALE, 10 * SimuPara.SCALE, 0);
			break;
		default:
			throw new IllegalArgumentException("Unknown name: " + player.getName());
		}

		return spawn;
	}
	
	private Coordinates getMineSpawn() {
		Coordinates spawn = null;

		switch (player.getName()) {
		case Constants.PLAYER:
			spawn = new Coordinates(15 * SimuPara.SCALE, 95 * SimuPara.SCALE, 0);
			break;
		case Constants.AI:
			spawn = new Coordinates(110 * SimuPara.SCALE, 10 * SimuPara.SCALE, 0);
			break;
		default:
			throw new IllegalArgumentException("Unknown name: " + player.getName());
		}

		return spawn;
	}
}