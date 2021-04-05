/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
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
                int choise = (int) (Math.random() * 100) + 1;
                if (choise < 20) {
                    mp.setUP(true);
                    mp.setDOWN(false);
                    mp.setLEFT(false);
                    mp.setRIGHT(false);
                }
                if (choise > 30 && choise < 50) {
                    mp.setUP(false);
                    mp.setDOWN(true);
                    mp.setLEFT(false);
                    mp.setRIGHT(false);
                }
                if (choise > 60 && choise < 75) {
                    mp.setUP(false);
                    mp.setDOWN(false);
                    mp.setLEFT(true);
                    mp.setRIGHT(false);
                }
                if (choise > 90) {
                    mp.setUP(false);
                    mp.setDOWN(false);
                    mp.setLEFT(false);
                    mp.setRIGHT(true);
                }
                mp.process(e);
            }

        }
    }

}
