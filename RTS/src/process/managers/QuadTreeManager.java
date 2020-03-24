package process.managers;

import java.awt.Point;

import data.quadtree.Leaf;
import data.quadtree.QuadTree;
import data.quadtree.Region;
import process.factory.QuadTreeNodeFactory;
import process.visitor.HeightVisitor;

public class QuadTreeManager {
	private Region root;

	public QuadTreeManager(Region root) {
		this.root = root;
	}

	public QuadTree insert(QuadTree tree, Point position, Integer id) {
		QuadTree node = null;
		if (!exists(tree)) {
			node = QuadTreeNodeFactory.createSelectableLeaf(position, id);
		}
		return node;
	}

	public void insert(Point position, Integer id) {
		System.out.println("region inser is called");
		Region tree = root;
		// We first compute the center.
		Point center = new Point((tree.getTopLeft().x + tree.getBottomRight().x) / 2,
				(tree.getTopLeft().y + tree.getBottomRight().y) / 2);
		System.out.println(center);

		QuadTree quadrant;
		if ((position.x <= center.x) && (position.y <= center.y)) {
			quadrant = tree.getNorthWest();
			if (exists(quadrant)) {

				Region newRegion = split(quadrant, tree.getTopLeft(), center);
			}
			quadrant = insert(quadrant, position, id);
			tree.setNorthWest(quadrant);
		} else if ((position.x > center.x) && (position.y <= center.y)) {
			System.out.println("NE comp is called");
			quadrant = tree.getNorthEast();
			System.out.println("quadrant: " + quadrant);
			if (exists(quadrant)) {
				quadrant = split(quadrant, new Point(center.x, tree.getTopLeft().y),
						new Point(tree.getBottomRight().x, center.y));
				System.out.println("new quadrant: " + quadrant);
			}
			quadrant = insert(quadrant, position, id);
			tree.setNorthEast(quadrant);
		} else if ((position.x <= center.x) && (position.y > center.y)) {
			quadrant = tree.getSouthWest();
			if (exists(quadrant)) {
				quadrant = split(quadrant, new Point(tree.getTopLeft().x, center.y),
						new Point(center.x, tree.getBottomRight().y));
			}
			quadrant = insert(quadrant, position, id);
			tree.setSouthWest(quadrant);
		} else if ((position.x > center.x) && (position.y > center.y)) {
			quadrant = tree.getSouthEast();
			if (exists(quadrant)) {
				quadrant = split(quadrant, center, tree.getBottomRight());
			}
			quadrant = insert(quadrant, position, id);
			tree.setSouthEast(quadrant);
		}

		root = tree;
	}

	private Region split(Leaf quadrant) {
		Point topLeft, bottomRight;
		if(quadrant.)
		Region newRegion = QuadTreeNodeFactory.createRegion(topLeft, bottomRight);
		
		return ;
	}

	public boolean exists(QuadTree tree) {
		return tree != null;
	}

	public boolean isLeaf(QuadTree tree) {
		return !(exists(tree.getNorthWest()) && exists(tree.getNorthEast()) && exists(tree.getSouthWest())
				&& exists(tree.getSouthEast()));
	}

	public boolean isEmpty(QuadTree tree) {
		HeightVisitor visitor = new HeightVisitor();
		tree.accept(visitor);
		return visitor.getHeight() == 0;
	}

	public Region getRoot() {
		return root;
	}

}