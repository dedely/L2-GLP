package cli.data.resource;

public class Material implements Resource {
	private int resourceCount;

	public Material(int resourceCount) {
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
		return "Material [resourceCount=" + resourceCount + "]";
	}
	 
	
}
