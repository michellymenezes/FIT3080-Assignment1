package planpath;

import java.util.ArrayList;

public class Backtrack {

	private Input input;
	private ArrayList<String[]> table;
	private ArrayList<ArrayList<String>> states;
	private ArrayList<boolean []> visited;

	public Backtrack(String fileName) throws Exception {

		this.input = new Input(fileName);
		this.table = input.getMap();
		this.states = new ArrayList<ArrayList<String>>();
		this.visited = createVisited();

	}

	public ArrayList<String> backtrack() {
		ArrayList<String> moves = new ArrayList<String>();

		for (int i = 0; i < input.getSize(); i++) {
			for (int j = 0; j < input.getSize(); j++) {
				if (table.get(i)[j].equals("S")) {
					moves.add("S");
					backtrackRecursive(i, j, moves, visited);
				}
			}
		}
		System.out.println(moves);
		System.out.println(states);
		return moves;
	}

	private ArrayList<String> backtrackRecursive(int i, int j, ArrayList<String> moves, ArrayList<boolean []> visited) {
		
		states.add(possibleMoves(i, j));
		
		for(int k = 0; k < 8; k++){
			if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
				break;
			}
			switch (k) {
			
			case 0: 
				if (goR(i, j, moves)){
					if (table.get(i)[j + 1].equals("G")) {
						moves.add("G");
						return moves;
					}
					visited.get(i)[j+1] = true;
					backtrackRecursive(i, j + 1, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
				
			case 1:	
				if(goRD(i, j, moves)){
					if(table.get(i + 1)[j + 1].equals("G")){
						moves.add("G");
						return moves;
					}
					visited.get(i+1)[j+1] = true;
					backtrackRecursive(i + 1, j + 1, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
			
			case 2:
				if(goD(i, j, moves)){
					if(table.get(i + 1)[j].equals("G")){
						moves.add("G");
						break;
					}
					visited.get(i+1)[j] = true;
					backtrackRecursive(i + 1, j, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
				
			case 3:	
				if(goLD(i, j, moves)){
					if(table.get(i + 1)[j - 1].equals("G")){
						moves.add("G");
						return moves;
					}
					visited.get(i+1)[j-1] = true;
					backtrackRecursive(i + 1, j - 1, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
				
			case 4:	
				if(goL(i, j, moves)){
					if(table.get(i)[j - 1].equals("G")){
						moves.add("G");
						return moves;
					}
					visited.get(i)[j-1] = true;
					backtrackRecursive(i, j - 1, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
			
			case 5:	
				if(goLU(i, j, moves)){
					if(table.get(i - 1)[j - 1].equals("G")){
						moves.add("G");
						return moves;
					}
					visited.get(i-1)[j-1] = true;
					backtrackRecursive(i - 1, j - 1, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
				
			case 6:	
				if(goU(i, j, moves)){
					if(table.get(i - 1)[j].equals("G")){
						moves.add("G");
						return moves;
					}
					visited.get(i-1)[j] = true;
					backtrackRecursive(i - 1, j, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;

				}
			
			case 7:	
				if(goRU(i, j, moves)){
					if(table.get(i - 1)[j + 1].equals("G")){
						moves.add("G");
						return moves;
					}
					visited.get(i-1)[j+1] = true;
					backtrackRecursive(i - 1, j + 1, moves, visited);
					if(moves.size() > 0 && moves.get(moves.size()-1).equals("G")){
						break;
					}
					moves.remove(moves.size()-1);
					break;
				}
				if(moves.size() - states.size() < 1)
					states.remove(states.size()-1);
			}
		}
		return null;
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
	
	private ArrayList<String> possibleMoves(int i, int j){
		ArrayList<String> possibleMoves = new ArrayList<String>();
		goR(i, j, possibleMoves);
		goRD(i, j, possibleMoves);
		goD(i, j, possibleMoves);
		goLD(i, j, possibleMoves);
		goL(i, j, possibleMoves);
		goLU(i, j, possibleMoves);
		goU(i, j, possibleMoves);
		goRU(i, j, possibleMoves);
		
		return possibleMoves;
	}
	
	private boolean goR(int i, int j , ArrayList<String> possibleMoves){
		if(j < input.getSize() - 1 && !table.get(i)[j + 1].equals("X") && !visited.get(i)[j + 1]){
			possibleMoves.add("R");
			return true;
		}
		return false;
	}
	
	private boolean goRD(int i, int j , ArrayList<String> possibleMoves){
		if(j < input.getSize() - 1 && i < input.getSize() - 1 && !table.get(i)[j + 1].equals("X") && !table.get(i + 1)[j].equals("X") && !table.get(i + 1)[j + 1].equals("X") && !visited.get(i + 1)[j + 1]){
			possibleMoves.add("RD");
			return true;
		}
		return false;
	}
	
	private boolean goD(int i, int j , ArrayList<String> possibleMoves){
		if(i < input.getSize() - 1 && !table.get(i + 1)[j].equals("X") && !visited.get(i + 1)[j]){
			possibleMoves.add("D");
			return true;
		}
		return false;
	}
	
	private boolean goLD(int i, int j , ArrayList<String> possibleMoves){
		if(j > 0 && i < input.getSize() - 1 && !table.get(i + 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i + 1)[j].equals("X") && !visited.get(i +1)[j - 1]){
			possibleMoves.add("LD");
			return true;
		}
		return false;
	}
	
	private boolean goL(int i, int j , ArrayList<String> possibleMoves){
		if(j > 0 && !table.get(i)[j - 1].equals("X") && !visited.get(i)[j -1]){
			possibleMoves.add("L");
			return true;
		}
		return false;
	}
	
	private boolean goLU(int i, int j , ArrayList<String> possibleMoves){
		if(j > 0 && i > 0 && !table.get(i - 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j -1]){
			possibleMoves.add("LU");
			return true;
		}
		return false;
	}
	
	private boolean goU(int i, int j , ArrayList<String> possibleMoves){
		if(i > 0 && !table.get(i - 1)[j].equals("X") && !visited.get(i - 1)[j]){
			possibleMoves.add("U");
			return true;
		}
		return false;
	}
	
	private boolean goRU(int i, int j , ArrayList<String> possibleMoves){
		if(j < input.getSize() - 1 && i > 0 && !table.get(i - 1)[j + 1].equals("X") && !table.get(i)[j + 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j +1]){
			possibleMoves.add("RU");
			return true;
		}
		return false;
	}
}