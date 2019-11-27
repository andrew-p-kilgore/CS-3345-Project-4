import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Flights {

	File in;
	File out;
	File plans;
	LinkedList<Edges> vertices = new LinkedList<Edges>();
	CityInfo tempcity = new CityInfo();
	
	Flights () {}
	
	void readinput1fromfile (String infile) throws Exception {
		in = new File (infile);
		Scanner input = new Scanner (in);
		int numflights = input.nextInt();
		for(int i=0; i < numflights; i++) {
			String instring = input.next();
			tempcity.fromcity = instring.substring(0, instring.indexOf('|'));
			String nextstring = instring.substring(instring.indexOf('|') + 1);
			tempcity.tocity = nextstring.substring(0, nextstring.indexOf('|'));
			tempcity.time = Integer.parseInt(nextstring.substring(nextstring.indexOf('|') + 1, nextstring.lastIndexOf('|')));
			tempcity.cost = Double.parseDouble(nextstring.substring(nextstring.lastIndexOf('|') + 1));
			if(vertices.size() == 0) {
				System.out.println("First city is added..");
				vertices.add(new Edges());
				System.out.println("Now there are " + vertices.size() + " vertices");
				vertices.getFirst().addEdge(tempcity);
				continue;
			}
			Boolean foundcity = false;
			for(int j=0; j < vertices.size(); j++) {
				if( vertices.get(j).getSourceCity().equalsIgnoreCase(tempcity.fromcity) ) {
					System.out.println("Adding a city to an existing source city...");
					vertices.get(j).addEdge(tempcity);
					System.out.println("Now there are " + vertices.get(j).getSize() + " flights from " + tempcity.fromcity);
					foundcity = true;
				}	
			}
			if (foundcity == false) {
				System.out.println("Print this when adding a new vertex");
				vertices.add(new Edges());
				vertices.getLast().addEdge(tempcity);
			}
		}
	input.close();
	}
	
	void showfirst() {
		vertices.getFirst().showedges();
	}
	
	void showflights() {
		for(int i=0; i < vertices.size(); i++) {
			vertices.get(i).showedges();
		}
	}
	
}
