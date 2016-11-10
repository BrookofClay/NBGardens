/**
 * 
 */
package NBGardens;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andrew and Niall
 * 
 * Class to show creation of new customer with its attributes and behaviours.
 *
 */
public class Customer {
	
	
	////////////////////////////////Attributes/////////////////////////////////////////
	
	/**
	 * 
	 * Attributes of the Customer class.
	 * 
	 * Note the AtomticInteger in this class, an AtomticInteger will hold its current set value on object creation making it useful for creating 
	 * unique numeric IDs still readable by humans (vs using the UUID.randomUUID() or Hash value)
	 * 
	 */
	
	private static final AtomicInteger nextId = new AtomicInteger(0); // Final AtomicInteger that will hold its current set value when a new object is created
	private int id;
	private String name;
	private String address;
	private String emailaddress;
	private int phonenumber;

	
	////////////////////////////Constructors///////////////////////////////////////////
	
	/**
	 * 
	 * Constructors are created here, 4 overloading constructors are used to allow entries with some missing, non-necessary, information
	 * 
	 * @param name - String containing Customer's Name
	 * @param address - String containing Customer's Address
	 * @param emailaddress - String containing Customer's E-mail address
	 * @param phonenumber - Long containing phone number of the customer
	 */
	
	public Customer(String name, String address, String emailaddress, int phonenumber) {
		this.id = Customer.nextId.incrementAndGet(); //Atomic Integer is incremented here on object creation.
		this.name = name;
		this.address = address;
		this.emailaddress = emailaddress;
		this.phonenumber = phonenumber;
		
	}

	public Customer(String name, String address, int phonenumber) {
		this.id = Customer.nextId.incrementAndGet(); //Atomic Integer is incremented here on object creation.
		this.name = name;
		this.address = address;
		this.emailaddress = "Not Given";
		this.phonenumber = phonenumber;
	}
	
	public Customer(String name, String address, String emailaddress) {
		this.id = Customer.nextId.incrementAndGet(); //Atomic Integer is incremented here on object creation.
		this.name = name;
		this.address = address;
		this.emailaddress = emailaddress;
		this.phonenumber = 0;
	}
	
	public Customer(String name, String address) {
		this.id = Customer.nextId.incrementAndGet(); //Atomic Integer is incremented here on object creation.
		this.name = name;
		this.address = address;
		this.emailaddress = "Not Given";
		this.phonenumber = 0;
	}

	/**
	 * 
	 * Creation of getters and setters to allow privacy to this class. Note the lack of a setter for ID as we want this handled by the AtomticInteger.
	 * 
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public int getId() {
		return id;
	}
	
	////////////////////////////Methods///////////////////////////////////////////
	
	/**
	 * 
	 * Method for returning a customer object. As Customer objects are stored in a PersonList ArrayList objects from this Array need 
	 * to be cast back to Customer object type for use of methods in this class.
	 *  
	 * @param id - ID from personList ArrayList so we know what object in the list we are working on
	 * @param personsList - ArrayList of PersonList objects (containing Customer, Supplier and WarehouseOperative objects)
	 * @return - returns Customer object
	 */
	
	public static Customer getCustomer(int id, ArrayList<PersonLine> personsList) {
		
		Customer tempOperative = (Customer) personsList.get(id).getPerson();

			return tempOperative;
			}	
	
	 public void deleteCustomer(int id) {}
	
	 public void updateCustomer(int id) {}
	
}
