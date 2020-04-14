package gui.management;

import java.awt.Color;
import java.awt.Graphics;

import data.Constants;
import data.building.UnitBuilding;
import data.unit.GroundUnit;

public class TestColorStrategy implements ColorStrategy {

	@Override
	public void setColor(Graphics graphics, GroundUnit selectable) {
		if(selectable.getPlayerName().equals(Constants.AI)) {
			graphics.setColor(Color.RED);
		}else {
			graphics.setColor(Color.BLUE);
		}
	}

	@Override
	public void setColor(Graphics graphics, UnitBuilding selectable) {
		if(selectable.isSelected()) {
			graphics.setColor(Color.GREEN);
		}else {
			if(selectable.getPlayerName().equals(Constants.AI)) {
				graphics.setColor(Color.RED);
			}else {
				graphics.setColor(Color.BLUE);
			}
		}
		
	}

	@Override
	public void setColorSelected(Graphics graphics) {
		graphics.setColor(Color.GREEN);
	}

}