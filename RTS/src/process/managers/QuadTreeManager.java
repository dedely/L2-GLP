package process.managers;

import java.awt.Point;

import data.quadtree.QuadTree;

public class QuadTreeManager {
	private QuadTree tree;

	public QuadTreeManager(QuadTree tree) {
		this.tree = tree;
	}

	public void addSelectable(Point point, Integer id) {

	}

	public boolean exists() {
		return tree != null;
	}

	public boolean exists(QuadTree tree) {
		return tree != null;
	}

	public boolean isLeaf(QuadTree tree) {
		return !(exists(tree.getNorthWest()) && exists(tree.getNorthEast()) && exists(tree.getSouthWest())
				&& exists(tree.getSouthEast()));
	}
	


}