package cli.data.building;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.faction.Faction;

public class ResearchBuilding extends Building {

	private ArrayList<Integer> unlocksList = new ArrayList<Integer>();

	public ResearchBuilding(String name, int cost, Faction faction, int maxHealth, int currentHealth, int armorPoints,
			int armorType, boolean selected, String description, Coordinates position, Size size,
			ArrayList<Integer> unlocksList) {
		super(name, cost, faction, maxHealth, currentHealth, armorPoints, armorType, selected, description, position,
				size);
		this.unlocksList = unlocksList;
	}

	public void add(Integer researchIndex) {
		unlocksList.add(researchIndex);
	}

}