/**
 * 
 */
package NBGardens;

import java.util.ArrayList;

/**
 * @author Andrew and Niall
 * 
 * Class to show creation of items in the inventory system
 *
 */
public class InventorySystem {
	
	////////////////////////////////Attributes/////////////////////////////////////////
	
	private int id;
	private String itemName;
	private int noOfItem;
	private String itemLocation;
	private String itemType;
	private int noOfPorusware;
	private double itemCost;
	
	////////////////////////////Constructors///////////////////////////////////////////
	
	public InventorySystem(){
	}
	
	// Overloading of Constructor to allow user to add item if they do not have all the information for this class.
	
	public InventorySystem(int id, String itemName, int noOfItem, String itemLocation, String itemType, int noOfPorusware, double itemCost)
	{
		this.id = id;
		this.itemName = itemName;
		this.noOfItem = noOfItem;
		this.itemLocation = itemLocation;
		this.itemType = itemType;
		this.noOfPorusware = noOfPorusware;
		this.itemCost = itemCost;
	}
	
	public InventorySystem(int id, String itemName, int noOfItem, String itemLocation, String itemType, double itemCost)
	{
		this.id = id;
		this.itemName = itemName;
		this.noOfItem = noOfItem;
		this.itemLocation = itemLocation;
		this.itemType = itemType;
		this.noOfPorusware = 0;
		this.itemCost = itemCost;
	}

	// Start of creation of Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNoOfItem() {
		return noOfItem;
	}

	public void setNoOfItem(int noOfItem) {
		this.noOfItem = noOfItem;
	}

	public String getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getNoOfPorusware() {
		return noOfPorusware;
	}

	public void setNoOfPorusware(int noOfPorusware) {
		this.noOfPorusware = noOfPorusware;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	
	
	////////////////////////////////////Methods///////////////////////////////////////////////////////
	
	 public ArrayList<InventorySystem> PoruswareCheck() {
		 
		 ArrayList<InventorySystem> itemsNeedPorusware = new ArrayList<InventorySystem>();
		 return itemsNeedPorusware;
	 }
	
	 public void UpdatePorusware(int noOfPorusware) {}
	
	// Method addNewItem which is passed all information needed to create a new order except for Id which is made automatically
	 public void AddNewItem(String string, int i, String string2, String string3, int j, double d) {
		 
		 int id = Main.inventoryList.size() + 1; //Id created by taking current element size of customer order list array. 1 is added at the end to account for computer counting from 0.
		 
		// Creating new temporary InventorySystem object to allow us to add our new attributes to it.
		 InventorySystem tempItem = new InventorySystem(id, string, i, string2, string3, j, d);
		 
		// Temporary object is added to main inventory list list array.
		 Main.inventoryList.add(tempItem);
	 }
	 
	 public String printStock(ArrayList<InventorySystem> inventoryList) {
			// Method which is passed to the main for printing, main customer order list array is passed through to allow us to iterate through it.
			
			// For-each loop which allows method to go through each entry in the array regardless of size.
			// Order ID is used to print out each element in the object. -1 to account for arraylist ID starting from 0.
			String inventoryOutput = "";
			for(InventorySystem i : inventoryList) {
				inventoryOutput +="ID: " + inventoryList.get(i.getId()-1).getId() + " "; // Prints Order Id
				inventoryOutput +="Item Name: " + inventoryList.get(i.getId()-1).getItemName() + " ";	 // Prints Customer Id
				inventoryOutput +="No. Of Items: " + inventoryList.get(i.getId()-1).getNoOfItem() + " "; // Prints No. of Items in the order
				inventoryOutput +="Item Location: " + inventoryList.get(i.getId()-1).getItemLocation() + " "; // Prints No. of porusware items in the order
				inventoryOutput +="No. Of Porusware: " + inventoryList.get(i.getId()-1).getNoOfPorusware() + " "; // Prints total cost
				inventoryOutput +="Item Cost : £" + inventoryList.get(i.getId()-1).getItemCost() + "\n\n";
			}	
			return inventoryOutput;
		}
	
	 public void DeleteItem(int id) {}
	
	 public void UpdateItem(int id) {}
}
