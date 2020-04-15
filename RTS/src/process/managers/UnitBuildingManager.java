package process.managers;

import data.Selectable;
import data.building.UnitBuilding;
import data.order.Order;
import process.FactionTest;
import process.executor.Executor;
import process.visitor.UnitBuildingVisitor;

public class UnitBuildingManager extends SelectableManager {
	private FactionTest player;
	private UnitBuilding unitBuilding;
	private UnitBuildingVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public UnitBuildingManager(UnitBuilding unitBuilding, FactionTest player) {
		this.unitBuilding = unitBuilding;
		this.player = player;
		visitor = new UnitBuildingVisitor(unitBuilding, player);
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

	@Override
	public int getProgress() {
		return concreteExecutor.getProgress();

	}

}