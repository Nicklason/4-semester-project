/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.AnimationPart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.service.ProcessorService;

/**
 *
 * @author Kasper
 * @author Lucas
 */
public class PlayerProcessor extends PlayerCore implements ProcessorService {

    @Override
    public void process() {
        if(this.mapService == null) {
            for(Entity e : this.mapService.getEntities(Player.class)) {
                MovingPart mp = e.getPart(MovingPart.class);
                mp.setMovingUp(true);
                mp.setMovingDown(false);
                mp.setMovingLeft(false);
                mp.setMovingRight(false);
                mp.process(e);
            }
        }
    }
    
}
