package gui.management;

import java.awt.Color;
import java.awt.Graphics;

import data.unit.GroundUnit;

public class TestColorStrategy implements ColorStrategy {

	@Override
	public void setColor(Graphics graphics, GroundUnit selectable) {
		graphics.setColor(Color.BLUE);
	}

	@Override
	public void setColorSelected(Graphics graphics) {
		graphics.setColor(Color.GREEN);
	}

}