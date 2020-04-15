package data;

public class Cost {
	private int cost;
	private int time;

	public Cost(int cost, int time) {
		this.cost = cost;
		this.time = time;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Cost [cost=" + cost + ", time=" + time + "]";
	}

}