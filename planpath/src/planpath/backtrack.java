package planpath;

import java.util.ArrayList;

public class Backtrack {

	private Input input;
	private ArrayList<String[]> table;
	private ArrayList<boolean []> visited;

	public Backtrack() throws Exception {

		this.input = new Input();
		this.table = input.getMap();
		this.visited = createVisited();

	}

	public ArrayList<String> backtrack() {
		ArrayList<String> moves = new ArrayList<String>();

		for (int i = 0; i < input.getSize(); i++) {
			for (int j = 0; j < input.getSize(); j++) {
				if (table.get(i)[j].equals("S")) {
					return backtrackRecursive(i, j, moves, visited);
				}
			}
		}
		return moves;
	}

	private ArrayList<String> backtrackRecursive(int i, int j, ArrayList<String> moves, ArrayList<boolean []> visited) {
		ArrayList<boolean []> currentVisited = visited;
		
		for(int k = 0; k < 8; k++){
			System.out.println(".");
			switch (k) {
			
			
			case 0: 
				if (j < input.getSize() - 1 && !table.get(i)[j + 1].equals("X") && !visited.get(i)[j + 1]){
					System.out.println(moves);
					
					System.out.println(i);
					System.out.println(j);
					moves.add("R");
					if (table.get(i)[j + 1].equals("G")) {
						return moves;
					}
					visited.get(i)[j+1] = true;
					backtrackRecursive(i, j + 1, moves, visited);
					moves.remove(moves.size()-1);

				}
				
			case 1:	
				if(j < input.getSize() - 1 && i < input.getSize() - 1 && !table.get(i)[j + 1].equals("X") && !table.get(i + 1)[j].equals("X") && !table.get(i + 1)[j + 1].equals("X") && !visited.get(i + 1)[j + 1]){
					moves.add("RD");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i + 1)[j + 1].equals("G")){
						return moves;
					}
					visited.get(i+1)[j+1] = true;
					backtrackRecursive(i + 1, j + 1, moves, visited);
					moves.remove(moves.size()-1);

				}
			
			case 2:
				if(i < input.getSize() - 1 && !table.get(i + 1)[j].equals("X") && !visited.get(i + 1)[j]){
					moves.add("D");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i + 1)[j].equals("G")){
						return moves;
					}
					visited.get(i+1)[j] = true;
					backtrackRecursive(i + 1, j, moves, visited);
					moves.remove(moves.size()-1);

				}
				
			case 3:	
				if(j > 0 && i < input.getSize() - 1 && !table.get(i + 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i + 1)[j].equals("X") && !visited.get(i +1)[j - 1]){
					moves.add("LD");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i + 1)[j - 1].equals("G")){
						return moves;
					}
					visited.get(i+1)[j-1] = true;
					backtrackRecursive(i + 1, j - 1, moves, visited);
					moves.remove(moves.size()-1);

				}
				
			case 4:	
				if(j > 0 && !table.get(i)[j - 1].equals("X") && !visited.get(i)[j -1]){
					moves.add("L");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i)[j - 1].equals("G")){
						return moves;
					}
					visited.get(i)[j-1] = true;
					backtrackRecursive(i, j - 1, moves, visited);
					moves.remove(moves.size()-1);

				}
			
			case 5:	
				if(j > 0 && i > 0 && !table.get(i - 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j -1]){
					moves.add("LU");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i - 1)[j - 1].equals("G")){
						return moves;
					}
					visited.get(i-1)[j-1] = true;
					backtrackRecursive(i - 1, j - 1, moves, visited);
					moves.remove(moves.size()-1);

				}
				
			case 6:	
				if(i > 0 && !table.get(i - 1)[j].equals("X") && !visited.get(i - 1)[j]){
					moves.add("U");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i - 1)[j].equals("G")){
						System.out.println("ok");
						return moves;
					}
					visited.get(i-1)[j] = true;
					backtrackRecursive(i - 1, j, moves, visited);
					moves.remove(moves.size()-1);

				}
			
			case 7:	
				if(j < input.getSize() - 1 && i > 0 && !table.get(i - 1)[j + 1].equals("X") && !table.get(i)[j + 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j +1]){
					moves.add("RU");
					System.out.println(i);
					System.out.println(j);
					System.out.println(moves);

					if(table.get(i - 1)[j + 1].equals("G")){
						return moves;
					}
					visited.get(i-1)[j+1] = true;
					backtrackRecursive(i - 1, j + 1, moves, visited);
					moves.remove(moves.size()-1);
					
				}
			}
		}
		return null;
		
	}
	
	public static void main(String [] args) throws Exception{
		Backtrack b = new Backtrack();
		ArrayList<String> k = b.backtrack();
		System.out.println(k);
		
		
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