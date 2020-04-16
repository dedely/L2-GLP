package process.managers;

import data.Selectable;
import data.order.Order;
import data.unit.Unit;
import process.executor.Executor;
import process.visitor.order.UnitExVisitor;

public class UnitManager extends SelectableManager {

	private Unit unit;
	private UnitExVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public UnitManager(Unit unit) {
		this.unit = unit;
		visitor = new UnitExVisitor(unit);
	}

	@Override
	public Selectable getSelectable() {
		return unit;
	}

	@Override
	public void giveOrder(Order order) {
		if(order != null) {
			if (isExecutingOrder()) {
				complete = true;
				finish();
			}
			getSelectable().addOrder(order);
		}

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
		return 0;
	}

	@Override
	public boolean isBuilding() {
		return false;
	}

	@Override
	public void setExecutor(Executor executor) {
		this.concreteExecutor = executor;
	}
	
}