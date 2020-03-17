package data.quadtree;

import java.awt.geom.Point2D;

/**
 * @author Adel
 *
 */
public abstract class Leaf implements QuadTree {

	private Point2D position;

	public Leaf(Point2D position) {
		this.position = position;
	}

	@Override
	public QuadTree getNorthWest() {
		return null;
	}

	@Override
	public QuadTree getNorthEast() {
		return null;
	}

	@Override
	public QuadTree getSouthWest() {
		return null;
	}

	@Override
	public QuadTree getSouthEast() {
		return null;
	}

	public Point2D getPosition() {
		return position;
	}

}