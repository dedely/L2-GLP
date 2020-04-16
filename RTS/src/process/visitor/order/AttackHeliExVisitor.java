package process.visitor.order;

import data.order.*;
import data.unit.AttackHelicopter;
import process.executor.Executor;

/**
 * @author Adel
 *
 */
public class AttackHeliExVisitor implements OrderVisitor<Executor> {

	private AttackHelicopter unit;

	public AttackHeliExVisitor(AttackHelicopter unit) {
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
