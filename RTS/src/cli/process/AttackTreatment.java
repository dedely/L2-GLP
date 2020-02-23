package cli.process;

import java.util.HashMap;

import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
import cli.data.unit.Unit;

public class AttackTreatment {

	public void attack(Unit caster, Selectable target) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target.getPosition()) > caster.getRange()) {
			MoveToTreatment.moveToward(caster, target.getPosition());
		} else {
			if (SelectableTreatment.canShoot(caster, target)) {
				SelectableTreatment.dealDamage(caster, target);
				caster.setTimeLeftToReload(caster.getTimeBeetweenShots());
			}
		}
	}

	public void attack(DefenseBuilding caster, Selectable target) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target.getPosition()) <= caster.getRange()) {
			if (caster.getTimeLeftToReload() <= 0) {
				SelectableTreatment.dealDamage(caster, target);
				caster.setTimeLeftToReload(caster.getTimeBeetweenShots());
			} else {
				caster.setTimeLeftToReload(caster.getTimeLeftToReload() - 1);
			}
		}
	}

	public void attack(Unit caster, Coordinates target, HashMap<Coordinates, Selectable> positions) {
		if (CoordinatesTreatment.distance(caster.getPosition(), target) > caster.getRange()) {
			MoveToTreatment.moveToward(caster, target);
		} else {
			if (caster.getTimeLeftToReload() <= 0) {
				if (positions.containsKey(target)) {
					SelectableTreatment.dealDamage(caster, positions.get(target));
				}
				caster.setTimeLeftToReload(caster.getTimeBeetweenShots());
			} else {
				caster.setTimeLeftToReload(caster.getTimeLeftToReload() - 1);
			}
		}
	}

}