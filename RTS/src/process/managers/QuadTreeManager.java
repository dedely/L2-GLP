package process.managers;

import java.awt.Point;

import data.quadtree.QuadTree;
import data.quadtree.Region;
import data.quadtree.Type;
import process.factory.QuadTreeNodeFactory;
import process.visitor.HeightVisitor;

public class QuadTreeManager {
	private Region root;

	public QuadTreeManager(Region root) {
		this.root = root;
	}

	public void insert(Point position, Integer id) {
		root = insert(root, position, id);
	}

	public QuadTree insert(QuadTree tree, Point position, Integer id, String type, Region root) {
		QuadTree node = null;
		if (!exists(tree)) {
			node = QuadTreeNodeFactory.createSelectableLeaf(position, id, type, root);
		}
		return node;
	}

	public Region insert(Region region, Point position, Integer id) {
		Region tree = region;

		// We first compute the center.
		Point center = new Point((tree.getTopLeft().x + tree.getBottomRight().x) / 2,
				(tree.getTopLeft().y + tree.getBottomRight().y) / 2);

		QuadTree quadrant;

		if ((position.x <= center.x) && (position.y <= center.y)) {
			quadrant = tree.getNorthWest();
			if (!exists(quadrant)) {
				quadrant = QuadTreeNodeFactory.createSelectableLeaf(position, id, Type.NORTH_WEST, tree);
			} else if (isLeaf(quadrant)) {
				quadrant = split(quadrant);
				quadrant = insert((Region) quadrant, position, id);
			} else {
				insert((Region) quadrant.getNorthWest(), position, id);
			}
			tree.setNorthWest(quadrant);
		} else if ((position.x > center.x) && (position.y <= center.y)) {

			quadrant = tree.getNorthEast();
			if (!exists(quadrant)) {
				quadrant = QuadTreeNodeFactory.createSelectableLeaf(position, id, Type.NORTH_EAST, tree);
			} else if (isLeaf(quadrant)) {
				quadrant = split(quadrant);
				quadrant = insert((Region) quadrant, position, id);
			} else {
				insert((Region) quadrant.getNorthEast(), position, id);
			}
			tree.setNorthEast(quadrant);
		} else if ((position.x <= center.x) && (position.y > center.y)) {
			quadrant = tree.getSouthWest();
			if (!exists(quadrant)) {
				quadrant = QuadTreeNodeFactory.createSelectableLeaf(position, id, Type.SOUTH_WEST, tree);
			} else if (isLeaf(quadrant)) {
				quadrant = split(quadrant);
				quadrant = insert((Region) quadrant, position, id);
			} else {
				insert((Region) quadrant.getSouthWest(), position, id);
			}
			tree.setSouthWest(quadrant);
		} else if ((position.x > center.x) && (position.y > center.y)) {
			quadrant = tree.getSouthEast();
			if (!exists(quadrant)) {
				quadrant = QuadTreeNodeFactory.createSelectableLeaf(position, id, Type.SOUTH_EAST, tree);
			} else if (isLeaf(quadrant)) {
				quadrant = split(quadrant);
				quadrant = insert((Region) quadrant, position, id);
			} else {
				insert((Region) quadrant.getSouthEast(), position, id);
			}
			tree.setSouthEast(quadrant);
		}

		return tree;
	}

	private Region split(QuadTree quadrant) throws IllegalArgumentException {
		Region parentNode = quadrant.getRoot();
		System.out.println("Parent" +parentNode);
		Point topLeft = parentNode.getTopLeft();
		Point bottomRight = parentNode.getBottomRight();
		Point center = new Point((topLeft.x + bottomRight.x) / 2, (topLeft.y + bottomRight.y) / 2);
		Region newRegion = null;

		if (exists(parentNode)) {
			switch (quadrant.getType()) {
			case Type.NORTH_WEST:
				newRegion = QuadTreeNodeFactory.createRegion(topLeft, center, Type.NORTH_WEST, parentNode);
				newRegion.setNorthWest(quadrant);
				break;
			case Type.NORTH_EAST:
				newRegion = QuadTreeNodeFactory.createRegion(new Point(center.x, topLeft.y),
						new Point(bottomRight.x, center.y), Type.NORTH_EAST, parentNode);
				newRegion.setNorthEast(quadrant);
				break;
			case Type.SOUTH_WEST:
				newRegion = QuadTreeNodeFactory.createRegion(new Point(topLeft.x, center.y),
						new Point(center.x, bottomRight.y), Type.SOUTH_WEST, parentNode);
				newRegion.setSouthWest(quadrant);
				break;
			case Type.SOUTH_EAST:
				newRegion = QuadTreeNodeFactory.createRegion(center, bottomRight, Type.SOUTH_EAST, parentNode);
				newRegion.setSouthEast(quadrant);
				break;
			default:
				throw new IllegalArgumentException(" Unknown quadrant type : " + quadrant.getType());
			}
		}
		return newRegion;
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