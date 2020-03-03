package data.order;

import java.util.ArrayList;

public class Defense {

	private int range;
	private int damagePerShot;
	private int fireRate;
	private ArrayList<DefBuildingOrder> orders = new ArrayList<DefBuildingOrder>();
	
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getDamagePerShot() {
		return damagePerShot;
	}
	public void setDamagePerShot(int damagePerShot) {
		this.damagePerShot = damagePerShot;
	}
	public int getFireRate() {
		return fireRate;
	}
	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}
	public ArrayList<DefBuildingOrder> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<DefBuildingOrder> orders) {
		this.orders = orders;
	}

}
