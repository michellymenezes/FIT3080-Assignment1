package planpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {

	private ArrayList map;
	private BufferedReader input;

	public Map() throws Exception {

		this.map = new ArrayList();
		this.input = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/planpath/input.txt"));
		
		while (input.ready()) {
			map.add(input.readLine().toUpperCase());
		}
		
		input.close();
	}
	
	public ArrayList getMap(){
		return map;
	}
}
