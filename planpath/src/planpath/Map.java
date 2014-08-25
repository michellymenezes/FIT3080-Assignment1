package planpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {

	private ArrayList map;
	private BufferedReader input;

	public Map() throws Exception {

		this.map = new ArrayList();
		input = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/planpath/input.txt"));
		while (input.ready()) {
			map.add(input.readLine().toUpperCase());
		}
		input.close();
	}
	
	public ArrayList getMap(){
		return (ArrayList) map.subList(3, map.size()-1);
	}
	
	public String getAlg(){
		return (String) map.get(0);
	}
	
	public int getInt(){
		return Integer.parseInt((String) map.get(1));
	}
	
	public int getSize(){
		return Integer.parseInt((String) map.get(2));
	}
}
