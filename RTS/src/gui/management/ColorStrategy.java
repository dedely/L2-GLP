package gui.management;

import java.awt.Graphics;
import java.awt.Graphics2D;

import data.building.UnitBuilding;
import data.unit.GroundUnit;
import data.unit.Worker;

public interface ColorStrategy {
	void setColor(Graphics graphics, GroundUnit selectable);

	void setColor(Graphics graphics, UnitBuilding selectable);

	void setColorSelected(Graphics graphics);

	void setColor(Graphics2D graphics, Worker selectable);
}