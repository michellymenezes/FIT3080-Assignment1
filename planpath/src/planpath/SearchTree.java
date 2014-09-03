package planpath;

import java.util.ArrayList;

public class SearchTree {
	
	private ArrayList<Node> tree;
	private ArrayList<String[]> map;
	private String alg;
	private int size;
	
	public SearchTree(String alg, int size, ArrayList<String[]> map){
		this.map = map;
		this.alg = alg;
		this.size = size;
	}
	
	private ArrayList<Node> searchTree(String alg){

		return null;
	}
	
	
	private ArrayList<Node> algB(){
		return null;
	}
	
	private Node findStart(){
		Node S = null;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(map.get(i)[j].equals("S")){
					S = new Node(null, "S", 0, 0, Integer.toString(i) + Integer.toString(j));
				}
			}
		}
		return S;
	}

}
