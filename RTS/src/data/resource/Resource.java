package data.resource;

public class Resource {

	private int resourceCount;
	private String type;

	public Resource(int resourceCount, String type) {
		this.resourceCount = resourceCount;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	@Override
	public String toString() {
		return "Resource [resourceCount=" + resourceCount + ", type=" + type + "]";
	}

}
