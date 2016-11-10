package JunitTest;

import NBGardens.Supplier;
import static org.junit.Assert.*;

import org.junit.Test;

public class SupplierTest {
	

	@Test
	public void testGetIdIsNotNull() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		assertNotNull("Shoud not be null", tester.getId());
	}
	
	@Test
	public void testGetNameIsNotNull1() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		assertNotNull("Shoud not be null", tester.getName());
	}
	
	@Test
	public void testGetAddressIsNotNull() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		assertNotNull("Shoud not be null", tester.getAddress());
	}
	
	@Test
	public void testGetEmailIsNotNull() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		assertNotNull("Shoud not be null", tester.getEmailaddress());
	}
	
	@Test
	public void testGetPhonenumberIsNotNull() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		assertNotNull("Shoud not be null", tester.getPhonenumber());
	}
	
	@Test
	public void testSetName() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		tester.setName("Gnomes Express");
		assertSame("Shoud be Gnomes Express", tester.getName(), "Gnomes Express");
	}
	
	@Test
	public void testSetAddress() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		tester.setAddress("2 Gnome Grove");
		assertSame("Shoud be 2 Gnome Grove", tester.getAddress(), "2 Gnome Grove");
	}
	
	@Test
	public void testSetEmail() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		tester.setEmailaddress("terry@gnomesrus.com");
		assertSame("Shoud be terry@gnomesrus.com", tester.getEmailaddress(), "terry@gnomesrus.com");
	}
	
	@Test
	public void testSetPhone() {
		Supplier tester = new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L);
		tester.setPhonenumber(0225156114152L);
		assertSame("Shoud be 0225156114152", tester.getPhonenumber(), 0225156114152L);
	}
	
}
