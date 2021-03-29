/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data.parts;

import dk.sdu.se4.common.data.GameObject;
import java.awt.Point;

/**
 *
 * @author steff
 */
public class PositionPart implements IGameObjectPart{
    private Point point;

    public PositionPart(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
    
    

    @Override
    public void partProcess(GameObject gameObject) {
       
    }
    
}
