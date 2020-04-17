package process.factory;

import java.io.IOException;
import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.faction.Faction;
import data.unit.AttackHelicopter;
import data.unit.GroundUnit;
import data.unit.GroundUnitSuicide;
import data.unit.GroundUnitWithMountedWeapon;
import data.unit.TransportHelicopter;
import data.unit.TroopTransport;
import data.unit.Unit;
import data.unit.Weapon;
import data.unit.Worker;
import process.file.FileExtractor;

public class UnitFactory {
	private HashMap<String, HashMap<String, String>> datas = new HashMap<String, HashMap<String, String>>();

	private String path = "src/tests/input/";
	
	private FileExtractor unitFileExtractor = new FileExtractor();
	
	private UnitFactory() {
		initialiseFiles();

	}

	private void initialiseFiles() {
		try {
			datas.put("hth", unitFileExtractor.readFile(path+"hth.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load hth file");
		}
		try {
			datas.put("justice", unitFileExtractor.readFile(path+"justice.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load justice file");
		}
		try {
			datas.put("lion", unitFileExtractor.readFile(path+"lion.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load lion file");
		}
		try {
			datas.put("mbt", unitFileExtractor.readFile(path+"mbt.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load mbt file");
		}
		try {
			datas.put("mcm", unitFileExtractor.readFile(path+"mcm.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load mcm file");
		}
		try {
			datas.put("nightjar", unitFileExtractor.readFile(path+"nightjar.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load nightjar file");
		}
		try {
			datas.put("ranger", unitFileExtractor.readFile(path+"ranger.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load ranger file");
		}
		try {
			datas.put("republic_worker", unitFileExtractor.readFile(path+"republic_worker.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load republic_worker file");
		}
		try {
			datas.put("specialist", unitFileExtractor.readFile(path+"specialist.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load specialist file");
		}
		try {
			datas.put("tapir", unitFileExtractor.readFile(path+"tapir.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load tapir file");
		}
		try {
			datas.put("trooper", unitFileExtractor.readFile(path+"trooper.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load trooper file");
		}
		try {
			datas.put("wrath", unitFileExtractor.readFile(path+"wrath.txt"));
		} catch (IOException e) {
			System.err.println("couldn't load wrath file");
		}
		
		
	}

	private static UnitFactory instance = new UnitFactory();

	public static UnitFactory getInstance() {
		return instance;
	}

	public void setDatas(HashMap<String, HashMap<String, String>> datas) {
		this.datas = datas;
	}

	public Unit createUnit(String type, Coordinates spawnPosition, String playerName) throws IllegalArgumentException {
		HashMap<String, String> unitDatas;
		switch (type) {
		// Union units
		// infantry
		case Constants.SPECIALIST:
			unitDatas = datas.get(Constants.SPECIALIST);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		case Constants.AT_SOLDIER:
			unitDatas = datas.get(Constants.AT_SOLDIER);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		// troop transport
		case Constants.ASAV:
			unitDatas = datas.get(Constants.ASAV);
			return buildTroopTransport(unitDatas, playerName, spawnPosition);
		// heavy
		case Constants.MBT:
			unitDatas = datas.get(Constants.MBT);
			return buildGroundUnitWithMountedWeapon(unitDatas, playerName, spawnPosition);
		case Constants.SPH:
			unitDatas = datas.get(Constants.SPH);
			return buildGroundUnitWithMountedWeapon(unitDatas, playerName, spawnPosition);
		// worker
		case Constants.MCM:
			unitDatas = datas.get(Constants.MCM);
			return buildWorker(unitDatas, playerName, spawnPosition);
		// helicopter
		case Constants.HTH:
			unitDatas = datas.get(Constants.HTH);
			return buildTransportHelicpoter(unitDatas, playerName, spawnPosition);

		// Federation Units
		// Infantry
		case Constants.RANGER:
			unitDatas = datas.get(Constants.SPECIALIST);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		case Constants.HEAVY_INFANTRY:
			unitDatas = datas.get(Constants.HEAVY_INFANTRY);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		// troop transport
		case Constants.HARE:
			unitDatas = datas.get(Constants.HARE);
			return buildTroopTransport(unitDatas, playerName, spawnPosition);
		// heavy tank
		case Constants.ELEPHANT:
			unitDatas = datas.get(Constants.ELEPHANT);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		// worker
		case Constants.TAPIR:
			unitDatas = datas.get(Constants.TAPIR);
			return buildWorker(unitDatas, playerName, spawnPosition);
		// attack helicopter
		case Constants.NIGHTJAR:
			unitDatas = datas.get(Constants.NIGHTJAR);
			return buildAttackHelicopter(unitDatas, playerName, spawnPosition);

		// Republic Units
		case Constants.TROOPER:
			unitDatas = datas.get(Constants.TROOPER);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		case Constants.MARTYR:
			unitDatas = datas.get(Constants.MARTYR);
			return buildGroundUnitSuicide(unitDatas, playerName, spawnPosition);
		case Constants.REPUBLIC_WORKER:
			unitDatas = datas.get(Constants.REPUBLIC_WORKER);
			return buildWorker(unitDatas, playerName, spawnPosition);
		case Constants.LIBERATOR:
			unitDatas = datas.get(Constants.LIBERATOR);
			return buildTroopTransport(unitDatas, playerName, spawnPosition);
		case Constants.JUSTICE:
			unitDatas = datas.get(Constants.JUSTICE);
			return buildGroundUnit(unitDatas, playerName, spawnPosition);
		case Constants.WRATH:
			unitDatas = datas.get(Constants.WRATH);
			return buildAttackHelicopter(unitDatas, playerName, spawnPosition);
		}

		throw new IllegalArgumentException("type " + type + " is not implemented or defined");

	}

	private int toInt(String string) {
		return Integer.parseInt(string);
	}

	private boolean toBool(String string) {
		return Boolean.parseBoolean(string);
	}

	private Unit buildTroopTransport(HashMap<String, String> unitDatas, String playerName, Coordinates spawnPosition) {
		return new TroopTransport(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")),
				new Weapon(toInt(unitDatas.get("damagePerShot")), toInt(unitDatas.get("typeOfDammage")),
						toInt(unitDatas.get("timeBeetweenShots")), toInt(unitDatas.get("range")),
						toInt(unitDatas.get("minimuRange")), toBool(unitDatas.get("canShootAtAirTarget"))),
				toInt(unitDatas.get("unitSize")), toInt(unitDatas.get("infantrySeats")));
	}

	private Unit buildGroundUnit(HashMap<String, String> unitDatas, String playerName, Coordinates spawnPosition) {
		return new GroundUnit(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")),
				new Weapon(toInt(unitDatas.get("damagePerShot")), toInt(unitDatas.get("typeOfDammage")),
						toInt(unitDatas.get("timeBeetweenShots")), toInt(unitDatas.get("range")),
						toInt(unitDatas.get("minimuRange")), toBool(unitDatas.get("canShootAtAirTarget"))),
				toInt(unitDatas.get("unitSize")));
	}

	private Unit buildGroundUnitWithMountedWeapon(HashMap<String, String> unitDatas, String playerName,
			Coordinates spawnPosition) {
		return new GroundUnitWithMountedWeapon(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")),
				new Weapon(toInt(unitDatas.get("damagePerShot")), toInt(unitDatas.get("typeOfDammage")),
						toInt(unitDatas.get("timeBeetweenShots")), toInt(unitDatas.get("range")),
						toInt(unitDatas.get("minimuRange")), toBool(unitDatas.get("canShootAtAirTarget"))),
				toInt(unitDatas.get("unitSize")),
				new Weapon(toInt(unitDatas.get("mwDamagePerShot")), toInt(unitDatas.get("mwTypeOfDammage")),
						toInt(unitDatas.get("mwTimeBeetweenShots")), toInt(unitDatas.get("mwRange")),
						toInt(unitDatas.get("mwMinimuRange")), toBool(unitDatas.get("mwCanShootAtAirTarget"))));
	}

	private Unit buildWorker(HashMap<String, String> unitDatas, String playerName, Coordinates spawnPosition) {
		return new Worker(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")),
				new Weapon(toInt(unitDatas.get("damagePerShot")), toInt(unitDatas.get("typeOfDammage")),
						toInt(unitDatas.get("timeBeetweenShots")), toInt(unitDatas.get("range")),
						toInt(unitDatas.get("minimuRange")), toBool(unitDatas.get("canShootAtAirTarget"))),
				toInt(unitDatas.get("unitSize")), toInt(unitDatas.get("contenerSize")));
	}

	private Unit buildTransportHelicpoter(HashMap<String, String> unitDatas, String playerName,
			Coordinates spawnPosition) {
		return new TransportHelicopter(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")),
				new Weapon(toInt(unitDatas.get("damagePerShot")), toInt(unitDatas.get("typeOfDammage")),
						toInt(unitDatas.get("timeBeetweenShots")), toInt(unitDatas.get("range")),
						toInt(unitDatas.get("minimuRange")), toBool(unitDatas.get("canShootAtAirTarget"))),
				toInt(unitDatas.get("unitSlots")));
	}

	private Unit buildAttackHelicopter(HashMap<String, String> unitDatas, String playerName,
			Coordinates spawnPosition) {
		return new AttackHelicopter(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")),
				new Weapon(toInt(unitDatas.get("damagePerShot")), toInt(unitDatas.get("typeOfDammage")),
						toInt(unitDatas.get("timeBeetweenShots")), toInt(unitDatas.get("range")),
						toInt(unitDatas.get("minimuRange")), toBool(unitDatas.get("canShootAtAirTarget"))),
				new Weapon(toInt(unitDatas.get("secDamagePerShot")), toInt(unitDatas.get("secTypeOfDammage")),
						toInt(unitDatas.get("secTimeBeetweenShots")), toInt(unitDatas.get("secRange")),
						toInt(unitDatas.get("secMinimuRange")), toBool(unitDatas.get("secCanShootAtAirTarget"))));
	}

	private Unit buildGroundUnitSuicide(HashMap<String, String> unitDatas, String playerName,
			Coordinates spawnPosition) {
		return new GroundUnitSuicide(unitDatas.get("name"), playerName, toInt(unitDatas.get("maxHealth")),
				toInt(unitDatas.get("armorPoints")), toInt(unitDatas.get("armorType")), unitDatas.get("description"),
				spawnPosition, toInt(unitDatas.get("speed")), new Weapon(toInt(unitDatas.get("damagePerShot")),
						toInt(unitDatas.get("typeOfDammage")), 200, toInt(unitDatas.get("range")), 0, false),
				toInt(unitDatas.get("unitSize")));
	}
}
