package JunitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import NBGardens.InventorySystem;


public class InventorySystemTest {

	@Test
	public void testGetIdIsNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getId());
	}
	
	@Test
	public void testGetItemNameIsNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getItemName());
	}
	
	@Test
	public void testGetNoOfItemisNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getNoOfItem());
	}
	
	@Test
	public void testGetItemLocationIsNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getItemLocation());
	}
	
	@Test
	public void testGetItemTypeIsNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getItemType());
	}
	
	@Test
	public void testGetNoOfPoruswareIsNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getNoOfPorusware());
	}
	
	@Test
	public void testGetItemCostIsNotNull() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		assertNotNull("Shoud not be null", tester.getItemCost());
	}
	
	@Test
	public void testSetID() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setId(2);
		assertSame("Shoud be 2", tester.getId(), 2);
	}
	
	@Test
	public void testSetItemName() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setItemName("Ray Smithy Gnome");
		assertSame("Shoud be Ray Smithy Gnome", tester.getItemName(), "Ray Smithy Gnome");
	}
	
	@Test
	public void testSetNoOfItem() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setNoOfItem(2);
		assertSame("Shoud be 2", tester.getNoOfItem(), 2);
	}
	
	@Test
	public void testSetItemLocation() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setItemLocation("A4");
		assertSame("Shoud be A4", tester.getItemLocation(), "A4");
	}
	
	@Test
	public void testSetItemType() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setItemType("Gnome Accessory");
		assertSame("Shoud be Gnome Accessory", tester.getItemType(), "Gnome Accessory");
	}
	
	@Test
	public void testNoOfPorusware() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setNoOfPorusware(4);
		assertSame("Shoud be 4", tester.getNoOfPorusware(), 4);
	}
	
	@Test
	public void testSetItemCost() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		tester.setItemCost(4.50);
		assertSame("Shoud be 4.50", tester.getItemCost(), 4.50);
	}
	
	@Test
	public void addingNewItem() {
		InventorySystem tester = new InventorySystem();
		tester.AddNewItem("Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		
		assertEquals("Should be the same","Garden Gnome" , tester.getItemName());
	}
	
	@Test
	public void deletingItem() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);
		
		tester.DeleteItem(1);
		
		assertTrue("Should be true", tester.equals(null));
	}
	
	@Test
	public void updateItem() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);

		tester.UpdateItem(1);
	
		assertNotSame("Should not be the same", "Garden Gnome", tester.getItemName());
		
	}
	
	@Test
	public void updateNoOfPorusware() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 2, 9.99);

		tester.UpdatePorusware(5);
	
		assertSame("Should be the same", 5, tester.getNoOfPorusware());
		
	}
	
	@Test
	public void checkPoruswareCheck() {
		InventorySystem tester = new InventorySystem(1, "Garden Gnome", 5, "B2", "Gnome", 0, 9.99);
		
		assertSame("Should not be null", tester.PoruswareCheck(), tester);
	}
	
}
