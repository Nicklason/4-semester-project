/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commongameinput.GameInput;
import dk.sdu.se4.commongameinput.GameInputKeys;

/**
 *
 * @author Kasper
 * @author Lucas
 */
public class PlayerProcessor extends PlayerCore implements ProcessorService {
    
    private GameInput gameInput = null;
    
    public void addGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
    }
    
    public void removeGameInput(GameInput gameInput) {
        this.gameInput = null;
    }
    
    @Override
    public void process() {
        if(this.mapService != null) {
            for(Entity e : this.mapService.getEntities(Player.class)) {
                MovingPart mp = e.getPart(MovingPart.class);
                DirectionPart dp = e.getPart(DirectionPart.class);
                
                dp.setMovingUp(this.gameInput.isPressed(GameInputKeys.UP));
                dp.setMovingDown(this.gameInput.isPressed(GameInputKeys.DOWN));
                dp.setMovingLeft(this.gameInput.isPressed(GameInputKeys.LEFT));
                dp.setMovingRight(this.gameInput.isPressed(GameInputKeys.RIGHT));
                
                mp.process(e);
            }
        }
    }
    
}
