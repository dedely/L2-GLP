package data.order;

import data.Coordinates;
import data.building.Building;

public class Build implements Order{
	
	private Building toBuild;
	private Coordinates position;
	private int timeUntilConstructed;
	
	public Build (Building toBuild, Coordinates position, int time) {
		this.position = position;
		timeUntilConstructed = time;
		this.toBuild = toBuild;
	}
	public Building getToBuild() {
		return toBuild;
	}
	public void setToBuild(Building toBuild) {
		this.toBuild = toBuild;
	}
	public Coordinates getPosition() {
		return position;
	}
	public void setPosition(Coordinates position) {
		this.position = position;
	}
	public int getTimeUntilConstructed() {
		return timeUntilConstructed;
	}
	public void setTimeUntilConstructed(int timeUntilConstructed) {
		this.timeUntilConstructed = timeUntilConstructed;
	}
	public String toString() {
		return "Build [position=" + position + ", timeUntilConstructed=" + timeUntilConstructed
				+ ", toBuild=" + toBuild + "]";
	}
		
}