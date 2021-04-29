/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author kjalris
 */
public class CollisionPart implements EntityPart {
    
    private int height;
    private int width;

    public CollisionPart(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }    
    
    @Override
    public void process(Entity entity) {
      
    }
}
