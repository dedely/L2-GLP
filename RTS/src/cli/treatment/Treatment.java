package cli.treatment;

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

public class Treatment {
	public static void main(String[] args) {
		int range = 2;
		CoordinatesTreatment coordsTreatment = new CoordinatesTreatment();

		HashMap<Coordinates, Selectable> unitsPos = new HashMap<Coordinates, Selectable>();

		Faction goodGuys = new Faction("good guys", new BinaryTree("good guys research tree"),
				new Description("the good ones"));
		Faction badGuys = new Faction("bad guys", new BinaryTree("bad guys research tree"),
				new Description("the bad ones"));
		Faction neutral = new Faction("neutral", null, new Description("random ppl"));

		goodGuys.getEnnemies().add(badGuys);
		badGuys.getEnnemies().add(goodGuys);

		Unit aUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, goodGuys, "john", new Coordinates(5, 5),

				new Description("yeeeeeeessss"), 10 , Constants.SUPER_LIGHT, 50, 10, range, Constants.GROUND, 1);
		Unit aSecondUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, badGuys, "Tom", new Coordinates(5, 6),
				new Description("uuuuuraaaaa"), 10, Constants.SUPER_LIGHT, 50, 10, range, Constants.GROUND, 1);
		Unit aThirdUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, badGuys, "Dave", new Coordinates(5, 7),
				new Description("blyat"), 10, Constants.SUPER_LIGHT, 50, 10, 3, Constants.GROUND, 1);
		Unit aFourthUnit = new GenericInfantry(50, 5, Constants.SUPER_LIGHT, neutral, "James", new Coordinates(4, 5),
				new Description("why am I here ?"), 10, Constants.SUPER_LIGHT, 50, 10, range, Constants.GROUND, 1);

		unitsPos.put(aUnit.getPosition(), aUnit);
		unitsPos.put(aSecondUnit.getPosition(), aSecondUnit);
		unitsPos.put(aThirdUnit.getPosition(), aThirdUnit);
		unitsPos.put(aFourthUnit.getPosition(), aFourthUnit);

		long startTime = System.nanoTime();

		for (Coordinates c : coordsTreatment.tilesAroundSpiral(aUnit.getPosition(), aUnit.getRange())) {
			if (unitsPos.containsKey(c)) {
				Selectable currentUnit = unitsPos.get(c);
				System.out.println("a unit from " + unitsPos.get(c).getFaction().getName() + " is around");
				if (currentUnit.getFaction().getEnnemies().contains(aUnit.getFaction())) {
					System.out.println("it's an ennemy !!");
				}
			}
		}

		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000.0 + " ms");

		startTime = System.nanoTime();

		for (Coordinates c : coordsTreatment.tilesAroundLineByLine(aUnit.getPosition(), aUnit.getRange())) {
			if (unitsPos.containsKey(c)) {
				Selectable currentUnit = unitsPos.get(c);
				System.out.println("a unit from " + currentUnit.getFaction().getName() + " is around");
				if (currentUnit.getFaction().getEnnemies().contains(aUnit.getFaction())) {
					System.out.println("it's an ennemy !!");
				}
			}
		}

		endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000.0 + " ms");

	}

}
