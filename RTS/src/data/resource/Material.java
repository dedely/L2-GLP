package data.resource;

/**
 * @author Adel
 *
 */
public class Material extends Resource {
	private int resourceCount;

	public Material(int resourceCount) {
		super(resourceCount);
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
