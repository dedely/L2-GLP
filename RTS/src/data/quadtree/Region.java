package data.quadtree;

import java.awt.Point;

import process.visitor.QuadTreeVisitor;

/**
 * A Region decomposes 2D space into 4 equal quadrants.
 * @author Adel
 *
 */
public class Region implements QuadTree {

	private Point topLeft;
	private Point bottomRight;

	private QuadTree northWest;
	private QuadTree northEast;
	private QuadTree southWest;
	private QuadTree southEast;

	public Region(Point topLeft, Point bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		this.northWest = null;
		this.northEast = null;
		this.southWest = null;
		this.southEast = null;
	}
	
	public Region(Point topLeft, Point bottomRight, QuadTree northWest, QuadTree northEast, QuadTree southWest,
			QuadTree southEast) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		this.northWest = northWest;
		this.northEast = northEast;
		this.southWest = southWest;
		this.southEast = southEast;
	}

	@Override
	public QuadTree getNorthWest() {
		return northWest;
	}

	@Override
	public QuadTree getNorthEast() {
		return northEast;
	}

	@Override
	public QuadTree getSouthWest() {
		return southWest;
	}

	@Override
	public QuadTree getSouthEast() {
		return southEast;
	}

	public void setNorthWest(QuadTree northWest) {
		this.northWest = northWest;
	}

	public void setNorthEast(QuadTree northEast) {
		this.northEast = northEast;
	}

	public void setSouthWest(QuadTree southWest) {
		this.southWest = southWest;
	}

	public void setSouthEast(QuadTree southEast) {
		this.southEast = southEast;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(Point bottomRight) {
		this.bottomRight = bottomRight;
	}

	@Override
	public <T> T accept(QuadTreeVisitor<T> visitor) {
		return visitor.visit(this);;
	}

}