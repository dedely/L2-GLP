package gui.input;

import java.awt.Rectangle;
import java.util.ArrayList;

import gui.management.ShapeRepository;
import process.Faction;

public class AreaInputManager implements InputManager {

	private Faction player;
	private Rectangle area = null;

	public AreaInputManager(Faction player) {
		this.player = player;
	}

	@Override
	public void process() {
		if (area != null) {
			ShapeRepository screen = ShapeRepository.getInstance();
			player.deselectAll();
			ArrayList<Integer> intersection = screen.intersection(area);
			for (Integer id : intersection) {
				player.select(id);
			}
		}
	}

	public void update(Rectangle rectangle) {
		area = rectangle;
	}

}