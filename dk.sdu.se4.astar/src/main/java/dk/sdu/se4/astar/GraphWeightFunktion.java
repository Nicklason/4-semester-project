package dk.sdu.se4.astar;

import java.util.HashMap;
import java.util.Map;

public class GraphWeightFunktion {

  private final Map<GraphNode, Map<GraphNode, Double>> map = new HashMap<>();

  public void set(GraphNode tail , GraphNode head, double weight){
    this.map.put(tail, new HashMap<>());
    this.map.get(tail).put(head, weight);
  }

  public double get(GraphNode tail, GraphNode head ){
    double a = this.map.get(tail).get(head);
    System.out.println(a);
    return a;
  }
}
