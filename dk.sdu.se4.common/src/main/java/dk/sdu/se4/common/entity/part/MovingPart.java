package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Steffen and Kasper jalris
 */
public class MovingPart implements EntityPart {
    private final float stepSize;

    /**
     * Pythagoras constant thingy
     */
    private static final double DIAGONAL_SCALING_CONSTANT = Math.sqrt(2) / 2;

    public MovingPart(float stepSize) {
        this.stepSize = stepSize;
    }

    @Override
    public void process(Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        DirectionPart directionPart = entity.getPart(DirectionPart.class);
        
        // Postive value is right, negative is left
        int changeHorizontal = 0;
        // Postiive value is up, negative is down
        int changeVertical = 0;
       
        // We need to make sure that you can only move "stepSize" in any direction
        // It is only a problem when moving diagonally (both a change in
        // horizontal and a change in vertical)

        if (directionPart.getMovingUp()){
            changeVertical += 1;
        }
        if (directionPart.getMovingDown()) {
            changeVertical -= 1;
        }
        if (directionPart.getMovingRight()){
            changeHorizontal += 1;
        }
        if (directionPart.getMovingLeft()){
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

        // Remember which way the player was walking
        if (changeHorizontal != 0 || changeVertical != 0) {
            directionPart.setLookingUp(directionPart.getMovingUp());
            directionPart.setLookingDown(directionPart.getMovingDown());
            directionPart.setLookingLeft(directionPart.getMovingLeft());
            directionPart.setLookingRight(directionPart.getMovingRight());
        }
        
        // x and y should be a float to move the correct distance
        // diagonally, but it is probably not that important anyway; if stepSize
        // is 10, then the change in x and y is +-7.0...
        positionPart.translate((float)deltaX, (float)deltaY);
    }
}
