package cli.process;

import cli.data.Constants;
import cli.data.unit.Weapon;

public class WeaponFactory {
	public static Weapon createWeapon(String typeOfWeapon) throws IllegalArgumentException {
		if(typeOfWeapon == Constants.TEST_GROUND_WEAPON_H)
		return new Weapon(100, Constants.HEAVY, 10, 100, 10, true);
		if(typeOfWeapon == Constants.TEST_GROUND_WEAPON_L)
			return new Weapon(100, Constants.LIGHT, 10, 100, 10, true);
		if(typeOfWeapon == Constants.TEST_GROUND_WEAPON_SL)
			return new Weapon(100, Constants.SUPER_LIGHT, 10, 100, 10, true);
		throw new IllegalArgumentException("Type of weapon "+typeOfWeapon+" is not defined");
	}

}
