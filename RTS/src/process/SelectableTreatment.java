package process;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.building.Building;
import data.building.DefenseBuilding;
import data.order.Order;
import data.unit.GroundUnit;
import data.unit.GroundUnitWithMountedWeapon;
import data.unit.TroopTransport;
import data.unit.TransportHelicopter;
import data.unit.Unit;

public class SelectableTreatment {

	public static void receiveDamage(Selectable target, int amount, Unit caster) {
		target.setCurrentHealth(target.getCurrentHealth() - amount);
		if (target.getCurrentHealth() <= 0) {
			SelectableRepository.getInstance().addDeadUnit(target.getId());
		}
	}

	public static void receiveDamage(Selectable target, int amount, DefenseBuilding caster) {
		target.setCurrentHealth(target.getCurrentHealth() - amount);
		if (target.getCurrentHealth() <= 0) {
			SelectableRepository.getInstance().addDeadUnit(target.getId());
		}
	}

	public static void dealDamage(Unit caster, Selectable target) {
		int baseDamage = caster.getWeapon().getDamagePerShot();
		int damageType = caster.getWeapon().getTypeOfDammage();

		int armorPoints = target.getArmorPoints();
		int armorType = target.getArmorType();
		int calculatedDamage = calculDamage(baseDamage, damageType, armorPoints, armorType);
		receiveDamage(target, calculatedDamage, caster);
	}

	public static void dealDamage(DefenseBuilding caster, Selectable target) {
		int base = caster.getWeapon().getDamagePerShot();
		int damageType = caster.getWeapon().getTypeOfDammage();
		int armor = target.getArmorPoints();
		int armorType = target.getArmorType();
		int calculatedDamage = calculDamage(base, damageType, armor, armorType);
		receiveDamage(target, calculatedDamage, caster);
	}

	public static int calculDamage(int baseAmount, int damageType, int armor, int armorType) {
		return (int) (Math.max(baseAmount - (armor * ((armorType - damageType) / 2.0 + 1)), 1));
	}

	public static boolean canShoot(Unit unit, Selectable target) {
		if (unit.getPosition().getHeight() < 0) {
			return false;
		}

		return true;
	}

	public static boolean isReloaded(Unit unit) {
		if (unit.getWeapon().getTimeLeftToReload() > 0) {
			return false;
		} else
			return true;
	}

	public static void reloadWeapon(Unit unit) {
		unit.getWeapon().setTimeLeftToReload(unit.getWeapon().getTimeLeftToReload() - 1);
	}

	public static void moveToward(Unit unitToMove, Coordinates destination) {
		unitToMove.setPosition(CoordinatesTreatment.positionNextTick(unitToMove, destination));
	}

	public static void changePositionState(Unit unitToUpdate, int newState) {
		unitToUpdate.setPosition(new Coordinates(unitToUpdate.getPosition(), newState));
	}

	public static void getIn(GroundUnit unitToEmbark, TransportHelicopter whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getUnitSlotsAvailable();
		int unitSize = unitToEmbark.getUnitSlots();
		if (canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setUnitSlotsAvailable(unitsSlotsAvailable - unitSize);
			whereToEmbark.getUnitsIn().add(unitToEmbark);
			unitToEmbark.getPosition().setHeight(Constants.CARRIED);

		}

	}

	public static boolean canEmbark(GroundUnit unitToEmbark, TransportHelicopter whereToEmbark) {

		int unitsSlotsAvailable = whereToEmbark.getUnitSlotsAvailable();
		int unitSize = unitToEmbark.getUnitSlots();
		if (unitsSlotsAvailable >= unitSize) {
			return true;
		} else {
			return false;
		}
	}

	public static void getIn(GroundUnit unitToEmbark, TroopTransport whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getInfantrySeatsRemaining();
		int unitSize = unitToEmbark.getUnitSlots();
		if (canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setInfantrySeatsRemaining(unitsSlotsAvailable - unitSize);
			whereToEmbark.getUnitsIn().add(unitToEmbark);
			unitToEmbark.getPosition().setHeight(Constants.CARRIED);
		}

	}

	public static boolean isEmbarkable(Selectable whereToEmbark) {
		try {
			((TroopTransport) whereToEmbark).getName();
			return true;

		} catch (Exception e) {

		}
		try {
			((TransportHelicopter) whereToEmbark).getName();
			return true;

		} catch (Exception e) {

		}
		try {
			((GroundUnitWithMountedWeapon) whereToEmbark).getName();
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	public static boolean canEmbark(GroundUnit unitToEmbark, TroopTransport whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getInfantrySeatsRemaining();
		int unitSize = unitToEmbark.getUnitSlots();
		if (unitsSlotsAvailable >= unitSize) {
			return true;
		} else {
			return false;
		}
	}

	public static void getIn(GroundUnit unitToEmbark, GroundUnitWithMountedWeapon whereToEmbark) {
		if (canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setInfanteryIn(unitToEmbark);
			unitToEmbark.getPosition().setHeight(Constants.OPERATING_TURRET);
		}

	}

	public static void getIn(Unit unitToEmbark, Selectable whereToEmbark) {
		if (canEmbark(unitToEmbark, whereToEmbark)) {
			try {
				((TroopTransport) whereToEmbark).getName();
				getIn(unitToEmbark, whereToEmbark);

			} catch (Exception e) {

			}
			try {
				((TransportHelicopter) whereToEmbark).getName();
				getIn(unitToEmbark, whereToEmbark);

			} catch (Exception e) {

			}
			try {
				((GroundUnitWithMountedWeapon) whereToEmbark).getName();
				getIn(unitToEmbark, whereToEmbark);

			} catch (Exception e) {

			}
		}
	}

	public static boolean canEmbark(GroundUnit unitToEmbark, GroundUnitWithMountedWeapon whereToEmbark) {

		if (unitToEmbark.getUnitSlots() == 1 && whereToEmbark.getInfanteryIn() == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean canEmbark(Unit unitToEmbark, Selectable whereToEmbark) {

		try {
			((TroopTransport) whereToEmbark).getName();
			return canEmbark(unitToEmbark, whereToEmbark);

		} catch (Exception e) {

		}
		try {
			((TransportHelicopter) whereToEmbark).getName();
			return canEmbark(unitToEmbark, whereToEmbark);

		} catch (Exception e) {

		}
		try {
			((GroundUnitWithMountedWeapon) whereToEmbark).getName();
			return canEmbark(unitToEmbark, whereToEmbark);

		} catch (Exception e) {

		}
		return false;
	}

	/*public static boolean areEnnemies(Selectable caster, Selectable target) {
		if (caster.getFaction().getTeam() != target.getFaction().getTeam()) {
			return true;
		} else
			return false;
	}*/

	public static boolean haveUnit(ArrayList<Selectable> selectedCollection) {
		for(Selectable s : selectedCollection) {
			if(s instanceof Unit) {
				return true;
			}
				
		}
		return false;
	}

	public static boolean areUnits(ArrayList<Selectable> selectedCollection) {
		for(Selectable s : selectedCollection) {
			if(s instanceof Building) {
				return false;
			}
				
		}
		return true;
	}
	
	public static boolean areBuildings(ArrayList<Selectable> selectedCollection) {
		for(Selectable s : selectedCollection) {
			if(s instanceof Unit) {
				return false;
			}
				
		}
		return true;
	}

}
