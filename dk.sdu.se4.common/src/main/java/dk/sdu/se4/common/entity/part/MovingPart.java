package dk.sdu.se4.common.entity.part;

import java.lang.Math;
import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Steffen and Kasper jalris
 */
public class MovingPart implements EntityPart {
    private boolean movingUp, movingDown, movingLeft, movingRight;
    private int stepSize;

    public MovingPart(int stepSize) {
        this.movingUp = false;
        this.movingDown = false;
        this.movingLeft = false;
        this.movingRight = false;
        this.stepSize = stepSize;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    @Override
    public void process(Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        
        // Postive value is right, negative is left
        int changeHorizontal = 0;
        // Postiive value is up, negative is down
        int changeVertical = 0;
       
        // We need to make sure that you can only move "stepSize" in any direction
        // It is only a problem when moving diagonally (both a change in
        // horizontal and a change in vertical)

        if (movingUp){
            changeVertical += 1;
        }
        if (movingDown) {
            changeVertical -= 1;
        }
        if (movingRight){
            changeHorizontal += 1;
        }
        if (movingLeft){
            changeHorizontal -= 1;
        }
        
        double deltaX = 0;
        double deltaY = 0;
        
        if (changeHorizontal != 0 && changeVertical != 0) {
            // We are moving both horizontally and vertically. We need to find
            // the correct change in x and y to move the stepSize.
            deltaX = (Math.sqrt(changeHorizontal * this.stepSize) / 2);
            deltaY = (Math.sqrt(changeVertical * this.stepSize) / 2);
        } else {
            deltaX += changeHorizontal * this.stepSize;
            deltaY += changeVertical * this.stepSize;
        }
        
        // We can't use the Point class if we want to move the correct distance
        // but it is probably not that important anyway.
        positionPart.getPoint().translate((int)Math.round(deltaX), (int)Math.round(deltaY));
    }
}
