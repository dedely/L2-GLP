package process.managers;

import data.Selectable;
import data.building.DefenseBuilding;
import process.executor.Executor;

public class DefenseBuildingManager extends SelectableManager {

	private DefenseBuilding building;

	public DefenseBuildingManager(DefenseBuilding building) {
		this.building = building;
	}

	@Override
	public Selectable getSelectable() {
		return building;
	}

	@Override
	public void update() {
	}

	@Override
	public void executeNextOrder() {
	}

	@Override
	public int getProgress() {
		return 0;
	}

	@Override
	public boolean isBuilding() {
		return true;
	}

	@Override
	public void setExecutor(Executor executor) {
	}

}