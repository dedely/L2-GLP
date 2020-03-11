package process;

import data.Selectable;

public abstract class SelectableManager extends Thread {
	private Selectable selectable;
	
	
	public SelectableManager(Selectable selectable) {
		this.selectable = selectable;
	}

	@Override
	public void run() {
		executeNextOrder(selectable);
	}

	public abstract void executeNextOrder(Selectable selectable);

}