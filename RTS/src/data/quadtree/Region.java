package data.quadtree;

import java.awt.Point;

import process.visitor.QuadTreeVisitor;

/**
 * A Region decomposes 2D space into 4 equal quadrants.
 * 
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

	private Region root;

	private String type;

	public Region(Point topLeft, Point bottomRight, String type, QuadTree root) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		this.northWest = null;
		this.northEast = null;
		this.southWest = null;
		this.southEast = null;
		this.type = type;
	}

	public Region(Point topLeft, Point bottomRight, QuadTree northWest, QuadTree northEast, QuadTree southWest,
			QuadTree southEast, String type, Region root) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		this.northWest = northWest;
		this.northEast = northEast;
		this.southWest = southWest;
		this.southEast = southEast;
		this.type = type;
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
	public String getType() {
		return type;
	}

	@Override
	public Region getRoot() {
		return root;
	}

	public void setRoot(Region root) {
		this.root = root;
	}

	@Override
	public <T> T accept(QuadTreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Region [topLeft=" + topLeft + ", bottomRight=" + bottomRight + ", northWest=" + northWest
				+ ", northEast=" + northEast + ", southWest=" + southWest + ", southEast=" + southEast + ", root="
				+ root + ", type=" + type + "]";
	}

}