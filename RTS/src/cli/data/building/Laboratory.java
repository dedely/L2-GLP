package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;


public class Laboratory extends Building {
	
	private 
	
	public Laboratory (int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
	}
	
}