package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class DirectionPart implements EntityPart {
    private boolean movingUp, movingDown, movingLeft, movingRight;

    public DirectionPart(boolean movingUp, boolean movingDown, boolean movingLeft, boolean movingRight) {
        this.movingUp = movingUp;
        this.movingDown = movingDown;
        this.movingLeft = movingLeft;
        this.movingRight = movingRight;
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
    public void process(Entity entity) {}
}
