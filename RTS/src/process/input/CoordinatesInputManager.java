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
		SelectableRepository.getInstance().select(coordinates);
		System.out.println(coordinates.toString());
		System.out.println(SelectableRepository.getInstance().exists(coordinates));
	}
}