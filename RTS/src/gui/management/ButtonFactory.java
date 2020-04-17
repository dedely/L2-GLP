package gui.management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import data.Action;
import gui.elements.buttons.CreateTestUnitButton;
import gui.elements.buttons.OrderButton;
import process.Faction;

/**
 * @author Adel
 *
 */
public class ButtonFactory {

	public static final String ACTIONS_PATH = "src/tests/input/actions.csv";
	public static final String SEPARATOR = ";";
	public static final String DESTROY = "Destroy";
	private HashMap<String, Action> actions = new HashMap<String, Action>();

	private ButtonFactory() {
		initActions();
	}

	private void initActions() {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ACTIONS_PATH));
			while (((line = reader.readLine()) != null)) {
				fields = line.split(SEPARATOR);
				if (fields.length > 0) {
					Action action = new Action(fields[0]);
					for (int i = 1; i < fields.length; i++) {
						action.add(fields[i]);
					}
					actions.put(action.getSelectableName(), action);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private static ButtonFactory instance = new ButtonFactory();

	public static ButtonFactory getInstance() {
		return instance;
	}

	public static OrderButton createOrderButton(Faction player, String type) throws IllegalArgumentException {
		switch (type) {
		case DESTROY:
			return new CreateTestUnitButton(player, type);
		default:
			throw new IllegalArgumentException("Unknown button type: " + type);
		}
	}

	public Action getAction(String name) {
		Action action = null;
		if (actions.containsKey(name)) {
			action = actions.get(name);
		}
		return action;
	}

}