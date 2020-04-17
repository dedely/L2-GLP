package process.managers;

import data.Constants;
import data.Resource;
import data.Selectable;
import data.building.ResourceBuilding;
import data.order.Order;
import process.Faction;
import process.counter.BoundedCounter;
import process.counter.CyclicCounter;
import process.executor.Executor;

public class ResourceBuildingManager extends SelectableManager {

	private Faction player;
	private ResourceBuilding building;
	private Resource resource;
	private CyclicCounter counter;
	private BoundedCounter stock;

	public ResourceBuildingManager(Faction player, ResourceBuilding building) {
		this.player = player;
		this.building = building;
		initMechanism();
	}

	private void initMechanism() {
		resource = building.getResourceProduced();
		int delay = building.getTimeToProduce();
		counter = new CyclicCounter(delay * 20);
	}

	@Override
	public Selectable getSelectable() {
		return building;
	}

	/**
	 * This building doesn't recieve orders.
	 */
	@Override
	public void giveOrder(Order order) {

	}

	@Override
	public void update() {
		if (counter.getValue() == 0) {
			int value = player.getResource(Constants.MATERIALS).getResourceCount();
			value += building.getNumberProduced();
			player.updateResource(Constants.MATERIALS, value);
		}
		counter.decrease();
	}

	@Override
	public void executeNextOrder() {

	}

	@Override
	public int getProgress() {
		return 0;
	}

	@Override
	public boolean isBuilding() {
		return true;
	}

	@Override
	public void setExecutor(Executor executor) {

	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public BoundedCounter getStock() {
		return stock;
	}

	public void setStock(BoundedCounter stock) {
		this.stock = stock;
	}

	public void deliver(WorkerManager worker, int quantity) {
		
	}
}
