package process.managers;

import data.Selectable;
import data.building.Building;
import data.order.Order;
import process.executor.Executor;
import process.visitor.BuildingExecutionVisitor;

public class BuildingManager extends SelectableManager {
	private Building building;
	private BuildingExecutionVisitor visitor;

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
			Executor concreteExecutor = order.accept(visitor);
			if (concreteExecutor != null) {
				boolean complete = concreteExecutor.execute();
				if (complete) {
					finish();
				}
			}
		}
	}

}