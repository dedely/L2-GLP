package data.quadtree;

import java.awt.Point;

import process.visitor.QuadTreeVisitor;

/**
 * General definition of a QuadTree node. The QuadTree structure is used to
 * store spatial data.
 * 
 * @author Adel
 *
 */
public abstract class QuadTree {
	private Boundary boundary;

	public QuadTree(Point topLeft, Point bottomRight) {
		boundary = new Boundary(topLeft, bottomRight);
	}

	public abstract QuadTree getNorthWest();

	public abstract QuadTree getNorthEast();

	public abstract QuadTree getSouthWest();

	public abstract QuadTree getSouthEast();

	public abstract <T> T accept(QuadTreeVisitor<T> visitor);

	public Boundary getBoundary() {
		return boundary;
	}

	public void setBoundary(Boundary boundary) {
		this.boundary = boundary;
	}

}