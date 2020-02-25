package cli.process;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.faction.Faction;
import cli.data.unit.Artillery;
import cli.data.unit.ArtilleryLikeInfantry;
import cli.data.unit.ArtilleryWithMountedWeapon;
import cli.data.unit.AttackHelicopter;
import cli.data.unit.GroundUnit;
import cli.data.unit.GroundUnitWithMountedWeapon;
import cli.data.unit.LightTV;
import cli.data.unit.TransportHelicopter;
import cli.data.unit.Unit;
import cli.data.unit.Worker;

public class UnitFactory {
	public Unit create(String type, Coordinates spawnPosition, Faction faction) throws IllegalArgumentException {
		if (type == Constants.ARTILLERY) {
			if (faction.getName() == Constants.UNION) {
				new ArtilleryWithMountedWeapon("SPH", 500, faction, 400, 20, Constants.LIGHT,
						"Self propelled howitzer from the Union, may be equiped with a roof Anti-air machine gun",
						spawnPosition, 20, 200, Constants.HEAVY, 90, 1500, false, 12, 100,
						false, 20, 20,Constants.LIGHT, true);

			} else if (faction.getName() == Constants.FEDERATION) {
				return new Artillery("Elephant", 600,faction, 400, 20, Constants.LIGHT,
						"Self propelled long range support of the Federation",
						spawnPosition, 15, 250, Constants.HEAVY,
						150, 1700, false, 15, 100);

			} else if (faction.getName() == Constants.REPUBLIC) {
				return new ArtilleryLikeInfantry("Mortar Team", 200,faction, 100, 5, Constants.SUPER_LIGHT,
						"Mobile mortar team of the Republic",
						spawnPosition, 8, 125, Constants.HEAVY, 60, 800, false, 3,
						60);
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}

		else if (type == Constants.HElICOPTER) {
			if (faction.getName() == Constants.UNION) {				
				
				return new TransportHelicopter("HTH",800, faction, 700, 15, Constants.LIGHT,
						"Heavy transport helicopter of the Union",
						spawnPosition, 50, 0, Constants.NO_MAIN_WEAPON, 0, 0,
						false, 15);
			} else if (faction.getName() == Constants.FEDERATION) {
			
				return new AttackHelicopter("NightJar", 900, faction, 800, 30, Constants.LIGHT,
						"Attack helicopter of the federation",
						spawnPosition, 60, 40, Constants.LIGHT, 15, 500,
						true, 120, 30, 8, Constants.HEAVY);

			} else if (faction.getName() == Constants.REPUBLIC) {
				return new AttackHelicopter("Wrath", 600, faction, 400, 35, Constants.SUPER_LIGHT,
						"Helicopter-mounted rocket platform of the Republic",
						spawnPosition, 50, 0, Constants.NO_MAIN_WEAPON, 0, 450,
						false, 200, 10, 12, Constants.HEAVY);
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}

		else if (type == Constants.GENERIC_INFANTRY) {
			if (faction.getName() == Constants.UNION) {
				return new GroundUnit("Specialist", 100,faction, 50, 10, Constants.SUPER_LIGHT,
						"The special force of the Union",
						spawnPosition, 10, 20, Constants.SUPER_LIGHT, 8, 100, true,
						1);
			} else if (faction.getName() == Constants.FEDERATION) {
				return new GroundUnit("Ranger", 150,faction, 50, 10, Constants.SUPER_LIGHT,
						"Foot soldier of the Federation",
						spawnPosition, 10, 30, Constants.SUPER_LIGHT, 12, 100, true,
						1);

			} else if (faction.getName() == Constants.REPUBLIC) {
				return new GroundUnit("Trooper", 75,faction, 50, 5, Constants.SUPER_LIGHT,
						"Main infantery of the Republic",
						spawnPosition, 10, 25, Constants.SUPER_LIGHT, 8, 100, true,
						1);
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}

		else if (type == Constants.HEAVY_INFANTRY) {
			if (faction.getName() == Constants.UNION) {
				return new GroundUnit("AT Soldier", 150,faction, 50, 10, Constants.SUPER_LIGHT,
						"The anti-tank infantery support",
						spawnPosition, 8, 100, Constants.HEAVY, 70, 100, true, 1);
			} else if (faction.getName() == Constants.FEDERATION) {
				return new GroundUnit("Mechanised Infantery", 200,faction, 50, 10, Constants.LIGHT,
						"Armored infantery unit",
						spawnPosition, 8, 60, Constants.LIGHT, 30, 100, true, 1);

			} else if (faction.getName() == Constants.REPUBLIC) {
				throw new IllegalArgumentException("Unit not yet implemented");
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}

		else if (type == Constants.HEAVY_ARMORED) {
			if (faction.getName() == Constants.UNION) {
				return new GroundUnitWithMountedWeapon("MBT", 500, faction, 500, 20, Constants.HEAVY,
						"Main battle tank of the Union",
						spawnPosition, 20, 100, Constants.HEAVY, 100, 100, false, 12,
						false, 30, 20, Constants.LIGHT, true);

			} else if (faction.getName() == Constants.FEDERATION) {
				return new GroundUnit("Lion", 600,faction, 500, 30, Constants.HEAVY,
						"Heavy armored vehicle from the Federation",
						spawnPosition, 16, 120, Constants.SUPER_LIGHT, 120,
						100, true, 15);

			} else if (faction.getName() == Constants.REPUBLIC) {
				return new GroundUnit("Justice", 400,faction, 400, 20, Constants.LIGHT,
						"Armored car of the republic",
						spawnPosition, 35, 80, Constants.HEAVY, 90, 80, true, 8);
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}
		else if (type == Constants.LIGHT_TV) {
			if (faction.getName() == Constants.UNION) {
				return new LightTV("ASSV",300, faction, 300, 20, Constants.LIGHT,
						"Advanced support and scouting Vehicle of the Union",
						spawnPosition, 45, 45, Constants.LIGHT, 15, 80, true, 8, 5);
			} else if (faction.getName() == Constants.FEDERATION) {
				return new LightTV("Gepard", 500,faction, 400, 20, Constants.LIGHT,
						"Infantry armored transport from the Federation",
						spawnPosition, 35, 60, Constants.LIGHT, 30, 70, true, 12, 12);
			} else if (faction.getName() == Constants.REPUBLIC) {
				return new LightTV("Justice", 300,faction, 250, 10, Constants.LIGHT, "Armored car of the republic",
						spawnPosition, 35, 20, Constants.HEAVY, 10, 80, true, 7, 5);
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}
		
		else if (type == Constants.WORKER) {
			if (faction.getName() == Constants.UNION) {	
				return new Worker("MCM", 500, faction, 400, 10, Constants.LIGHT,
						"Multi-porpose construction medium of the Union",
						spawnPosition, 20, 200, Constants.RESSOURCE, 10, 1, false, 14);
			} else if (faction.getName() == Constants.FEDERATION) {
				return new Worker("Turtle", 600, faction, 400, 10, Constants.LIGHT,
						"Heavy duty logistic vehicle from the federation",
						spawnPosition, 15, 300, Constants.RESSOURCE, 30, 1, false, 14);
			} else if (faction.getName() == Constants.REPUBLIC) {
				return new Worker("Worker", 100,faction, 50, 5, Constants.SUPER_LIGHT,
						"Armored car of the republic",
						spawnPosition, 10, 75, Constants.RESSOURCE, 5, 1, false, 1);
			} else {
				throw new IllegalArgumentException("The faction " + faction.getName() + " doesn't exist !");
			}
		}

		throw new IllegalArgumentException("type "+type+" is not defined");		
		
	}
}
