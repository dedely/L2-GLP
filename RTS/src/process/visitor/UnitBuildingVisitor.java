package process.visitor;

import data.building.UnitBuilding;
import data.order.Attack;
import data.order.AttackBuilding;
import data.order.AttackPosition;
import data.order.Build;
import data.order.CreateUnit;
import data.order.Defend;
import data.order.Embark;
import data.order.MoveToPosition;
import data.order.MoveToTarget;
import process.FactionTest;
import process.executor.CreateUnitExecutor;
import process.executor.Executor;

public class UnitBuildingVisitor implements OrderVisitor<Executor> {

	private UnitBuilding unitBuilding;
	private FactionTest player;

	public UnitBuildingVisitor(UnitBuilding unitBuilding, FactionTest player) {
		this.unitBuilding = unitBuilding;
		this.player = player;
	}

	@Override
	public Executor visit(Attack order) {
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
		return new CreateUnitExecutor(player, unitBuilding, order.getUnitToCreate());
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
