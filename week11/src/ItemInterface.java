
public interface ItemInterface {
	/**
	 * Gets the price of the item
	 * @return item price
	 */
	float getPrice();
	
	/**
	 * Gets whether the item is a basic item or an assembly of items
	 * @return true if item is basic item or false if has children items
	 */
	boolean isBasicItem();
}
