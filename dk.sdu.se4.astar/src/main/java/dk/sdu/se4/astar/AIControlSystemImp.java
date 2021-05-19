package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

public class AIControlSystemImp extends Observable implements AIControlSystem {
  private MapService mapService=null;
  protected Logger log = LoggerFactory.getLogger(this.getClass());
  private List<GraphNode> graph = null;



  @Override
  public PositionPart pathFinding(Entity start, Entity target) {
    return null;
  }

  @Override
  public void grideBulder(Entity target) {
    int arcs = 0;
    int nodes = this.mapService.getHeight()*this.mapService.getWeight();
    graph = new ArrayList<>(nodes);
    for (int i = 0; i<nodes; i++){
      graph.add(new GraphNode(i));
    }
//    while (arcs>0){
//      GraphNode tail = choise(graph, random);
//      GraphNode head = choise(graph, random);
//      tail.addNode(head);
//      --arcs;
//
//    }
  }

  public static void main(String[] args) {
    int arcs = 5000000;
    int nodes = 800*600;
    long seed = System.nanoTime();
    System.out.println("Starter");
    Random random = new Random(seed);
    List<GraphNode> graph = getRandomNodes(nodes, arcs, random);
    GraphCordinbtes cordinbtes = getCordinbtes(graph, random,800,600);
    GraphWeightFunktion graphWeightFunktion = getWeightFunktion(graph, cordinbtes);

    GraphNode start = choise(graph, random);
    GraphNode target = choise(graph,random);
    System.out.println("Start node "+start.toString());
    System.out.println("target node "+target.toString());
    HeuristicFunktion heuristicFunktion = new EuckideanHeuristicFunktion(cordinbtes);

    List<GraphNode> path = AStar.search(start, target,graphWeightFunktion,heuristicFunktion);
    for (GraphNode i : path){

      System.out.println(i);
    }
    System.out.println("FINISH");
  }
  private static List<GraphNode> getRandomNodes(int nodes, int arcs , Random random){
    List<GraphNode> graph = new ArrayList<>(nodes);
    for (int i = 0; i<nodes; i++){
      graph.add(new GraphNode(i));
    }

    while (arcs>0){
      GraphNode tail = choise(graph, random);
      GraphNode head = choise(graph, random);
      tail.addNode(head);
      --arcs;

    }
    return graph;
  }

  private static GraphCordinbtes getCordinbtes(List<GraphNode> graph, Random random, double height, double weight){
    GraphCordinbtes cordinates = new GraphCordinbtes();
    for ( GraphNode node: graph){
      cordinates.put(node, randomPoint(weight, height , random));
    }
    return cordinates;
  }

  private static Point2D.Double randomPoint(double width, double height, Random random){
    return new Point2D.Double(width*random.nextDouble(), height*random.nextDouble());
  }

  private static GraphWeightFunktion getWeightFunktion(List<GraphNode> graph, GraphCordinbtes cordinbtes){
    GraphWeightFunktion graphWeightFunktion = new GraphWeightFunktion();
    for ( GraphNode node: graph ){
      Point2D.Double p1 = cordinbtes.get(node);
      for (GraphNode children : node.getChildren()){
        Point2D.Double p2 = cordinbtes.get(children);
        double distance = p1.distance(p2);
        graphWeightFunktion.set(node, children, 1.2*distance);
      }
    }
    return graphWeightFunktion;
  }

  private static <T> T choise(List<T> list, Random random){
    return list.get(random.nextInt(list.size()));
  }

  public void addMapService(MapService mapService) {
    log.debug("Add Mapservice on {}", this.getClass());
    this.mapService = mapService;

  }

  public void removeMapService(MapService mapService) {
    log.debug("Remove Mapservice from {}", this.getClass());
    this.mapService = null;
  }
}
