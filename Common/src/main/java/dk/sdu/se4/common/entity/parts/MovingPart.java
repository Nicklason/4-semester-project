/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.parts;

import dk.sdu.se4.common.entity.Entity;
import java.awt.Point;

/**
 *
 * @author steff
 */
public class MovingPart implements EntityPart {

    private float speed;
    private boolean UP, DOWN, RIGTH, LEFT;

    public MovingPart(float speed) {
        this.speed = speed;

    }


    public boolean isUP() {
        return UP;
    }

    public void setUP(boolean UP) {
        this.UP = UP;
    }

    public boolean isDOWN() {
        return DOWN;
    }

    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }

    public boolean isRIGTH() {
        return RIGTH;
    }

    public void setRIGTH(boolean RIGTH) {
        this.RIGTH = RIGTH;
    }

    public boolean isLEFT() {
        return LEFT;
    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public void process(Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        Point p = positionPart.getPoint();

        if (this.UP) {
            p.translate(0, 1);
        }
        if (this.DOWN) {

            p.translate(0, -1);
        }
        if (this.RIGTH) {
            p.translate(1, 0);

        }
        if (this.LEFT) {
            p.translate(-1, 0);
        }
        positionPart.setPoint(p);
    }

}
