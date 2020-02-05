package cli.data.building;

import cli.data.Coordinates;

public abstract class Building {
	private Coordinates rallyPoint;

	public Building(Coordinates rallyPoint) {
		this.rallyPoint = rallyPoint;
	}

	public Coordinates getRallyPoint() {
		return rallyPoint;
	}

	public void setRallyPoint(Coordinates rallyPoint) {
		this.rallyPoint = rallyPoint;
	}

	@Override
	public String toString() {
		return "Building [rallyPoint=" + rallyPoint + "]";
	}
	
}
