public class CityInfo {

	String fromcity;
	String tocity;
	int time;
	double cost;
	
	CityInfo () {}
	
	CityInfo (CityInfo city) {
		fromcity = city.fromcity;
		tocity = city.tocity;
		time = city.time;
		cost = city.cost;
	}
	
	public String toString() {
		return "From: " + fromcity + " To: " + tocity + " Time: " + time + " Cost: " + cost;
	}
}
