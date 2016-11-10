/**
 * 
 */
package NBGardens;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andrew & Niall
 * 
 * Class to show warehouse operatives
 *
 */
public class WarehouseOperative {
	
	
	//////////////////////////////Attributes///////////////////////////////////////
	
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private int id;
	private String name;
	
	/////////////////////////////Constructors//////////////////////////////////////
	
	public WarehouseOperative () {
	}
	
	public WarehouseOperative(String name) {
		this.id = WarehouseOperative.nextId.incrementAndGet();
		this.name = name;
	}
	
	// Start of creation of Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	////////////////////////////Methods////////////////////////////////////////////

	public static WarehouseOperative getWarehouseOperative(int id, ArrayList<PersonLine> personsList) {
				
		WarehouseOperative tempOperative = (WarehouseOperative) personsList.get(id).getPerson();
		
					return tempOperative;
			}

	
	public void deleteWarehouseOperative(int id) {}
	
	
}
