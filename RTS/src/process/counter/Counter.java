package process.counter;

public class Counter {
	private int value;

	public Counter() {
		value = 0;
	}

	public Counter(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value >= 0)
			this.value = value;
	}

	public void increase() {
		value++;
	}

	public void decrease() {
		if (value > 0) {
			value--;
		}
	}

	public String toString() {
		return "value: " + value + "\t";
	}
}
