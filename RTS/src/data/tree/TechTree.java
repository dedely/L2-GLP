package data.tree;

import java.util.HashMap;

/**
 * The tech tree is represented by a perfect binary tree.
 * @author Maria
 *
 */
public class TechTree {
	/**
	 * The perfect binary tree is implemented as a HashMap. We use the Integer id keys to represent the tree hierachy.
	 */
	private HashMap<Integer, Research> researches = new HashMap<Integer, Research>();

	public TechTree() {
	}

	public HashMap<Integer, Research> getResearches() {
		return researches;
	}

	public void setResearches(HashMap<Integer, Research> researches) {
		this.researches = researches;
	}
	
	/**
	 * This method inserts a given {@link Research} in the tree.
	 * Ovewriting old values is allowed.
	 * @param research
	 */
	public void add(Research research) {
		if(research != null) {
			Integer id = research.getId();
			if(id != null) {
				researches.put(id, research);
			}
		}
	}
	
	public void remove(Integer id) {
		researches.remove(id);
	}

	@Override
	public String toString() {
		return "BinaryTree [researches=" + researches + "]";
	}
}