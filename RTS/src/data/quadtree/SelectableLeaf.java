package data.quadtree;

import java.awt.Point;

import process.visitor.QuadTreeVisitor;

/**
 * @author Adel
 *
 */
public class SelectableLeaf extends Leaf {
	private Integer id;

	public SelectableLeaf(Point position, Integer id) {
		super(position);
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

	@Override
	public String toString() {
		return "SelectableLeaf [id=" + id + "]";
	}

}