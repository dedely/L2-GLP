package gui.elements;

/**
 * 
 * @author Adel
 *
 */
public class SimuPara {

	public static final int SIMULATION_DURATION = 300;

	/**
	 * The simulation speed needs to be set at 16 or lower for the game to run at 60 fps
	 * and above.
	 */
	public static final int SIMULATION_SPEED = 20;

	/**
	 * The WIDTH of a standard screen size for computer games.
	 */
	public static final int WINDOW_WIDTH = 1920;

	public static final int BASIC = WINDOW_WIDTH / 1920;

	public static final int WINDOW_HEIGHT = BASIC * 1080;

	/**
	 * The scale factor needs to be a common divider of our WINDOW_WIDTH and
	 * WINDOW_HEIGHT.
	 */
	public static final int SCALE = BASIC * 24;

	public static final int RADIUS = BASIC * 24;

}