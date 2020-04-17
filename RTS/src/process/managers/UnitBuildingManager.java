package process.managers;

import data.Selectable;
import data.building.UnitBuilding;
import data.order.Order;
import process.Faction;
import process.executor.Executor;
import process.visitor.order.UnitBuildingExVisitor;

public class UnitBuildingManager extends SelectableManager {
	private Faction player;
	private UnitBuilding unitBuilding;
	private UnitBuildingExVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public UnitBuildingManager(UnitBuilding unitBuilding, Faction player) {
		this.unitBuilding = unitBuilding;
		this.player = player;
		visitor = new UnitBuildingExVisitor(unitBuilding, player);
	}

	@Override
	public Selectable getSelectable() {
		return unitBuilding;
	}

	@Override
	public void executeNextOrder() {
		Order order = getOrder();
		if (order != null) {
			setExecutingOrder(true);
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

	@Override
	public boolean isBuilding() {
		return true;
	}

	@Override
	public void setExecutor(Executor executor) {
		this.concreteExecutor = executor;
	}

}