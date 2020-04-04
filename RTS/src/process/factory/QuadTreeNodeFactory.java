package process.factory;

import java.awt.Point;

import data.quadtree.Region;
import data.quadtree.SelectableLeaf;

public class QuadTreeNodeFactory {

	public static SelectableLeaf createSelectableLeaf(Point topLeft, Point bottomRight, Point position, Integer id) {
		return new SelectableLeaf(topLeft, bottomRight, position, id);
	}

	public static Region createRegion(Point topLeft, Point bottomRight) {
		return new Region(topLeft, bottomRight, null, null, null, null);
	}
}