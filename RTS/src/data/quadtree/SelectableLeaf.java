package data.quadtree;

import java.awt.Point;

import data.Selectable;
import process.visitor.QuadTreeVisitor;

/**
 * A SelectableLeaf, sub-class of {@link Leaf}, stores the id of a
 * {@link Selectable} and its position on the map.
 * 
 * @see QuadTree
 * @author Adel
 * 
 */
public class SelectableLeaf extends Leaf {
	private Integer id;

	public SelectableLeaf(Point topLeft, Point bottomRight, Point position, Integer id) {
		super(topLeft, bottomRight, position);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public <T> T accept(QuadTreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}