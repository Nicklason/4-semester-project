/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.player.Player;

import java.awt.*;
import java.util.Collection;

/**
 *
 * @author steff
 */
public class EnemyProcessor extends EnemyCore implements ProcessorService {

    private AIControlSystem aiControlSystem = null;
    private int count =0;

    @Override
    public void process() {
        Entity target=null;
        if (this.mapService != null && count ==120) {
            if (this.aiControlSystem!=null){
                Collection<Entity> pl = this.mapService.getEntities(Player.class);
                for (Entity p: pl){
                    target = p;
                    aiControlSystem.grideBulder(target);
                }

            }
            for (Entity e : this.mapService.getEntities(Enemy.class)) {
                MovingPart mp = e.getPart(MovingPart.class);
                DirectionPart dp = e.getPart(DirectionPart.class);
                if (this.aiControlSystem!=null ){
                    PositionPart aiPos= this.aiControlSystem.pathFinding(e,target);
                    System.out.println(aiPos.toString());
                    if (aiPos!=null ){
                        PositionPart ep= e.getPart(PositionPart.class);
                        ep.translate(aiPos.getX()+ ep.getX(),aiPos.getY()+ ep.getY());
                        this.count = 0;
                    }

                }
            }
        }else{
            //log.error("mapservices is null");
        }
        count++;
    }


    public void addAIControlSystem(AIControlSystem aIControlSystem) {
        log.debug("Add AIControlSystem on {}", this.getClass());
        this.aiControlSystem = aIControlSystem;
    }

    public void removeAIControlSystem(AIControlSystem aiControlSystem) {
        log.debug("Remove AIControlSystem from {}", this.getClass());
        this.aiControlSystem = null;
    }
}
