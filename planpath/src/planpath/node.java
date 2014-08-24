package planpath;

public class node {

	boolean status;
	node father, children;
	String terrain;
	
	public node(boolean status, node father, node children, String terrain){
		this.status = status;
		this.father = father;
		this.children = children;
		this.terrain = terrain;
	}

	public void setStatus() {
		if(status == true){
			status = false;
		}
		else{
			status = true;
		}
	}

	public String getTerrain() {
		return terrain;
	}

	public node getFather() {
		return father;
	}

	public node getChildren() {
		return children;
	}

	public boolean isRoot(){
		return this.father == null;
	}
	
	public boolean isLeaf(){
		return this.children == null;
	}
	
}
