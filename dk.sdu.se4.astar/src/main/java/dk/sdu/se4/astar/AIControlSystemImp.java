package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.MapService;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AIControlSystemImp extends Observable implements AIControlSystem {
  private MapService mapService=null;
  protected Logger log = LoggerFactory.getLogger(this.getClass());
  protected List<List<Integer>> blocksArray;
  private int y;
  private int x;

    public AIControlSystemImp() {
        this.blocksArray = new ArrayList<>();
    }





  @Override
  public int[][] pathFinding(Entity start, Entity target) {
    PositionPart startps = start.getPart(PositionPart.class);
    Node initialNode = new Node(startps.getY(), startps.getX());
    PositionPart targetps = target.getPart(PositionPart.class);
    Node finalNode = new Node(targetps.getY(), targetps.getX());
    AStar aStar = new AStar( this.mapService.getHeight(),this.mapService.getWeight(), initialNode, finalNode);
    aStar.setBlocks(blocksArray);
    List<Node> path = aStar.findPath();
    if(path.isEmpty()){
      return null;
    }
    int[][] pathsArray = new int[path.size()][2];
    int count=0;
    for (Node n: path){
      pathsArray[count][0] = n.getY();
      pathsArray[count][1] = n.getY();
      count++;
    }
    return pathsArray;

  }



  @Override
  public void mapbuilder(Entity target) {
    this.y =this.mapService.getHeight();
    this.x=this.mapService.getWeight();
    int count=0;
//    for (Entity entity: this.mapService.getEntities()){
//      BlockPart bk = entity.getPart(BlockPart.class);
//      if (entity!=target && bk!=null){
//        PositionPart ps = entity.getPart(PositionPart.class);
//        blocksArray[count][0]=ps.getY();
//        blocksArray[count][1]=ps.getX();
//        count+=1;
//      }
//    }
        for (int i=0; i<y;i++){
            List<Integer> ls = new ArrayList<>();
            ls.add(0);
            ls.add(i);
            blocksArray.add(ls);
            ls = new ArrayList<>();
            ls.add(i);
            ls.add(y);
          }
        for (int i=1; i<x-1;i++){  
           List<Integer> ls = new ArrayList<>();
            ls.add(i);
            ls.add(0);
            blocksArray.add(ls);
            ls = new ArrayList<>();
            ls.add(y);
            ls.add(i);
          }
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
