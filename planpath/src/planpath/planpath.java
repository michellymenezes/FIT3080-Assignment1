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
			input = new Input("input.txt");
			
			if(input.getAlg().equals("K")){
				b = new Backtrack(input.getSize(), input.getMapB());
				pack = b.backtrack();
				
				if(pack == null){
					writeFile.print("NO-PATH");
				}
				else{
					write(1, input.getInt() -1, writeFile, pack, b.getPossiblesMoves(), b.getCost());
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
	
	private static void write(int n, int iterations, PrintWriter writeFile, ArrayList<String> pack, ArrayList<ArrayList<String>> moves, int totalCost){
		
		writePath(writeFile, pack, totalCost);	
		writeFile.println(pack.get(0) + " 0");
		
		writeFile.print(moves.get(0).get(0));
		
		for(int i = 1; i < moves.get(0).size(); i++){
			writeFile.print(" " + moves.get(0).get(i));	
		}
		writeFile.print("\n");
		int cont = 0;
		for(int i = 1; i < iterations; i++){
			writeFile.print(pack.get(0));
			for(int j = 1; j <= i; j++){
				writeFile.print("-" + pack.get(j));
			}
			writeFile.print(" ");
			if(pack.get(i).length() == 1){
				cont += 2;
			}
			else{
				cont++;
			}
			writeFile.print(cont);
			writeFile.print("\n" + moves.get(i).get(0));
			for(int k = 1; k < moves.get(i).size(); k++){
				System.out.println(moves.get(i).get(k));
				writeFile.print(" " + moves.get(i).get(k));				
			}
			writeFile.print("\n");
		}
		
		if(iterations >= moves.size()){
			writePath(writeFile, pack, totalCost);
		}
	}
	
	private static void writePath(PrintWriter writeFile, ArrayList<String> pack, int totalCost){
		// movements
		writeFile.print(pack.get(0));
		
		for(int i = 1; i < pack.size(); i++){
			writeFile.print("-" + pack.get(i));
		}
		
		writeFile.print(" ");
		// total cost
		writeFile.println((totalCost));
	}
}
