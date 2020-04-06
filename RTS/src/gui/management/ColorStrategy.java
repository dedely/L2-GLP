package gui.management;

import java.awt.Graphics;

import data.building.UnitBuilding;
import data.unit.GroundUnit;

public interface ColorStrategy {
	void setColor(Graphics graphics, GroundUnit selectable);

	void setColor(Graphics graphics, UnitBuilding selectable);

	void setColorSelected(Graphics graphics);
}