package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class DirectionPart implements EntityPart {
    private boolean movingUp, movingDown, movingLeft, movingRight;
    private boolean lastMovingUp, lastMovingDown, lastMovingLeft, lastMovingRight;

    public DirectionPart(boolean movingUp, boolean movingDown, boolean movingLeft, boolean movingRight) {
        this.movingUp = movingUp;
        this.movingDown = movingDown;
        this.movingLeft = movingLeft;
        this.movingRight = movingRight;

        this.lastMovingUp = movingUp;
        this.lastMovingDown = movingDown;
        this.lastMovingLeft = movingLeft;
        this.lastMovingRight = movingRight;

        if (!(this.lastMovingUp || this.lastMovingDown || this.lastMovingLeft || this.lastMovingRight)) {
            this.lastMovingRight = true;
        }
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

    public boolean getLookingUp() {
        return this.lastMovingUp;
    }

    public boolean getLookingDown() {
        return this.lastMovingDown;
    }

    public boolean getLookingLeft() {
        return this.lastMovingLeft;
    }

    public boolean getLookingRight() {
        return this.lastMovingRight;
    }

    public void setLookingUp(boolean lookingUp) {
        this.lastMovingUp = lookingUp;
    }

    public void setLookingDown(boolean lookingDown) {
        this.lastMovingDown = lookingDown;
    }

    public void setLookingLeft(boolean lookingLeft) {
        this.lastMovingLeft = lookingLeft;
    }

    public void setLookingRight(boolean lookingRight) {
        this.lastMovingRight = lookingRight;
    }

    @Override
    public void process(Entity entity) {}
}
