package process.visitor;

import data.quadtree.Boundary;
import data.quadtree.QuadTree;
import data.quadtree.Region;
import data.quadtree.SelectableLeaf;

public class BuildVisitor implements QuadTreeVisitor<QuadTree> {
	private Boundary boundary;

	public BuildVisitor(Boundary boundary) {
		this.boundary = boundary;
	}

	@Override
	public QuadTree visit(SelectableLeaf node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadTree visit(Region node) {
		// TODO Auto-generated method stub
		return null;
	}

}