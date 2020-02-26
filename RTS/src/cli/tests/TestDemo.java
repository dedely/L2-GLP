package cli.tests;

import cli.data.Constants;
import cli.data.Coordinates;

import cli.data.Team;
import cli.data.faction.Faction;
import cli.data.unit.Unit;
import cli.process.SelectableTreatment;
import cli.process.UnitFactory;

public class TestDemo {

	public static void main(String[] args) {
		//Game game = new Game();
		Team team1 = new Team();
		Faction faction1 = new Faction(Constants.UNION, Constants.PLAYER, null, "the player faction");
		Unit unit1 = UnitFactory.create(Constants.TEST_GROUND, new Coordinates(0, 0, Constants.GROUND), faction1);
		
		Faction faction2 = new Faction(Constants.UNION, Constants.ENNEMY + "1", null, "the ennemy faction");
		Unit unit2 = UnitFactory.create(Constants.TEST_GROUND, new Coordinates(0, 10, Constants.GROUND), faction2);
	
		System.out.println("unit1 health = " + unit1.getCurrentHealth());
		System.out.println("unit2 health = " + unit2.getCurrentHealth());

		//System.out.println(unit1.getName()+" from "+unit1.getOwner()+"faction, attacks" + unit2.getName()+" from "+unit2.getOwner());
		SelectableTreatment.dealDamage(unit1, unit2);
		
	}

}
