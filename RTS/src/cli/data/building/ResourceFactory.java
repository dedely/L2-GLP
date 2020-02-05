package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.resource.Resource;

public class ResourceFactory extends Building {

	private Resource resourceProduced;
	private int timeToProduce;
	private int numberProduced;
	
	public ResourceFactory(int health, int maxHealth, boolean selected, String factionName, String name,
			Coordinates position, Description description, Coordinates rallyPoint, Resource resourceProduced,
			int timeToProduce, int numberProduced) {
		super(health, maxHealth, selected, factionName, name, position, description, rallyPoint);
		this.resourceProduced = resourceProduced;
		this.timeToProduce = timeToProduce;
		this.numberProduced = numberProduced;
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

	@Override
	public String toString() {
		return "ResourceFactory [resourceProduced=" + resourceProduced + ", timeToProduce=" + timeToProduce
				+ ", numberProduced=" + numberProduced + "]";
	}

}
