package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import NBGardens.CustomerOrder;

public class CustomerOrderTest {
	
	@Test
	public void testGetIdIsNotNull() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		assertNotNull("Shoud not be null", tester.getId());
	}
	
	@Test
	public void testGetListOfItemsIsNotNull() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		assertNotNull("Shoud not be null", tester.getListOfItems());
	}
	
	@Test
	public void testGetOperativeIdIsNotNull() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		assertNotNull("Shoud not be null", tester.getOperativeId());
	}
	
	@Test
	public void testGetPoruswareItemsIsNotNull() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		assertNotNull("Shoud not be null", tester.getPoruswareItems());
	}
	
	@Test
	public void testGetIsDispatchedIsNotNull() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		assertNotNull("Shoud not be null", tester.isDispatched());
	}
	
	@Test
	public void testGetHasBeenRecievedIsNotNull() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		assertNotNull("Shoud not be null", tester.isHasBeenRecieved());
	}
	
	@Test
	public void testSetID() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		tester.setId(2);
		assertSame("Shoud be 2", tester.getId(), 2);
	}

	@Test
	public void testSetListOfItems() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		int newOrderedItems[] = {1,2,4,4};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		tester.setListOfItems(newOrderedItems);
		assertSame("Shoud be 2 Gnome Grove", tester.getListOfItems(), newOrderedItems);
	}
	
	@Test
	public void testSetOperativeID() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		tester.setOperativeId(3);
		assertSame("Shoud be 3", tester.getOperativeId(), 3);
	}
	
	@Test
	public void testSetPoruswareItems() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		int newPoruswareItems[] = {3,4};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		tester.setPoruswareItems(newPoruswareItems);
		assertSame("Shoud be 2 Gnome Grove", tester.getPoruswareItems(), newPoruswareItems);
	}
	
	@Test
	public void testSetIsDispatched() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		tester.setDispatched(true);
		assertSame("Shoud be 0225156114152", tester.isDispatched(), true);
	}
	
	@Test
	public void testSetHasBeenDispatched() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		tester.setHasBeenRecieved(true);
		assertSame("Shoud be 0225156114152", tester.isHasBeenRecieved(), true);
	}
	
	@Test
	public void testUpdateStatus() {
		
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		
		tester.updateStatus(tester, 4);
		
		assertSame("Should not be the same", "Order Recieved", tester.getOrderStatus());
		
	}
	
	@Test
	public void testUpdateDispatch() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		
		tester.updateDispatch(tester);
		
		assertSame("Should not be the same", true, tester.isDispatched());
		
	}
	
	@Test
	public void testUpdateRecieved() {
		
		int orderedItems[] = {1,3,4};
		
		int poruswareItems[] = {1,3};
		
		CustomerOrder tester = new CustomerOrder(orderedItems , 2, poruswareItems, 1);
		
		tester.updateRecieved(tester);
		
		assertSame("Should not be the same", true, tester.isHasBeenRecieved());
		
	}
}
