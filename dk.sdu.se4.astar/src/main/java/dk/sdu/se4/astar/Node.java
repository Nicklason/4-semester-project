package dk.sdu.se4.astar;

public class Node {

  private double g;
  private double f;
  private double h;
  private int y;
  private int x;
  private boolean isBlock;
  private Node parent;

  public Node(int y, int x) {
    super();
    this.y = y;

    this.x = x;
  }

  public void calculateHeuristic(Node finalNode) {
    double ac = Math.abs(finalNode.getY() - getY());
    double cb = Math.abs(finalNode.getX() - getX());
    this.h =  5 * Math.hypot(ac, cb);  

  }

  public void setNodeData(Node currentNode, int cost) {
    double gCost = currentNode.getG() + cost;
    setParent(currentNode);
    setG(gCost);
    calculateFinalCost();
  }

  public boolean checkBetterPath(Node currentNode, int cost) {
    double gCost = currentNode.getG() + cost;
    if (gCost < getG()) {
      setNodeData(currentNode, cost);
      return true;
    }
    return false;
  }

  private void calculateFinalCost() {
    double finalCost = getG() + getH();
    setF(finalCost);
  }

  @Override
  public boolean equals(Object arg0) {
    Node other = (Node) arg0;
    return this.getY() == other.getY() && this.getX() == other.getX();
  }

  @Override
  public String toString() {
    return "Node [y=" + y + ", x=" + x + "]";
  }

  public double getG() {
    return g;
  }

  public void setG(double g) {
    this.g = g;
  }

  public double getF() {
    return f;
  }

  public void setF(double f) {
    this.f = f;
  }

  public double getH() {
    return h;
  }

  public void setH(double h) {
    this.h = h;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public boolean isBlock() {
    return isBlock;
  }

  public void setBlock(boolean block) {
    isBlock = block;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }
}