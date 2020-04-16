package process.visitor.order;

import data.order.*;
import data.unit.TroopTransport;
import process.executor.Executor;

/**
 * @author Adel
 *
 */
public class TroopTransportExVisitor implements OrderVisitor<Executor> {

	private TroopTransport unit;

	public TroopTransportExVisitor(TroopTransport unit) {
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
