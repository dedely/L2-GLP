package data;

import java.util.ArrayList;

public class Actions {
	private ArrayList<String> actions = new ArrayList<String>();

	public void add(String action) {
		if (!actions.contains(action)) {
			actions.add(action);
		}
	}

	public void remove(String action) {
		actions.remove(action);
	}

	public void clear() {
		actions.clear();
	}
}