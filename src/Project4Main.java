public class Project4Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Flights flights = new Flights();
		flights.readinput1fromfile("FlightDataFile.txt");
		flights.showflights();
		FlightPath f = new FlightPath(flights.vertices);
		f.findshortestpath(flights.vertices, 0);
	}

}
