package NBGardens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Travelling Salesman Class which is used to do a number of steps to determine the most efficient route for a warehouse operative to collect items for the outstanding orders
 * 
 * 1. A full list of all outstanding items is obtained from the int Arrays found in all order objects
 * 2. A HashSet (to get rid of any repetition) of Locations that these items belong in (set within the InventorySystem class) is then created and saved to a String Array
 * 3. This is then iterated through and the X and Y coordinates of these locations from the Location class are then assigned in a new List.
 * 4. This List is passed to the getShortestLocation() method which is the main method for figuring out the travelling salesman result. This:-
 * 		a. Iterates through the finalLocationWithCoords calculating the result from the set x and y int variables. This determines the distance from the set point
 * 		b. The results of this are added to the distance ArrayList along with the Location name so we know what result belongs to which location
 * 		c. This is sorted with a new comparator which sorts the ArrayList using the DistancefromNeighbour in acceding order (putting the location with the smallest distance first).
 * 		d. This result is then added to the nearestLocation String.
 * 		e. Finally a for loop is used to find this object within the finalLocationWithCoords ArrayList to set the x and y int to the x and y location that this location has and then
 * 			deleted from the ArrayList so this location is not checked again.
 * 		f. After all locations are checked the nearestLocation String is then returned allowing the Travelling Salesman GUI to set this String in a label for the user to see.
 * 
 * 
 * @author Andrew and Niall
 *
 */

public class TravellingSalesman {
	
	public String getTravellingSalesman(ArrayList<OrderLine> orders, ArrayList<InventorySystem> items){
		
		String[] finalLocationList = getLocationList(orders, items);
		List<Location> finalLocationWithCoords = getLocationCoordinates(finalLocationList, Main.locationList);
		String nearestLocation = getShortestLocation(finalLocationWithCoords);
		return nearestLocation;
			}
	
	public String[] getLocationList(ArrayList<OrderLine> orders, ArrayList<InventorySystem> items){
		CustomerOrder customer = new CustomerOrder();
		
		ArrayList<CustomerOrder> corderList = customer.getCustomerOrders(orders);
		
		List<Integer> fullOutstandingItems = new ArrayList<Integer>();
		
		for (CustomerOrder i : corderList){
			int tempItemArray[] = i.getListOfItems();
				for (int j=0; j < tempItemArray.length; j++){
					fullOutstandingItems.add(tempItemArray[j]);
				}
		}
		Set<String> fullLocationList = new HashSet<String>(); // HashSet used here to remove entries with identical values.
		for(Integer i : fullOutstandingItems){
			fullLocationList.add(items.get(fullOutstandingItems.get(i).intValue()).getItemLocation());
		}
		
		String[] finalLocationList = fullLocationList.toArray(new String[fullLocationList.size()]);
		return finalLocationList;
	}
	
	public List<Location> getLocationCoordinates(String[] finalLocationList, ArrayList<Location> locationList){
		
		List<Location> finalLocationWithCoords = new ArrayList<Location>();
		
		for(int i = 0; i < finalLocationList.length ; i++){
			
			for(Location l : locationList){
				
				if(finalLocationList[i] == l.getLocation()){
					
					finalLocationWithCoords.add(l);	
				}
			}		
		}
		
		return finalLocationWithCoords;				
	}
	
	public String getShortestLocation(List<Location> finalLocationWithCoords){
		String nearestLocation = "";
		int origFinalLocationWithCoords = finalLocationWithCoords.size(); // Size of array is declared here instead of in the for loop as objects are deleted from this Array changing the size of this array.
		
		int x = 0;
		int y = 200;
		
		for(int i = 0; i < origFinalLocationWithCoords ; i++){
			ArrayList<LocationDistance> distance = new ArrayList<LocationDistance>();

			for(Location l : finalLocationWithCoords){
				int xDistance = Math.abs(x - l.getX()); 
				int yDistance = Math.abs(y - l.getY());
				int totalDistance = xDistance + yDistance;
				
				distance.add(new LocationDistance(l.getLocation(), totalDistance));
					
			}
			
			Collections.sort(distance, new Comparator<LocationDistance>() {
		        public int compare(LocationDistance ex1, LocationDistance ex2) {
		            return ex1.getDistanceFromNeighbour() - ex2.getDistanceFromNeighbour(); // Ascending order
		        }

		    });	
						
			nearestLocation += distance.get(0).getLocation() +" ";
						
			for(int j = 0; i < finalLocationWithCoords.size(); j ++){
				if (finalLocationWithCoords.get(j).getLocation() == distance.get(0).getLocation()){
					x = finalLocationWithCoords.get(j).getX();
					y = finalLocationWithCoords.get(j).getY();
					
					finalLocationWithCoords.remove(j);
					break;
				}
			}
			
		}
		  
		nearestLocation.trim();
		return nearestLocation;
		
	}
}
