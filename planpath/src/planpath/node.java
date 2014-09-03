package planpath;

public class Node {

	private Node parent;
	private String operator, state;
	private int depht, path;
	
	public Node(Node parent, String operator, int depht, int path, String state){
		this.parent = parent;
		this.operator = operator;
		this.depht++;
		this.path += path;
		this.state = state;
	}

	public String getState() {
		return state;
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
