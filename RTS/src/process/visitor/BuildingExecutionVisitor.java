package process.visitor;

import data.building.Building;
import data.order.Attack;
import data.order.AttackBuilding;
import data.order.AttackPosition;
import data.order.Build;
import data.order.CreateUnit;
import data.order.Defend;
import data.order.Embark;
import data.order.MoveToPosition;
import data.order.MoveToTarget;
import process.executor.Executor;

public class BuildingExecutionVisitor implements OrderVisitor<Executor> {
	private Building building;

	public BuildingExecutionVisitor(Building building) {
		this.building = building;
	}

	@Override
	public Executor visit(Attack order) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public Executor visit(CreateUnit order) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor visit(MoveToTarget order) {
		// TODO Auto-generated method stub
		return null;
	}

}
