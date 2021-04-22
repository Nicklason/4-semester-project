/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.ai;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.NodePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.commonenemy.Enemy;
import dk.sdu.se4.commonnode.Node;
import dk.sdu.se4.commonplayer.Player;


import javax.xml.stream.events.EntityReference;
import java.util.*;

/**
 * @author Kasper
 */
public class AIControlImpl implements AIControlService {

  private MapService mapService = null;
  private SelectedAction action = SelectedAction.UP;
  private ScorerSerrvice heuristicScorer;
  private ScorerSerrvice pathcost;


  public AIControlImpl() {
    this.heuristicScorer= new HeuristicScorer();
    this.pathcost = new PathCost();


  }


//    @Override
//    public void pathFinding(Entity start) {
//        Entity playerNode=null;
//            for (Entity n : this.mapService.getEntities(Node.class)) {
//                NodePart np = n.getPart(NodePart.class);
//                if (np.getNodeEntities().containsKey(Player.class)) {
//                    playerNode=n;
//                }
//                if (np.getNodeEntities().containsKey(start)) {
//                    if (np.getState()!= NodePart.State.CLOSED){
//                        np.setState(NodePart.State.CLOSED);
//                    }
//
//                    PositionPart p = n.getPart(PositionPart.class);
//                    for ( Entity e : this.mapService.getEntities(Node.class)){
//                        PositionPart ep = e.getPart(PositionPart.class);
//                        int px=p.getX();
//                        int epx=ep.getX();
//                        int py=p.getY();
//                        int epy=ep.getY();
//
//                        if (epx>=px-32 && epx <= px + 32 && epy >= py-32 && epy<=py+32){
//                            NodePart nodePart = e.getPart(NodePart.class);
//                            nodePart.setState(NodePart.State.OPEN);
//                            System.out.printf(nodePart.getState().toString());
//                        }
//                    }
//                }
//            }
//
//
//    }

  @Override
  public void pathFinding(Entity start, Entity target) {
    Entity startNode = null;
    Entity targetNode = null;

    for (Entity n : this.mapService.getEntities(Node.class)){
      NodePart np = n.getPart(NodePart.class);
      if (np.getNodeEntities().containsKey(start.getClass())){
        startNode = n;
        np.setH(this.heuristicScorer.computeCostScore(start, target));
        np.setG(0);
        RouteNode rn = new RouteNode(startNode);
        System.out.println(startNode);
      }

      if (np.getNodeEntities().containsKey(target.getClass())){
        targetNode = n;
        np.setG(this.pathcost.computeCostScore(startNode, targetNode));
        System.out.println(targetNode);
      }
    }

  }



  @Override
  public SelectedAction choseAction() {
    return action;

  }

  public void addMapService(MapService mapService) {
    this.mapService = mapService;
  }

  public void removeMapService(MapService mapService) {
    this.mapService = null;
  }

}

