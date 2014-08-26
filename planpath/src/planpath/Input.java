package planpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Input {

	ArrayList<String []> map;
	private ArrayList<String> info;
	private BufferedReader input;

	public Input() throws Exception {

		this.map = new ArrayList<String[]>();
		this.info = new ArrayList<String>();
		input = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/planpath/input.txt"));
		int cont = 0;
		while (input.ready()) {
			if(cont < 3){
				info.add(input.readLine().toUpperCase());
			}
			else{
				map.add(input.readLine().toUpperCase().split(" "));
			}
			cont++;
		}
		input.close();
	}
	
	public ArrayList<String[]> getMap(){
		return map;
	}
	
	public String getAlg(){
		return (String) info.get(0);
	}
	
	public int getInt(){
		return Integer.parseInt((String) info.get(1));
	}
	
	public int getSize(){
		return Integer.parseInt((String) info.get(2));
	}
}
