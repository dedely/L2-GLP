package gui.management;

import data.building.DefenseBuilding;
import data.building.ResearchBuilding;
import data.building.ResourceBuilding;
import data.building.UnitBuilding;
import data.unit.AttackHelicopter;
import data.unit.GroundUnit;
import data.unit.GroundUnitWithMountedWeapon;
import data.unit.TransportHelicopter;
import data.unit.TroopTransport;
import data.unit.Worker;
import process.visitor.selectable.SelectableVisitor;

public class InputVisitor implements SelectableVisitor<Void> {

	@Override
	public Void visit(DefenseBuilding selectable) {
		return null;
	}

	@Override
	public Void visit(ResearchBuilding selectable) {
		return null;
	}

	@Override
	public Void visit(ResourceBuilding selectable) {
		return null;
	}

	@Override
	public Void visit(UnitBuilding selectable) {
		return null;
	}

	@Override
	public Void visit(AttackHelicopter selectable) {
		return null;
	}

	@Override
	public Void visit(GroundUnit selectable) {
		return null;
	}

	@Override
	public Void visit(GroundUnitWithMountedWeapon selectable) {
		return null;
	}

	@Override
	public Void visit(TransportHelicopter selectable) {
		return null;
	}

	@Override
	public Void visit(TroopTransport selectable) {
		return null;
	}

	@Override
	public Void visit(Worker selectable) {
		return null;
	}

}