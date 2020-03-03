package process.builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import data.map.Map;

/**
 * This class builds the map based on a text file input. The input file contains
 * information about all the maps elements.
 * 
 * @author Adel
 *
 */
public class MapBuilder {
	public static final String SEPARATOR = ",";

	/**
	 * @param fileName
	 * @return the constructed Map or null if the loading process failed.
	 */
	public Map buildMap(String fileName) {
		String line, fields[];
		int width = 0, height = 0, tmp = 0;
		Map map = null;
		try {
			BufferedReader counter = new BufferedReader(new FileReader(fileName));

			// We first need to count the amount of rows and columns in the file;
			while ((line = counter.readLine()) != null) {
				fields = line.split(SEPARATOR);
				tmp = fields.length;
				// The input file may contain rows with different amounts of columns, therefore
				// we need to find the maximum.
				if (tmp > width) {
					width = tmp;
				}
				++height;
			}
			counter.close();

			// Now we can fill our 2 dimensions array.
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			int tiles[][] = new int[height][width];
			// We reset the tmp variable and use it to count lines.
			tmp = 0;
			while ((line = reader.readLine()) != null) {
				fields = line.split(SEPARATOR);
				for (int index = 0; index < fields.length; index++) {
					String field = fields[index];
					int value = Integer.parseInt(field);
					tiles[tmp][index] = value;
				}
				++tmp;
			}

			reader.close();

			map = new Map(width, height, tiles);

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return map;
	}
}