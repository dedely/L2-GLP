package cli.process;

import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
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

}
