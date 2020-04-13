package data.map;

import data.Coordinates;

/**
 * This class will store all the map data in a 2 dimensional array. The possible
 * map elements will be represented as integers.
 * 
 * @author Adel
 *
 */
public class Map {

	public static final int TILE_SIZE = 24;

	public static final int CLEAR = 0;
	public static final int BLOCKED = 1;

	private int width, height;
	private Tile tiles[][];

	public Map(int width, int height, Tile[][] tiles) {
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

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public void add(Coordinates position, Integer id) {
		int x = position.getAbsciss();
		int y = position.getOrdinate();
		if(position.getHeight() == 0) {
			tiles[y][x].setGroundId(id);
		}else {
			tiles[y][x].setAirId(id);
		}
	}
	
	public void delete(Coordinates position) {
		int x = position.getAbsciss();
		int y = position.getOrdinate();
		if(position.getHeight() == 0) {
			tiles[y][x].setGroundId(null);
		}else {
			tiles[y][x].setAirId(null);
		}
	}

	@Override
	public String toString() {
		String tmp = "Map : width=" + width + ", height=" + height + "\n";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tmp += tiles[i][j].getType() + " ";
			}
			tmp += "\n";
		}
		return tmp;
	}
}