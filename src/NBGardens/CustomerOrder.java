/**
 * 
 */
package NBGardens;

import java.util.ArrayList;


/**
 * @author Andrew and Niall
 * 
 * Class to show creation of new customer orders with its attributes and behaviours.
 * This class extends from the abstract Order class and implements the Accounts interface along with the Purchase Order class.
 *
 */
public class CustomerOrder extends Order implements Accounts { // CustomerOrder class extends from the abstract Order class
	
	
	///////////////////////////////Attributes///////////////////////////////
	
	private int customerId;
	private int[] poruswareItems;
	private boolean isPicked;
	private boolean isDispatched;
	private boolean hasBeenRecieved;
	
	/////////////////////////////Constructors///////////////////////////////
	
	public CustomerOrder(){}
		
	public CustomerOrder(int[] listOfItems, int operativeId, int[] poruswareItems, int customerId) {
		super(listOfItems, operativeId);
		this.customerId = customerId;
		this.poruswareItems = poruswareItems;
		this.isPicked = false;
		this.isDispatched = false;
		this.hasBeenRecieved = false;
	}
	
	public CustomerOrder(int[] listOfItems, int[] poruswareItems, int customerId) {
		super( listOfItems);
		this.customerId = customerId;
		this.poruswareItems = poruswareItems;
		this.isPicked = false;
		this.isDispatched = false;
		this.hasBeenRecieved = false;
	}
	
	
	// Start of creation of Getters and Setters

	public int[] getPoruswareItems() {
		return poruswareItems;
	}

	public void setPoruswareItems(int[] poruswareItems) {
		this.poruswareItems = poruswareItems;
	}

	public boolean isDispatched() {
		return isDispatched;
	}

	public void setDispatched(boolean isDispatched) {
		this.isDispatched = isDispatched;
	}

	public boolean isHasBeenRecieved() {
		return hasBeenRecieved;
	}

	public void setHasBeenRecieved(boolean hasBeenRecieved) {
		this.hasBeenRecieved = hasBeenRecieved;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public boolean isPicked() {
	return isPicked;
	}

	public void setPicked(boolean isPicked) {
	this.isPicked = isPicked;
	}

	
	//////////////////////////////Methods//////////////////////////////////
	

		public CustomerOrder updateStatus(CustomerOrder order, int status){
			
			switch (status) {
			case 1:
				order.setOrderStatus("Order Placed");
				break;
			case 2:
				order.setOrderStatus("Order Picked");
				updateStock(order, Main.inventoryList);
				updatePicked(order);
				break;
			case 3:
				order.setOrderStatus("Order Dispatched");
				updateDispatch(order);
				break;
			case 4:
				order.setOrderStatus("Order Recieved");
				updateRecieved(order);
				break;	
			}
			return order;
			
		}
		
		public void updatePicked(CustomerOrder order) {
			order.setPicked(true);
			
		}
	
		public void updateDispatch(CustomerOrder order) {
			order.setDispatched(true);
		}
	
		public void updateRecieved(CustomerOrder order) {
			order.setHasBeenRecieved(true);
			
		}
		
	public ArrayList<InventorySystem> updateStock(CustomerOrder order, ArrayList<InventorySystem> inventoryList) {
			
			for(int i = 0; i < order.getListOfItems().length; i++) 	// Uses .length method to determine size of array
			{
				int tempItemId[] = order.getListOfItems(); 
																		// List of items array assigned to temporary integer array to allow us to use as an index in next line.
				int tempItemAmount = inventoryList.get(tempItemId[i]-1).getNoOfItem();
				inventoryList.get(tempItemId[i]-1).setNoOfItem(tempItemAmount+1); 	// Temporary array used to get specific item being iterated in the for loop. -1 to account for arraylist count from 0.
			}	
			
			return inventoryList;
		}
	
	public ArrayList<CustomerOrder> getCustomerOrders(ArrayList<OrderLine> orders){
		ArrayList<CustomerOrder> corders = new ArrayList<CustomerOrder>();
		for (OrderLine i : orders)
		if (i.getOrder() instanceof CustomerOrder) {
			corders.add((CustomerOrder) i.getOrder());
		}
		return corders;
	}
	
		@Override
	public Order updateOperative(int operativeId, CustomerOrder order) {
		return super.updateOperative(operativeId, order);
	}
		
		public void updateAccountBool(CustomerOrder order){
			order.setAccountUpdate(true);			
		}

		public String updateAccounts() {
		 
			 String message = "Customer Order has been dispatched. Accounts has been notified";
			 return message;
		}
		
}