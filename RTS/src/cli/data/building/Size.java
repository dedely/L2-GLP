package cli.data.building;

/**
 * @author Adel
 *
 */
public class Size {
	private int height;
	private int lenght;

	public Size(int height, int lenght) {
		this.height = height;
		this.lenght = lenght;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	@Override
	public String toString() {
		return "Size [height=" + height + ", lenght=" + lenght + "]";
	}

}