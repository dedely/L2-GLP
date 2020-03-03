package tests;


import data.map.Map;
import process.builder.MapBuilder;
import tests.input.InputParameter;

/**
 * This allows us to test the map loading process.
 * @author Adel
 *
 */
public class MapTest {

	public static void main(String[] args) {
		MapBuilder builder = new MapBuilder();
		Map map = builder.buildMap(InputParameter.MAP_PATH);
		System.out.println("Map loading test:");
		System.out.println(map.toString());
	}

}
