package tests;

import java.awt.Point;

import data.quadtree.QuadTree;
import data.quadtree.Region;
import data.quadtree.SelectableLeaf;
import process.factory.QuadTreeNodeFactory;
import process.managers.QuadTreeManager;
import process.visitor.HeightVisitor;
import process.visitor.SelectableVisitor;

public class TestQuadTree {

	public static void main(String[] args) {
		Region root = QuadTreeNodeFactory.createRegion(new Point(0, 0), new Point(10, 10));
		SelectableLeaf leaf = QuadTreeNodeFactory.createSelectableLeaf(new Point(0,0), new Point(10 ,10), null, null);
		root.setNorthEast(leaf);
		root.setNorthWest(leaf);
		root.setSouthEast(leaf);
		root.setSouthWest(leaf);
		
		
		HeightVisitor visitor = new HeightVisitor();
		root.accept(visitor);
		System.out.println("Height:"+ visitor.getHeight());
	}
}