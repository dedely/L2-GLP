package cli.process;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.Building;
import cli.data.building.DefenseBuilding;
import cli.data.faction.Faction;
import cli.data.order.Order;
import cli.data.unit.GroundUnit;
import cli.data.unit.GroundUnitWithMountedWeapon;
import cli.data.unit.TroopTransport;
import cli.data.unit.TransportHelicopter;
import cli.data.unit.Unit;

public class SelectableTreatment {

	public static void receiveDamage(Selectable target, int amount, Unit caster) {
		target.setCurrentHealth(target.getCurrentHealth() - amount);
		if (target.getCurrentHealth() <= 0) {
			System.out.println(target.getName() + " was killed by " + caster.getName());
		}

	}

	public static void receiveDamage(Selectable target, int amount, DefenseBuilding caster) {
		target.setCurrentHealth(target.getCurrentHealth() - amount);
		if (target.getCurrentHealth() <= 0) {
			System.out.println(target.getName() + " was killed by " + caster.getName());
		}

	}

	public static void dealDamage(Unit caster, Selectable target) {
		int baseDamage = caster.getWeapon().getDamagePerShot();
		int damageType = caster.getWeapon().getTypeOfDammage();

		int armorPoints = target.getArmorPoints();
		int armorType = target.getArmorType();
		int calculatedDamage = calculDamage(baseDamage, damageType, armorPoints, armorType);
		System.out.println("dealing " + calculatedDamage + "damage");
		System.out.println("base = " + baseDamage + " damageType = " + damageType + " armor = " + armorPoints
				+ " armorType = " + armorType);
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
		if (unit.getWeapon().getTimeLeftToReload() > 0) {
			return false;
		}

		return true;
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
		}

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
		}

	}

	public static boolean canEmbark(GroundUnit unitToEmbark, GroundUnitWithMountedWeapon whereToEmbark) {

		if (unitToEmbark.getUnitSlots() == 1 && whereToEmbark.getInfanteryIn() == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEnnemy(Selectable caster, Selectable target, Faction casterFaction) {
		if (casterFaction.getEnnemies().contains(target.getFaction())) {
			return true;
		} else
			return false;
	}

	public static void giveOrderReplace(Selectable orderReceiver, Order order) {
		ArrayList<Order> newOrderList = new ArrayList<Order>();
		newOrderList.add(order);
		orderReceiver.setOrders(newOrderList);

	}

	public static void giveOrderStagger(Selectable orderReceiver, Order order) {
		ArrayList<Order> newOrderList = orderReceiver.getOrders();
		newOrderList.add(order);
		orderReceiver.setOrders(newOrderList);

	}

	public static void executeNextOrder(Building currentBuilding) {
		if (!currentBuilding.getOrders().isEmpty()) {
			/*
			 * OrderTreatment.executeOrder(currentbuilding,
			 * currentBuilding.getOrders().get(0))
			 */
		}
	}

	public static void executeNextOrder(Unit currentUnit) {
		if (!currentUnit.getOrders().isEmpty()) {
			/*
			 * OrderTreatment.executeOrder(currentUnit, currentUnit.getOrders().get(0))
			 */
		}

	}
}
