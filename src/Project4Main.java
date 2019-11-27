public class Project4Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Flights flights = new Flights();
		flights.readinput1fromfile("FlightDataFile.txt");
		flights.showflights();
	}

}
