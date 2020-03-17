package process.visitor;

import data.quadtree.Region;
import data.quadtree.SelectableLeaf;

public interface QuadTreeVisitor<T> {
	T visit(SelectableLeaf node);
	T visit(Region node);
}