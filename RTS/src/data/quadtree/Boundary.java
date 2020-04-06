package data.quadtree;

import java.awt.Point;

public class Boundary {
	private Point topLeft;
	private Point bottomRight;

	public Boundary(Point topLeft, Point bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	@Override
	public String toString() {
		return "Boundary [topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
	}

}