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
	
	void showedges() {
		System.out.println(edges);
	}
}
