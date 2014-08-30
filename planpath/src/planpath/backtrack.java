package planpath;

import java.util.ArrayList;

public class Backtrack {

	private Input input;
	private ArrayList<String[]> table;
	private ArrayList<boolean []> visited;

	public Backtrack(String fileName) throws Exception {

		this.input = new Input(fileName);
		this.table = input.getMap();
		this.visited = createVisited();

	}

	public ArrayList<String> backtrack() {
		ArrayList<String> moves = new ArrayList<String>();

		for (int i = 0; i < input.getSize(); i++) {
			for (int j = 0; j < input.getSize(); j++) {
				if (table.get(i)[j].equals("S")) {
					backtrackRecursive(i, j, moves, visited);
				}
			}
		}
		System.out.println("---");
		System.out.println(moves);
		return moves;
	}

	private ArrayList<String> backtrackRecursive(int i, int j, ArrayList<String> moves, ArrayList<boolean []> visited) {
		
		for(int k = 0; k < 8; k++){
			System.out.println(moves);
			if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
				break;
			}
			
			System.out.println(".");
			switch (k) {
			
			
			case 0: 
				if (j < input.getSize() - 1 && !table.get(i)[j + 1].equals("X") && !visited.get(i)[j + 1]){
					System.out.println(moves);
					
					System.out.println(i);
					System.out.println(j);
					moves.add("R");
					if (table.get(i)[j + 1].equals("G")) {
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i)[j+1] = true;
					backtrackRecursive(i, j + 1, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
				
			case 1:	
				if(j < input.getSize() - 1 && i < input.getSize() - 1 && !table.get(i)[j + 1].equals("X") && !table.get(i + 1)[j].equals("X") && !table.get(i + 1)[j + 1].equals("X") && !visited.get(i + 1)[j + 1]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("RD");

					if(table.get(i + 1)[j + 1].equals("G")){
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i+1)[j+1] = true;
					backtrackRecursive(i + 1, j + 1, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
			
			case 2:
				if(i < input.getSize() - 1 && !table.get(i + 1)[j].equals("X") && !visited.get(i + 1)[j]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("D");

					if(table.get(i + 1)[j].equals("G")){
						moves.add("G");
						System.out.println("ok");
						break;
					}
					else{
					visited.get(i+1)[j] = true;
					backtrackRecursive(i + 1, j, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
				
			case 3:	
				if(j > 0 && i < input.getSize() - 1 && !table.get(i + 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i + 1)[j].equals("X") && !visited.get(i +1)[j - 1]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("LD");

					if(table.get(i + 1)[j - 1].equals("G")){
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i+1)[j-1] = true;
					backtrackRecursive(i + 1, j - 1, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
				
			case 4:	
				if(j > 0 && !table.get(i)[j - 1].equals("X") && !visited.get(i)[j -1]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("L");

					if(table.get(i)[j - 1].equals("G")){
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i)[j-1] = true;
					backtrackRecursive(i, j - 1, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
			
			case 5:	
				if(j > 0 && i > 0 && !table.get(i - 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j -1]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("LU");

					if(table.get(i - 1)[j - 1].equals("G")){
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i-1)[j-1] = true;
					backtrackRecursive(i - 1, j - 1, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
				
			case 6:	
				if(i > 0 && !table.get(i - 1)[j].equals("X") && !visited.get(i - 1)[j]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("U");

					if(table.get(i - 1)[j].equals("G")){
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i-1)[j] = true;
					backtrackRecursive(i - 1, j, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
			
			case 7:	
				if(j < input.getSize() - 1 && i > 0 && !table.get(i - 1)[j + 1].equals("X") && !table.get(i)[j + 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j +1]){
					System.out.println(moves);
					System.out.println(i);
					System.out.println(j);
					moves.add("RU");

					if(table.get(i - 1)[j + 1].equals("G")){
						moves.add("G");
						return moves;
					}
					else{
					visited.get(i-1)[j+1] = true;
					backtrackRecursive(i - 1, j + 1, moves, visited);
					System.out.println(moves);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					System.out.println(moves);
					break;
					}

				}
			}
		}
		
		return null;
		
	}
	
	public static void main(String [] args) throws Exception{
		Backtrack b = new Backtrack("teste6.txt");
		b.backtrack();
		
		
	}
	
	private ArrayList<boolean []> createVisited(){
		ArrayList<boolean []> table = new ArrayList<boolean []>();		
		for(int i = 0; i < input.getSize(); i++){
			boolean [] line = new boolean [input.getSize()];
			for(int j = 0; j < input.getSize(); j++){
				if(input.getMap().get(i)[j].equals("S")){
					line[j] = true;
				}
				else{
					line[j] = false;
				}
			}
			table.add(line);
		}
		return table;
	}
}