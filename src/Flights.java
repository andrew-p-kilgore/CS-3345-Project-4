import java.util.*;
import java.io.*;

public class Flights {

	File in;
	File out;
	File plans;
	LinkedList<Edges> vertices = new LinkedList<Edges>();
	CityInfo tempcity = new CityInfo();
	ReqFlight reqflight = new ReqFlight();
	LinkedList<Edges> pathstosort = new LinkedList<Edges>();
	
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
				//System.out.println("First city is added..");
				vertices.add(new Edges());
				//System.out.println("Now there are " + vertices.size() + " vertices");
				vertices.getFirst().addEdge(tempcity);
				continue;
			}
			Boolean foundcity = false;
			for(int j=0; j < vertices.size(); j++) {
				if( vertices.get(j).getSourceCity().equalsIgnoreCase(tempcity.fromcity) ) {
					//System.out.println("Adding a city to an existing source city...");
					vertices.get(j).addEdge(tempcity);
					//System.out.println("Now there are " + vertices.get(j).getSize() + " flights from " + tempcity.fromcity);
					foundcity = true;
				}	
			}
			if (foundcity == false) {
				//System.out.println("Print this when adding a new vertex");
				vertices.add(new Edges());
				vertices.getLast().addEdge(tempcity);
			}
		}
	input.close();
	}
	
	void readinput2fromfile(String infile) throws Exception {
		in = new File (infile);
		Scanner input = new Scanner (in);
		int numplans = input.nextInt();
		for(int i=0; i < numplans; i++) {
			String instring = input.next();
			reqflight.src = instring.substring(0, instring.indexOf('|'));
			String nextstring = instring.substring(instring.indexOf('|') + 1);
			reqflight.dest = nextstring.substring(0, nextstring.indexOf('|'));
			reqflight.timeorcost = nextstring.charAt(nextstring.indexOf('|') + 1);
			System.out.print("Flight " + (i+1) + " : " + reqflight.src + ", " + reqflight.dest + " (");
			if(reqflight.timeorcost == 'C')
				System.out.print("Cost)\n");
			else
				System.out.print("Time)\n");
			sortpaths(reqflight.timeorcost);
			showflights(reqflight);
		}
	input.close();
	}
	
	void showfirst() {
		vertices.getFirst().showedges();
	}
	
	void showflights(ReqFlight reqflight) {
		FlightPath path = new FlightPath();
		int srcindex = -1;
		String src = reqflight.src;
		String dest = reqflight.dest;
		pathstosort.clear();
		for(int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getSourceCity().equalsIgnoreCase(src)) {
				srcindex = i;
				break;
			}
		}
		
		for(int i = 0; i < vertices.get(srcindex).getSize(); i++) {
			pathstosort.add(path.findflightpath(vertices, vertices.get(srcindex).edges.get(i),dest));
			for(int j = 0; j < vertices.size(); j++)
				for(int k = 0; k < vertices.get(j).getSize(); k++)
					vertices.get(j).edges.get(k).visited = false;
		}
		
		
		for(int i = 0; i < pathstosort.size(); i++) {
			System.out.print("Path " + (i+1) + ": " + pathstosort.get(i).getSourceCity());
			for(int j = 0; j < pathstosort.get(i).getSize(); j++) {
				System.out.print(" -> " + pathstosort.get(i).getDestCityatIndex(j));
			}
			System.out.print(" Time: " + pathstosort.get(i).totaltime);
			System.out.print(" Cost: " + pathstosort.get(i).totalcost + "\n");
		}
	}
	
	void sortpaths(char orderchar) {
		int n = pathstosort.size();
		for (int i = 0; i < n-1; i++) 
			{ 
        	int min = i; 
        	for (int j = i+1; j < n; j++) {
        		if(orderchar == 'C') {
        			if (pathstosort.get(j).totalcost < pathstosort.get(min).totalcost) 
        				min = j;
        		}
        		else {
        			if (pathstosort.get(j).totaltime < pathstosort.get(min).totaltime)
        				min = j;
        		}
        	}
            Edges temp1 = new Edges();
            temp1 = pathstosort.get(min); 
            Edges temp2 = new Edges();
            temp2 = pathstosort.get(i);
            pathstosort.remove(min);
            pathstosort.add(min,temp2); 
            pathstosort.remove(i);
            pathstosort.add(temp1);
	        } 
	}
}
