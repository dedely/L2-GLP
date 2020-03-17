package process.managers;

import data.Selectable;
import data.order.Order;

public abstract class SelectableManager extends Thread {
	private Selectable selectable;
	private Order currentOrder = null;
	private boolean dead = false;
	private boolean exectutingOrder = false;

	public SelectableManager(Selectable selectable) {
		this.selectable = selectable;
	}

	@Override
	public void run() {
		executeNextOrder(selectable);
	}

	public abstract void giveOrder(Selectable selectable, Order order);

	public abstract void executeNextOrder(Selectable selectable);

	public boolean isDead() {
		return dead;
	}

	public boolean isExectutingOrder() {
		return exectutingOrder;
	}

}