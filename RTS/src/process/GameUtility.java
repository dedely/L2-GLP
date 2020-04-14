package process;

import data.Coordinates;
import gui.elements.SimuPara;

public class GameUtility {
	/**
	 * Simulates the unit time (for an iteration) defined for the simulation. 
	 */
	public static void unitTime() {
		try {
			Thread.sleep(SimuPara.SIMULATION_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Simulated the necessary refresh time for avoiding printing issue.
	 */
	public static void windowRefreshTime() {
		try {
			Thread.sleep(SimuPara.SIMULATION_SPEED * 10);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Coordinates convert(Coordinates pixelPosition) {
		return new Coordinates(pixelPosition.getAbsciss() / SimuPara.SCALE,
				pixelPosition.getOrdinate() / SimuPara.SCALE, pixelPosition.getHeight());
	}
}