package dop.mission.rocket;

import dop.mission.cargo.Item;
import dop.mission.rocket.comm.SpaceShip;

/**
 * SpacePlane represents reusable vehicles designed only for crewed space flight
 * These are modified versions of rockets and will be used in future simulations
 */
public class SpacePlane implements SpaceShip {
	
	/* Attribute(s) */
	
	/** Cargo weight will be updated as we load the cargo on the rocket (unit kg) */
	private int cargoWeight;

	/** Value of maximum available cargo storage on a rocket (unit kg) */
	private int cargoLimit;
	
	/* Method(s) */
	
	@Override
	public boolean launch() {
		return true;
	}

	@Override
	public boolean land() {
		return true;
	}

	@Override
	public boolean canCarry(Item anItem) {
		if (this.cargoWeight + anItem.getWeight() <= cargoLimit) {
			return true;
		} else {
			System.out.println("The rocket is full");
			return false;
		}
	}

	@Override
	public void carry(Item anItem) {
		this.cargoWeight = cargoWeight + anItem.getWeight();

	}

	/**
	 * Get current status of cargo weight
	 * @return the cargoWeight
	 */
	public int getCargoWeight() {
		return cargoWeight;
	}

	/**
	 * Get value of the cargo limit
	 * @return the cargoLimit
	 */
	public int getCargoLimit() {
		return cargoLimit;
	}
}