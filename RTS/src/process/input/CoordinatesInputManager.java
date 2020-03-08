package process.input;

import data.Coordinates;
import process.SelectableRepository;

/**
 * @author Adel
 *
 */
public class CoordinatesInputManager implements InputManager {
	Coordinates coordinates;

	public CoordinatesInputManager(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void process() {
		translate(coordinates);
		SelectableRepository.getInstance().select(coordinates);
	}

	private void translate(Coordinates coordinates) {
		
	}
}