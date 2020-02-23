package cli.process;

import java.util.ArrayList;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.building.DefenseBuilding;
import cli.data.unit.Unit;

public class DefenseTreatment {

	public Selectable detectClosestEnnemy (Unit caster) {
			Selectable closestEnnemy = CoordinatesTreatment.getClosestSelectable;
			return closestEnnemy;
		}
	
	public Selectable detectClosestEnnemy (DefenseBuilding caster) {
		Selectable closestEnnemy = null;
		return closestEnnemy;
	}

	public void defense (Unit caster) {
		if (detectClosestEnnemy(caster) != null) {
			AttackTreatment.attack(caster, detectClosestEnnemy(caster));
		}
	}
	
	
	public void defense (DefenseBuilding caster) {
		if (detectClosestEnnemy(caster) != null) {
			AttackTreatment.attack(caster, detectClosestEnnemy(caster));
		}
	}
	
}
