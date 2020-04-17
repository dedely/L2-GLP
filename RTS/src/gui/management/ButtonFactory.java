package gui.management;

import gui.elements.buttons.CreateTestUnitButton;
import gui.elements.buttons.OrderButton;
import process.FactionTest;
import process.factory.UnitFactory;

/**
 * @author Adel
 *
 */
public class ButtonFactory {
	
	private ButtonFactory() {

	}

	private static ButtonFactory instance = new ButtonFactory();

	public static ButtonFactory getInstance() {
		return instance;
	}

	public static final String TEST_BUTTON = "create unit";

	public static OrderButton createOrderButton(FactionTest player, String type) throws IllegalArgumentException {
		switch (type) {
		case TEST_BUTTON:
			return new CreateTestUnitButton(player, type);
		default:
			throw new IllegalArgumentException("Unknown button type: " + type);
		}
	}
}