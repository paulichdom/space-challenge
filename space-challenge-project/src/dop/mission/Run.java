package dop.mission;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dop.mission.cargo.Item;
import dop.mission.cargo.ItemData;
import dop.mission.rocket.Rocket;

/**
 * Run class loads all items and runs the simulation.
 * All while keeping track of the total budget required 
 * to send each rocket safely to Mars.
 */

public class Run {
	
	/* Attribute(s) */
	
	/** Total budget for each fleet of rockets both phases inclusive */
	private int budgetU1;
	private int budgetU2;
	
	/** Initialize source files for the item parameters to be loaded */
	File sourceOne = new File("resources/phase1.txt");
	File sourceTwo = new File("resources/phase2.txt");
	
	/** Create two empty lists of Items for each phase */
	List<Item> phaseOneItems = new ArrayList<>();
	List<Item> phaseTwoItems = new ArrayList<>();
	
	/** Create four empty lists of rockets for each phase */
	List<Rocket> fleetU1P1 = new ArrayList<>();
	List<Rocket> fleetU1P2 = new ArrayList<>();
	List<Rocket> fleetU2P1 = new ArrayList<>();
	List<Rocket> fleetU2P2 = new ArrayList<>();
	
	/** Create ItemData object to load the items from source files to ArrayLists */
	ItemData getItems = new ItemData();
	
	/** Create Simulation class object to load the rockets and run the simulation */
	Simulation sim = new Simulation();
	
	/* Constructor(s) */
	
	/**
	 * Create Run class object
	 * Object creation automatically loads all the items to our lists
	 */
	public Run() {
		System.out.println("Loading items... \n");
		System.out.println("Phase 1 items:");
		getItems.loadItems(sourceOne, phaseOneItems);
		System.out.println("\nPhase 2 items:");
		getItems.loadItems(sourceTwo, phaseTwoItems);
		System.out.println("\nAll items successfuly loaded");
	}
	
	/* Method(s)
	
	/**
	 * Run the first simulation: Rocket fleet U1 - Phase 1 Items
	 */
	public void simU1P1() {
		sim.loadU1(phaseOneItems, fleetU1P1);
		sim.runSimulation(fleetU1P1);
		this.budgetU1 = budgetU1 + sim.getBudget();
	}
	
	/**
	 * Run the second simulation: Rocket fleet U1 - Phase 2 Items
	 */
	public void simU1P2() {
		sim.loadU1(phaseTwoItems, fleetU1P2);
		sim.runSimulation(fleetU1P2);
		this.budgetU1 = budgetU1 + sim.getBudget();
	}
	
	/**
	 * Run the third simulation: Rocket fleet U2 - Phase 1 Items
	 */
	public void simU2P1() {
		sim.loadU2(phaseOneItems, fleetU2P1);
		sim.runSimulation(fleetU2P1);
		this.budgetU2 = budgetU2 + sim.getBudget();
	}
	
	/**
	 * Run the fourth simulation: Rocket fleet U2 - Phase 2 Items
	 */
	public void simU2P2() {
		sim.loadU2(phaseTwoItems, fleetU2P2);
		sim.runSimulation(fleetU2P2);
		this.budgetU2 = budgetU2 + sim.getBudget();
	}

	/**
	 * Get current budget status for U1 rocket fleet
	 * @return the budgetU1
	 */
	public int getBudgetU1() {
		return budgetU1;
	}

	/**
	 * Get current budget status for U2 rocket fleet
	 * @return the budgetU2
	 */
	public int getBudgetU2() {
		return budgetU2;
	}
}