package process.visitor.order;

import data.building.DefenseBuilding;
import data.order.*;
import process.executor.Executor;

/**
 * @author Adel
 *
 */
public class DefenseBuildingExVisitor implements OrderVisitor<Executor> {

	private DefenseBuilding building;

	public DefenseBuildingExVisitor(DefenseBuilding building) {
		this.building = building;
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
