package cli.process;

import cli.data.Coordinates;

/**
 * This class is supposed to process inputs and make the appropriate changes,
 * i.e. either select/deselect Selectable(s), add or remove Order(s), update the
 * Camera position (and later pause the game).
 * 
 * @author Adel
 *
 */
public class Input {
	private String[] args;

	public Input(String[] args) {
		this.args = args;
	}
	
	public void process() {
		String arg;
		for (int i = 0; i < args.length; i++) {
			arg = args[i];
			switch (arg) {
			case "-s":
				if (args.length >= i + 2) {
					select(Integer.valueOf(args[i + 1]), Integer.valueOf(args[i + 2]));
				}
				break;
			}
		}
	}

	private void select(Integer absciss, Integer ordinate) {
		Coordinates position = new Coordinates(absciss, ordinate, 0);
		SelectableRepository.getInstance().select(position);
	}
}