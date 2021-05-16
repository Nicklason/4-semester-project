package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
  private final int x;
  private final int y;
  private  Entity entity;
  private static int idCounter = 0;
  public int id;

  // Parent in the path
  public Node parent = null;

  public List<Neighbors> neighbors;


  public double f = Double.MAX_VALUE;
  public double g = Double.MAX_VALUE;
  public double h;



  public Node(int x, int y, double h) {
    this.entity=null;
    this.x = x;
    this.y = y;
    this.h = h;
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  public double getH() {
    return h;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Entity getEntity() {
    return entity;
  }

  public void setEntity(Entity entity) {
    this.entity = entity;
  }

  @Override
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }
  public static class Neighbors {
    Neighbors(int weight, Node node){
      this.weight = weight;
      this.node = node;
    }

    public int weight;
    public Node node;
  }

  public void addBranch(int weight, Node node){
    Neighbors newNeighbors = new Neighbors(weight, node);
    neighbors.add(newNeighbors);
  }

  public double calculateHeuristic(Node target){
    return this.h;
  }

}
