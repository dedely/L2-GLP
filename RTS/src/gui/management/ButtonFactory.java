package gui.management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import data.Action;
import data.Constants;
import gui.elements.buttons.BuildButton;
import gui.elements.buttons.HthButton;
import gui.elements.buttons.JusticeButton;
import gui.elements.buttons.LionButton;
import gui.elements.buttons.MCMButton;
import gui.elements.buttons.NightJarButton;
import gui.elements.buttons.OrderButton;
import gui.elements.buttons.RWorkerButton;
import gui.elements.buttons.RangerButton;
import gui.elements.buttons.SpecialistButton;
import gui.elements.buttons.TapirButton;
import gui.elements.buttons.TrooperButton;
import gui.elements.buttons.WrathButton;
import process.Faction;

/**
 * This utility class allows the creation of any concrete button type needed in
 * the contextual menu. It uses a simple factory design pattern as well as a
 * Singleton pattern.
 * 
 * @author Adel
 *
 */
public class ButtonFactory {

	public static final String ACTIONS_PATH = "src/tests/input/actions.csv";
	public static final String SEPARATOR = ";";
	public static final String DESTROY = "Destroy";
	public static final String BUILD = "Build";
	private HashMap<String, Action> actions = new HashMap<String, Action>();

	private ButtonFactory() {
		initActions();
		for (Action action: actions.values()) {
			System.out.println("name: " + action.getSelectableName() + " Actions : " + action.getActions());
		}
	}

	/**
	 * This method loads the required data for the create method using a csv file input.
	 */
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

	public  OrderButton createOrderButton(Faction player, String type) throws IllegalArgumentException {
		switch (type) {
		case BUILD:
			return new BuildButton(player, type);
		case Constants.MCM:
			return new MCMButton(player, type);
		case Constants.TAPIR:
			return new TapirButton(player, type);
		case Constants.REPUBLIC_WORKER:
			return new RWorkerButton(player, type);
		case Constants.SPECIALIST:
			return new SpecialistButton(player, type);
		case Constants.SPH:
			return new SpecialistButton(player, type);
		case Constants.HTH:
			return new HthButton(player, type);
		case Constants.RANGER:
			return new RangerButton(player, type);
		case Constants.LION:
			return new LionButton(player, type);
		case Constants.NIGHTJAR:
			return new NightJarButton(player, type);
		case Constants.TROOPER:
			return new TrooperButton(player, type);
		case Constants.JUSTICE:
			return new JusticeButton(player, type);
		case Constants.WRATH:
			return new WrathButton(player, type);
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