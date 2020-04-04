package data.quadtree;

import java.awt.Point;

/**
 * The Leaf will store will store data associated to a specific position.
 * 
 * @author Adel
 *
 */
public abstract class Leaf extends QuadTree {

	private Point position;

	public Leaf(Point topLeft, Point bottomRight, Point position) {
		super(topLeft, bottomRight);
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

	public void setPosition(Point position) {
		this.position = position;
	}

}