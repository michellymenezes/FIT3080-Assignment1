package planpath;

import java.util.ArrayList;

public class Backtrack {

	private int size;
	private ArrayList<String[]> table;
	private ArrayList<ArrayList<String>> states;
	private ArrayList<boolean []> visited;

	public Backtrack(int size, ArrayList<String []> table) throws Exception {
		
		this.size = size;
		this.table = table;
		this.states = new ArrayList<ArrayList<String>>();
		this.visited = createVisited();

	}
	
	/* 
	 * This method will return the movements chosen from the S to the G.
	 * First it will search for the tile S and, after that, applies the data in the recursive function.
	 */
	public ArrayList<String> backtrack() {
		ArrayList<String> moves = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (table.get(i)[j].equals("S")) {
					moves.add("S");
					backtrackRecursive(i, j, moves, visited);
				}
			}
		}
		return moves;
	}

	/*
	 * This is the recursive method to find the G.
	 * It will check if it is possible to move to another tile according to the specification and add the move to a list for each movement.
	 * If in a specific case it finds the G, it will return all moves until the current state.
	 * If not, will apply the current state in a recursive call.
	 * In each case it update a boolean copy  of the map to not return to a previous tile.
	 * At the end of each case, it will remove the movement from the list, so the idea of backtrack can be done.
	 * If it can not enter in none of the cases, it returns null.
	 */
	
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
	
	/*
	 * This method creates version of the map filled with boolean objects and return it.
	 * This Array List will be used to not return to a visited tile.
	 */
	private ArrayList<boolean []> createVisited(){
		ArrayList<boolean []> visitedTable = new ArrayList<boolean []>();		
		for(int i = 0; i < size; i++){
			boolean [] line = new boolean [size];
			for(int j = 0; j < size; j++){
				if(table.get(i)[j].equals("S")){
					line[j] = true;
				}
				else{
					line[j] = false;
				}
			}
			visitedTable.add(line);
		}
		return visitedTable;
	}
	
	/*
	 * This method verifies and return an Array List with all the possible moves in a specific state
	 */
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
	
	/*
	 * This method returns all the possible movies in sequence
	 */
	public ArrayList<ArrayList<String>> getPossiblesMoves(){
		return states;
	}
	
	/*
	 * All the methods below verifies if a specific movement is possible.
	 * If it is possible, the letter of the movement will be added in a list and true will be returned.
	 * If not, it will return false.
	 */
	
	private boolean goR(int i, int j , ArrayList<String> possibleMoves){
		if(j < size - 1 && !table.get(i)[j + 1].equals("X") && !visited.get(i)[j + 1]){
			possibleMoves.add("R");
			return true;
		}
		return false;
	}
	
	private boolean goRD(int i, int j , ArrayList<String> possibleMoves){
		if(j < size - 1 && i < size - 1 && !table.get(i)[j + 1].equals("X") && !table.get(i + 1)[j].equals("X") && !table.get(i + 1)[j + 1].equals("X") && !visited.get(i + 1)[j + 1]){
			possibleMoves.add("RD");
			return true;
		}
		return false;
	}
	
	private boolean goD(int i, int j , ArrayList<String> possibleMoves){
		if(i < size - 1 && !table.get(i + 1)[j].equals("X") && !visited.get(i + 1)[j]){
			possibleMoves.add("D");
			return true;
		}
		return false;
	}
	
	private boolean goLD(int i, int j , ArrayList<String> possibleMoves){
		if(j > 0 && i < size - 1 && !table.get(i + 1)[j - 1].equals("X") && !table.get(i)[j - 1].equals("X") && !table.get(i + 1)[j].equals("X") && !visited.get(i +1)[j - 1]){
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
		if(j < size - 1 && i > 0 && !table.get(i - 1)[j + 1].equals("X") && !table.get(i)[j + 1].equals("X") && !table.get(i - 1)[j].equals("X") && !visited.get(i -1)[j +1]){
			possibleMoves.add("RU");
			return true;
		}
		return false;
	}
}