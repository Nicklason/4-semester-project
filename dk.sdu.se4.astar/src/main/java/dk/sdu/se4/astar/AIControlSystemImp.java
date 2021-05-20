package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.xml.stream.events.EntityReference;
import java.util.*;
import java.util.List;

public class AIControlSystemImp extends Observable implements AIControlSystem {
  private MapService mapService=null;
  protected Logger log = LoggerFactory.getLogger(this.getClass());
  private int[][] blocksArray;
  private int rows = 6;
  private int cols = 7;





  @Override
  public PositionPart pathFinding(Entity start, Entity target) {
    PositionPart startps = start.getPart(PositionPart.class);
    Node initialNode = new Node(startps.getX(), startps.getY());
    PositionPart targetps = target.getPart(PositionPart.class);
    Node finalNode = new Node(targetps.getX(), targetps.getY());
    AStar aStar = new AStar(this.rows, this.cols, initialNode, finalNode);
    aStar.setBlocks(blocksArray);
    List<Node> path = aStar.findPath();

    return new PositionPart(path.get(1).getRow(),path.get(1).getCol());

  }

  @Override
  public void grideBulder(Entity target) {
    this.rows=this.mapService.getHeight();
    this.cols=this.mapService.getWeight();
    blocksArray = new int[this.mapService.getHeight()][this.mapService.getWeight()];
    for (Entity entity: this.mapService.getEntities()){
      if (entity!=target){
        PositionPart ps = entity.getPart(PositionPart.class);
        blocksArray[ps.getX()][ps.getX()]=1;
      }
    }
  }
  private static List<GraphNode> getRandomNodes(int nodes, int arcs , Random random){
    List<GraphNode> graph = new ArrayList<>(nodes);
    for (int i = 0; i<nodes; i++){
      graph.add(new GraphNode(i));
    }


//  public static void main(String[] args) {
//      Node initialNode = new Node(2, 1);
//      Node finalNode = new Node(2, 5);
//      int rows = 6;
//      int cols = 7;
//      AStar aStar = new AStar(rows, cols, initialNode, finalNode);
//      int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};
//      aStar.setBlocks(blocksArray);
//      List<Node> path = aStar.findPath();
//      for (Node node : path) {
//        System.out.println(node);
//      }
//  }

  public void addMapService(MapService mapService) {
    log.debug("Add Mapservice on {}", this.getClass());
    this.mapService = mapService;

  }

  public void removeMapService(MapService mapService) {
    log.debug("Remove Mapservice from {}", this.getClass());
    this.mapService = null;
  }
}
