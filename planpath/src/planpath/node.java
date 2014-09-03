package planpath;

public class Node {

	private Node parent;
	private String operator;
	private int depht, path, i, j;
	
	public Node(Node parent, String operator, int depht, int path, int i, int j){
		this.parent = parent;
		this.operator = operator;
		this.depht++;
		this.path += path;
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public Node getParent() {
		return parent;
	}

	public String getOperator() {
		return operator;
	}

	public int getDepht() {
		return depht;
	}

	public int getPath() {
		return path;
	}
}
