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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class AIControlImpl implements AIControlService {

    MapService mapService = null;

    
    public AIControlImpl() {
    }
    
    
    
    @Override
    public void pathFinding() {
        List<Entity> enemyNodes = new LinkedList();
        Entity playerNode=null;
            for (Entity n : this.mapService.getEntities(Node.class)) {
                NodePart np = n.getPart(NodePart.class);
                if (np.getNodeEntities().containsKey(Player.class)) {
                    playerNode=n;
                }
                if (np.getNodeEntities().containsKey(Enemy.class)) {
                    enemyNodes.add(n);
                    np.setState(NodePart.State.CLOSED);
                    PositionPart p = n.getPart(PositionPart.class);
                    for ( Entity e : this.mapService.getEntities(Node.class)){
                        PositionPart ep = e.getPart(PositionPart.class);
                        int px=p.getX();
                        int epx=ep.getX();
                        int py=p.getY();
                        int epy=ep.getY();

                        if (epx>=px-32 && epx <= px + 32 && epy >= py-32 && epy<=py+32){
                            NodePart nodePart = e.getPart(NodePart.class);
                            nodePart.setState(NodePart.State.OPEN);
                        }
                    }
                }
            }


    }
    private void findPath(Node start, Node target, List<Node> neighbors){
        NodePart snp = start.getPart(NodePart.class);
        snp.setG(0);
        snp.setH();
    }
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
    }
    
    public void removeMapService(MapService mapService) {
        this.mapService = null;
    }

    private void FindNextStep(Entity e, Entity p) {
        
    }
}
