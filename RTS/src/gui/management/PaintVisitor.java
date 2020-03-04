package gui.management;

import java.awt.Graphics;

import data.Coordinates;
import data.Selectable;
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
import gui.elements.Camera;
import gui.elements.SimuPara;
import process.visitor.SelectableVisitor;

/**
 * This visitor print the selectables.
 * 
 * @author Adel
 *
 */
public class PaintVisitor implements SelectableVisitor<Void> {

	private Graphics graphics;
	private Camera camera;

	public PaintVisitor(Graphics graphics, Camera camera) {
		this.graphics = graphics;
		this.camera = camera;
	}

	@Override
	public Void visit(DefenseBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ResearchBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ResourceBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(UnitBuilding selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(AttackHelicopter selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(GroundUnit selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(GroundUnitWithMountedWeapon selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(TransportHelicopter selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(TroopTransport selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Worker selectable) {
		printCircle(selectable);
		return null;
	}

	private void printCircle(Selectable selectable) {
		Coordinates position = selectable.getPosition();
		int x=position.getAbsciss()+5;
		int y=position.getAbsciss()-5;
		graphics.drawOval(x, y, 11, 11);
	}
}