package cli.data.tree;

import java.util.HashMap;

public class BinaryTree implements ResearchTree{

	private HashMap<Integer, Research> researches = new HashMap<Integer, Research>();
	private String name;
	
	
	public BinaryTree(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public HashMap<Integer, Research> getResearches() {
		return researches;
	}


	public void setResearches(HashMap<Integer, Research> researches) {
		this.researches = researches;
	}


	@Override
	public String toString() {
		return "BinaryTree [researches=" + researches + ", name=" + name + "]";
	}	
}
