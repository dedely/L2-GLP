package process.builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import data.Cost;
import tests.input.InputParameter;

/**
 * @author Adel
 *
 */
public class CostBuilder {

	public final static String SEPARATOR = ";";

	/**
	 * This method uses a slightly improved linear search algorithm to build the
	 * appropriate cost map for the specified faction, based on an input csv file.
	 * 
	 * The input file contains information about the build cost and time of each selectable.
	 * 
	 * @param factionName
	 * @return costs
	 */
	public static HashMap<String, Cost> buildCosts(String factionName) {
		HashMap<String, Cost> costs = new HashMap<String, Cost>();
		String line, fields[];
		boolean stop = false;
		int state = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(InputParameter.COSTS));
			while (((line = reader.readLine()) != null) && (!stop)) {
				fields = line.split(SEPARATOR);
				if ((state == 0) && fields[0].equals(factionName)) {
					state = 1;
				}
				if (state == 1) {
					if (!fields[0].equals(factionName)) {
						stop = true;
					} else {
						Cost cost = new Cost(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
						costs.put(fields[1], cost);
					}
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return costs;
	}
}