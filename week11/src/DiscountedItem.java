
public class DiscountedItem extends DecoratedItem {
	private float discount;
	
	public DiscountedItem(ItemInterface item, float discount) {
		super(item);
		this.discount = discount;
	}
	
	/**
	 * Gets the discounted price of the item
	 * @return discounted price
	 */
	public float getDiscountedPrice() {
		return getPrice()*this.discount;
	}
}
