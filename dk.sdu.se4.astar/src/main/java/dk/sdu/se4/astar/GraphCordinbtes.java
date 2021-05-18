package dk.sdu.se4.astar;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class GraphCordinbtes {

  private final Map<GraphNode, Point2D.Double> map = new HashMap<>();

  public void put(GraphNode node , Point2D.Double point){
    this.map.put(node, point);

  }
  public Point2D.Double get(GraphNode node){
    return this.map.get(node);
  }

}
