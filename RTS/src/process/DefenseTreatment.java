package cli.process;

import java.util.HashMap;

import data.Coordinates;
import data.Selectable;
import data.building.DefenseBuilding;
import data.unit.Unit;

public class DefenseTreatment {

	public Selectable detectClosestEnnemy (Unit caster, HashMap<Coordinates, Selectable> positions) {
		Selectable closestEnnemy = null;
		if (caster.getWeapon().isCanShootAtAirTarget()) {
			closestEnnemy = CoordinatesTreatment.closestEnnemySelectable(caster);
		}
		else {
			closestEnnemy = CoordinatesTreatment.closestGroundEnnemySelectable(caster, positions);
			}
		return closestEnnemy;

		}
	
	public Selectable detectClosestEnnemy (DefenseBuilding caster, HashMap<Coordinates, Selectable> positions) {
		Selectable closestEnnemy = null;
		if (CoordinatesTreatment.closestEnnemySelectable(caster, positions) != null) {
			closestEnnemy = CoordinatesTreatment.closestEnnemySelectable(caster, positions);
		}
		else {}
		return closestEnnemy;
	}

	public void defense (Unit caster, HashMap<Coordinates, Selectable> positions) {
		if (detectClosestEnnemy(caster, positions) != null) {
			AttackTreatment.attack(caster, detectClosestEnnemy(caster, positions));
		}
		else {}
	}
	
	
	public void defense (DefenseBuilding caster, HashMap<Coordinates, Selectable> positions) {
		if (detectClosestEnnemy(caster, positions) != null) {
			AttackTreatment.attack(caster, detectClosestEnnemy(caster, positions));
		}
		else {}
	}
	
}
