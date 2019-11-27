public class Project4Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Flights flights = new Flights();
		flights.readfromfile("FlightDataFile.txt");
		flights.showflights();
	}

}
