package tests;

import java.awt.Point;

import data.quadtree.Region;
import process.factory.QuadTreeNodeFactory;
import process.managers.QuadTreeManager;

public class TestQuadTree {

	public static void main(String[] args) {
		Region tree = QuadTreeNodeFactory.createRegion(new Point(0, 0), new Point(10, 10));
		QuadTreeManager manager = new QuadTreeManager(tree);
		System.out.println(tree.toString());
		manager.insert(new Point(0, 1), 1);
		System.out.println(tree.toString());
		System.out.println(tree.getNorthWest().getRoot());
		manager.insert(new Point(4, 5), 2);
		System.out.println(tree.toString());
		System.out.println(tree.getNorthWest().getSouthEast().getRoot());
		manager.insert(new Point(3, 3), 3);
		System.out.println(tree.toString());
	}
}