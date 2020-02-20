package cli.tests;

import java.util.HashMap;

import cli.data.Coordinates;

public class TestCircle {

	public static void main(String[] args) {
		HashMap<Coordinates, String> pos = new HashMap<Coordinates, String>();
		double x = 5;
		double y = 5;
		double r = 4;
		double j = x + 1;
		double i = y + 1;
		
		pos.put(new Coordinates((int)x, (int)y), "X    ");
		
		for(int m = 1; m <= r; m++) {


			while(i > y-m) {
				i--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(r, 2)) {
					pos.put(new Coordinates((int)j, (int)i), "("+j+","+i+")");
				}
				else {
					pos.put(new Coordinates((int)j, (int)i), "     ");
				}
			}
			while(j > x-m) {
				j--;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(r, 2)) {
					pos.put(new Coordinates((int)j, (int)i), "("+j+","+i+")");
				}
				else {
					pos.put(new Coordinates((int)j, (int)i), "     ");
				}
			}
			while(i < y+m) {
				i++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(r, 2)) {
					pos.put(new Coordinates((int)j, (int)i), "("+j+","+i+")");
				}
				else {
					pos.put(new Coordinates((int)j, (int)i), "     ");
				}
			}
			while(j < x+m) {
				j++;
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(r, 2)) {
					pos.put(new Coordinates((int)j, (int)i), "("+j+","+i+")");
				}
				else {
					pos.put(new Coordinates((int)j, (int)i), "     ");
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
					System.out.print("     ");
				}
			}
		}
		

		
		/*for (double i = Math.max((y - r), 0); i <= (y + r); i++) {
			System.out.println("");
			for (double j = Math.max((x - r), 0); j <= (x + r); j++) {
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(r, 2)) {
					System.out.print("(" + i + "," + j + ")");
				}
			}

		}

		for (double i = 0; i <= 50; i++) {
			System.out.println("");
			for (double j = 0; j <= 50; j++) {
				if (Math.pow((j - x), 2) + Math.pow((i - y), 2) < Math.pow(r, 2)) {
					if (i == y && j == x) {
						System.out.print("X   ");
					} else {
						System.out.print(k);
						k++;
						System.out.print(" ");
						if (k / 10 == 0) {
							System.out.print(" ");
						}
						if (k / 100 == 0) {
							System.out.print(" ");
						}

					}
				} else {
					System.out.print("    ");
				}

			}

		}*/

	}
}