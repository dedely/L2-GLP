package process.executor;

import data.Selectable;
import data.unit.Unit;
import process.CoordinatesTreatment;
import process.SelectableTreatment;

/**
 * @author Adel
 *
 */
public class AttackExecutor implements Executor {

	private Unit caster;
	private Selectable target;
	private Executor helper = null;

	public AttackExecutor(Unit caster, Selectable target) {
		this.caster = caster;
		this.target = target;
	}

	@Override
	public boolean execute() {
		if (CoordinatesTreatment.distance(caster.getPosition(), target.getPosition()) >= caster.getWeapon()
				.getRange()) {
			move();
		} else {
			attack();
		}
		return target.getCurrentHealth() <= 0;
	}

	private void attack() {
		if (SelectableTreatment.canShoot(caster, target)) {
			if (isReloaded()) {
				SelectableTreatment.dealDamage(caster, target);
				caster.getWeapon().setTimeLeftToReload(caster.getWeapon().getTimeBeetweenShots());
			} else {
				SelectableTreatment.reloadWeapon(caster);
			}
		}
	}

	private void move() {
		if (helper == null) {
			helper = new MoveExecutor(caster, target.getPosition());
		} else {
			helper.execute();
		}
	}

	private boolean isReloaded() {
		return caster.getWeapon().getTimeLeftToReload() == 0;
	}

	@Override
	public int getProgress() {
		return 0;
	}

}