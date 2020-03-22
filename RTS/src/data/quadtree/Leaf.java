package data.quadtree;

import java.awt.Point;

/**
 * 
 * @author Adel
 *
 */
public abstract class Leaf implements QuadTree {

	private Point position;

	public Leaf(Point position) {
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

	public Point getPosition() {
		return position;
	}

}