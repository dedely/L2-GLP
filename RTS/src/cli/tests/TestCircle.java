package cli.tests;

import java.util.HashMap;

import cli.data.Coordinates;

public class TestCircle {

	public static void main(String[] args) {
		HashMap<Coordinates, String> pos = new HashMap<Coordinates, String>();
		double x = 5;
		double y = 5;
		double r = 50;
		double j = x + 1;
		double i = y + 1;
		
		pos.put(new Coordinates((int)x, (int)y), "X        ");
		
		for (int k = 0; k <= r; k++) {
			for ( i = Math.max((y - k), 0); i <= (y + k); i++) {
				for ( j = Math.max((x - k), 0); j <= (x + k); j++) {
					if ((Math.pow((j - x), 2) + Math.pow((i - y), 2)) <= Math.round(Math.pow(k, 2)) && (Math.pow((j - x), 2) + Math.pow((i - y), 2)) > Math.round(Math.pow(k, 2)-1)) {
						if (i != y || j != x) {
							pos.put(new Coordinates((int)j, (int)i), "("+j+","+i+")");
						}
					}

				}

			}
		}
		
		for (int a = 0; a <= 50; a++) {
			System.out.println("");
			for (int b = 0; b <= 50; b++) {
				if(pos.containsKey(new Coordinates(b, a))) {
					System.out.print(pos.get(new Coordinates(b, a)));
				}
				else {
					System.out.print("         ");
				}
			}
		}

	}
}