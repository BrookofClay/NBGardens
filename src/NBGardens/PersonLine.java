package NBGardens;

import java.util.ArrayList;

public class PersonLine {

	/////////////////////////////Attributes/////////////////////////////////////////
	
	private int id;
	private Object person; // Set as Object type so both CustomerOrder and PurchaseOrder objects can be passed to it.


	
	///////////////////////////Constructors////////////////////////////////////////
	
	public PersonLine() {
		
	}

	
	public PersonLine(int id, Object person) {
		this.id = id;
		this.person = person;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Object getPerson() {
		return person;
	}



	public void setPerson(Object person) {
		this.person = person;
	}
	
	
	
	/////////////////////////////Methods/////////////////////////////////////////

	public void addPersonnel (Object person, ArrayList<PersonLine> personsList)
	{
		 int id = personsList.size() + 1; //Id created by taking current element size of customer order list array. 1 is added at the end to account for computer counting from 0.
			// Creating new temporary Customer object to allow us to add our new attributes to it.
			 PersonLine tempPerson = new PersonLine(id, person);
			 
			 // Temporary object is added to main customer list array.
			personsList.add(tempPerson);
	}
	
	public String[] printPeople(ArrayList<PersonLine> personList) {
		
		// Method which is passed to the main for printing, main customer order list array is passed through to allow us to iterate through it.
		
					// For-each loop which allows method to go through each entry in the array regardless of size.
					// Order ID is used to print out each element in the object. -1 to account for arraylist ID starting from 0.
					String customerOutput = "";
					String supplierOutput = "";
					String warehouseOutput = "";
					for(PersonLine i : personList) {
						if (i.getPerson() instanceof Customer){
						Customer tempCustomer = (Customer) i.getPerson();
						customerOutput += "Type: Customer";
						customerOutput += "ID: " + i.getId() + " "; // Prints Order Id
						customerOutput += "Name: " + tempCustomer.getName() + " ";
						customerOutput += "Address: " + tempCustomer.getAddress() + " ";
						customerOutput += "E-Mail: " + tempCustomer.getEmailaddress() + " ";
						customerOutput += "Phone No.: " + tempCustomer.getPhonenumber() + "\n\n";						
						}
						else if (i.getPerson() instanceof Supplier)
						{
						Supplier tempSupplier = (Supplier) i.getPerson();
						supplierOutput += "ID: " + i.getId() + " "; // Prints Order Id
						supplierOutput += "Name: " + tempSupplier.getName() + " ";
						supplierOutput += "Address: " + tempSupplier.getAddress() + " ";
						supplierOutput += "E-Mail: " + tempSupplier.getEmailaddress() + " ";
						supplierOutput += "Phone No.: " + tempSupplier.getPhonenumber() + "\n\n";
						}
						else if (i.getPerson() instanceof WarehouseOperative)
						{
							WarehouseOperative tempOperative = (WarehouseOperative) i.getPerson();
							warehouseOutput += "ID: " + i.getId() + " ";
							warehouseOutput += "Name: " + tempOperative.getName() + "\n\n";
						}
							
						}	
					String fullPersonOutput[] = {customerOutput, supplierOutput, warehouseOutput};
					return fullPersonOutput;
					}

	public String printPeopleDetails(int id, ArrayList<PersonLine> personsList){
		String output = "";
		
		if (personsList.get(id).getPerson() instanceof Customer){
			Customer tempPerson = (Customer) personsList.get(id).getPerson();
			output += "Type: Customer\n";
			output += "Name: " + tempPerson.getName() + "\n";
			output += "Address: " + tempPerson.getAddress() + "\n";
			output += "E-Mail: " + tempPerson.getEmailaddress() + "\n";
			output += "Phone No.: " + tempPerson.getPhonenumber() + "";	
		}
		else if (personsList.get(id).getPerson() instanceof Supplier){
			Supplier tempPerson = ( Supplier) personsList.get(id).getPerson();
			output += "Type: Supplier\n";
			output += "Company Name: " + tempPerson.getName() + "\n";
			output += "Address: " + tempPerson.getAddress() + "\n";
			output += "E-Mail: " + tempPerson.getEmailaddress() + "\n";
			output += "Phone No.: " + tempPerson.getPhonenumber() + "";	
		}
		else if (personsList.get(id).getPerson() instanceof WarehouseOperative){
			WarehouseOperative tempPerson = (WarehouseOperative) personsList.get(id).getPerson();
			output += "Type: Warehouse Employee\n";
			output += "Name: " + tempPerson.getName() + "\n";
		}		
		return output;		
	}
	
	public void deletePersonnel(int id, ArrayList<PersonLine> personsList){
		
		personsList.remove(id);
	}
		
	}