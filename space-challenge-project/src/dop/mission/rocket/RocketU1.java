package dop.mission.rocket;

import java.util.Random;

/**
 * The U-1 Rocket is light weight (10 tones), agile and 
 * pretty safe, but can only carry a total of 18 tones of 
 * cargo. It costs $100 Million to build and weighs 10 tones. 
 * It has a slim chance of crashing while landing but a 
 * bigger chance of exploding when launching, both chances 
 * depend on the amount of cargo carried in the rocket.
 * 
 * explosionProbability = 5% * (cargo carried / cargo limit)
 * crashProbability = 1% * (cargo carried / cargo limit)
 */
public class RocketU1 extends Rocket {
	
	/* Attribute(s) */
	
	/** Chance of launch explosion (%) */
	public static final double EXPLOSION = 0.05;
	
	/** Chance of landing crash (%) */
	public static final double CRASH = 0.01;
	
	/** Color for console output text */
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	/** Chance of launch explosion */
	private double chanceOfLaunchEx;
	
	/** Chance of landing crash */
	private double chanceOfCrash;
	
	/* Constructor(s) */
	
	/**
	 * Create a RocketU1 object
	 */
	public RocketU1() {
		this.weight = 10000;
		this.maxWeight = 18000;
		this.cargoLimit = maxWeight - weight;
		this.cost = 100;
	}
	
	/**
	 * Create a RocketU1 object with parameters 
	 */
	public RocketU1(int weight, int maxWeight, int cost) {
		super(weight, maxWeight, cost); 
	}
	
	/* Method(s) */
	
	/**
	 * Get the calculated value for chance of launch Explosion
	 * @return the chanceOfLaunchEx
	 */
	public double getChanceOfLaunchEx() {
		this.chanceOfLaunchEx = EXPLOSION * ((double)this.getCargoWeight() / cargoLimit);
		return chanceOfLaunchEx;
	}

	/**
	 * Get the calculated value for chance of landing crash
	 * @return the chanceOfCrash
	 */
	public double getChanceOfCrash() {
		this.chanceOfCrash = CRASH * ((double)this.getCargoWeight() / cargoLimit);
		return chanceOfCrash;
	}
	
	/**
	 * Launch a rocket with a probability of 5% launch explosion
	 * @return true if launch is successful, otherwise false
	 */
	@Override
	public boolean launch() {
		Random chance = new Random();
		double number = chance.nextDouble();
		//System.out.println(number);
		if(number <= this.getChanceOfLaunchEx()) {
			System.out.println(ANSI_RED + "Explosion occurred during the launch. Launch failed" + ANSI_RESET);
			//System.out.println(chanceOfLaunchEx);
			return false;
		} else {
			System.out.println(ANSI_GREEN + "Launch successful!" + ANSI_RESET);
			//System.out.println(chanceOfLaunchEx);
			return true;	
		}
	}
	
	/**
	 * Land a rocket with a probability of 1% land crash
	 * @return true if landing is successful, otherwise false
	 */
	@Override
	public boolean land() {
		if(new Random().nextDouble() <= this.getChanceOfCrash()) { 
			System.out.println(ANSI_RED + "Rocket has crashed. Landing failed" + ANSI_RESET);
			//System.out.println(chanceOfCrash);
			System.out.println(">-->-->-->-->-->-->-->-->-->-->-->");
			return false;
		} else {
			System.out.println(ANSI_GREEN + "Landing successful!" + ANSI_RESET);
			//System.out.println(chanceOfCrash);
			System.out.println(">-->-->-->-->-->-->-->-->-->-->-->");
			return true;
		}
	}
	
	/**
	 * Get RocketU1 info
	 */
	@Override
	public String toString() {
		return "RocketU1 [cargoWeight=" + this.getCargoWeight() + ", cargoList=" + cargoList + "]";
	}
}