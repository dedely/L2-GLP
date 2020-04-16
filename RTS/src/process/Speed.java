package process;

public class Speed {

	private int speed;
	private int delay;

	public Speed(int speed, int delay) {
		this.speed = speed;
		this.delay = delay;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public String toString() {
		return "Speed [speed=" + speed + ", delay=" + delay + "]";
	}

}