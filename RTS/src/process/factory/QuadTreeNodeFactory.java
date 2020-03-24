package process.factory;

import java.awt.Point;

import data.quadtree.Region;
import data.quadtree.SelectableLeaf;
import data.quadtree.Type;

public class QuadTreeNodeFactory {
	public static SelectableLeaf createSelectableLeaf(Point position, Integer id, String type, Region root) {
		return new SelectableLeaf(position, id, type, root);
	}
	
	public static SelectableLeaf createSelectableLeaf(Point position, Integer id, String type) {
		return new SelectableLeaf(position, id, type);
	}

	public static Region createRegion(Point topLeft, Point bottomRight, String type, Region root) {
		return new Region(topLeft, bottomRight, type, root);
	}
	
	public static Region createRegion(Point topLeft, Point bottomRight) {
		return new Region(topLeft, bottomRight, Type.ROOT, null);
	}
}