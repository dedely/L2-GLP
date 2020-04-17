package process.factory;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.Resource;
import data.building.Building;
import data.building.ResourceBuilding;
import data.building.Size;
import data.building.UnitBuilding;
import gui.elements.SimuPara;
import process.builder.FileExtractor;

public class BuildingFactory {
	private HashMap<String, HashMap<String, String>> datas = new HashMap<String, HashMap<String, String>>();

	private static String ROOT_PATH = "src/tests/input/";
	private static String EXTENSION = ".txt";
	private FileExtractor buildingFileExtractor = new FileExtractor();
	
	private static BuildingFactory instance = new BuildingFactory();

	private BuildingFactory() {
		initialiseFiles();

	}

	private void initialiseFiles() {
		tryReadAndPutInDatas(Constants.UNION_HQ);
		tryReadAndPutInDatas(Constants.FEDERATION_HQ);
		tryReadAndPutInDatas(Constants.REPUBLIC_HQ);
		tryReadAndPutInDatas(Constants.UNION_FACTORY);
		tryReadAndPutInDatas(Constants.FEDERATION_FACTORY);
		tryReadAndPutInDatas(Constants.REPUBLIC_FACTORY);
		tryReadAndPutInDatas(Constants.UNION_MINE);
		tryReadAndPutInDatas(Constants.FEDERATION_MINE);
		tryReadAndPutInDatas(Constants.REPUBLIC_MINE);
	}

	private void tryReadAndPutInDatas(String name) {
		datas.put(name, buildingFileExtractor.readFile(ROOT_PATH + name + EXTENSION));

	}

	public Building createBuilding(String type, Coordinates spawnPosition, String playerName)
			throws IllegalArgumentException {
		HashMap<String, String> buidingDatas;
		switch (type) {
		// Union buidings
		case Constants.UNION_HQ:
			buidingDatas = datas.get(Constants.UNION_HQ);
			return buildUnitBuilding(buidingDatas, playerName, spawnPosition);
		case Constants.UNION_FACTORY:
			buidingDatas = datas.get(Constants.UNION_FACTORY);
			return buildUnitBuilding(buidingDatas, playerName, spawnPosition);
		case Constants.UNION_MINE:
			buidingDatas = datas.get(Constants.UNION_MINE);
			return buildMine(buidingDatas, playerName, spawnPosition);
		// Union buidings
		case Constants.FEDERATION_HQ:
			buidingDatas = datas.get(Constants.FEDERATION_HQ);
			return buildUnitBuilding(buidingDatas, playerName, spawnPosition);
		case Constants.FEDERATION_FACTORY:
			buidingDatas = datas.get(Constants.FEDERATION_FACTORY);
			return buildUnitBuilding(buidingDatas, playerName, spawnPosition);
		case Constants.FEDERATION_MINE:
			buidingDatas = datas.get(Constants.FEDERATION_MINE);
			return buildMine(buidingDatas, playerName, spawnPosition);
		// Union buidings
		case Constants.REPUBLIC_HQ:
			buidingDatas = datas.get(Constants.REPUBLIC_HQ);
			return buildUnitBuilding(buidingDatas, playerName, spawnPosition);
		case Constants.REPUBLIC_FACTORY:
			buidingDatas = datas.get(Constants.REPUBLIC_FACTORY);
			return buildUnitBuilding(buidingDatas, playerName, spawnPosition);
		case Constants.REPUBLIC_MINE:
			buidingDatas = datas.get(Constants.REPUBLIC_MINE);
			return buildMine(buidingDatas, playerName, spawnPosition);
		}

		throw new IllegalArgumentException("type " + type + " is not implemented or defined");

	}

	private Building buildMine(HashMap<String, String> buildingDatas, String playerName, Coordinates spawnPosition) {
		return new ResourceBuilding(buildingDatas.get("name"), playerName, toInt(buildingDatas.get("maxhealth")),
				toInt(buildingDatas.get("armorPoints")), toInt(buildingDatas.get("armorType")),
				buildingDatas.get("description"), spawnPosition,
				new Size(toInt(buildingDatas.get("sizeX")), toInt(buildingDatas.get("sizeY"))),
				new Resource(0, Constants.MATERIALS), toInt(buildingDatas.get("timeToProduce")),
				toInt(buildingDatas.get("numberProduced")), toInt(buildingDatas.get("capacity")));
	}

	private Building buildUnitBuilding(HashMap<String, String> buildingDatas, String playerName,
			Coordinates spawnPosition) {
		return new UnitBuilding(buildingDatas.get("name"), playerName, toInt(buildingDatas.get("maxHealth")),
				toInt(buildingDatas.get("armorPoints")), toInt(buildingDatas.get("armorType")),
				buildingDatas.get("description"), spawnPosition,
				new Size(toInt(buildingDatas.get("sizeX")), toInt(buildingDatas.get("sizeY"))),
				offsetPosition(spawnPosition));
	}

	private Coordinates offsetPosition(Coordinates spawnPosition) {
		return new Coordinates(spawnPosition.getAbsciss() + 5 * SimuPara.SCALE, spawnPosition.getOrdinate());
	}

	private int toInt(String string) {
		return Integer.parseInt(string);
	}

	private boolean toBool(String string) {
		return Boolean.parseBoolean(string);
	}

	public static BuildingFactory getInstance() {
		return instance;
	}
}