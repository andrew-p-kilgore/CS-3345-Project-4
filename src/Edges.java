import java.util.*;

public class Edges {

	LinkedList<CityInfo> edges = new LinkedList<CityInfo>();
	
	Edges () {}
	
	void addEdge (CityInfo city) {
		edges.add(new CityInfo(city));
	}
	
	int getSize () {
		return edges.size();
	}
	
	String getSourceCity () {
		return edges.getFirst().fromcity;
	}
	
	String getDestCityatIndex (int index) {
		return edges.get(index).tocity;
	}
	
	int getTimeatIndex (int index) {
		return edges.get(index).time;
	}
	
	int getIndexofDest (String dest) {
		for( int i = 0; i < edges.size(); i++) {
			if (edges.get(i).tocity.equalsIgnoreCase(dest))
				return i;
		}
		System.out.println("This shouldn't print");
		return -1;
	}
	
	Boolean containsDest (String city) {
		for( int i = 0; i < edges.size(); i++) {
			if(edges.get(i).tocity.equalsIgnoreCase(city))
				return true;
		}
		return false;
	}
	
	void showedges() {
		System.out.println(edges);
	}
}
