package data.quadtree;

import java.awt.Point;

/**
 * The Leaf will store will store data associated to a specific position.
 * 
 * @author Adel
 *
 */
public abstract class Leaf implements QuadTree {

	private Point position;
	private String type;
	private Region root;

	public Leaf(Point position, String type, Region root) {
		this.position = position;
		this.type = type;
		this.root = root;
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

}