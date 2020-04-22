package gui.management;

import java.awt.Graphics;
import java.awt.Graphics2D;

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
public interface ColorStrategy {
	void setColor(Graphics graphics, ResourceBuilding selectable);

	void setColor(Graphics graphics, UnitBuilding selectable);

	void setColorSelected(Graphics graphics);

	void setColor(Graphics2D graphics, Worker selectable);

	void setColor(Graphics2D graphics, ResearchBuilding selectable);

	void setColor(Graphics2D graphics, TransportHelicopter selectable);

	void setColor(Graphics2D graphics, AttackHelicopter selectable);

	void setColor(Graphics2D graphics, DefenseBuilding selectable);

	void setColor(Graphics2D graphics, GroundUnit selectable);

}