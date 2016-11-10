package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import NBGardens.InventorySystem;
import NBGardens.Main;
import NBGardens.PurchaseOrder;

public class PurchaseOrderTest {

	@Test
	public void testGetIdIsNotNull() {
		
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		assertNotNull("Shoud not be null", tester.getId());
	}
	
	@Test
	public void testGetListOfItemsIsNotNull() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		assertNotNull("Shoud not be null", tester.getListOfItems());
	}
	
	@Test
	public void testGetOperativeIdIsNotNull() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		assertNotNull("Shoud not be null", tester.getOperativeId());
	}
	
	
	@Test
	public void testGetHasBeenStackedIsNotNull() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		assertNotNull("Shoud not be null", tester.isHasBeenStacked());
	}
	
	@Test
	public void testGetHasBeenRecievedIsNotNull() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		assertNotNull("Shoud not be null", tester.isHasBeenRecieved());
	}
	
	@Test
	public void testSetID() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		tester.setId(2);
		assertSame("Shoud be 2", tester.getId(), 2);
	}

	@Test
	public void testSetListOfItems() {
		int orderedItems2[] = {1,3,4};
		int newOrderedItems[] = {1,2,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		tester.setListOfItems(newOrderedItems);
		assertSame("Shoud be 2 Gnome Grove", tester.getListOfItems(), newOrderedItems);
	}
	
	@Test
	public void testSetOperativeID() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		tester.setOperativeId(3);
		assertSame("Shoud be 3", tester.getOperativeId(), 3);
	}
	
	
	@Test
	public void testSetHasBeenStackedIsDispatched() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		tester.setHasBeenStacked(true);
		assertSame("Shoud be 0225156114152", tester.isHasBeenStacked(), true);
	}
	
	@Test
	public void testSetHasBeenDispatched() {
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		tester.setHasBeenRecieved(true);
		assertSame("Shoud be 0225156114152", tester.isHasBeenRecieved(), true);
	}
	
	@Test
	public void testUpdateStatus() {
		
		InventorySystem inventory = new InventorySystem();
		
		inventory.AddNewItem("Garden Gnome", 8,"B2","Gnome", 5, 9.99);
		inventory.AddNewItem("Ray Smithy Gnome", 10,"B1","Gnome", 4, 10.99);
		inventory.AddNewItem("Deck Chair", 15,"C1","Garden Furniture", 10, 7.99);
		inventory.AddNewItem("Garden Gnome Hat", 25,"A3","Gnome Accessories", 17, 2.99);
		
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		
		tester.updateStatus(tester, 4);
		
		assertSame("Should be the same", "Order Stacked", tester.getOrderStatus());
		
	}
	
	@Test
	public void testUpdateStacked() {
			
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		
		tester.updateStacked(tester);
		
		assertSame("Should be the same", true, tester.isHasBeenStacked());	
	}
	
	@Test
	public void testUpdateRecieved() {
		
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		
		tester.updateRecieved(tester);
	
		assertSame("Should be the same", true, tester.isHasBeenRecieved());
	}
	
	@Test
	public void testupdateStock() {
			
		InventorySystem inventory = new InventorySystem();
		
		inventory.AddNewItem("Garden Gnome", 8,"B2","Gnome", 5, 9.99);
		inventory.AddNewItem("Ray Smithy Gnome", 10,"B1","Gnome", 4, 10.99);
		inventory.AddNewItem("Deck Chair", 15,"C1","Garden Furniture", 10, 7.99);
		inventory.AddNewItem("Garden Gnome Hat", 25,"A3","Gnome Accessories", 17, 2.99);
		
		int orderedItems2[] = {1,3,4};
		
		PurchaseOrder tester = new PurchaseOrder(orderedItems2, 2, 1);
		
		tester.updateStatus(tester, 4);
		
		assertSame("Should be the same", 9, Main.inventoryList.get(0).getNoOfItem());
		

	}
	
}
