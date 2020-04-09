package data.map;

public class Tile {
	private int type;
	private Integer groundId;
	private Integer airId;

	public Tile(int type) {
		this.type = type;
		groundId = null;
		airId = null;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getGroundId() {
		return groundId;
	}

	public void setGroundId(Integer groundId) {
		this.groundId = groundId;
	}

	public Integer getAirId() {
		return airId;
	}

	public void setAirId(Integer airId) {
		this.airId = airId;
	}

}