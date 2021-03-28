package dop.mission.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dop.mission.Run;
import dop.mission.cargo.Item;
/**
 * Main class runs the simulation Prompt. The prompt displays a menu
 * where user can select a phase of the project to be initiated.
 * After finishing all four stages of the simulation the prompt
 * shows the mission's total budget for each phase. From the comparison
 * of the two budgets user can determine which rocket fleet is more
 * suitable for the mission.
 * @author dooms
 *
 */
public class Main {

	public static void main(String[] args) {

		/** Initialize the scanner to read the user input */
		Scanner scan = new Scanner(System.in);
		
		/** initialize the Run class object to run the simulation */
		Run run = new Run();
		
		/** Run the simulation prompt */
		Main.simulationPrompt(scan, run);
	}
	
	/**
	 * Prompts the user to select a phase of the simulation to be initiated
	 * Shows the current status of the mission total budget
	 * @param scan
	 * @param run
	 */
	public static void simulationPrompt(Scanner scan, Run run) {
		
		int choice;
		
		List<String> menuOptions = new ArrayList<>();
		menuOptions.add("  \n\t1) Launch Rockets U1 for Phase 1  \n");
		menuOptions.add("  \t2) Launch Rockets U1 for Phase 2  \n");
		menuOptions.add("  \t3) Launch Rockets U2 for Phase 1  \n");
		menuOptions.add("  \t4) Launch Rockets U2 for Phase 2  \n");
		// System.out.println(menuOptions);

		do {
			System.out.printf("\n_____________________________________\n");
			System.out.printf("\nWelcome to Mission to Mars simulation\n");
			System.out.println("\n  Current budget status for:\n"); 
			System.out.println("     Rocket fleet U1 is: €" + run.getBudgetU1() + " Million"); 
			System.out.println("     Rocket fleet U2 is: €" + run.getBudgetU2() + " Million\n"); 
			System.out.println("  What would you like to do?\n");
			System.out.println("  1) Launch Rockets U1 for Phase 1");
			System.out.println("  2) Launch Rockets U1 for Phase 2");
			System.out.println("  3) Launch Rockets U2 for Phase 1");
			System.out.println("  4) Launch Rockets U2 for Phase 2");
			
			System.out.println("\n  5) Quit the simulation");
			System.out.print("\nEnter choice: ");
			choice = scan.nextInt();

			if (choice < 1 || choice > 5) {
				System.out.println("Invalid choice. Please choose 1-5");
			}
		} while (choice < 1 || choice > 5);

		switch (choice) {

		case 1:
			System.out.println("\nLoading the rockets...\n");
			run.simU1P1();
			break;
		case 2:
			System.out.println("\nLoading the rockets...\n");
			run.simU1P2();
			break;
		case 3:
			System.out.println("\nLoading the rockets...\n");
			run.simU2P1();
			break;
		case 4:
			System.out.println("\nLoading the rockets...\n");
			run.simU2P2();
			break;
		case 5:
			System.out.println("\nThank you for helping humanity survive. Simulation terminated");
			System.exit(0);
			break;
		}

		if (choice != 5) {
			Main.simulationPrompt(scan, run);
		}
	}
}