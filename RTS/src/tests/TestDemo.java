package tests;

import data.Constants;
import data.Coordinates;

import data.faction.Faction;
import data.unit.Unit;
import process.SelectableTreatment;
import process.factory.UnitFactory;

public class TestDemo {

	public static void main(String[] args) {
		// Game game = new Game();
		Faction faction1 = new Faction(Constants.UNION, Constants.PLAYER, null, "the player faction", 0);
		Unit unit1 = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(0, 0, Constants.GROUND), faction1);

		Faction faction2 = new Faction(Constants.UNION, Constants.ENNEMY + "1", null, "the ennemy faction", 1);
		Unit unit2 = UnitFactory.createUnit(Constants.TEST_GROUND, new Coordinates(0, 10, Constants.GROUND), faction2);

		System.out.println("unit1 health = " + unit1.getCurrentHealth());
		System.out.println("unit2 health = " + unit2.getCurrentHealth());

		// System.out.println(unit1.getName()+" from "+unit1.getOwner()+"faction,
		// attacks" + unit2.getName()+" from "+unit2.getOwner());
		SelectableTreatment.dealDamage(unit1, unit2);

	}

}
