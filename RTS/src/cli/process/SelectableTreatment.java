package cli.process;


import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
import cli.data.unit.ArtilleryWithMountedWeapon;
import cli.data.unit.GroundUnit;
import cli.data.unit.HeavyTVWithMountedWeapon;
import cli.data.unit.LightTV;
import cli.data.unit.TransportHelicopter;
import cli.data.unit.Unit;

public class SelectableTreatment {

	public static void receiveDamage(Selectable target, int amount, Unit caster) {
		target.setHealth(target.getHealth() - amount);
		if (target.getHealth() <= 0) {
			System.out.println(target.getName() + " was killed by " + caster.getName());
		}

	}

	public static void receiveDamage(Selectable target, int amount, DefenseBuilding caster) {
		target.setHealth(target.getHealth() - amount);
		if (target.getHealth() <= 0) {
			System.out.println(target.getName() + " was killed by " + caster.getName());
		}

	}

	public static void dealDamage(Unit caster, Selectable target) {
		int base = caster.getDamagePerShot();
		int damageType = caster.getTypeOfDammage();
		int armor = target.getArmorPoints();
		int armorType = target.getArmorType();
		int calculatedDamage = calculDamage(base, damageType, armor, armorType);
		System.out.println("dealing " + calculatedDamage + "damage");
		System.out.println(
				"base = " + base + " damageType = " + damageType + " armor = " + armor + " armorType = " + armorType);
		receiveDamage(target, calculatedDamage, caster);
	}

	public static void dealDamage(DefenseBuilding caster, Selectable target) {
		int base = caster.getDamage();
		int damageType = caster.getDamageType();
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
		if(unit.getTimeLeftToReload() > 0) {
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
		if( canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setUnitSlotsAvailable(unitsSlotsAvailable-unitSize);
			whereToEmbark.getUnitsIn().add(unitToEmbark);
		}
		
	}
	
	public static boolean canEmbark(GroundUnit unitToEmbark, TransportHelicopter whereToEmbark) {

		int unitsSlotsAvailable = whereToEmbark.getUnitSlotsAvailable();
		int unitSize = unitToEmbark.getUnitSlots();
		if( unitsSlotsAvailable >= unitSize) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void getIn(GroundUnit unitToEmbark, LightTV whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getInfantrySeatsRemaining();
		int unitSize = unitToEmbark.getUnitSlots();
		if( canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setInfantrySeatsRemaining(unitsSlotsAvailable-unitSize);
			whereToEmbark.getUnitsIn().add(unitToEmbark);
		}
		
	}

	public static boolean canEmbark(GroundUnit unitToEmbark, LightTV whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getInfantrySeatsRemaining();
		int unitSize = unitToEmbark.getUnitSlots();
		if( unitsSlotsAvailable >= unitSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void getIn(GroundUnit unitToEmbark, HeavyTVWithMountedWeapon whereToEmbark) {
		if( canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setInfanteryIn(unitToEmbark);
		}
		
	}

	public static boolean canEmbark(GroundUnit unitToEmbark, HeavyTVWithMountedWeapon whereToEmbark) {
		if( unitToEmbark.getUnitSlots()== 1 && whereToEmbark.getInfanteryIn()==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void getIn(GroundUnit unitToEmbark, ArtilleryWithMountedWeapon whereToEmbark) {
		if( canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setInfanteryIn(unitToEmbark);
		}
		
	}

	public static boolean canEmbark(GroundUnit unitToEmbark, ArtilleryWithMountedWeapon whereToEmbark) {
		if( unitToEmbark.getUnitSlots()== 1 && whereToEmbark.getInfanteryIn()==null) {
			return true;
		}
		else {
			return false;
		}
	}
}
