package cli.data.resource;

/**
 * @author Adel
 *
 */
public class Energy extends Resource{
	private int resourceCount;

	public Energy(int resourceCount) {
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
		return "Energy [resourceCount=" + resourceCount + "]";
	}
	
	
}
