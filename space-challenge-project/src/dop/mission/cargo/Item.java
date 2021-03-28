package dop.mission.cargo;

/**
 * Item class represents an item to be carried by the rockets.
 * Item has a name and a certain value of weight
 * @author dooms
 */
public class Item {
	
	/* Attributes */
	
	/** Item name */
	 private String name;
	
	/** Item weight (unit 1 kg) */
	 private int weight;
	
	/* Constructor */
	
	/**
	 * Create an Item object
	 * @param name
	 * @param weight
	 */
	public Item(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	/**
	 * Get item's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get item' weight
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Create info line for the item object
	 * @return info line
	 */
	public String itemInfo() {
		return "item: " + name + " = " + weight + " kg";
	}
	
	/**
	 * Return the item info from itemInfo-method
	 */
	@Override
	public String toString() {
		return itemInfo();
	}
}
