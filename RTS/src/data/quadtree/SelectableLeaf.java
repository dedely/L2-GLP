package data.quadtree;

import java.awt.geom.Point2D;

import process.visitor.QuadTreeVisitor;

/**
 * @author Adel
 *
 */
public class SelectableLeaf extends Leaf {
	private Integer id;

	public SelectableLeaf(Point2D position, Integer id) {
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
		return null;
	}

	@Override
	public String toString() {
		return "SelectableLeaf [id=" + id + "]";
	}

}