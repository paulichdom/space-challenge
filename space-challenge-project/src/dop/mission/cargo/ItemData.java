package dop.mission.cargo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Class ItemData loads Item data (parameters) from a source (text file).
 * For each item in a text file a new Item object is created and added to a list.
 * As a result a new ArrayList of items is created.
 */
public class ItemData {
	
	/**
	 * Load item parameters from a text file and create a new list of new items
	 * @param source file (text file)
	 * @return item List
	 */
	public List<Item> loadItems(File source, List<Item> phase) {
		
		/* initialise a list */
		List<Item> cargoList = new ArrayList<>();
		cargoList = phase;
		
		Item newItem;
		String param[];
		int weight;
		
		/*
		 * Read the text file line by line and create an Item object for each and then
		 * add it to an ArrayList of Items
		 */
		try (BufferedReader myReader = new BufferedReader(new FileReader(source))) { // try-with-resources
			String data = myReader.readLine();
			while (true) {
				if (data == null) {
					break;
				}
				param = data.split("=");
				weight = Integer.parseInt(param[1]);
				newItem = new Item(param[0], weight);
				cargoList.add(newItem);
				data = myReader.readLine();
			}
		} catch (IOException except) {
			System.err.println("Failed or interrupted I/O operation");
			except.printStackTrace();
		}
		cargoList.forEach(item -> System.out.println(item));
		return cargoList;
	}
}
