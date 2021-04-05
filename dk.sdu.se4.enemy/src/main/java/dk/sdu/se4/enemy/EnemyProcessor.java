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
            int choise = (int) (Math.random() * 4) + 1;
            if (choise == 1) {
                mp.setDOWN(true);
                mp.setDOWN(false);
                mp.setLEFT(false);
                mp.setDOWN(false);
            }
            if (choise == 2) {
                mp.setDOWN(false);
                mp.setDOWN(true);
                mp.setLEFT(false);
                mp.setDOWN(false);
            }
            if (choise == 3) {
                mp.setDOWN(false);
                mp.setDOWN(false);
                mp.setLEFT(true);
                mp.setDOWN(false);
            }
            if (choise == 4) {
                mp.setDOWN(false);
                mp.setDOWN(false);
                mp.setLEFT(false);
                mp.setDOWN(true);
            }
            mp.process(e);
            }
            
        
        } else {
            System.out.println("enemy processer mapservices is null");
        }
    }

}
