package cli.process.factory;

import cli.data.Constants;
import cli.data.faction.Faction;

public class FactionFactory {
	public static Faction createFaction(String side) throws IllegalArgumentException {
		if(side == Constants.FEDERATION)
		return new Faction(name, playerName, researchTree, description)
		if(side == Constants.UNION)
			return new Weapon(100, Constants.LIGHT, 10, 100, 10, true);
		if(side == Constants.REPUBLIC)
			return new Weapon(100, Constants.SUPER_LIGHT, 10, 100, 10, true);
		throw new IllegalArgumentException("Type of weapon "+side+" is not defined");
	}
}
