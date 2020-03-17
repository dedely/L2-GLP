package data.quadtree;

import java.awt.Dimension;

import process.visitor.QuadTreeVisitor;

/**
 * @author Adel
 *
 */
public class Region implements QuadTree {

	private Dimension size;

	private QuadTree northWest;
	private QuadTree northEast;
	private QuadTree southWest;
	private QuadTree southEast;

	public Region(Dimension size, QuadTree northWest, QuadTree northEast, QuadTree southWest, QuadTree southEast) {
		this.size = size;
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

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	@Override
	public <T> T accept(QuadTreeVisitor<T> visitor) {
		return null;
	}

}