package cli.tests;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.faction.Faction;
import cli.data.order.Attack;
import cli.data.unit.Unit;
import cli.process.SelectableTreatment;
import cli.process.UnitFactory;

public class Treatment {
	public static void main(String[] args) {

		long firstTime = System.nanoTime();
		/* test specific variables */
		
		long startTime = System.nanoTime();
		
		Faction faction1 = new Faction(Constants.UNION,Constants.PLAYER, null, "the union");
		Faction faction2 = new Faction(Constants.FEDERATION,Constants.ENNEMY+"1", null, "the federation");


		Unit unit1 = UnitFactory.create(Constants.TEST_GROUND, new Coordinates(0, 0, Constants.GROUND), faction1);
		Unit unit2 = UnitFactory.create(Constants.TEST_GROUND, new Coordinates(100, 100, Constants.GROUND), faction2);

		SelectableTreatment.giveOrderReplace(unit1, new Attack( Constants.STOP_TO_SHOOT, unit2));
		
		
		
		
		long endTime = System.nanoTime();
		System.out.println("moving Took " + (endTime - startTime) / 1000000.0 + " ms");

		
		endTime = System.nanoTime();
		System.out.println("Took " + (endTime - firstTime) / 1000000.0 + " ms");
	}
}
