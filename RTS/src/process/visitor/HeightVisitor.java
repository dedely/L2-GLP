package process.visitor;

import data.quadtree.Region;
import data.quadtree.SelectableLeaf;

public class HeightVisitor implements QuadTreeVisitor<Void> {
	private int height = 0;
	private int currentHeight = 0;

	public int getHeight() {
		return height;
	}

	@Override
	public Void visit(SelectableLeaf node) {
		processLeaf();
		return null;
	}

	private void processLeaf() {
		if (height < currentHeight) {
			height = currentHeight;
		}
	}

	@Override
	public Void visit(Region node) {
		processRegion(node);
		return null;
	}

	private void processRegion(Region node) {
		currentHeight++;
		node.getNorthEast().accept(this);
		node.getNorthWest().accept(this);
		node.getSouthEast().accept(this);
		node.getSouthWest().accept(this);
		currentHeight--;
	}

}