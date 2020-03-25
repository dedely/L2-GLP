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
import gui.management.ButtonFactory;

/**
 * This visitor can return the possible actions of a {@link Selectable} as a
 * collection of String.
 * 
 * @author Adel
 *
 */
public class ActionVisitor implements SelectableVisitor<ArrayList<String>> {

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
		ArrayList<String> actions = new ArrayList<String>();
		actions.add(ButtonFactory.TEST_BUTTON);
		return actions;
	}

	@Override
	public ArrayList<String> visit(AttackHelicopter selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> visit(GroundUnit selectable) {
		ArrayList<String> actions = new ArrayList<String>();
		//actions.add("");
		return actions;
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