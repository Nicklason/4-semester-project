/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Steffen and Kasper jalris
 */
public class MovingPart implements EntityPart{
    private boolean UP, DOWN, LEFT, RIGHT;

    public MovingPart() {
        this.UP = false;
        this.DOWN = false;
        this.LEFT = false;
        this.RIGHT = false;
    }

    public void setUP(boolean UP) {
        this.UP = UP;
    }

    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }
    

    
    

    @Override
    public void process(Entity entity) {
        PositionPart p = entity.getPart(PositionPart.class);
        if (UP){
             p.getPoint().translate(0,1);
        }
        if(DOWN){
            p.getPoint().translate(0, -1);
        }
        if (RIGHT){
            p.getPoint().translate(1, 0);
        }
        if(LEFT){
            p.getPoint().translate(-1, 0);
        }
       
    }
    
    

    
    
    
    
}
