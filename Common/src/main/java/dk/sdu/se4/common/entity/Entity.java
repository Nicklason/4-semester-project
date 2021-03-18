/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity;

import dk.sdu.se4.common.entity.parts.EntityPart;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author steffen
 */
public class Entity {
    private final String id = UUID.randomUUID().toString();
    private Map<Class, EntityPart> PartStorage;
    

    public Entity() {
        this.PartStorage = new HashMap<Class, EntityPart>();
    }
    
    public void AddPart(EntityPart entitypart){
        this.PartStorage.put(entitypart.getClass(), entitypart);
    }
    public void RemovePart(Class partClass){
        this.PartStorage.remove(partClass);
    }
    public <E extends Entity> E getpart(Class partClass){
        return (E) PartStorage.get(partClass);
    }
    
    
    
    
}
