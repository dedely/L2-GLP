package gui.elements;

/**
 * @author Adel
 *
 */
public class SimuPara {

	public static final int SIMULATION_DURATION = 300;

	/**
	 * The smaller the value is, the faster the simulation will be.
	 */
	public static final int SIMULATION_SPEED = 20;

	public static final int WINDOW_WIDTH = 1200;

	public static final int BASIC = WINDOW_WIDTH / 1200;

	public static final int WINDOW_HEIGHT = BASIC * 500;

	public static final int SCALE = BASIC * 40;

	public static final Camera START_POINT = new Camera(WINDOW_WIDTH / SCALE / 2, 1, SCALE);

	public static final int RADIUS = BASIC * 40;

	// These parameters are used for a centered printing of arithmetic operations.
	public static final int MULTIPLICATION_AJUSTEMENT = BASIC * 6;
	public static final int SUBTRACTION_AJUSTEMENT = BASIC * 5;
	public static final int ADDITION_STRING_AJUSTEMENT = BASIC * 9;

	public static final int STRING_AJUSTEMENT = BASIC * 10;

	public static final int POLICE_SIZE = BASIC * 30;

	public static final Camera DEFAULT_CAMERA = new Camera(WINDOW_WIDTH / SCALE / 2, 1, SCALE);
}