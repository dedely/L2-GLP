package cli.process;

import java.util.ArrayList;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.unit.Unit;

public class CoordinatesTreatment {
	public static ArrayList<Coordinates> tilesAroundLineByLine(Coordinates center, int radius) {
		ArrayList<Coordinates> tilesAround = new ArrayList<Coordinates>();

		radius++;

		double x = center.getAbsciss();
		double y = center.getOrdinate();

		for (double i = Math.max((y - radius), 0); i <= (y + radius); i++) {
			for (double j = Math.max((x - radius), 0); j <= (x + radius); j++) {
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					if (i != y || j != x) {
						tilesAround.add(new Coordinates((int) j, (int) i, Constants.GROUND));
						tilesAround.add(new Coordinates((int) j, (int) i, Constants.AIR));
					}
				}

			}

		}
		return tilesAround;
	}

	public static ArrayList<Coordinates> tilesAroundSpiral(Coordinates center, int radius) {
		ArrayList<Coordinates> tilesAround = new ArrayList<Coordinates>();

		radius++;

		double x = center.getAbsciss();
		double y = center.getOrdinate();

		double j = x + 1;
		double i = y + 1;

		for (int m = 1; m <= radius; m++) {

			while (i > y - m) {
				i--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.GROUND));
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.AIR));
				}

			}
			while (j > x - m) {
				j--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.GROUND));
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.AIR));
				}

			}
			while (i < y + m) {
				i++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.GROUND));
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.AIR));
				}
			}
			while (j < x + m) {
				j++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.GROUND));
					tilesAround.add(new Coordinates((int) j, (int) i, Constants.AIR));

				}

			}
		}
		return tilesAround;
	}

	public static Coordinates positionNextTick(Unit unitToMove, Coordinates destination) {
		Coordinates origin = unitToMove.getPosition();
		int deltaX = destination.getAbsciss() - origin.getAbsciss();
		int deltaY = destination.getOrdinate() - origin.getOrdinate();
		double length = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		if (unitToMove.getSpeed() < length) {
			int newX = (int) Math.round((origin.getAbsciss() + (deltaX / length * unitToMove.getSpeed())));
			int newY = (int) Math.round((origin.getOrdinate() + (deltaY / length * unitToMove.getSpeed())));
			return new Coordinates(newX, newY, origin.getHeight());
		} else
			return destination;

	}

	public static double distance(Coordinates position1, Coordinates position2) {
		return Math.sqrt((Math.pow(position1.getAbsciss() - position2.getAbsciss(), 2)
				+ (Math.pow(position1.getOrdinate() - position2.getOrdinate(), 2))));
	}
}