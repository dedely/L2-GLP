package process.managers;

import data.Selectable;
import data.building.UnitBuilding;
import data.order.Order;
import process.executor.Executor;
import process.visitor.UnitBuildingVisitor;

public class UnitBuildingManager extends SelectableManager {
	private UnitBuilding unitBuilding;
	private UnitBuildingVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public UnitBuildingManager(UnitBuilding unitBuilding) {
		this.unitBuilding = unitBuilding;
		visitor = new UnitBuildingVisitor(unitBuilding);
	}

	@Override
	public Selectable getSelectable() {
		return unitBuilding;
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
}