package dop.mission.rocket.comm;

import dop.mission.cargo.Item;

/**
 * SpaceShip interface has four methods:
 * 
 * --1-- launch: a method that returns either true of false indicating 
 * if the launch was successful or if the rocket has crashed
 * 
 * --2-- land: a method that also returns either true or false based on 
 * the success of the landing
 * 
 * --3-- canCarry: a method that takes an Item object as a parameter and
 * returns true if the rocket can carry such item or false if it will 
 * exceed the weight limit.
 * 
 * --4-- carry: a method that also takes an Item object and updates the 
 * current weight of the rocket
 * @author dooms
 *
 */
public interface SpaceShip {
	
	/* Methods are by default public abstract */
	 
	public boolean launch();
	public boolean land();
	public boolean canCarry(Item anItem);
	public void carry (Item anItem);	
}
