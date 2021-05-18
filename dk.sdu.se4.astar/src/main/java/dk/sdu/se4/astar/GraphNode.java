package dk.sdu.se4.astar;

import java.util.*;

public class GraphNode {

  private final int id;
  private final Set<GraphNode> children = new HashSet<>();

  public GraphNode(int id) {
    this.id = id;
  }

  public void addNode(GraphNode childe){
    children.add(childe);
  }
  public Set<GraphNode> getChildren(){
    return Collections.unmodifiableSet(children);
  }


  public boolean equals(Object o){
    if (o==null || !this.getClass().equals(o.getClass())){
      return false;

    }else{
      return id ==((GraphNode) o).id;
    }
  }

  public int hashCode(){
    return id;
  }

  @Override
  public String toString() {
    return "GraphNode{" +
            "id=" + id +
            ", children=" + children +
            '}';
  }
}
