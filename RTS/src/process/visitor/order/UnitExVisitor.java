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
import data.unit.Unit;
import process.executor.AttackExecutor;
import process.executor.Executor;
import process.executor.MoveExecutor;

/**
 * @author Adel
 *
 */
public class UnitExVisitor implements OrderVisitor<Executor> {

	private Unit unit;

	public UnitExVisitor(Unit unit) {
		this.unit = unit;
	}

	@Override
	public Executor visit(Attack order) {
		return new AttackExecutor(unit, order.getTarget());
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
		return new MoveExecutor(unit, order.getPosition());
	}

	@Override
	public Executor visit(MoveToTarget order) {
		return null;
	}

	@Override
	public Executor visit(AttackSuicide order) {
		return null;
	}

}
