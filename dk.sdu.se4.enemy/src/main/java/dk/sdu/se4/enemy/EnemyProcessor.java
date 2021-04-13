/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commonenemy.Enemy;

/**
 *
 * @author steff
 */
public class EnemyProcessor extends EnemyCore implements ProcessorService {

    @Override
    public void process() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Enemy.class)) {
                MovingPart mp = e.getPart(MovingPart.class);
                int choise = (int) (Math.random() * 100) + 1;
                
                mp.setMovingUp(false);
                mp.setMovingDown(false);
                mp.setMovingLeft(false);
                mp.setMovingRight(false);
                
                if (choise < 20) {
                    mp.setMovingUp(true);
                } else if (choise > 30 && choise < 50) {
                    mp.setMovingDown(true);
                } else if (choise > 60 && choise < 75) {
                    mp.setMovingLeft(true);
                } else if (choise > 90) {
                    mp.setMovingRight(true);
                }
                mp.process(e);
            }
        }else{
            log.error("mapservices is null");
        }
    }
}
