package process.visitor;

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

public class UnitExecutionVisitor implements OrderVisitor<Executor> {

	private Unit unit;


	public UnitExecutionVisitor(Unit unit) {
		this.unit = unit;
	}

	@Override
	public Executor visit(Attack order) {
		return new AttackExecutor(unit, order.getTarget());
	}

	@Override
	public Executor visit(AttackBuilding order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(AttackPosition order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(Build order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(CreateUnit order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(Defend order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(Embark order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(MoveToPosition order) {
		return new MoveExecutor(unit, order.getPosition());
	}

	@Override
	public Executor visit(MoveToTarget order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(AttackSuicide order) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
