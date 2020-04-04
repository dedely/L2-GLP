package tests;

import data.Constants;
import gui.elements.GameGUI;

public class TestGameGUI {

	public static void main(String[] args) {
		GameGUI simulationGUI = new GameGUI(Constants.DEFAULT_CONFIG);
		Thread guiTread = new Thread(simulationGUI);
		guiTread.start();
	}
} 