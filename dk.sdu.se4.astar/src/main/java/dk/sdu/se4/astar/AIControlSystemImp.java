package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.Type;
import dk.sdu.se4.common.entity.part.TypePart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.commontile.Tile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;

public class AIControlSystemImp implements AIControlSystem {
  private MapService mapService=null;
  private List<Node> grid =  new ArrayList<Node>();
  protected Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public PositionPart pathFinding(Entity startEntity, Entity targetEntity) {
    Node start = null;
    Node target = null;
    for (Node n : this.grid){
      if (start==null || target==null){
        if (startEntity.equals(n.getEntity())){
          start = n;
        }
        if (targetEntity.equals(n.getEntity())){
          target = n;
        }
      }
      if (start!=null && target!=null){
        continue;
      }
    }
    if (start==null && target==null){
      return null;
    }
    PriorityQueue<Node> closedList = new PriorityQueue<>();
    PriorityQueue<Node> openList = new PriorityQueue<>();
    openList.addAll(this.grid);

    start.f = start.g + start.calculateHeuristic(target);
    openList.add(start);

    while(!openList.isEmpty()){
      Node n = openList.peek();
      if(n == target){
        return new PositionPart(n.getX(), n.getY());
      }

      for(Node.Neighbors neighbors : n.neighbors){
        Node m = neighbors.node;
        double totalWeight = n.g + neighbors.weight;

        if(!openList.contains(m) && !closedList.contains(m)){
          m.parent = n;
          m.g = totalWeight;
          m.f = m.g + m.calculateHeuristic(target);
          openList.add(m);
        } else {
          if(totalWeight < m.g){
            m.parent = n;
            m.g = totalWeight;
            m.f = m.g + m.calculateHeuristic(target);

            if(closedList.contains(m)){
              closedList.remove(m);
              openList.add(m);
            }
          }
        }
      }

      openList.remove(n);
      closedList.add(n);
    }
    return null;
  }

  public static void printPath(Node target){
    Node n = target;

    if(n==null)
      return;

    List<Integer> ids = new ArrayList<>();

    while(n.parent != null){
      ids.add(n.id);
      n = n.parent;
    }
    ids.add(n.id);
    Collections.reverse(ids);

    for(int id : ids){
      System.out.print(id + " ");
    }
    System.out.println("");


  }

  @Override
  public void grideBulder(Entity target) {
    if (this.mapService!=null){
      this.grid.clear();
      for (int i=0; i< this.mapService.getHeight();i+=32){
        for (int j=0; j< this.mapService.getWeight();j+=32){
          this.grid.add(new Node(i,j, this.computeCost(i,j,target)));
          for(Entity e : this.mapService.getEntities()) {
            TypePart tp = e.getPart(TypePart.class);
            if (tp!=null && (tp.getType()== Type.ENEMY|| tp.getType()==Type.PLAYER)){
              PositionPart ps = e.getPart(PositionPart.class);
              if (ps.getX()>=this.grid.get(this.grid.size()-1).getX() && ps.getX()<this.grid.get(this.grid.size()-1).getX()+32 &&
                      ps.getY() >= this.grid.get(this.grid.size()-1).getY() && ps.getY()<this.grid.get(this.grid.size()-1).getY()+32) {
                this.grid.get(this.grid.size()-1).setEntity(e);
                continue;
              }

            }
          }

        }
      }
    }
  }

  private double computeCost(Entity from, Entity to) {
    PositionPart fromps =from.getPart(PositionPart.class);
    PositionPart tops = to.getPart(PositionPart.class);
    double ac = Math.abs(tops.getY() - fromps.getY());
    double cb = Math.abs(tops.getY() - fromps.getX());
    return 5 * Math.hypot(ac, cb);
  }
  private double computeCost(int x, int y , Entity to) {
    PositionPart tops = to.getPart(PositionPart.class);
    double ac = Math.abs(tops.getY() - y);
    double cb = Math.abs(tops.getY() - x);
    return 5 * Math.hypot(ac, cb);
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
