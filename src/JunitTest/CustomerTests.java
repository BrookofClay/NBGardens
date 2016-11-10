package JunitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import NBGardens.Customer;
import NBGardens.PersonLine;

public class CustomerTests {
	
	@Test
	public void testGetIdIsNotNull() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		assertNotNull("Shoud not be null", tester.getId());
	}
	
	@Test
	public void testGetNameIsNotNull1() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		assertNotNull("Shoud not be null", tester.getName());
	}
	
	@Test
	public void testGetAddressIsNotNull() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		assertNotNull("Shoud not be null", tester.getAddress());
	}
	
	@Test
	public void testGetEmailIsNotNull() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		assertNotNull("Shoud not be null", tester.getEmailaddress());
	}
	
	@Test
	public void testGetPhonenumberIsNotNull() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		assertNotNull("Shoud not be null", tester.getPhonenumber());
	}
	
	@Test
	public void testSetName() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		tester.setName("Terry Gnome");
		assertSame("Shoud be Terry Gnome", tester.getName(), "Terry Gnome");
	}
	
	@Test
	public void testSetAddress() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		tester.setAddress("2 Gnome Grove");
		assertSame("Shoud be 2 Gnome Grove", tester.getAddress(), "2 Gnome Grove");
	}
	
	@Test
	public void testSetEmail() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		tester.setEmailaddress("terry@gnomesrus.com");
		assertSame("Shoud be terry@gnomesrus.com", tester.getEmailaddress(), "terry@gnomesrus.com");
	}
	
	@Test
	public void testSetPhone() {
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		tester.setPhonenumber(022515);
		assertSame("Shoud be 0225156114152", tester.getPhonenumber(), 0225156114152L);
	}
	
	@Test
	public void testGetCustomer() {
		
		ArrayList<PersonLine> personsList = new ArrayList<PersonLine>();
		Customer customer = new Customer ("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		PersonLine persons = new PersonLine();
		persons.addPersonnel(customer, personsList);
		
		@SuppressWarnings("static-access")
		Customer tempCustomer = (Customer) customer.getCustomer(1, personsList);
		
		assertEquals("Should be the same",customer.getName(), tempCustomer.getName());
	}
	
	
	@Test
	public void deletingCustomer() {
		
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		
		tester.deleteCustomer(1);
		
		assertTrue("Should be true", tester.equals(null));
	}
	
	@Test
	public void updateCustomer() {
		
		Customer tester = new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561);
		
		tester.updateCustomer(1);
	
		assertNotSame("Should not be the same", "Gnomes R Us", tester.getName());
		
	}

}
