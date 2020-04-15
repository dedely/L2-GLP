package process.managers;

import data.Selectable;
import data.building.Building;
import data.order.Order;
import process.executor.Executor;
import process.visitor.BuildingExecutionVisitor;

public class BuildingManager extends SelectableManager {
	private Building building;
	private BuildingExecutionVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public BuildingManager(Building building) {
		this.building = building;
		this.visitor = new BuildingExecutionVisitor(building);
	}

	@Override
	public Selectable getSelectable() {
		return building;
	}

	@Override
	public void giveOrder(Order order) {
		getSelectable().addOrder(order);
	}

	@Override
	public void executeNextOrder() {
		Order order = getOrder();
		if (order != null) {
			complete = false;
			if (concreteExecutor == null) {
				if ((concreteExecutor = order.accept(visitor)) == null) {
					finish();
				}
			} else {
				complete = concreteExecutor.execute();
				if (complete) {
					concreteExecutor = null;
					finish();
				}
			}
		}
	}

	@Override
	public void update() {
		executeNextOrder();
	}

	@Override
	public int getProgress() {
		return 0;
	}

}