package cli.data.building;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.faction.Faction;

public class Laboratory extends Building {

	private ArrayList<Integer> unlocksList = new ArrayList<Integer>();

	public Laboratory(String name, Faction faction, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, Size size, ArrayList<Integer> unlocksList) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, size);
		this.unlocksList = unlocksList;
	}
	
	public void add(Integer researchIndex) {
		unlocksList.add(researchIndex);
	}

}