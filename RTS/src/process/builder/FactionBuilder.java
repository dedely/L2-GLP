package process.builder;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.Cost;
import data.Player;
import data.building.UnitBuilding;
import data.resource.Resource;
import data.unit.Unit;
import gui.elements.SimuPara;
import process.FactionTest;
import process.SelectableRepository;
import process.factory.BuildingFactory;
import process.factory.TestFactory;
import process.factory.UnitFactory;
import process.managers.UnitBuildingManager;
import process.managers.UnitManager;

public class FactionBuilder {

	private Player player;
	private FactionTest faction;

	public FactionTest buildFaction(Player player) {
		this.player = player;
		faction = new FactionTest(player);

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
		SelectableRepository r = SelectableRepository.getInstance();
		String name = player.getName();
		Coordinates hQSpawn = getHQSpawn();
		Coordinates workerSpawn = getWorkerSpawn();
		UnitBuilding headquaters = TestFactory.createUnitBuilding(Constants.HEADQUATERS, name, hQSpawn, hQSpawn);
		r.register(headquaters);
		UnitBuildingManager manager = new UnitBuildingManager(headquaters, faction);
		faction.addSelectableManager(manager);
		Unit unit = TestFactory.createUnit(Constants.MCM, name, workerSpawn);
		r.register(unit);
		UnitManager unitManager = new UnitManager(unit);
		faction.addSelectableManager(unitManager);
	}

	private void initResources() {
		faction.addResource(new Resource(1000, Constants.MATS));
	}
	
	private void initCosts() {
		HashMap<String, Cost> costs = CostBuilder.buildCosts(player.getFactionName());
		faction.setCosts(costs);
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
}