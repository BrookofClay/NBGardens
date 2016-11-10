package NBGardens;

import java.util.ArrayList;
import java.util.List;

public class Location 
{
//////////////////attributes////////////////////////
	
	
	private String location;
	private int x;
	private int y;
	
	
////////////////constructors////////////////////////
	
	
	public Location(){}
	
	public Location(String location, int x, int y)
	{
		
		this.location = location;
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}


	public void setX(int x)
	{
		this.x = x;
	}


	public int getY()
	{
		return y;
	}


	public void setY(int y)
	{
		this.y = y;
	}


	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String getLocation()
	{
		return location;
	}
	
///////////////methods/////////////////////////////
    
	public void addLocation(Location location2, ArrayList<Location> locationList)
	{
		locationList.add(location2);
		}		
	
	

 public void printLocation(ArrayList<Location> locationList)
 {
	 for(Location i : locationList)
	 {
			System.out.print("Location: " +     i.getLocation() + "	"); // Prints Order Id
			System.out.print("X Coordinate: " + i.getX() + "	");	 // Prints Customer Id
			System.out.print("Y Coordinate: " + i.getY() + "	"); // Prints No. of Items in the order
			
			System.out.println(); //Blank line to allow spacing in between each order
	 }
 }
	
 
    public List<Location> deleteLocation(List<Location> finalLocationWithCoords, String location)
	{
    	int id = 0;
    	for(Location i : finalLocationWithCoords)
    	{
    		int j = 0;
    		j++;
    		if(i.getLocation()==location)
    		{
    			id = j;
    		}
    	}
		finalLocationWithCoords.remove(id);
		
		return finalLocationWithCoords;
	}

	
}
