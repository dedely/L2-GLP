package process.managers;

import java.awt.Point;

import data.quadtree.QuadTree;
import process.factory.QuadTreeNodeFactory;

public class QuadTreeManager {
	private QuadTree tree;

	public QuadTreeManager(QuadTree tree) {
		this.tree = tree;
	}

	public void addSelectable(Point position, Integer id) {
		QuadTree leaf = QuadTreeNodeFactory.createSelectableLeaf(position, id);
		if (!exists(tree)) {
			tree = leaf;
		} else {
			
		}
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