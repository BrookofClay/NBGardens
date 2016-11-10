/**
 * 
 */
package NBGardens;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andrew and Niall
 * 
 * Class to show creation of new supplier and it's attributes
 *
 */
public class Supplier {
	
	
	/////////////////////////////Attributes////////////////////////////////
	
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private int id;
	private String name;
	private String address;
	private String emailaddress;
	private Long phonenumber;
	
	////////////////////////////Constructors//////////////////////////////
	
	public Supplier(String name, String address, String emailaddress, Long phonenumber) {
		this.id = Supplier.nextId.incrementAndGet();
		this.name = name;
		this.address = address;
		this.emailaddress = emailaddress;
		this.phonenumber = phonenumber;
	}

	public Supplier(String name, String address, Long phonenumber) {
		this.id = Supplier.nextId.incrementAndGet();
		this.name = name;
		this.address = address;
		this.emailaddress = null;
		this.phonenumber = phonenumber;
	}
	
	public Supplier(String name, String address, String emailaddress) {
		this.id = Supplier.nextId.incrementAndGet();
		this.name = name;
		this.address = address;
		this.emailaddress = emailaddress;
		this.phonenumber = 0L;
	}
	
	// Start of creation of Getters and Setters
	
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

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public int getId() {
		return id;
	}

	////////////////////////////////Methods/////////////////////////////////////////
	
	public static Supplier getSupplier(int id, ArrayList<PersonLine> personsList) {
		Supplier tempSupplier = (Supplier) personsList.get(id).getPerson();

		return tempSupplier;
			}	
	
	public void deleteSupplier(int id) {}
	
	 public void updateSupplier(int id) {}

}
