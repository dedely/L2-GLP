package cli.data;

public class Coordinates {
	private int absciss;
	private int ordinate;
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
	
	
}
