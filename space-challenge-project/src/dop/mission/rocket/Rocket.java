package dop.mission.rocket;

import java.util.ArrayList;
import java.util.List;

import dop.mission.cargo.Item;
import dop.mission.rocket.comm.SpaceShip;

/**
 * Rocket class represents a rocket item. It implements the SpaceShip interface
 * Rocket has a weight and a maximum carrying capacity
 * By implementing the interface Rocket can launch, land and carry cargo
 * 
 * The attributes weight, maxWeight, cargoWeight and cargoLimit are set to protected
 * and therefore made visible to all the subclasses and classes in the same package
 * All attribute values are integers and one integer represents one kilogram unit
 */
public class Rocket implements SpaceShip {
	
	/** Attribute(s) */
	
	/** Production price of the rocket (million) */
	protected int cost;
	
	/** The weight of the rocket (unit kg) */
	protected int weight;
	
	/** Maximum weight of the rocket including cargo (unit kg) */
	protected int maxWeight; 
	
	/**  Cargo weight will be updated as we load the cargo on the rocket (unit kg) */
	protected int cargoWeight;
	
	/** Value of maximum available cargo storage on a rocket (unit kg) */
	protected int cargoLimit;
	
	/** Create list of items in a rocket's cargo */
	protected List<Item> cargoList = new ArrayList<>();
	
	/** Constructor(s) */
	
	/**
	 * Create a Rocket object with no cargo
	 */
	public Rocket() {
		this.cargoWeight = 0;
	}
	
	/**
	 * Create a Rocket object with parameters
	 * weight and maximum weight, without cargo 
	 */
	public Rocket(int weight, int maxWeight, int cost) {
		this.cargoWeight = 0;
		this.weight = weight;
		this.maxWeight = maxWeight;
		this.cargoLimit = maxWeight - weight;
		this.cost = cost;
	}
	
	/* Method(s) */
	
	/**
	 * Launch a rocket
	 */
	@Override
	public boolean launch() {
		return true;
	}
	
	/**
	 * Land a rocket on the surface 
	 */
	@Override
	public boolean land() {
		return true;
	}
	
	/**
	 * Take an Item object and test whether the rocket can 
	 * carry this item, or if it will exceed the weight limit
	 * @return true if rocket can carry an item, false if it 
	 * will exceed the weight limit
	 */
	@Override
	public boolean canCarry(Item anItem) {
		if (this.cargoWeight + anItem.getWeight() <= cargoLimit) {
			return true;
		} else {
			System.out.println("The rocket is full");
			return false;
		}
	}
	
	/**
	 * Load an Item object and update the current
	 * weight of the rocket
	 */
	@Override
	public void carry(Item anItem) {
			// Update the cargoWeight
			this.cargoWeight = cargoWeight + anItem.getWeight();
			// Add item to the list
			cargoList.add(anItem);
	}

	/**
	 * Get the current status of cargo weight
	 * @return the cargoWeight
	 */
	public int getCargoWeight() {
		return cargoWeight;
	}

	/**
	 * Get list of all items loaded on a rocket
	 * @return the cargoList
	 */
	public List<Item> getCargoList() {
		return cargoList;
	}

	/**
	 * Get value of cargo limit
	 * @return the cargoLimit
	 */
	public int getCargoLimit() {
		return cargoLimit;
	}

	/**
	 * Get rocket weight value
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Set rocket weight value
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Get value of maximum weight
	 * @return the maxWeight
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * Set values of maximum weight
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * Get rocket production price
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Set rocket production price
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
}