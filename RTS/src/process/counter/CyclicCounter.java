package process.counter;

public class CyclicCounter extends BoundedCounter {
	public CyclicCounter(int max) {
		super(max);
	}

	public CyclicCounter(int value, int max) {
		super(value, max);
	}

	public void increase() {
		if (getValue() == getMax())
			setValue(0);
		else
			super.increase();
	}

	public void decrease() {
		if (getValue() == 0)
			setValue(getMax());
		else
			super.decrease();
	}
}
