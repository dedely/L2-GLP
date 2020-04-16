package process.managers;

import data.Selectable;
import data.order.Order;
import process.executor.Executor;

public abstract class SelectableManager {
	private Order order = null;
	private boolean executingOrder = false;

	public abstract Selectable getSelectable();

	public abstract void update();

	public abstract void executeNextOrder();

	public abstract int getProgress();

	public abstract boolean isBuilding();
	
	public abstract void setExecutor(Executor executor);

	public boolean isDead() {
		return getSelectable().getCurrentHealth() <= 0;
	}

	public void giveOrder(Order order) {
		getSelectable().addOrder(order);
	}

	public Order getOrder() {
		if (order == null) {
			order = getSelectable().getNextOrder();
		}
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isSelected() {
		return getSelectable().isSelected();
	}

	public Integer getSelectableId() {
		return getSelectable().getId();
	}

	public void select() {
		getSelectable().setSelected(true);
	}

	public void deselect() {
		getSelectable().setSelected(false);
	}

	public void setId(Integer id) {
		getSelectable().setId(id);
	}

	public void finish() {
		setOrder(null);
		setExecutor(null);
		setExecutingOrder(false);
	}

	public boolean isExecutingOrder() {
		return executingOrder;
	}

	public void setExecutingOrder(boolean executingOrder) {
		this.executingOrder = executingOrder;
	}

}