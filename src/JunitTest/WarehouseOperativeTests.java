package JunitTest;

import NBGardens.PersonLine;
import NBGardens.WarehouseOperative;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WarehouseOperativeTests {
		
	@Test
	public void testGetIdIsNotNull() {
		WarehouseOperative tester = new WarehouseOperative("Ray Smithy Jr");
		assertNotNull("Shoud not be null", tester.getId());
	}
	
	@Test
	public void testGetNameIsNotNull() {
		WarehouseOperative tester = new WarehouseOperative("Ray Smithy Jr");
		assertNotNull("Shoud not be null", tester.getName());
	}
	
	@Test
	public void testSetName() {
		WarehouseOperative tester = new WarehouseOperative("Ray Smithy Jr");
		tester.setName("Andy");
		assertSame("Shoud be Andy", tester.getName(), "Andy");
	}
		
	@Test
	public void checkGetWarehouseOperative() {
		WarehouseOperative tester = new WarehouseOperative("Ray Smithy Jr");
		PersonLine persons = new PersonLine();
		ArrayList<PersonLine> personsList = new ArrayList<PersonLine>();
		
		persons.addPersonnel(new WarehouseOperative("Ray Smithy Jr"), personsList);
		
		@SuppressWarnings("static-access")
		WarehouseOperative tempOperative = (WarehouseOperative) tester.getWarehouseOperative(1, personsList);
		assertEquals("Should be the same", tester.getName(), tempOperative.getName());
	}

}
