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
public class Entity{
    private final String id;
    private Map<Class, EntityPart> partStorage;
    

    public String getId() {
        return this.id;
    }
    

    public Entity() {
        this.id = UUID.randomUUID().toString();
        this.partStorage = new HashMap<Class, EntityPart>();
    }
    
    public void addPart(EntityPart entitypart){
        this.partStorage.put(entitypart.getClass(), entitypart);
    }
    public void removePart(Class partClass){
        this.partStorage.remove(partClass);
    }
    public <E extends EntityPart> E getPart(Class partClass){
        return (E) this.partStorage.get(partClass);
    }

    
    
    
    
}
