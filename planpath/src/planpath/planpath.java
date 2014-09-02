package planpath;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Planpath {
	
	public static void main(String [] args){
		
		Input input;
		Backtrack b;
		ArrayList<String> pack = null;
		FileWriter file;
		PrintWriter writeFile;
		
		try {
			
			file = new FileWriter("output.txt");
			writeFile = new PrintWriter(file);
			input = new Input("teste1.txt");
			
			if(input.getAlg().equals("K")){
				b = new Backtrack(input.getSize(), input.getMap());
				pack = b.backtrack();
				
				if(pack == null){
					writeFile.print("NO-PATH");
				}
				else{
					write(1, input.getInt(), writeFile, pack, b.getPossiblesMoves());
				}
			}
			
			else{
				
			}
			file.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void write(int n, int iterations, PrintWriter writeFile, ArrayList<String> pack, ArrayList<ArrayList<String>> moves){
		// movements
		writeFile.print(pack.get(0));
		
		for(int i = 1; i < pack.size(); i++){
			writeFile.print("-" + pack.get(i));
		}
		
		writeFile.print(" ");
		// total cost
		writeFile.println((pack.size() + n));
		
		writeFile.println(pack.get(0) + " 0");
		
		writeFile.print(moves.get(0).get(0));
		
		for(int i = 1; i < moves.get(0).size(); i++){
			writeFile.print(" " + moves.get(0).get(i));	
		}
		
		for(int i = 1; i < iterations; i++){
			writeFile.print("\n"+ pack.get(0));
			for(int j = 0; j < i; j++){
				writeFile.print("-" + pack.get(i));
			}
			writeFile.print(" ");
			writeFile.print(i + 1);
			writeFile.print("\n" + moves.get(i).get(0));
			
			for(int k = 1; k < moves.get(i).size(); k++){
				writeFile.print(" " + moves.get(i).get(k));				
			}
		}
	}
}
