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
		receiveDamage(target, calculDamage(caster.getDamagePerShot(), caster.getTypeOfDammage(),
				target.getArmorPoints(), target.getArmorType()), caster);
	}

	public void dealDamage(DefenseBuilding caster, Selectable target) {
		receiveDamage(target, calculDamage(caster.getDamage(), 0, target.getArmorPoints(), target.getArmorType()),
				caster);
	}

	public int calculDamage(int baseAmount, int damageType, int armor, int armorType) {
		return (Math.max(baseAmount - (armor * (armorType - damageType) / 2 + 1), 1));
	}

}
