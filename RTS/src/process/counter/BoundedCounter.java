package process.counter;

public class BoundedCounter extends Counter {
	private int max;

	public BoundedCounter(int max) {
		super();
		this.max = max;
	}

	public BoundedCounter(int value, int max) {
		super(value);
		this.max = max;
	}

	public void increase() {
		if (getValue() < max)
			super.increase();
	}

	/*
	 * public String toString() { return "value: " + getValue(); // + "\tmax: " +
	 * max; }
	 */
	public String toString() {
		if (getValue() < 10) {
			return " 0" + getValue();
		} else
			return " " + getValue();
	}

	public int getMax() {
		return max;
	}
}