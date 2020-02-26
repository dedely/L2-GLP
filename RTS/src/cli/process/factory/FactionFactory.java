package cli.process.factory;

import cli.data.Constants;
import cli.data.faction.Faction;

public class FactionFactory {
	public static Faction createFaction(String name, String side) throws IllegalArgumentException {
		if(side == Constants.FEDERATION)
		return new Faction(name, side, null, null);
		if(side == Constants.UNION)
			return new Faction(name, side, null, null);
		if(side == Constants.REPUBLIC)
			return new Faction(name, side, null, null);
		throw new IllegalArgumentException("Faction"+side+" is not defined");
	}
}
