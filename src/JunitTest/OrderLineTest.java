package JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import NBGardens.CustomerOrder;
import NBGardens.InventorySystem;
import NBGardens.OrderLine;
import NBGardens.PurchaseOrder;

public class OrderLineTest {
	
	@Test
	public void testGetIDIsNotNull() {
	
		int orderedItems2[] = {1,3,4};
		
		int poruswareItems2[] = {1,3};
				
		OrderLine orders = new OrderLine(1, new CustomerOrder (orderedItems2, 1, poruswareItems2, 2));
		
		assertNotNull("Shoud not be null", orders.getId());
	}
	
	@Test
	public void testGetObjectIsNotNull() {
			
		int orderedItems2[] = {1,3,4};
		
		int poruswareItems2[] = {1,3};
				
		OrderLine orders = new OrderLine(1, new CustomerOrder (orderedItems2, 1, poruswareItems2, 2));
		
		assertNotNull("Shoud not be null", orders.getOrder());
	}
	
	@Test
	public void testSetOrderObject() {
		
		int orderedItems2[] = {1,3,4};
		
		int poruswareItems2[] = {1,3};
				
		OrderLine orders = new OrderLine(1, new CustomerOrder (orderedItems2, 1, poruswareItems2, 2));
		
		CustomerOrder tempCustomer = new CustomerOrder (orderedItems2, 1, poruswareItems2, 2);
		
		orders.setOrder(tempCustomer);
		
		assertSame("Shoud be the same object", orders.getOrder(), tempCustomer);
	}
	

	@Test
	public void testaddOrder() {
		
		OrderLine orders = new OrderLine();
		ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
		
		int orderedItems2[] = {1,3,4};
		
		int poruswareItems2[] = {1,3};
		
		CustomerOrder tempCustomer = new CustomerOrder (orderedItems2, 1, poruswareItems2, 2);
				
		orders.addOrder(tempCustomer, orderList);
		
		assertSame("Both objects should be the same", tempCustomer, orderList.get(0).getOrder());
		
	}
	
	@Test
	public void testCalculateCost() {
		
		InventorySystem inventory = new InventorySystem();
		OrderLine orders = new OrderLine();
		
		ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
		ArrayList<InventorySystem> inventoryList = new ArrayList<InventorySystem>();
		
		inventory.AddNewItem("Garden Gnome", 8,"B2","Gnome", 5, 9.99);
		inventory.AddNewItem("Ray Smithy Gnome", 10,"B1","Gnome", 4, 10.99);
		inventory.AddNewItem("Deck Chair", 15,"C1","Garden Furniture", 10, 7.99);
		inventory.AddNewItem("Garden Gnome Hat", 25,"A3","Gnome Accessories", 17, 2.99);
		
		int orderedItems2[] = {1,3,4};
		
		int poruswareItems2[] = {1,3};
				
		orders.addOrder(new CustomerOrder (orderedItems2, 1, poruswareItems2, 2), orderList);
		
		double tempCost = orders.calculateCost(orderedItems2, inventoryList);
		
		assertSame("Should equal £20.97", tempCost, 20.97);
		
	}
	
	@Test
	public void testeditOrderCustomerObject() {
		
		InventorySystem inventory = new InventorySystem();
		OrderLine orders = new OrderLine();
		
		ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
		
		inventory.AddNewItem("Garden Gnome", 8,"B2","Gnome", 5, 9.99);
		inventory.AddNewItem("Ray Smithy Gnome", 10,"B1","Gnome", 4, 10.99);
		inventory.AddNewItem("Deck Chair", 15,"C1","Garden Furniture", 10, 7.99);
		inventory.AddNewItem("Garden Gnome Hat", 25,"A3","Gnome Accessories", 17, 2.99);
		
		int orderedItems2[] = {1,3,4};
		
		int poruswareItems2[] = {1,3};
		
		CustomerOrder tempCustomerOrder = new CustomerOrder (orderedItems2, 1, poruswareItems2, 2);
				
		orders.addOrder(tempCustomerOrder, orderList);
		
		orders.editOrder(tempCustomerOrder);
		
		assertSame("Should not be the same", tempCustomerOrder.getOrderStatus(), "Order Recieved");
		
	}
	
	@Test
	public void testeditOrderrWithPurchaseObject() {
		
		
		InventorySystem inventory = new InventorySystem();
		OrderLine orders = new OrderLine();
		
		ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
		
		inventory.AddNewItem("Garden Gnome", 8,"B2","Gnome", 5, 9.99);
		inventory.AddNewItem("Ray Smithy Gnome", 10,"B1","Gnome", 4, 10.99);
		inventory.AddNewItem("Deck Chair", 15,"C1","Garden Furniture", 10, 7.99);
		inventory.AddNewItem("Garden Gnome Hat", 25,"A3","Gnome Accessories", 17, 2.99);
		
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tempPurchaseOrder = new PurchaseOrder (orderedItems2, 2, 1);
				
		orders.addOrder(tempPurchaseOrder, orderList);
		
		orders.editOrder(tempPurchaseOrder);
		
		assertSame("Should not be the same",tempPurchaseOrder.getOrderStatus(), "Order Stacked");
		
	}	
}
