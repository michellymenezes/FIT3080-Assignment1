package planpath;

public class node {

	private boolean status;
	private node r, rd, d, ld, l, lu, u, ru;
	private String terrain;
	
	public node(boolean status, node r, node rd, node d, node ld, node l, node lu, node u, node ru, String terrain){
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

	public node getR() {
		return r;
	}

	public node getRd() {
		return rd;
	}

	public node getD() {
		return d;
	}

	public node getLd() {
		return ld;
	}

	public node getL() {
		return l;
	}

	public node getLu() {
		return lu;
	}

	public node getU() {
		return u;
	}

	public node getRu() {
		return ru;
	}

	public String getTerrain() {
		return terrain;
	}
}
