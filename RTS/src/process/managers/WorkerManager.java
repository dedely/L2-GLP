package process.managers;

import data.Selectable;
import data.order.Order;
import data.unit.Worker;
import process.FactionTest;
import process.executor.Executor;
import process.visitor.order.WorkerExVisitor;

public class WorkerManager extends SelectableManager {

	private FactionTest player;
	private Worker worker;
	private WorkerExVisitor visitor;
	private Executor concreteExecutor = null;
	private boolean complete = false;

	public WorkerManager(FactionTest player, Worker worker) {
		this.player = player;
		this.worker = worker;
		visitor = new WorkerExVisitor(worker);
	}

	@Override
	public void giveOrder(Order order) {
		if(order != null) {
			if (isExecutingOrder()) {
				complete = true;
				finish();
			}
			super.giveOrder(order);
		}
	}

	@Override
	public Selectable getSelectable() {
		return worker;
	}

	@Override
	public void update() {
		executeNextOrder();

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