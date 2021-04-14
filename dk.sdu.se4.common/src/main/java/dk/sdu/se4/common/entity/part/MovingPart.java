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

    /**
     * Pythagoras constant thingy
     */
    private static double DIAGONAL_SCALING_CONSTANT = Math.sqrt(2) / 2;

    public MovingPart(int stepSize) {
        this.movingUp = false;
        this.movingDown = false;
        this.movingLeft = false;
        this.movingRight = false;
        this.stepSize = stepSize;
    }

    public boolean getMovingUp() {
        return movingUp;
    }

    public boolean getMovingDown() {
        return movingDown;
    }

    public boolean getMovingLeft() {
        return movingLeft;
    }

    public boolean getMovingRight() {
        return movingRight;
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
            // If we move diagonally, then we need to decrease the change in x
            // and y by DIAGONAL_SCALING_CONSTANT (roughly 0.7) to make sure that we move stepSize.
            deltaX = DIAGONAL_SCALING_CONSTANT * changeHorizontal * this.stepSize;
            deltaY = DIAGONAL_SCALING_CONSTANT * changeVertical * this.stepSize;
        } else {
            deltaX += changeHorizontal * this.stepSize;
            deltaY += changeVertical * this.stepSize;
        }
        
        // x and y should be a float to move the correct distance
        // diagonally, but it is probably not that important anyway; if stepSize
        // is 10, then the change in x and y is +-7.0...
        positionPart.translate((int)Math.round(deltaX), (int)Math.round(deltaY));
    }
}
