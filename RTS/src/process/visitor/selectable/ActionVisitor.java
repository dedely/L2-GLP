package process.visitor.selectable;

import java.util.ArrayList;

import data.Action;
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

	ButtonFactory factory = ButtonFactory.getInstance();

	@Override
	public ArrayList<String> visit(DefenseBuilding selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(ResearchBuilding selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(ResourceBuilding selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(UnitBuilding selectable) {

		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(AttackHelicopter selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(GroundUnit selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(GroundUnitWithMountedWeapon selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(TransportHelicopter selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(TroopTransport selectable) {
		return getActions(selectable.getName());
	}

	@Override
	public ArrayList<String> visit(Worker selectable) {
		return getActions(selectable.getName());
	}

	private ArrayList<String> getActions(String name) {
		ArrayList<String> actions = null;
		Action action = factory.getAction(name);
		if (action != null) {
			actions = action.getActions();
		}
		return actions;
	}
}