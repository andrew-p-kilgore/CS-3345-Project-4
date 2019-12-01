public class CityInfo {

	String fromcity;
	String tocity;
	int time;
	double cost;
	boolean visited;
	
	CityInfo () {}
	
	CityInfo (CityInfo city) {
		fromcity = city.fromcity;
		tocity = city.tocity;
		time = city.time;
		cost = city.cost;
	}
	
	public String toString() {
		return fromcity + " -> " + tocity + " Time: " + time + " Cost: " + cost;
	}
}
