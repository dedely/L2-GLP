package cli.data;

public class Config {
	private String playerFactionName;
	private String aiFactionName;
	
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
	public String getAIFactionName() {
		return aiFactionName;
	}
	public void setAIFactionName(String aIFactionName) {
		aiFactionName = aIFactionName;
	}
	@Override
	public String toString() {
		return "Config [playerFactionName=" + playerFactionName + ", aiFactionName=" + aiFactionName + "]";
	}
	
	

}
