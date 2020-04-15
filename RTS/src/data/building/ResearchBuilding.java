package data.building;

import java.util.ArrayList;

import data.Coordinates;
import process.visitor.SelectableVisitor;

public class ResearchBuilding extends Building {

	private ArrayList<Integer> unlocksList = new ArrayList<Integer>();

	public ResearchBuilding(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, ArrayList<Integer> unlocksList) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, size);
		this.unlocksList = unlocksList;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public void add(Integer researchIndex) {
		unlocksList.add(researchIndex);
	}

}