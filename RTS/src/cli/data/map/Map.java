package cli.data.map;

/**
 * This class will store all the map data in a 2 dimensional array. The possible
 * map elements will be represented as integers.
 * 
 * @author Adel
 *
 */
public class Map {

	public static final int TILE_SIZE = 32;

	public static final int CLEAR = 0;
	public static final int BLOCKED = 1;

	//tiles[height][width]
	int width, height;
	int tiles[][];

	public Map(int width, int height, int[][] tiles) {
		this.width = width;
		this.height = height;
		this.tiles = tiles;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int[][] getTiles() {
		return tiles;
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}

	@Override
	public String toString() {
		String tmp = "Map [width=" + width + ", height=" + height + "\n tiles=\n";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tmp += tiles[i][j] + " ";
			}
			tmp += "\n";
		}
		tmp += "]";
		return tmp;
	}
}