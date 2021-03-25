/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

import dk.sdu.se4.common.entity.Entity;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author steff
 */
public class World {

    private Map<String, Entity> entityMap;

    private static World worldInstance = null;

    private World() {
        entityMap = new HashMap<String, Entity>();
    }

    public static World getInstance() {
        if (worldInstance == null) {
            worldInstance = new World();
        }
        return worldInstance;
    }

    public void addEntity(Entity entity) {
        this.entityMap.put(entity.getId(), entity);

    }

    public void reomveEntity(Entity entity) {
        this.entityMap.remove(entity.getId());
    }

    public Map<String, Entity> getEntityMap() {
        return this.entityMap;
    }

}
