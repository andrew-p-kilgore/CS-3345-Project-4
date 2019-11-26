import java.util.*;
import java.io.*;

public class Flights {

	File in;
	File out;
	File plans;
	LinkedList<LinkedList<CityInfo>> src = new LinkedList<LinkedList<CityInfo>>();
	LinkedList<CityInfo> dest = new LinkedList<CityInfo>();
	CityInfo city = new CityInfo();
	
	Flights (String infile) throws Exception {
		in = new File (infile);
		Scanner input = new Scanner (in);
		int num = input.nextInt();
		String instring = input.next();
		city.name = instring.substring(0, instring.indexOf('|'));
		System.out.println("The first city name is: " + city.name);
		src.add(dest);
	}
	
}
