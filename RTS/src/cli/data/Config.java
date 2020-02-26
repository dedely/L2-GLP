package cli.data;

public class Config {
	private String playerFactionName;
	private String aiFactionName;
	private int playerNumber;
	
	public Config(String playerFactionName, String aiFactionName) {
		this.playerFactionName = playerFactionName;
		this.aiFactionName = aiFactionName;
	}
	public String getPlayerFactionName() {
		return playerFactionName;
	}
	public void setPlayerFactionName(String playerFactionName) {
		this.playerFactionName = playerFactionName;
	}
	
	public String getAiFactionName() {
		return aiFactionName;
	}
	public void setAiFactionName(String aiFactionName) {
		this.aiFactionName = aiFactionName;
	}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	@Override
	public String toString() {
		return "Config [playerFactionName=" + playerFactionName + ", aiFactionName=" + aiFactionName + "]";
	}
	
	

}
