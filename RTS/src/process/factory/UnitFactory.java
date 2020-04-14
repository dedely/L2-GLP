package process.factory;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.unit.GroundUnit;
import data.unit.GroundUnitWithMountedWeapon;
import data.unit.TransportHelicopter;
import data.unit.TroopTransport;
import data.unit.Unit;
import data.unit.Weapon;
import data.unit.Worker;

public class UnitFactory {
	private HashMap<String, HashMap<String, String>> datas = new HashMap<String, HashMap<String, String>>();

	private UnitFactory() {

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
		// light
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
				new Weapon(toInt(unitDatas.get("MWdamagePerShot")), toInt(unitDatas.get("MWtypeOfDammage")),
						toInt(unitDatas.get("MWtimeBeetweenShots")), toInt(unitDatas.get("MWrange")),
						toInt(unitDatas.get("MWminimuRange")), toBool(unitDatas.get("MWcanShootAtAirTarget"))));
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

}
