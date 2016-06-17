
public class DecoratedItem implements ItemInterface {
	private ItemInterface item;
	
	public DecoratedItem(ItemInterface item) {
		this.item = item;
	}
	
	/**
	 * Gets the price of the item at original price
	 */
	public float getPrice() {
		return item.getPrice();
	}
	
	public boolean isBasicItem() {
		return item.isBasicItem();
	}
}
