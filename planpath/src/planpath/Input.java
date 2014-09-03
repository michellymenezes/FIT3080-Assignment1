package planpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Input {

	private ArrayList<String []> mapB;
	private ArrayList<Node> mapS;
	private ArrayList<String> info;
	private BufferedReader input;

	public Input(String fileName) throws Exception {

		this.info = new ArrayList<String>();
		input = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/planpath/"+ fileName));
		createInfo();
		
		if(getAlg().equals("K")){
			createMapB();
		}
		else{
		//	createMapS();
		}

		input.close();
	}
	

	public ArrayList<String[]> getMapB(){
		return mapB;
	}

	public ArrayList<Node> getMapS(){
		return mapS;
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
	
	private void createInfo() throws Exception{
		for(int i = 0; i < 3; i++){
			info.add(input.readLine().toUpperCase());
		}
	}
	
	public void createMapB() throws Exception{
		this.mapB = new ArrayList<String[]>();
		int cont = 0;
		while (input.ready()) {
			if(cont > 2){
			mapB.add(input.readLine().toUpperCase().split(""));
			}
			cont++;
		}
	}
	
}
