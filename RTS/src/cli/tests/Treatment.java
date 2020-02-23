package cli.tests;

import java.util.HashMap;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.Description;
import cli.data.Selectable;
import cli.data.faction.Faction;
import cli.data.tree.BinaryTree;
import cli.data.unit.GenericInfantry;
import cli.data.unit.Unit;
import cli.process.CoordinatesTreatment;
import cli.process.SelectableTreatment;

public class Treatment {
	public static void main(String[] args) {

		long firstTime = System.nanoTime();
		/* test specific variables */
		long startTime = System.nanoTime();

		/* range of action for the test units */
		int range = 20;

		/* treatment classes */
		CoordinatesTreatment coordsTreatment = new CoordinatesTreatment();
		SelectableTreatment selectableTreatment = new SelectableTreatment();

		/* HasMap representing positions */
		HashMap<Coordinates, Selectable> unitsPos = new HashMap<Coordinates, Selectable>();

		/* Faction initialization */
		Faction goodGuys = new Faction("good guys", new BinaryTree("good guys research tree"),
				new Description("the good ones"));
		Faction badGuys = new Faction("bad guys", new BinaryTree("bad guys research tree"),
				new Description("the bad ones"));
		Faction neutral = new Faction("neutral", null, new Description("random ppl"));

		/* setting good guys and badGuys to be enemies */
		goodGuys.getEnnemies().add(badGuys);
		badGuys.getEnnemies().add(goodGuys);

		/* unit initialization */
		Unit aUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, goodGuys, "john",
				new Coordinates(5, 5, Constants.GROUND),

				new Description("yeeeeeeessss"), 10, 50, Constants.LIGHT, 10, range, 1);

		Unit aSecondUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, badGuys, "Tom",
				new Coordinates(5, 6, Constants.GROUND), new Description("uuuuuraaaaa"), 10, 50, Constants.SUPER_LIGHT,
				10, range, 1);
		Unit aThirdUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, badGuys, "Dave",
				new Coordinates(5, 7, Constants.GROUND), new Description("blyat"), 10, 50, Constants.SUPER_LIGHT, 10, 3,
				1);
		Unit aFourthUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, neutral, "James",
				new Coordinates(1, 1, Constants.GROUND), new Description("why am I here ?"), 10, 50,
				Constants.SUPER_LIGHT, 10, range, 1);

		/* putting all units in the position HashMap */
		unitsPos.put(aUnit.getPosition(), aUnit);
		unitsPos.put(aSecondUnit.getPosition(), aSecondUnit);
		unitsPos.put(aThirdUnit.getPosition(), aThirdUnit);
		unitsPos.put(aFourthUnit.getPosition(), aFourthUnit);

		/* updating a position in the hashMap */
		unitsPos.remove(aFourthUnit.getPosition(), aFourthUnit);
		aFourthUnit.setPosition(new Coordinates(4, 5, Constants.GROUND));
		unitsPos.put(aFourthUnit.getPosition(), aFourthUnit);

		long endTime = System.nanoTime();

		System.out.println("Took " + (endTime - startTime) / 1000000.0 + " ms");

		startTime = System.nanoTime();

		/* detecting units around using linear adjusted method */

		startTime = System.nanoTime();

		/* detecting units around using spiral method */
		for (Coordinates c : coordsTreatment.tilesAroundSpiral(aUnit.getPosition(), aUnit.getRange())) {
			if (unitsPos.containsKey(c)) {
				Selectable currentUnit = unitsPos.get(c);
				System.out
						.println("a unit from " + currentUnit.getFaction().getName() + " is around " + aUnit.getName());
				if (currentUnit.getFaction().getEnnemies().contains(aUnit.getFaction())) {
					System.out.println("it's an ennemy !!");
				}
			}
		}

		endTime = System.nanoTime();

		System.out.println("spiral Took " + (endTime - startTime) / 1000000.0 + " ms");

		startTime = System.nanoTime();

		/* dealing damage */
		System.out.println(selectableTreatment.calculDamage(50, 0, 20, 0));

		System.out.println(aSecondUnit.getHealth());
		System.out.println(aThirdUnit.getHealth());

		selectableTreatment.dealDamage(aUnit, aSecondUnit);
		selectableTreatment.dealDamage(aUnit, aThirdUnit);

		System.out.println(aSecondUnit.getHealth());
		System.out.println(aThirdUnit.getHealth());

		endTime = System.nanoTime();
		System.out.println("Dealing damage Took " + (endTime - startTime) / 1000000.0 + " ms");

		System.out.println(aUnit.toString());
		
		startTime = System.nanoTime();
		selectableTreatment.moveToward(aUnit, new Coordinates(5,16, Constants.GROUND));
		endTime = System.nanoTime();
		System.out.println("moving Took " + (endTime - startTime) / 1000000.0 + " ms");

		
		endTime = System.nanoTime();
		System.out.println("Took " + (endTime - firstTime) / 1000000.0 + " ms");
	}
}
