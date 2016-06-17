import java.util.ArrayList;

public class Assembly implements ItemInterface {
	private ArrayList<ItemInterface> items;
	private float price;
	
	public Assembly() {
		this.items = new ArrayList<ItemInterface>();
		this.price = 0;
		// add up the prices of all the item parts the assembly is made up of
		for (ItemInterface i : this.items) {
			this.price += i.getPrice();
		}
	}
	
	/**
	 * Gets the price of the assembly
	 */
	public float getPrice() {
		return this.price;
	}
	
	public boolean isBasicItem() {
		return false;
	}
	
	/**
	 * Adds item i to the assembly
	 * @param i
	 */
	public void addItem(ItemInterface i) {
		this.items.add(i);
	}
	
	/**
	 * Removes item i from the assembly
	 * @param i
	 */
	public void removeItem(ItemInterface i) {
		items.remove(i);
	}
	
	/**
	 * Gets the item part at the index i
	 * @param i
	 * @precondition i >= 0
	 * @return item at index i
	 */
	public ItemInterface getItem(int i) {
		if (i < items.size()) {
			return items.get(i);
		}
		System.out.println("Index out of bounds");
		return null;
	}
}
