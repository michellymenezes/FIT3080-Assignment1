package planpath;

import java.util.ArrayList;

public class SearchTree {
	
	private ArrayList<Node> tree;
	private ArrayList<String[]> map;
	private ArrayList<String> pack;
	private String alg;
	private int size;
	
	public SearchTree(String alg, int size, ArrayList<String[]> map){
		this.map = map;
		this.alg = alg;
		this.size = size;
		this.pack = new ArrayList<String>();
	}
	
	public ArrayList<Node> searchTree(String alg){
		ArrayList<Node> start = new ArrayList<Node>();
		start.add(findStart());
		if(alg.equals("B")){
			algB(start);
		}

		return null;
	}
	
	
	private ArrayList<String> algB(ArrayList<Node> nodes){
		
		ArrayList<Node> toOpen = new ArrayList<Node>();
		
		if(nodes.isEmpty()){
			return null;
		}
		
		for(int i = 0; i < nodes.size(); i++){
			if(map.get(nodes.get(i).getI())[nodes.get(i).getJ()].equals("G")){
				pack.add(nodes.get(i).getOperator());
				return pack; 
			}
			
			else{
				if(goR(toOpen, nodes.get(i)));
				if(goRD(toOpen, nodes.get(i)));
				if(goD(toOpen, nodes.get(i)));
				if(goLD(toOpen, nodes.get(i)));
				if(goL(toOpen, nodes.get(i)));
				if(goLU(toOpen, nodes.get(i)));
				if(goU(toOpen, nodes.get(i)));
				if(goRU(toOpen, nodes.get(i)));
				
				return algB(toOpen);
			}
		}
		return null;
	}
	
	private Node findStart(){
		Node S = null;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(map.get(i)[j].equals("S")){
					S = new Node(null, "S", 0, 0, i, j);
				}
			}
		}
		return S;
	}
	
	private Node createNode(Node parent, String operator, int depht, int path, int i, int j){
		return new Node(parent, operator, depht, path, i, j);
	}
	
	private boolean goR(ArrayList<Node> possibleMoves, Node n){
		if(n.getJ() < size - 1 && !map.get(n.getI())[n.getJ() + 1].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI() && n.getParent().getJ()!=n.getJ()+1)){
			possibleMoves.add(new Node(n, "R", n.getDepht()+1, n.getPath()+2, n.getI(), n.getJ()+1));
			return true;
		}
		return false;
	}
	
	private boolean goRD(ArrayList<Node> possibleMoves, Node n){
		if(n.getJ() < size - 1 && n.getI() < size - 1 && !map.get(n.getI())[n.getJ() + 1].equals("X") && !map.get(n.getI() + 1)[n.getJ()].equals("X") && !map.get(n.getI() + 1)[n.getJ() + 1].equals("X")  && (n.getParent() != null && n.getParent().getI() != n.getI()+1 && n.getParent().getJ()!=n.getJ()+1)){
			possibleMoves.add(new Node(n, "RD", n.getDepht()+1, n.getPath()+1, n.getJ()+1, n.getJ()+1));
			return true;
		}
		return false;
	}
	
	private boolean goD(ArrayList<Node> possibleMoves, Node n){
		if(n.getI() < size - 1 && !map.get(n.getI() + 1)[n.getJ()].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI()+1 && n.getParent().getJ()!=n.getJ())){
			possibleMoves.add(new Node(n, "D", n.getDepht()+1, n.getPath() + 2, n.getI()+1, n.getJ()));
			return true;
		}
		return false;
	}
	
	private boolean goLD(ArrayList<Node> possibleMoves, Node n){
		if(n.getJ() > 0 && n.getI() < size - 1 && !map.get(n.getI() + 1)[n.getJ() - 1].equals("X") && !map.get(n.getI())[n.getJ() - 1].equals("X") && !map.get(n.getI() + 1)[n.getJ()].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI()+1 && n.getParent().getJ()!=n.getJ()-1)){
			possibleMoves.add(new Node(n, "LD", n.getDepht()+1, n.getPath()+1, n.getI()+1, n.getJ()-1));
			return true;
		}
		return false;
	}
	
	private boolean goL(ArrayList<Node> possibleMoves, Node n){
		if(n.getJ() > 0 && !map.get(n.getI())[n.getJ() - 1].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI() && n.getParent().getJ()!=n.getJ()-1)){
			possibleMoves.add(new Node(n, "L", n.getDepht()+1, n.getPath()+2, n.getI(), n.getJ()-1));
			return true;
		}
		return false;
	}
	
	
	private boolean goLU(ArrayList<Node> possibleMoves, Node n){
		if(n.getJ() > 0 && n.getI() > 0 && !map.get(n.getI() - 1)[n.getJ() - 1].equals("X") && !map.get(n.getI())[n.getJ() - 1].equals("X") && !map.get(n.getI() - 1)[n.getJ()].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI()-1 && n.getParent().getJ()!=n.getJ()-1)){
			possibleMoves.add(new Node(n, "LU", n.getDepht()+1, n.getPath()+1, n.getI()-1, n.getJ()-1));
			return true;
		}
		return false;
	}
	
	private boolean goU(ArrayList<Node> possibleMoves, Node n){
		if(n.getI() > 0 && !map.get(n.getI() - 1)[n.getJ()].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI()-1 && n.getParent().getJ()!=n.getJ())){
			possibleMoves.add(new Node(n, "U", n.getDepht()+1, n.getPath()+2, n.getI()-1, n.getJ()));
			return true;
		}
		return false;
	}
	
	private boolean goRU(ArrayList<Node> possibleMoves, Node n){
		if(n.getJ() < size - 1 && n.getI() > 0 && !map.get(n.getI() - 1)[n.getJ() + 1].equals("X") && !map.get(n.getI())[n.getJ() + 1].equals("X") && !map.get(n.getI() - 1)[n.getJ()].equals("X") && (n.getParent() != null && n.getParent().getI() != n.getI()-1 && n.getParent().getJ()!=n.getJ()+1)){
			possibleMoves.add(new Node(n, "RU", n.getDepht()+1, n.getPath()+1, n.getI()-1, n.getJ()+1));
			return true;
		}
		return false;
	}
}
