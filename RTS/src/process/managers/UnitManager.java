package process.managers;

import data.Selectable;
import data.order.Order;
import data.unit.Unit;
import process.executor.Executor;
import process.visitor.ExecutionVisitor;

public class UnitManager extends SelectableManager {

	private ExecutionVisitor visitor = new ExecutionVisitor((Unit) getSelectable());

	public UnitManager(Selectable selectable) {
		super(selectable);
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
			boolean complete = concreteExecutor.execute();
			if(complete) {
				finish();
			}
		}
	}

}