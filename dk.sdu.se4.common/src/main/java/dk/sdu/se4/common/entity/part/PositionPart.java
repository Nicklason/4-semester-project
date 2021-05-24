/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Steffen and Kasper Jalris
 */
public class PositionPart implements EntityPart{
    private float x;
    private float y;

    public PositionPart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return (int)x;
    }
    
    public int getY() {
        return (int)y;
    }
    
    public void translate(float deltaX, float deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void process(Entity entity) {}
}
