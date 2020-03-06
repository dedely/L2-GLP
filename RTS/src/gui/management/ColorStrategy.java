package gui.management;

import java.awt.Graphics;

import data.unit.GroundUnit;

public interface ColorStrategy {
	void setColor(Graphics graphics, GroundUnit selectable);
	
	void setColorSelected(Graphics graphics);
}