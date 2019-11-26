import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Flights {

	File in;
	File out;
	File plans;
	LinkedList<Rows> rows = new LinkedList<Rows>();
	CityInfo city = new CityInfo();
	
	Flights () {}
	
	void readfromfile (String infile) throws Exception {
		in = new File (infile);
		Scanner input = new Scanner (in);
		int numflights = input.nextInt();
		for(int i=0; i < numflights; i++) {
			String instring = input.next();
			city.fromcity = instring.substring(0, instring.indexOf('|'));
			System.out.println("The first city name is: " + city.fromcity);
			String nextstring = instring.substring(instring.indexOf('|') + 1);
			city.tocity = nextstring.substring(0, nextstring.indexOf('|'));
			System.out.println("The second city name is: " + city.tocity);
			city.time = Integer.parseInt(nextstring.substring(nextstring.indexOf('|') + 1, nextstring.lastIndexOf('|')));
			System.out.println("The flight time is: " + city.time);
			city.cost = Double.parseDouble(nextstring.substring(nextstring.lastIndexOf('|') + 1));
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println("The flight's cost is: $" + df.format(city.cost));
			
			
			
		}
	}
	
}
