package process;

import java.util.HashMap;

import data.Coordinates;
import data.Selectable;
import data.building.DefenseBuilding;
import data.unit.Unit;

public class AttackTreatment {
	

	public static void attack(Unit caster, Selectable target) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target.getPosition()) > caster.getWeapon().getRange()) {
			MoveToTreatment.moveToward(caster, target.getPosition());
		} else {
			if (SelectableTreatment.canShoot(caster, target)) {
				SelectableTreatment.dealDamage(caster, target);
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeBeetweenShots());
			}
		}
	}

	public static void attack(DefenseBuilding caster, Selectable target) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target.getPosition()) <= caster.getWeapon().getRange()) {
			if (caster.getWeapon().getTimeLeftToReload() <= 0) {
				SelectableTreatment.dealDamage(caster, target);
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeBeetweenShots());
			} else {
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeLeftToReload() - 1);
			}
		}
	}

	public void attack(Unit caster, Coordinates target, HashMap<Coordinates, Selectable> positions) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target) > caster.getWeapon().getRange()) {
			MoveToTreatment.moveToward(caster, target);
		} else {
			if (caster.getWeapon().getTimeLeftToReload() <= 0) {
				if (positions.containsKey(target)) {
					SelectableTreatment.dealDamage(caster, positions.get(target));
				}
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeBeetweenShots());
			} else {
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeLeftToReload() - 1);
			}
		}
	}

}