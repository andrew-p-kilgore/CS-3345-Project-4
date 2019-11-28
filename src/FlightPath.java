import java.util.*;
import java.lang.*;

public class FlightPath {

	int size;
	
	FlightPath (LinkedList<Edges> cities) {
		size = cities.size();
	}
	
	void findshortestpath (LinkedList<Edges> cities, int sourcecityindex) {
		
		int dist [] = new int [size];
		Boolean sptSet [] = new Boolean [size];
		for (int i = 0; i < size; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[sourcecityindex] = 0;
		
		for(int i = 0; i < (size - 1); i++ ) {
			int u = mindistance(dist,sptSet);
			sptSet[u] = true;
			for(int j = 0; j < size; j++ ) {
				String v = cities.get(j).getSourceCity();
				
				if(!sptSet[j] && dist[u] != Integer.MAX_VALUE && (cities.get(u).containsDest(v)))
					if((cities.get(j).getTimeatIndex(cities.get(u).getIndexofDest(v)) + dist[u]) < dist[j]) {
						dist[j] = dist[u] + cities.get(u).getTimeatIndex(cities.get(u).getIndexofDest(v));
			 	}
			}
		}
		System.out.println("Final:");
		printSolution(dist);
	}
	
	int mindistance (int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE;
		int minindex = -1;
		
		for (int i = 0; i < sptSet.length; i++) {
			if ((sptSet[i] == false) && (dist[i] <= min) ) {
				min = dist[i];
				minindex = i;
			}
		}
		return minindex;
	}
	
	void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < size; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
}
