
public class Item implements ItemInterface {
	private float price;
	
	public Item(int price) {
		this.price = price;
	}
	
	/**
	 * Gets the price of the item
	 */
	public float getPrice() {
		return this.price;
	}
	
	public boolean isBasicItem() {
		return true;
	}
}
