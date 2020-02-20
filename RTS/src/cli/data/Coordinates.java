package cli.data;

/**
 * @author Adel
 *
 */
public class Coordinates {
	private int absciss;
	private int ordinate;

	
	public Coordinates(int absciss, int ordinate) {
		this.absciss = absciss;
		this.ordinate = ordinate;
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
	@Override
	public String toString() {
		return "Coordinates [absciss=" + absciss + ", ordinate=" + ordinate + "]";
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
