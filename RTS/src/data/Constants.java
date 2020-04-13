package data;

import data.building.Size;

public class Constants {
	public static final String PLAYER = "player";
	public static final String AI = "ai";

	public static final String ATTACK_STS = "Attack stop to shoot";
	public static final String ATTACK_AAC = "Attack at all cost";
	public static final String ATTACK_POS_STS = "Attack position stop to shoot";
	public static final String ATTACK_POS_AAC = "Attack position at all cost";
	public static final String ATTACK_BUILDING = "Attack building";
	public static final String MOVE_TO_POSITION_AAC = "Move to  position at all cost";
	public static final String MOVE_TO_POSITION_STS = "Move to  position stop to shoot";

	public static final String MOVE_TO_TARGET_AAC = "Move to target at all cost";
	public static final String MOVE_TO_TARGET_STS = "Move to target stop to shot";

	public static final String EMBARK_AAC = "embark at all cost";
	public static final String EMBARK_STS = "embark stop to shot";

	public static final String CREATE_TEST_UNIT = "create test unit";

	public static final String DEFEND = "Defend";

	public static final String CREATE_UNIT = "Create unit";
	public static final String BUILD = "Build";

	public static final int GROUND = 1;
	public static final int AIR = 2;
	public static final int CARRIED_AND_CAN_SHOOT = 3;
	public static final int CARRIED = -1;
	public static final int OPERATING_TURRET = 0;

	public static final int GO_AT_ALL_COST = 0;
	public static final int STOP_TO_SHOOT = 1;

	public static final int SUPER_LIGHT = 1;
	public static final int LIGHT = 2;
	public static final int HEAVY = 3;

	public static final int RESSOURCE = -1;
	public static final int NO_MAIN_WEAPON = 0;

	public static final String UNION = "Union";
	public static final String FEDERATION = "Federation";
	public static final String REPUBLIC = "Republic";

	public static final String ARTILLERY = "Artillery";
	public static final String HElICOPTER = "Helicopter";
	public static final String GENERIC_INFANTRY = "GenericInfantry";
	public static final String HEAVY_INFANTRY = "HeavyInfatry";
	public static final String HEAVY_ARMORED = "HeavyArmored";

	public static final String TROOP_TRANSPORT = "TroopTransport";
	public static final String WORKER = "Worker";

	public static final String HEADQUATERS = "Headquaters"; // UnitBuilding
	public static final String LABORATORY = "Laboratory"; // ResearchBuilding
	public static final String SENTRY = "Sentry"; // DefenseBuilding
	public static final String BARRACKS = "Barracks"; // UnitBuilding
	public static final String FACTORY = "Factory"; // UnitBuilding
	public static final String WAREHOUSE = "Warehouse";// ResourceBuilding
	public static final String MINE = "Mine"; // ResourceBuilding

	public static final String TEST_GROUND = "testGround";
	public static final String TEST_GROUND_EMBARK = "testGroundEmbark";

	public static final String TEST_GROUND_WEAPON_H = "testGroundWeaponH";
	public static final String TEST_GROUND_WEAPON_L = "testGroundWeaponL";
	public static final String TEST_GROUND_WEAPON_SL = "testGroundWeaponSL";

	public static final Config DEFAULT_CONFIG = new Config(1, new Player("player", FEDERATION),
			new Player("ai", FEDERATION));
	public static final Size DEFAULT_SIZE = new Size(3, 3);

	public static final String SPEED = "speedUp";
	public static final String DAMAGE = "Damage greater";
	public static final String HEALTH = "Get more health";

}