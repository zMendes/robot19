package br.insper.robot19;

public class Node {
	private Block value;
	private Node parent;
	private RobotAction action;
	private float pathCost;
	private float heuristic;
	private float tot;

	public Node (Block value, Node parent, RobotAction action, float cost) {
		this.value = value;
		this.parent = parent;
		this.action = action;
		this.pathCost = parent == null ? 0 : parent.getPathCost() + cost;
	}


	public Block getValue() {
		return value;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public RobotAction getAction() {
		return action;
	}
	
	public float getPathCost() {
		return pathCost;
	}

	public void setHeuristic(float heuristic){
		this.heuristic = heuristic;
	}

	public float getHeuristic(){
		return this.heuristic;
	}

	public void setTot(float tot){ this.tot = tot;	}

	public float getTot(){ return this.tot;}
}
