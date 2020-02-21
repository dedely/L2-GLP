package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;
import cli.data.resource.Resource;

/**
 * @author Adel
 *
 */
public class ResourceFactory extends Building {

	private Resource resourceProduced;
	private int timeToProduce;
	private int numberProduced;

	public ResourceFactory(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
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