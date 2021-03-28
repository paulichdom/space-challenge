package dop.mission;

import java.util.List;

import dop.mission.cargo.Item;
import dop.mission.rocket.Rocket;
import dop.mission.rocket.RocketU1;
import dop.mission.rocket.RocketU2;

/**
 * Simulation class loads items in the rockets. New rocket objects are created 
 * until all items from a list are loaded. As a result a new ArrayList of fully
 * loaded rockets is created. 
 * RunSimulation method takes an ArrayList of rockets and calls launch and land
 * methods for each of the rockets in the array list. Every time a rocket explodes
 * or crashes it will have to send that rocket again.
 */
public class Simulation {
	
	/* Attribute(s) */
	
	/* Result of the simulation, sums up the total cost of the mission for each phase */
	private int budget;
	
	/* Constructor(s) */
	
	/**
	 * Create a Simulation object
	 * @param budget
	 */
	public Simulation() {
		this.budget = 0;
	}
	
	/* Method (s) */
	
	/**
	 * Call launch and land methods for each of the loaded rockets in the array list.
	 * For each crash or explosion another rocket is produced and deployed until all of
	 * the cargo is successfully delivered to Mars. All while keeping track of the total 
	 * budget required to send each rocket safely to Mars.
 	 * @return budget for phase one
	 */
	public int runSimulation(List<Rocket> fleet) {
		this.budget = 0;
		System.out.println("\n--> Launching rockets...\n");
		for (Rocket rocket : fleet) {
			while (true) { 
				budget = budget + rocket.getCost();
				if (!rocket.launch()) { 
					continue; 
				} else if (!rocket.land()) {
					continue;
				} else {
					break;
				}
			}
		}
		System.out.println("\nAll rockets have been dispached");
		System.out.println("\nBudget total: " + "€" + budget + " Million");
		return budget;
	}
	
	/**
	 * Load all the items from our list to a U1 rocket. New Rockets are
	 * created until all items are loaded. New rockets are added to a list
	 * @return ArrayList of fully loaded U1 rockets
	 */
	public List<Rocket> loadU1(List<Item> phase, List<Rocket> fleet) {

		Rocket rockOne = new RocketU1();
		fleet.add(rockOne);
		for (int i = 0; i < phase.size(); i++) {
			if (rockOne.canCarry(phase.get(i))) { 
				rockOne.carry(phase.get(i));
			} else {
				rockOne = new RocketU1();
				fleet.add(rockOne);
				rockOne.carry(phase.get(i));
			}
		}
		System.out.println("\nAll rockets successfuly loaded\n");
		fleet.forEach(rocket -> System.out.println(rocket));
		return fleet;
	}
	
	/**
	 * Load all the items from our list to a U2 rocket. New Rockets are
	 * created until all items are loaded. New rockets are added to a list
	 * @return ArrayList of fully loaded U2 rockets
	 */
	public List<Rocket> loadU2(List<Item> phase, List<Rocket> fleet) {

		Rocket rockTwo = new RocketU2();
		fleet.add(rockTwo);
		for (int i = 0; i < phase.size(); i++) {
			if (rockTwo.canCarry(phase.get(i))) {
				rockTwo.carry(phase.get(i));
			} else {
				rockTwo = new RocketU2();
				fleet.add(rockTwo);
				rockTwo.carry(phase.get(i));
			}
		}
		System.out.println("\nAll rockets successfuly loaded");
		fleet.forEach(rocket -> System.out.println(rocket));
		return fleet;
	}
	
	/**
	 * Get the value of the budget
	 * @return the budget
	 */
	public int getBudget() {
		return budget;
	}
}