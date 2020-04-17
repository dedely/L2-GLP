package data.building;

import data.Coordinates;
import data.Resource;
import process.visitor.selectable.SelectableVisitor;

/**
 * @author Adel
 *
 */
public class ResourceBuilding extends Building {

	private Resource resourceProduced;
	private int timeToProduce;
	private int numberProduced;
	private int capacity;

	public ResourceBuilding(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, Resource resourceProduced, int timeToProduce,
			int numberProduced, int capacity) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, size);
		this.resourceProduced = resourceProduced;
		this.timeToProduce = timeToProduce;
		this.numberProduced = numberProduced;
		this.capacity = capacity;
	}

	public Resource getResourceProduced() {
		return resourceProduced;
	}

	public void setResourceProduced(Resource resourceProduced) {
		this.resourceProduced = resourceProduced;
	}

	public int getTimeToProduce() {
		return timeToProduce;
	}

	public void setTimeToProduce(int timeToProduce) {
		this.timeToProduce = timeToProduce;
	}

	public int getNumberProduced() {
		return numberProduced;
	}

	public void setNumberProduced(int numberProduced) {
		this.numberProduced = numberProduced;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "ResourceBuilding [resourceProduced=" + resourceProduced + ", timeToProduce=" + timeToProduce
				+ ", numberProduced=" + numberProduced + ", capacity=" + capacity + "]";
	}

}