package cli.process;

import java.util.ArrayList;

import cli.data.Constants;
import cli.data.Coordinates;

public class CoordinatesTreatment {
	public ArrayList<Coordinates> tilesAroundLineByLine(Coordinates center, int radius) {
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

	public ArrayList<Coordinates> tilesAroundSpiral(Coordinates center, int radius) {
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

}