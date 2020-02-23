package cli.process;

import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
import cli.data.unit.GroundUnit;
import cli.data.unit.LightTV;
import cli.data.unit.TransportHelicopter;
import cli.data.unit.Unit;

public class SelectableTreatment {

	public void receiveDamage(Selectable target, int amount, Unit caster) {
		target.setHealth(target.getHealth() - amount);
		if (target.getHealth() <= 0) {
			System.out.println(target.getName() + " was killed by " + caster.getName());
		}

	}

	public void receiveDamage(Selectable target, int amount, DefenseBuilding caster) {
		target.setHealth(target.getHealth() - amount);
		if (target.getHealth() <= 0) {
			System.out.println(target.getName() + " was killed by " + caster.getName());
		}

	}

	public void dealDamage(Unit caster, Selectable target) {
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

	public void dealDamage(DefenseBuilding caster, Selectable target) {
		int base = caster.getDamage();
		int damageType = caster.getDamageType();
		int armor = target.getArmorPoints();
		int armorType = target.getArmorType();
		int calculatedDamage = calculDamage(base, damageType, armor, armorType);
		receiveDamage(target, calculatedDamage, caster);
	}

	public int calculDamage(int baseAmount, int damageType, int armor, int armorType) {
		return (int) (Math.max(baseAmount - (armor * ((armorType - damageType) / 2.0 + 1)), 1));
	}
	
	public Coordinates positionNextTick(Unit unitToMove, Coordinates destination) {
		Coordinates origin = unitToMove.getPosition();
		int deltaX = destination.getAbsciss()-origin.getAbsciss();
		int deltaY = destination.getOrdinate()-origin.getOrdinate();
		double length = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
		if (unitToMove.getSpeed()<length) {
		int newX = (int) Math.round((origin.getAbsciss()+(deltaX/length*unitToMove.getSpeed())));
		int newY = (int) Math.round((origin.getOrdinate()+(deltaY/length*unitToMove.getSpeed())));
		return new Coordinates(newX, newY, origin.getHeight());
		}
		else
			return destination;
		
	}
	
	public void moveToward(Unit unitToMove, Coordinates destination) {
		unitToMove.setPosition(positionNextTick(unitToMove, destination));
	}
	
	public void changePositionState(Unit unitToUpdate, int newState){
		unitToUpdate.setPosition(new Coordinates(unitToUpdate.getPosition(), newState));
	}
	
	public void getIn(GroundUnit unitToEmbark, TransportHelicopter whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getUnitSlotsAvailable();
		int unitSize = unitToEmbark.getUnitSlots();
		if( canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setUnitSlotsAvailable(unitsSlotsAvailable-unitSize);
			whereToEmbark.getUnitsIn().add(unitToEmbark);
		}
		
	}
	
	public boolean canEmbark(GroundUnit unitToEmbark, TransportHelicopter whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getUnitSlotsAvailable();
		int unitSize = unitToEmbark.getUnitSlots();
		if( unitsSlotsAvailable >= unitSize) {
			return true;
		}
		else {
			return false;
		}
	}
	public void getIn(GroundUnit unitToEmbark, LightTV whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getInfantrySeatsRemaining();
		int unitSize = unitToEmbark.getUnitSlots();
		if( canEmbark(unitToEmbark, whereToEmbark)) {
			whereToEmbark.setInfantrySeatsRemaining(unitsSlotsAvailable-unitSize);
			whereToEmbark.getUnitsIn().add(unitToEmbark);
		}
		
	}
	
	public boolean canEmbark(GroundUnit unitToEmbark, LightTV whereToEmbark) {
		int unitsSlotsAvailable = whereToEmbark.getInfantrySeatsRemaining();
		int unitSize = unitToEmbark.getUnitSlots();
		if( unitsSlotsAvailable >= unitSize) {
			return true;
		}
		else {
			return false;
		}
	}
}
