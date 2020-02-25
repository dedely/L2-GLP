package cli.process;

import cli.data.building.Building;
import cli.data.unit.Unit;

public class AttackBuildingTreatment {

	public void attackBuilding (Unit caster, Building target) {
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
	
}
