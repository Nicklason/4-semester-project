package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.BlockPart;
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
    Node initialNode = new Node(startps.getY(), startps.getX());
    PositionPart targetps = target.getPart(PositionPart.class);
    Node finalNode = new Node(targetps.getY(), targetps.getX());
    AStar aStar = new AStar( this.mapService.getWeight(),this.mapService.getHeight(), initialNode, finalNode);
    aStar.setBlocks(blocksArray);
    List<Node> path = aStar.findPath();
    if(path.isEmpty()){
      return null;
    }
    PositionPart npp = new PositionPart(path.get(5).getX(),path.get(5).getY());
    return npp;

  }

  @Override
  public void grideBulder(Entity target) {
    this.rows=this.mapService.getWeight();
    this.cols=this.mapService.getHeight();
    int x=0;
    blocksArray = new int[this.rows][this.cols];
//    for (Entity entity: this.mapService.getEntities()){
//      BlockPart bk = entity.getPart(BlockPart.class);
//      if (entity!=target && bk!=null){
//        PositionPart ps = entity.getPart(PositionPart.class);
//
//        blocksArray[x][0]=ps.getY();
//        blocksArray[x][1]=ps.getX();
//
//
//
//
//        x+=1;
//      }
//    }

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
