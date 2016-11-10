package NBGardens;

public class LocationDistance {
	
	private String location;
	private int distanceFromNext;
	
	public LocationDistance(String location, int distanceFromNext) {

		this.location = location;
		this.distanceFromNext = distanceFromNext;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDistanceFromNeighbour() {
		return distanceFromNext;
	}
	public void setDistanceFromNeighbour(int distanceFromNext) {
		this.distanceFromNext = distanceFromNext;
	}
}
