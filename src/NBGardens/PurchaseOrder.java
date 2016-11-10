package NBGardens;

import java.util.ArrayList;


/**
 * @author Administrator
 *
 */

public class PurchaseOrder extends Order implements Accounts { // PurchaseOrder class extends from the abstract Order class
	
	///////////////////////////////Attributes///////////////////////////////
	
	private int supplierId;
	private boolean hasBeenDispatched;
	private boolean hasBeenRecieved;
	private boolean hasBeenStacked;

	
	////////////////////////////Constructors///////////////////////////////
	
	public PurchaseOrder(){}
	
	public PurchaseOrder(int[] listOfItems, int operativeId, int supplierId) {
		super(listOfItems, operativeId);
		this.hasBeenDispatched = false;
		this.hasBeenRecieved = false;
		this.hasBeenStacked = false;
		this.supplierId = supplierId;
	}

	public PurchaseOrder(int[] listOfItems, int supplierId) {
		super(listOfItems);
		this.hasBeenDispatched = false;
		this.hasBeenRecieved = false;
		this.hasBeenStacked = false;
		this.supplierId = supplierId;
	}

	
	// Start of creation of Getters and Setters
	
	public boolean isHasBeenRecieved() {
		return hasBeenRecieved;
	}


	public void setHasBeenRecieved(boolean hasBeenRecieved) {
		this.hasBeenRecieved = hasBeenRecieved;
	}


	public boolean isHasBeenStacked() {
		return hasBeenStacked;
	}


	public void setHasBeenStacked(boolean hasBeenStacked) {
		this.hasBeenStacked = hasBeenStacked;
	}
	
	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public boolean isHasBeenDispatched() {
		return hasBeenDispatched;
	}

	public void setHasBeenDispatched(boolean hasBeenDispatched) {
		this.hasBeenDispatched = hasBeenDispatched;
	}

	
	
	///////////////////////////Methods/////////////////////////////////////
	
	
	
		public String updateAccounts() {
		 
		 String message = "Purchase Order has been recieved. Accounts has been notified";
		 return message;

	 }
		
		public ArrayList<PurchaseOrder> getPurchaseOrders(ArrayList<OrderLine> orders){
			ArrayList<PurchaseOrder> porders = new ArrayList<PurchaseOrder>();
			for (OrderLine i : orders)
			if (i.getOrder() instanceof PurchaseOrder) {
				porders.add((PurchaseOrder) i.getOrder());
			}
			return porders;
		}
		
		public PurchaseOrder updateStatus(PurchaseOrder order, int status){
			
			switch (status) {
			case 1:
				order.setOrderStatus("Order Placed");
				break;
			case 2:
				order.setOrderStatus("Order Dispatched");
				updateDispatch(order);
				break;
			case 3:
				order.setOrderStatus("Order Recieved");
				updateRecieved(order);
				break;	
			case 4:
				order.setOrderStatus("Order Stacked");
				updateRecieved(order);
				updateStacked(order);
				updateStock(order, Main.inventoryList);
				break;
			}
			return order;
			
		}
	
		public void updateStacked(PurchaseOrder order) {
			order.setHasBeenStacked(true);
		}
	
		public void updateDispatch(PurchaseOrder order) {
			order.setHasBeenDispatched(true);
		}
		
		public void updateRecieved(PurchaseOrder order) {
			order.setHasBeenRecieved(true);
			
		}
		
		public ArrayList<InventorySystem> updateStock(PurchaseOrder order, ArrayList<InventorySystem> inventoryList) {
			
			for(int i = 0; i < order.getListOfItems().length; i++) 	// Uses .length method to determine size of array
			{
				int tempItemId[] = order.getListOfItems(); 
																		// List of items array assigned to temporary integer array to allow us to use as an index in next line.
				int tempItemAmount = inventoryList.get(tempItemId[i]-1).getNoOfItem();
				inventoryList.get(tempItemId[i]-1).setNoOfItem(tempItemAmount+1); 	// Temporary array used to get specific item being iterated in the for loop. -1 to account for arraylist count from 0.
			}	
			
			return inventoryList;
		}
	
}
