/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.EntityType;

/**
 *
 * @author steff
 */


public class EntityTypePart implements EntityPart{
    
    private EntityType type;

    public EntityTypePart(EntityType type) {
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }
    
    
    @Override
    public void process(Entity entity) {
       
    }
    
}
