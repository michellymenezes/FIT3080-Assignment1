package planpath;

public class Node {

	private boolean status;
	private Node r, rd, d, ld, l, lu, u, ru;
	private String terrain;
	
	public Node(boolean status, Node r, Node rd, Node d, Node ld, Node l, Node lu, Node u, Node ru, String terrain){
		this.status = status;
		this.r = r;
		this.rd = rd;
		this.d = d;
		this.ld = ld;
		this.l = l;
		this.lu = lu;
		this.u = u;
		this.ru = ru;
		this.l = l;
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

	public boolean isStatus() {
		return status;
	}

	public Node getR() {
		return r;
	}

	public Node getRd() {
		return rd;
	}

	public Node getD() {
		return d;
	}

	public Node getLd() {
		return ld;
	}

	public Node getL() {
		return l;
	}

	public Node getLu() {
		return lu;
	}

	public Node getU() {
		return u;
	}

	public Node getRu() {
		return ru;
	}

	public String getTerrain() {
		return terrain;
	}
}
