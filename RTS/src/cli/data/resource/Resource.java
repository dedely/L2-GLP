package cli.data.resource;

public abstract class Resource {
	
	private int resourceCount;

	public Resource (int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}
}
