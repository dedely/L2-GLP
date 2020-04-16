package process.visitor.order;

import data.order.Attack;
import data.order.AttackBuilding;
import data.order.AttackPosition;
import data.order.AttackSuicide;
import data.order.Build;
import data.order.CreateUnit;
import data.order.Defend;
import data.order.Embark;
import data.order.MoveToPosition;
import data.order.MoveToTarget;
import data.unit.GroundUnit;
import process.executor.Executor;

/**
 * @author Adel
 *
 */
public class GroundUnitExVisitor implements OrderVisitor<Executor> {

	private GroundUnit unit;

	public GroundUnitExVisitor(GroundUnit unit) {
		this.unit = unit;
	}

	@Override
	public Executor visit(Attack order) {
		return null;
	}

	@Override
	public Executor visit(AttackSuicide order) {
		return null;
	}

	@Override
	public Executor visit(AttackBuilding order) {
		return null;
	}

	@Override
	public Executor visit(AttackPosition order) {
		return null;
	}

	@Override
	public Executor visit(Build order) {
		return null;
	}

	@Override
	public Executor visit(CreateUnit order) {
		return null;
	}

	@Override
	public Executor visit(Defend order) {
		return null;
	}

	@Override
	public Executor visit(Embark order) {
		return null;
	}

	@Override
	public Executor visit(MoveToPosition order) {
		return null;
	}

	@Override
	public Executor visit(MoveToTarget order) {
		return null;
	}

}
