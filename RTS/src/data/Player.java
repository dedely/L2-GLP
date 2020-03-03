package data;

/**
 * @author Adel
 *
 */
public class Player {
	private String name;
	private String factionName;

	public Player(String name, String factionName) {
		this.name = name;
		this.factionName = factionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", factionName=" + factionName + "]";
	}

}