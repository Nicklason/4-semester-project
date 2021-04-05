/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;
import java.awt.Point;

/**
 *
 * @author Steffen and Kasper Jalris
 */
public class PositionPart implements EntityPart{
    private Point point;

    public PositionPart(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public void process(Entity entity) {
       
    }

    
    
    
    
    
}
