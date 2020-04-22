package gui.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import data.Constants;
import data.Selectable;
import data.building.DefenseBuilding;
import data.building.ResearchBuilding;
import data.building.ResourceBuilding;
import data.building.UnitBuilding;
import data.unit.AttackHelicopter;
import data.unit.GroundUnit;
import data.unit.TransportHelicopter;
import data.unit.Worker;

/**
 * @author Adel
 *
 */
public class TestColorStrategy implements ColorStrategy {

	@Override
	public void setColor(Graphics graphics, UnitBuilding selectable) {
		if (selectable.isSelected()) {
			graphics.setColor(Color.GREEN);
		} else {
			if (selectable.getPlayerName().equals(Constants.AI)) {
				graphics.setColor(Color.RED);
			} else {
				graphics.setColor(Color.BLUE);
			}
		}
	}

	@Override
	public void setColorSelected(Graphics graphics) {
		graphics.setColor(Color.GREEN);
	}

	@Override
	public void setColor(Graphics2D graphics, Worker selectable) {
		if (selectable.getPlayerName().equals(Constants.AI)) {
			graphics.setColor(Color.RED);
		} else {
			graphics.setColor(Color.BLUE);
		}
	}

	@Override
	public void setColor(Graphics2D graphics, ResearchBuilding selectable) {
		if (selectable.isSelected()) {
			graphics.setColor(Color.GREEN);
		} else {
			if (selectable.getPlayerName().equals(Constants.AI)) {
				graphics.setColor(Color.RED);
			} else {
				graphics.setColor(Color.BLUE);
			}
		}

	}

	@Override
	public void setColor(Graphics2D graphics, TransportHelicopter selectable) {
		if (selectable.getPlayerName().equals(Constants.AI)) {
			graphics.setColor(Color.RED);
		} else {
			graphics.setColor(Color.BLUE);
		}
	}

	@Override
	public void setColor(Graphics2D graphics, AttackHelicopter selectable) {
		if (selectable.getPlayerName().equals(Constants.AI)) {
			graphics.setColor(Color.RED);
		} else {
			graphics.setColor(Color.BLUE);
		}
	}

	@Override
	public void setColor(Graphics2D graphics, DefenseBuilding selectable) {
		if (selectable.isSelected()) {
			graphics.setColor(Color.GREEN);
		} else {
			if (selectable.getPlayerName().equals(Constants.AI)) {
				graphics.setColor(Color.RED);
			} else {
				graphics.setColor(Color.BLUE);
			}
		}

	}

	@Override
	public void setColor(Graphics graphics, ResourceBuilding selectable) {
		if (selectable.isSelected()) {
			graphics.setColor(Color.GREEN);
		} else {
			if (selectable.getPlayerName().equals(Constants.AI)) {
				graphics.setColor(Color.RED);
			} else {
				graphics.setColor(Color.BLUE);
			}
		}
	}

	@Override
	public void setColor(Graphics2D graphics, GroundUnit selectable) {
		if (selectable.getPlayerName().equals(Constants.AI)) {
			graphics.setColor(Color.RED);
		} else {
			graphics.setColor(Color.BLUE);
		}
	}

}