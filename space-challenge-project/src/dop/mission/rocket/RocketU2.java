package dop.mission.rocket;

import java.util.Random;
/**
 * The U-2 Rocket is heavier (18 tones) than the U-1 but much safer and can carry a lot more cargo; 
 * to a total of 29 tones. However, it costs $120 Million to build and weighs 18 tonnes. 
 * It has a greater chance of crashing while landing than while launching, but just like 
 * the U-1 both chances depend on the amount of cargo carried.
 * 
 * explosionProbability = 4% * (cargo carried / cargo limit)
 * crashProbability = 8% * (cargo carried / cargo limit)
 */
public class RocketU2 extends Rocket {
	
	/* Attributes(s) */
	
	/* Chance of launch explosion (%) */
	public static final double EXPLOSION = 0.04;
	
	/* Chance of landing crash (%) */
	public static final double CRASH = 0.08;
	
	/* Color for console output text */
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	/* Chance of launch explosion */
	private double chanceOfLaunchEx;
	
	/* Chance of landing crash */
	private double chanceOfCrash;
	
	/* Constructor(s) */
	
	public RocketU2() {
		this.weight = 18000;
		this.maxWeight = 29000;
		this.cargoLimit = maxWeight - weight;
		this.cost = 120;
	}
	
	/**
	 * Create a RocketU2 object with parameters
	 */
	public RocketU2(int weight, int maxWeight, int cost) {
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
	 * Launch a rocket with a probability of 4% launch explosion
	 * @return true if launch is successful, otherwise false
	 */
	@Override
	public boolean launch() {
		Random chance = new Random();
		double number = chance.nextDouble();
		if(number <= this.getChanceOfLaunchEx()) {
			System.out.println(ANSI_GREEN + "Explosion occurred during the launch. Launch failed" + ANSI_RESET);
			return false;
		} else {
			System.out.println(ANSI_GREEN + "Launch successful!" + ANSI_RESET);
			return true;	
		}
	}
	
	/**
	 * Land a rocket with a probability of 8% land crash
	 * @return true if landing is successful, otherwise false
	 */
	@Override
	public boolean land() {
		if (new Random().nextDouble() <= this.getChanceOfCrash()) {
			System.out.println(ANSI_RED + "Rocket has crashed. Landing failed" + ANSI_RESET);
			System.out.println(">-->-->-->-->-->-->-->-->-->-->-->");
			return false;
		} else {
			System.out.println(ANSI_GREEN + "Landing successful!" + ANSI_RESET);
			System.out.println(">-->-->-->-->-->-->-->-->-->-->-->");
			return true;
		}
	}
	
	/**
	 * Get RocketU2 info
	 */
	@Override
	public String toString() {
		return "\nRocketU2 [cargoWeight=" + this.getCargoWeight() + ", cargoList=" + cargoList + "]";
	}
}