package data.tree;

import java.util.HashMap;

public class BinaryTree {
	private HashMap<Integer, Research> researches = new HashMap<Integer, Research>();

	public BinaryTree() {
	}

	public HashMap<Integer, Research> getResearches() {
		return researches;
	}
	public void putResearch (int i, Research r){
		researches.put(i, r);
	}
	public void setResearches(HashMap<Integer, Research> researches) {
		this.researches = researches;
	}

	@Override
	public String toString() {
		return "BinaryTree [researches=" + researches.toString() + "]";
	}
}