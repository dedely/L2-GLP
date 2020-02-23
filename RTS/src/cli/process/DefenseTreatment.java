package cli.process;

import java.util.ArrayList;
import java.util.HashMap;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
import cli.data.unit.Unit;

public class DefenseTreatment {

	public Selectable detectClosestEnnemy (Unit caster, HashMap<Coordinates, Selectable> positions) {
		Selectable closestEnnemy = null;
		if (caster.isCanShootTargetsOnDifferentHeight()) {
			closestEnnemy = CoordinatesTreatment.closestSelectable(caster, positions);
		}
		else {
			closestEnnemy = CoordinatesTreatment.closestGroundSelectable(caster, positions);
			}
		return closestEnnemy;

		}
	
	public Selectable detectClosestEnnemy (DefenseBuilding caster, HashMap<Coordinates, Selectable> positions) {
		Selectable closestEnnemy = null;
		if (CoordinatesTreatment.closestSelectable(caster, positions) != null) {
			closestEnnemy = CoordinatesTreatment.closestSelectable(caster, positions);
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
