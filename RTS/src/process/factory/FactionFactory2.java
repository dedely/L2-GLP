package cli.process.factory;

import cli.data.Constants;
import cli.data.faction.Faction;

public class FactionFactory {
	public static Faction createFaction(String side, String name, int team) throws IllegalArgumentException {
		if(side == Constants.FEDERATION)
		return new Faction(side, name, null, null, team);
		if(side == Constants.UNION)
			return new Faction(side, name, null, null, team);
		if(side == Constants.REPUBLIC)
			return new Faction(side, name, null, null, team);
		throw new IllegalArgumentException("Faction"+side+" is not defined");
	}
}
