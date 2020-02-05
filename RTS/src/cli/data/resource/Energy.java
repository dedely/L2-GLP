package cli.data.resource;

public class Energy implements Resource{
	private int resourceCount;

	public Energy(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	@Override
	public String toString() {
		return "Energy [resourceCount=" + resourceCount + "]";
	}
	
	
}
