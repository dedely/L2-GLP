package tests;

import data.Constants;
import data.Coordinates;
import data.faction.Faction;
import data.map.Map;
import data.unit.Unit;
import process.SelectableRepository;
import process.SelectableTreatment;
import process.builder.MapBuilder;
import process.factory.UnitFactory;
import tests.input.InputParameter;

public class TestAttack {

	public static void main(String[] args) {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		SelectableRepository repository = SelectableRepository.getInstance();

		Faction playerFaction = new Faction(Constants.UNION, Constants.PLAYER, null, "Just a faction", 0);

		Unit firstUnit = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(0, 0, Constants.GROUND),
				playerFaction);
		repository.register(firstUnit);

		Faction enemyFaction = new Faction(Constants.UNION, Constants.ENNEMY, null, "The enemy!", 1);

		Unit enemy = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(10, 10, Constants.GROUND),
				enemyFaction);
		repository.register(enemy);

		System.out.println(firstUnit);
		System.out.println(enemy);

		SelectableTreatment.dealDamage(firstUnit, enemy);

		System.out.println(firstUnit);
		System.out.println(enemy);

	}

}