/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.parts;

import dk.sdu.se4.common.data.GameData;
import dk.sdu.se4.common.data.World;
import dk.sdu.se4.common.entity.Entity;
import java.awt.Point;

/**
 *
 * @author steff
 */
public class PositionPart implements EntityPart {

    private Point point;
    private float radians;

    public PositionPart(Point point, float radians) {
        this.point = point;
        this.radians = radians;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public float getRadians() {
        return radians;
    }

    public void process(Entity entity) {

    }

}
