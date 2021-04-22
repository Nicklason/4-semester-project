/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.service.AIControlService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commonenemy.Enemy;
import dk.sdu.se4.commonnode.Node;
import dk.sdu.se4.commonplayer.Player;

import java.util.Map.Entry;

/**
 *
 * @author steff
 */
public class EnemyProcessor extends EnemyCore implements ProcessorService {

    private AIControlService aiControlService=null;

    @Override
    public void process() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Enemy.class)) {
                MovingPart mp = e.getPart(MovingPart.class);
                int choise = (int) (Math.random() * 100) + 1;

                Entity target = null;
                for (Entity t : this.mapService.getEntities(Player.class)){
                    target= t;

                }
                aiControlService.pathFinding(e, target);
                AIControlService.SelectedAction action =  aiControlService.choseAction();

                mp.setMovingUp(false);
                mp.setMovingDown(false);
                mp.setMovingLeft(false);
                mp.setMovingRight(false);
                
//                if (choise < 20) {
//                    mp.setMovingUp(true);
//                } else if (choise > 30 && choise < 50) {
//                    mp.setMovingDown(true);
//                } else if (choise > 60 && choise < 75) {
//                    mp.setMovingLeft(true);
//                } else if (choise > 90) {
//                    mp.setMovingRight(true);
//                }
//                if (action== AIControlService.SelectedAction.UP) {
//                    mp.setMovingUp(true);
//                } else if (action== AIControlService.SelectedAction.DOWN) {
//                    mp.setMovingDown(true);
//                } else if (action== AIControlService.SelectedAction.LEFT) {
//                    mp.setMovingLeft(true);
//                } else if (action== AIControlService.SelectedAction.RIGHT) {
//                    mp.setMovingRight(true);
//                }
                mp.process(e);
            }
        }else{
            log.error("mapservices is null");
        }
    }




    public void addAIControlService(AIControlService aiControlService) {
        log.debug("Add AIControlService on {}", this.getClass());
        this.aiControlService = aiControlService;
    }

    public void removeAIControlService(AIControlService aiControlService) {
        log.debug("Remove AIControlService from {}", this.getClass());
        this.aiControlService = null;
    }
}
