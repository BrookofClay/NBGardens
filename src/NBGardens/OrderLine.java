/**
 * 
 */
package NBGardens;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class OrderLine {
	
	/////////////////////////////Attributes/////////////////////////////////////////
	
	private int id;
	private Object order; // Set as Object type so both CustomerOrder and PurchaseOrder objects can be passed to it.

	
	///////////////////////////Constructors////////////////////////////////////////
	
	public OrderLine(){
		this.order = null;
	}
	
	public OrderLine(int id, Object order) {
		this.id = id;
		this.order = order;
	}
	
	// Start of creation of Getters and Setters

	public Object getOrder() {
		return order;
	}
	
	public void setOrder(Object order) {
		this.order = order;
	}
	
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	/////////////////////////////Methods/////////////////////////////////////////
	
	public void addOrder(Object order, ArrayList<OrderLine> orderList) {
		 
		 int id = orderList.size() + 1; //Id created by taking current element size of order list array. 1 is added at the end to account for array ID count from 0.
		 
		// Creating new temporary object to allow us to add our new object to it.
		 OrderLine tempOrderLine = new OrderLine(id, order);
			 
		 // Temporary object is added to main customer list array.
		 orderList.add(tempOrderLine);
		 
	 }
	
	public String[] printOrders(ArrayList<OrderLine> orderList, ArrayList<InventorySystem> inventoryList) {
		
		// Method which is passed to the main for printing, main customer order list array is passed through to allow us to iterate through it.
		
					// For-each loop which allows method to go through each entry in the array regardless of size.
					// Order ID is used to print out each element in the object. -1 to account for arraylist ID starting from 0.
					String customerOrdersOutput = "";
					String purchaseOrdersOutput = "";
					for(OrderLine i : orderList) {
						if (i.getOrder() instanceof CustomerOrder){
						CustomerOrder tempOrder = (CustomerOrder) i.getOrder();
						customerOrdersOutput += "ID: " + i.getId() + " "; // Prints Order Id
						customerOrdersOutput += "Customer ID: " + tempOrder.getCustomerId() + " ";	 // Prints Customer Id
						customerOrdersOutput += "No. Of Items: " + tempOrder.getListOfItems().length + " "; // Prints No. of Items in the order
						customerOrdersOutput += "No. Of Porusware Items: " + tempOrder.getPoruswareItems().length + " "; // Prints No. of porusware items in the order
						customerOrdersOutput += "Total Cost: £" + calculateCost(tempOrder.getListOfItems(), inventoryList) + " "; // Prints total cost
						if(tempOrder.getOperativeId() == 0){
						customerOrdersOutput += "NOT ASSIGNED\n\n";
						} else {
						customerOrdersOutput += "Order Status: " + tempOrder.getOrderStatus() + " \n\n";
						}
						}
						else if (i.getOrder() instanceof PurchaseOrder)
						{
						PurchaseOrder tempOrder = (PurchaseOrder) i.getOrder();
						purchaseOrdersOutput += "ID: " + i.getId() + " "; // Prints Order Id
						purchaseOrdersOutput += "Supplier ID: " + tempOrder.getSupplierId() + " ";	 // Prints Customer Id
						purchaseOrdersOutput += "No. Of Items: " + tempOrder.getListOfItems().length + " "; // Prints No. of Items in the order
						purchaseOrdersOutput += "Total Cost: £" + calculateCost(tempOrder.getListOfItems(), inventoryList) + " "; // Prints total cost
						purchaseOrdersOutput += "Order Status: " + tempOrder.getOrderStatus() + " \n\n";
						if(tempOrder.getOperativeId() == 0){
							purchaseOrdersOutput += "NOT ASSIGNED";
							}
							}
						}	
					String fullOrderOutput[] = {customerOrdersOutput, purchaseOrdersOutput};
					return fullOrderOutput;
					}
			
	public double calculateCost(int[] listOfItems, ArrayList<InventorySystem> inventoryList) {
						 
	double totalcost = 0;
						
		for(int i = 0; i < listOfItems.length; i++) 	// Uses .length method to determine size of array
		{
			totalcost += inventoryList.get(listOfItems[i]-1).getItemCost(); 
		}
					 
		return totalcost;
	}

	public String printOrderDetails(ArrayList<InventorySystem> inventoryList, CustomerOrder corder, ArrayList<PersonLine> personsList, int id) {
		
		String orderDetailsOutput = "";
		
		// start of printing order method
		orderDetailsOutput +="Order Status: " + corder.getOrderStatus() + "\n"; // Prints Order ID number
		
		int tempCustomerId = (corder.getCustomerId()-1); // Gets customer ID from order object. Assigned to temporary integer. -1 to account for arraylist count from 0.
		Customer tmpCustomer = (Customer) Customer.getCustomer(tempCustomerId, personsList);
		orderDetailsOutput +="Customer Name: " + tmpCustomer.getName() + "\n";  // temporary integer used to get name from Customer arraylist.
		
		if(corder.getOperativeId() == 0) {
			orderDetailsOutput +="ORDER NOT ASSIGNED\n";
		}
		else
		{			
		int tempEmployeeId = (corder.getOperativeId()-1); 	// Gets employee ID from order object. Assigned to temporary integer. -1 to account for arraylist count from 0.
		WarehouseOperative tmpOperative = (WarehouseOperative) WarehouseOperative.getWarehouseOperative(tempEmployeeId, personsList);
		orderDetailsOutput +="Employee Name: " + tmpOperative.getName() + "\n"; 	// temporary integer used to get name from Employee arraylist.
		}
		
		orderDetailsOutput +="\nItems In Order:\n"; 	// List of items is saved to array, so for loop is used to iterate through all elements in array.
					
		for(int i = 0; i < corder.getListOfItems().length; i++) 	// Uses .length method to determine size of array
		{
			int tempItemId[] = corder.getListOfItems(); 	// List of items array assigned to temporary integer array to allow us to use as an index in next line.
			orderDetailsOutput += inventoryList.get(tempItemId[i]-1).getItemName() + "\n"; 	// Temporary array used to get specific item being iterated in the for loop. -1 to account for arraylist count from 0.
		}
				
		orderDetailsOutput +="\nItems To Be Poruswared: \n"; 	// List of items is saved to array, so for loop is used to iterate through all elements in array.
		for(int i = 0; i < corder.getPoruswareItems().length; i++) 	// Uses .length method to determine size of array
		{
			int tempItemId[] = corder.getPoruswareItems(); 	// List of items array assigned to temporary integer array to allow us to use as an index in next line.
			orderDetailsOutput += inventoryList.get(tempItemId[i]-1).getItemName() + "\n"; 	// Temporary array used to get specific item being iterated in the for loop. -1 to account for arraylist count from 0.
		}
		
		// Prints boolean response from array.
		orderDetailsOutput += "\nHas this order been Dispatched? : " + corder.isDispatched();
		orderDetailsOutput +="\nHas this order been Recieved? : " + corder.isHasBeenRecieved(); 
		
		return orderDetailsOutput;
	}
	
	public String printOrderDetails(ArrayList<InventorySystem> inventoryList, PurchaseOrder porder, ArrayList<PersonLine> personsList, int id) {
		
		String orderDetailsOutput = "";
		
		// start of printing order method
		orderDetailsOutput +="Order Status: " + porder.getOrderStatus() + "\n"; // Prints Order ID number
		
		int tempSupplierId = (porder.getSupplierId()); // Gets customer ID from order object. Assigned to temporary integer. -1 to account for arraylist count from 0.
		Supplier tmpSupplier = (Supplier) Supplier.getSupplier(tempSupplierId, personsList);
		orderDetailsOutput +="Supplier Name: " + tmpSupplier.getName() + "\n";  // temporary integer used to get name from Customer arraylist.
		
		if(porder.getOperativeId() == 0) {
			orderDetailsOutput +="ORDER NOT ASSIGNED\n";
		}
		else
		{			
		int tempEmployeeId = (porder.getOperativeId()-1); 	// Gets employee ID from order object. Assigned to temporary integer. -1 to account for arraylist count from 0.
		WarehouseOperative tmpOperative = (WarehouseOperative) WarehouseOperative.getWarehouseOperative(tempEmployeeId, personsList);
		orderDetailsOutput +="Employee Name: " + tmpOperative.getName() + "\n"; 	// temporary integer used to get name from Employee arraylist.
		}
		
		orderDetailsOutput +="\nItems In Order:\n"; 	// List of items is saved to array, so for loop is used to iterate through all elements in array.
					
		for(int i = 0; i < porder.getListOfItems().length; i++) 	// Uses .length method to determine size of array
		{
			int tempItemId[] = porder.getListOfItems(); 	// List of items array assigned to temporary integer array to allow us to use as an index in next line.
			orderDetailsOutput += inventoryList.get(tempItemId[i]-1).getItemName() + "\n"; 	// Temporary array used to get specific item being iterated in the for loop. -1 to account for arraylist count from 0.
		}
				
		
		// Prints boolean response from array.
		orderDetailsOutput +="\nHas this order been Recieved? : " + porder.isHasBeenRecieved(); 
		orderDetailsOutput += "\nHas this order been Stacked? : " + porder.isHasBeenStacked();
		
		return orderDetailsOutput;
	}
	
	public void replaceOrder(int orderId, CustomerOrder order) {
		Main.orderList.get(orderId).setOrder(order);
	
	 }
	 
	public void replaceOrder(int orderId,PurchaseOrder order) {
		Main.orderList.get(orderId).setOrder(order); 
	 }
	
	public void deleteOrder(ArrayList<OrderLine> orderList, int id){
		orderList.remove(id);
	}
		
}