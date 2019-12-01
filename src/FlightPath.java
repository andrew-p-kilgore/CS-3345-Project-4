import java.util.*;

public class FlightPath {

	LinkedList<CityInfo> edges = new LinkedList<CityInfo>();
	
	Edges getrowgivencity (LinkedList<Edges> wholething, String dest) {
		
		int cityindex = -1;
		
		for(int i = 0; i < wholething.size(); i++) {
			if( wholething.get(i).getSourceCity().equalsIgnoreCase(dest)) {
				cityindex = i;
				break;
			}
		}
		return wholething.get(cityindex);
	}
	
	Edges findflightpath (LinkedList<Edges> rows, CityInfo city, String destination) {
		
		Stack<CityInfo> edges = new Stack<CityInfo>();
		edges.add(city);
		boolean stackfilled = false;
		Edges paths = new Edges();
		
		while(!edges.isEmpty()) {
			CityInfo dest = edges.pop();
			if(dest.visited == false) {
				//System.out.println(dest);
				paths.addEdge(dest);
				dest.visited = true;
				for (int j = 0; j < rows.size(); j++) {
					for (int k = 0; k < rows.get(j).edges.size(); k++) {
						if(rows.get(j).edges.get(k).tocity.equalsIgnoreCase(dest.fromcity))
							rows.get(j).edges.get(k).visited = true;
					}
				}
				if(dest.tocity.equalsIgnoreCase(destination)) {
					break;
				}
					
			}
			
			Edges row = getrowgivencity(rows, dest.tocity);
			
			if(stackfilled == false) {
				for(int i = 0; i < row.getSize(); i++) {
					CityInfo c = row.edges.get(i);
					if( (c != null) && (c.visited == false)) {
						edges.add(c);
					}
					if( c.tocity.equalsIgnoreCase(destination)) {
						stackfilled = true;
					}
				}	
			}
			
		}
		dupecheck(paths);
		for(int i = 0; i < paths.getSize(); i++) {
			paths.totalcost += paths.edges.get(i).cost;
			paths.totaltime += paths.edges.get(i).time;
		}
		return paths;
	}
	
	void dupecheck (Edges paths) {
		if(paths.getSize() > 2) {
			for(int i = 0; i < (paths.getSize() - 1); i++) {
				if(paths.edges.get(i).fromcity.equalsIgnoreCase(paths.edges.get(i+1).fromcity))
					paths.edges.remove(i);
			}
		}
	}
}
