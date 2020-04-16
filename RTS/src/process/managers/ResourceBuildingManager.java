package process.managers;

import data.Selectable;
import data.building.ResourceBuilding;
import process.executor.Executor;

public class ResourceBuildingManager extends SelectableManager {

	private ResourceBuilding building;

	public ResourceBuildingManager(ResourceBuilding building) {
		this.building = building;
	}

	@Override
	public Selectable getSelectable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeNextOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getProgress() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBuilding() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setExecutor(Executor executor) {
		// TODO Auto-generated method stub

	}

}
