package process.managers;

import data.Selectable;
import data.order.Order;
import process.GameUtility;

public abstract class SelectableManager extends Thread {
	private Selectable selectable;
	private Order order = null;
	private boolean exectutingOrder = false;

	public SelectableManager(Selectable selectable) {
		this.selectable = selectable;
	}

	@Override
	public void run() {
		while (!isDead()) {
			GameUtility.unitTime();
			executeNextOrder();
		}
	}

	public abstract void giveOrder(Order order);

	public abstract void executeNextOrder();

	public boolean isDead() {
		return selectable.getCurrentHealth() <= 0;
	}

	public boolean isExectutingOrder() {
		return exectutingOrder;
	}

	public Selectable getSelectable() {
		return selectable;
	}

	public void setSelectable(Selectable selectable) {
		this.selectable = selectable;
	}

	public Order getOrder() {
		if (order == null) {
			order = selectable.getNextOrder();
		}
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isSelected() {
		return selectable.isSelected();
	}

	public Integer getSelectableId() {
		return selectable.getId();
	}

	public void select() {
		selectable.setSelected(true);
	}

	public void deselect() {
		selectable.setSelected(false);
	}

	public void setId(Integer id) {
		selectable.setId(id);
	}
	
	public void finish() {
		setOrder(null);
	}

}