package process.visitor;

import java.util.ArrayList;

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

public class OrderVisitor implements SelectableVisitor<ArrayList<String>> {

	@Override
	public ArrayList<String> visit(DefenseBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(ResearchBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(ResourceBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(UnitBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(AttackHelicopter selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(GroundUnit selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(GroundUnitWithMountedWeapon selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(TransportHelicopter selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(TroopTransport selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(Worker selectable) {
		// TODO Auto-generated method stub
		return null;
	}

}