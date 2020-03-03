package process;

import java.util.HashMap;

import data.Coordinates;
import data.Selectable;
import data.building.Building;
import data.unit.Unit;

public class AttackBuildingTreatment {

	public void attackBuilding(Unit caster, Building target) {
		int base = caster.getWeapon().getDamagePerShot();
		int damageType = caster.getWeapon().getTypeOfDammage();

		int armor = target.getArmorPoints();
		int armorType = target.getArmorType();
		int calculatedDamage = SelectableTreatment.calculDamage(base, damageType, armor, armorType);
		System.out.println("dealing " + calculatedDamage + "damage");
		System.out.println(
				"base = " + base + " damageType = " + damageType + " armor = " + armor + " armorType = " + armorType);
		SelectableTreatment.receiveDamage(target, calculatedDamage, caster);
	}
	
	public void attackBuilding (Unit caster, Building target, HashMap<Coordinates, Selectable> positions) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target.getPosition()) > caster.getWeapon().getRange()) {
			MoveToTreatment.moveToward(caster, target.getPosition());
		} else {
			if (SelectableTreatment.canShoot(caster, target)) {
				SelectableTreatment.dealDamage(caster, target);
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeBeetweenShots());
			}
		}
	}
	
	public void attackBuilding (Building caster, Building target) {
		
	}

}