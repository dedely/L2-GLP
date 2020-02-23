package cli.process;

import java.util.ArrayList;
import java.util.HashMap;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
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

	public static Selectable closestEnnemySelectable(Unit unit, HashMap<Coordinates, Selectable> positions) {

		int radius = unit.getRange();
		radius++;

		double x = unit.getPosition().getAbsciss();
		double y = unit.getPosition().getOrdinate();

		double j = x + 1;
		double i = y + 1;

		for (int m = 1; m <= radius; m++) {

			while (i > y - m) {
				i--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}

			}
			while (j > x - m) {
				j--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}

			}
			while (i < y + m) {
				i++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}
			}
			while (j < x + m) {
				j++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}
			}
		}
		return null;
	}

	public static Selectable closestGroundSelectable(Unit unit, HashMap<Coordinates, Selectable> positions) {

		int radius = unit.getRange();
		radius++;

		double x = unit.getPosition().getAbsciss();
		double y = unit.getPosition().getOrdinate();

		double j = x + 1;
		double i = y + 1;

		for (int m = 1; m <= radius; m++) {

			while (i > y - m) {
				i--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}

					}

				}

			}
			while (j > x - m) {
				j--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					}
				}

			}
			while (i < y + m) {
				i++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					}
				}
			}
			while (j < x + m) {
				j++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(unit, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					}
				}

			}
		}
		return null;
	}

	public static Selectable closestEnnemySelectable(DefenseBuilding defense, HashMap<Coordinates, Selectable> positions) {

		int radius = defense.getRange();
		radius++;

		double x = defense.getPosition().getAbsciss();
		double y = defense.getPosition().getOrdinate();

		double j = x + 1;
		double i = y + 1;

		for (int m = 1; m <= radius; m++) {

			while (i > y - m) {
				i--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}

			}
			while (j > x - m) {
				j--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}

			}
			while (i < y + m) {
				i++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}
			}
			while (j < x + m) {
				j++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);
					Coordinates positionAir = new Coordinates((int) j, (int) i, Constants.AIR);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					} else if (positions.containsKey(positionAir)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionAir))) {
							return positions.get(positionAir);
						}
					}
				}
			}
		}
		return null;
	}

	public static Selectable closestGroundSelectable(DefenseBuilding defense, HashMap<Coordinates, Selectable> positions) {

		int radius = defense.getRange();
		radius++;

		double x = defense.getPosition().getAbsciss();
		double y = defense.getPosition().getOrdinate();

		double j = x + 1;
		double i = y + 1;

		for (int m = 1; m <= radius; m++) {

			while (i > y - m) {
				i--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}

					}

				}

			}
			while (j > x - m) {
				j--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					}
				}

			}
			while (i < y + m) {
				i++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					}
				}
			}
			while (j < x + m) {
				j++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(radius, 2)) {
					Coordinates positionGround = new Coordinates((int) j, (int) i, Constants.GROUND);

					if (positions.containsKey(positionGround)) {
						if (SelectableTreatment.isEnnemy(defense, positions.get(positionGround))) {
							return positions.get(positionGround);
						}
					}
				}

			}
		}
		return null;
	}
}