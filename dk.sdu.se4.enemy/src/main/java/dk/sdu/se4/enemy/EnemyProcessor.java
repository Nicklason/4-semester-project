/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.BlockPart;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.player.Player;
import java.util.Collection;

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

        if (this.mapService == null|| this.aiControlSystem==null) {
            return;
        }


        Collection<Entity> playerEntities = this.mapService.getEntities(Player.class);

        if (playerEntities.size() != 1) {
            return;
        }

        Entity player = playerEntities.iterator().next();
        this.aiControlSystem.grideBulder(player);

        for (Entity e : this.mapService.getEntities(Enemy.class)) {
            MovingPart mp = e.getPart(MovingPart.class);
            DirectionPart dp = e.getPart(DirectionPart.class);
            PositionPart pp = e.getPart(PositionPart.class);
            BlockPart bk = e.getPart(BlockPart.class);

            PositionPart aips = this.aiControlSystem.pathFinding(e,player);
            if (aips!=null){
                System.out.println(aips.getX()+" : "+ aips.getY());
                pp.translate(aips.getX(), aips.getY());
            }


            bk.process(e);
            mp.process(e);
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
