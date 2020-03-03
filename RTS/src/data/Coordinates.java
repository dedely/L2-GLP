package data;

/**
 * @author Adel
 *
 */
public class Coordinates {
	private int absciss;
	private int ordinate;
	private int height;

	public Coordinates(int absciss, int ordinate, int height) {
		this.absciss = absciss;
		this.ordinate = ordinate;
		this.height = height;
	}
	
	public Coordinates(Coordinates oldCoordinates, int newHeight) {
		absciss = oldCoordinates.getAbsciss();
		ordinate = oldCoordinates.getOrdinate();
		height = newHeight;
	}

	public int getAbsciss() {
		return absciss;
	}

	public void setAbsciss(int absciss) {
		this.absciss = absciss;
	}

	public int getOrdinate() {
		return ordinate;
	}

	public void setOrdinate(int ordinate) {
		this.ordinate = ordinate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "coordinates :" + "\n absciss = " + absciss + "\n ordinate = " + ordinate + "\n height = " + height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + absciss;
		result = prime * result + ordinate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (absciss != other.absciss)
			return false;
		if (ordinate != other.ordinate)
			return false;
		return true;
	}

}
