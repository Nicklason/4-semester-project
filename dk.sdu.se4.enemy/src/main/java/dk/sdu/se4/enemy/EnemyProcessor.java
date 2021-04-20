/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.commenEnemy.Enemy;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.service.ProcessorService;

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
                DirectionPart dp = e.getPart(DirectionPart.class);
                int choise = (int) (Math.random() * 100) + 1;
                
                dp.setMovingUp(false);
                dp.setMovingDown(false);
                dp.setMovingLeft(false);
                dp.setMovingRight(false);
                
                if (choise < 20) {
                    dp.setMovingUp(true);
                } else if (choise > 30 && choise < 50) {
                    dp.setMovingDown(true);
                } else if (choise > 60 && choise < 75) {
                    dp.setMovingLeft(true);
                } else if (choise > 90) {
                    dp.setMovingRight(true);
                }
                mp.process(e);
            }
        }else{
            log.error("mapservices is null");
        }
    }
}
