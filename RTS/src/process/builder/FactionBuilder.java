package process.builder;

import data.Constants;
import data.Coordinates;
import data.Player;
import data.building.UnitBuilding;
import process.FactionTest;
import process.SelectableRepository;
import process.factory.BuildingFactory;
import process.managers.UnitBuildingManager;

public class FactionBuilder {

	private Player player;
	private FactionTest faction;

	public FactionTest buildFaction(Player player) {
		this.player = player;
		faction = new FactionTest(player);

		initResources();
		initResearch();
		initSelectable();

		return faction;
	}

	private void initResearch() {
		// TODO Auto-generated method stub

	}

	private void initSelectable() {
		SelectableRepository r = SelectableRepository.getInstance();
		String type = player.getFactionName();
		Coordinates spawnPosition = getSpawn();
		UnitBuilding headquaters = BuildingFactory.createHeadQuaters(spawnPosition, type);
		r.register(headquaters);
		UnitBuildingManager manager = new UnitBuildingManager(headquaters);
		faction.addSelectableManager(manager);
	}

	private void initResources() {
		// TODO Auto-generated method stub

	}

	private Coordinates getSpawn() {
		Coordinates spawn = null;

		switch (player.getName()) {
		case Constants.PLAYER:
			spawn = new Coordinates(15, 105, 0);
			break;
		case Constants.AI:
			spawn = new Coordinates(105, 15, 0);
			break;
		default: 
			throw new IllegalArgumentException("Unknown name: " + player.getName());
		}

		return spawn;
	}
}