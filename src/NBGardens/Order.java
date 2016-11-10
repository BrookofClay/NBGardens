/**
 * 
 */
package NBGardens;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andrew and Niall
 * 
 * Class to show creation of a new order. Please note this is abstract and not to be used in creation of objects
 *
 */
public abstract class Order { // Abstract class, only created to allow creation of CustomerOrder and PurchaseOrder class. Does not have any functionality.

	/////////////////////////////Attributes/////////////////////////////////////////
	
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private int id;
	private int[] listOfItems;
	private int operativeId;
	private String orderStatus;
	private boolean accountUpdate;
	
	///////////////////////////Constructors////////////////////////////////////////
	
	public Order(){

	}
	
	public Order(int[] listOfItems, int operativeId) {
		this.id = Order.nextId.incrementAndGet();
		this.listOfItems = listOfItems;
		this.operativeId = operativeId;
		this.setOrderStatus("Order Placed");
		this.accountUpdate = false;
		
	}
	
	public Order(int[] listOfItems) {
		this.id = Order.nextId.incrementAndGet();
		this.listOfItems = listOfItems;
		this.operativeId = 0;
		this.setOrderStatus("Order Placed");
		this.accountUpdate = false;
	}
	
	// Start of creation of Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int[] getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(int[] listOfItems) {
		this.listOfItems = listOfItems;
	}

	public int getOperativeId() {
		return operativeId;
	}

	public void setOperativeId(int operativeId) {
		this.operativeId = operativeId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public boolean isAccountUpdate() {
		return accountUpdate;
	}

	public void setAccountUpdate(boolean accountUpdate) {
		this.accountUpdate = accountUpdate;
	}

	public Order updateOperative(int operativeId, CustomerOrder order){
		
		order.setOperativeId(operativeId);
		
		return order;
		
	}
	
}
