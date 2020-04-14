package gui.management;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

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
import gui.elements.SimuPara;
import process.Camera;
import process.visitor.SelectableVisitor;

/**
 * This visitor prints the selectables.
 * 
 * @author Adel
 *
 */
public class PaintVisitor implements SelectableVisitor<Void> {

	private Graphics2D graphics;
	private int offsetX;
	private int offsetY;
	private ColorStrategy colorStrategy = new TestColorStrategy();

	public PaintVisitor(Graphics2D graphics, Camera camera) {
		this.graphics = graphics;
		offsetX = camera.getMinX();
		offsetY = camera.getMinY();
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
		colorStrategy.setColor(graphics, selectable);
		printSquare(selectable);
		// printSelected(selectable);
		return null;
	}

	@Override
	public Void visit(AttackHelicopter selectable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(GroundUnit selectable) {
		colorStrategy.setColor(graphics, selectable);
		printCircle(selectable);
		printSelected(selectable);
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
		colorStrategy.setColor(graphics, selectable);
		printCircle(selectable);
		printSelected(selectable);
		return null;
	}

	private void printCircle(Selectable selectable) {
		Shape shape = new Ellipse2D.Double(selectable.getPositionX() - offsetX * SimuPara.SCALE,
				selectable.getPositionY() - offsetY * SimuPara.SCALE, SimuPara.RADIUS, SimuPara.RADIUS);
		graphics.fill(shape);
		ShapeRepository.getInstance().addShape(selectable, shape);
	}

	private void printSquare(UnitBuilding selectable) {
		Shape shape = new Rectangle2D.Double(selectable.getPositionX() - offsetX  * SimuPara.SCALE,
				selectable.getPositionY() - offsetY * SimuPara.SCALE, SimuPara.RADIUS, SimuPara.RADIUS);
		graphics.fill(shape);
		ShapeRepository.getInstance().addShape(selectable, shape);
	}

	private void printSelected(Selectable selectable) {
		if (selectable.isSelected()) {
			colorStrategy.setColorSelected(graphics);
			graphics.drawOval((selectable.getPositionX() - offsetX * SimuPara.SCALE) - 8 / 2,
					(selectable.getPositionY() - offsetY * SimuPara.SCALE) - 8 / 2, SimuPara.RADIUS + 8, SimuPara.RADIUS + 8);
		}
	}

}