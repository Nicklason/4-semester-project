/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

import dk.sdu.se4.common.data.parts.IGameObjectPart;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author steff
 */
public class GameObject implements Serializable {
    
    private final String ID;
    
    private Map<Class, IGameObjectPart> partsMap;

    public GameObject() {
        this.partsMap = new HashMap<>();
        this.ID = UUID.randomUUID().toString();
    }

    public String getID() {
        return ID;
    }
    
    public void addPart(IGameObjectPart gameObjectPart){
        this.partsMap.put(gameObjectPart.getClass(), gameObjectPart);
    }
    public void removePart(Class partclass){
        this.partsMap.remove(partclass);
    }
    public <E extends IGameObjectPart> E getPart(Class partclass){
        if (this.partsMap.containsKey(partclass)) {
            return (E) this.partsMap.get(partclass);
        }else 
            return null;
    }
    
    
    
    
    
}
