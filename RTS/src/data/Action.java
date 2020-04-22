package data;

import java.util.ArrayList;

public class Action {
	private String selectableName;
	private ArrayList<String> actions = new ArrayList<String>();

	public Action(String selectableName) {
		this.selectableName = selectableName;
	}

	public void add(String action) {
			actions.add(action);
	}

	public void remove(String action) {
		actions.remove(action);
	}

	public void clear() {
		actions.clear();
	}

	public ArrayList<String> getActions() {
		return actions;
	}

	public String getSelectableName() {
		return selectableName;
	}

	public void setSelectableName(String selectableName) {
		this.selectableName = selectableName;
	}

}