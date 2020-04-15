package process.managers;

import data.Selectable;
import data.order.Order;
import data.unit.Unit;
import process.executor.Executor;
import process.visitor.UnitExecutionVisitor;

public class UnitManager extends SelectableManager {

	private Unit unit;
	private UnitExecutionVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public UnitManager(Unit unit) {
		this.unit = unit;
		visitor = new UnitExecutionVisitor(unit);
	}

	@Override
	public Selectable getSelectable() {
		return unit;
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