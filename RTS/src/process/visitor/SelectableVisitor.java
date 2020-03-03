package process.visitor;


import data.building.*;
import data.unit.*;

public interface SelectableVisitor<T> {
	T visit(DefenseBuilding selectable);

	T visit(ResearchBuilding selectable);

	T visit(ResourceBuilding selectable);

	T visit(UnitBuilding selectable);

	T visit(AttackHelicopter selectable);

	T visit(GroundUnit selectable);

	T visit(GroundUnitWithMountedWeapon selectable);

	T visit(TransportHelicopter selectable);

	T visit(TroopTransport selectable);

	T visit(Worker selectable);

}