package cli.process;

import cli.data.Coordinates;
import cli.data.building.Building;

public interface BuildingFactory {
	Building createBuilding(String factionName, String type, Coordinates position);
}