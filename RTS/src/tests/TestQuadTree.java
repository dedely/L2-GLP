package tests;

import java.awt.Point;

import data.quadtree.Region;
import process.factory.QuadTreeNodeFactory;
import process.managers.QuadTreeManager;

public class TestQuadTree {

	public static void main(String[] args) {
		Region tree = QuadTreeNodeFactory.createRegion(new Point(0, 0), new Point(10, 10));
		QuadTreeManager manager = new QuadTreeManager(tree);
		manager.insert(new Point(6, 3), 1);
		manager.insert(new Point(6, 2), 2);
		//System.out.println(manager.isEmpty(tree));
		System.out.println(tree.toString());
	}
}