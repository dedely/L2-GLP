package process;

import java.awt.Point;

public class Camera {
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	public static final int CAMERA_WIDTH = 80;
	public static final int CAMERA_HEIGHT = 40;
	public static final int MIN_OFFSET = 0;
	public static final int MAX_OFFSET_X = 40;
	public static final int MAX_OFFSET_Y = 80;

	public Camera(Point point) {
		minX = point.x;
		minY = point.y;
		maxX = minX + CAMERA_WIDTH;
		maxY = minY + CAMERA_HEIGHT;
	}

	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void moveUp() {
		if (minY > MIN_OFFSET) {
			minY--;
			maxY--;
		}
	}

	public void moveDown() {
		if (minY < MAX_OFFSET_Y) {
			minY++;
			maxY++;
		}
	}

	public void moveLeft() {
		if (minX > MIN_OFFSET) {
			minX--;
			maxX--;
		}
	}

	public void moveRight() {
		if(minX < MAX_OFFSET_X) {
			minX++;
			maxX++;
		}
	}
}