package cli.tests;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.faction.Faction;
import cli.data.map.Map;
import cli.data.unit.Unit;
import cli.process.SelectableRepository;
import cli.process.SelectableTreatment;
import cli.process.builder.MapBuilder;
import cli.process.factory.UnitFactory;
import cli.tests.input.InputParameter;

public class TestAttack {

	public static void main(String[] args) {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		SelectableRepository repository = SelectableRepository.getInstance();

		Faction playerFaction = new Faction(Constants.UNION, Constants.PLAYER, null, "Just a faction");

		Unit firstUnit = UnitFactory.create(Constants.TEST_GROUND, new Coordinates(0, 0, Constants.GROUND),
				playerFaction);
		repository.register(firstUnit);

		Faction enemyFaction = new Faction(Constants.UNION, Constants.ENNEMY, null, "The enemy!");

		Unit enemy = UnitFactory.create(Constants.TEST_GROUND, new Coordinates(10, 10, Constants.GROUND), enemyFaction);
		repository.register(enemy);
		
		System.out.println(firstUnit);
		System.out.println(enemy);
		
		SelectableTreatment.dealDamage(firstUnit, enemy);
		
		System.out.println(firstUnit);
		System.out.println(enemy);

	}

}