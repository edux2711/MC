import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {
	
	private Graph graph = new Graph();

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		//Get graph's vertices.
		Set<Town> towns = graph.vertexSet();

		Town t1 = null,
			 t2 = null;
		
		//Look for the town in towns that matches the names of the String parameters.
		for(Town t : towns) {
			
			if(t.getName().equals(town1)) 
				t1 = t;
			else if(t.getName().equals(town2)) 
				t2 = t;
			
		}
		
		//After finding the town objects, add the road with t1 and t2 as parameters
		if(graph.addEdge(t1, t2, weight, roadName) == null) 
			return false;
		else
			return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		//Get graph's vertices.
		Set<Town> towns = graph.vertexSet();
		Town t1 = null,
			 t2 = null;
		
		//Look for the town in towns that matches the names of the String parameters.
		for(Town t : towns) {
			if(t.getName().equals(town1)) 
				t1 = t;
			
			else if(t.getName().equals(town2)) 
				t2 = t;
			
			
		}
		
		//Get edge from graph by passing town objects, if it returns null then the edge in not in the graph.
		if(graph.getEdge(t1, t2) == null) 
			return null;
		else
			return graph.getEdge(t1, t2).getName();
	}

	@Override
	public boolean addTown(String v) {
		
		//Create new town object.
		Town t = new Town(v);
		
		//Add t to the graph.
		return graph.addVertex(t);
	}

	@Override
	public Town getTown(String name) {
		
		//Find and return the town in graph's set of vertices that has the same name as the string parameter name
		for(Town town : graph.vertexSet()) {
			if(town.getName().equals(name));
				return town;
		}
		
		//Return null if not found.
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		
		//Create town object with the same name as the string parameter v
		Town t = new Town(v);
		
		//Check if graph contains a vertex with the same name as t.
		return graph.containsVertex(t);
		
		
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		//Create town objects with the same name as the string parameters
		Town t1 = new Town(town1),
			 t2 = new Town(town2);
		
		//Check if graph contains a road with the same vertices.
		return graph.containsEdge(t1, t2);
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> result = new ArrayList<>();
		
		//Holds each edge of graph.
		Set<Road> roads = graph.edgeSet();
		
		//Add each road in the set to result array.
		for(Road road : roads) {
			result.add(road.getName());
		}
		Collections.sort(result); //sort array
		return result;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		//Remove edge, create town objects to pass as arguments and to get the weight
		Road r = graph.removeEdge(new Town(town1), new Town(town2), graph.getEdge(new Town(town1), new Town(town2)).getWeight(), road);
		
		//Store the removed edge in r, if it is null then edge was not deleted
		if(r == null) 
			return false;
		else
			return true;
	}

	@Override
	public boolean deleteTown(String v) {
		//Create town obkect, pass v to create it.
		Town t = new Town(v);
		
		//Remove from graph.
		return graph.removeVertex(t);
	}

	@Override
	public ArrayList<String> allTowns() {
		//Create a set that stores every vertex of the graph.
		Set<Town> towns = graph.vertexSet();
		
		//Holds each edge of graph.
		ArrayList<String> result = new ArrayList<>();
		
		//Add each town in the set to result array.
		for(Town town : towns) {
			result.add(town.getName());
		}
		//sort array result.
		Collections.sort(result);
		return result;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		
		//
		Set<Town> towns = graph.vertexSet();
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> result = new ArrayList<>();
		
		
		
		Town r1 = null,
			 r2 = null;
		
		for(Town t : towns) {
			if(t.getName().equals(town1)) 
				r1 = t;
			
			else if(t.getName().equals(town2)) 
				r2 = t;
			
		}
			
		boolean foundSource = false,
				foundDest   = false;
		
		for(Road r : roads) {
			if(r.getSource().compareTo(r1) == 0 || r.getDestination().compareTo(r1) == 0) {
				foundSource = true;
			}
			else if(r.getSource().compareTo(r2) == 0 || r.getDestination().compareTo(r2) == 0 ) {
				foundDest = true;
			}
			if(foundSource == true && foundDest == true) {
				result = graph.shortestPath(r1, r2);
			}
		}
		
		return result;
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException{
		
	
	}

}
