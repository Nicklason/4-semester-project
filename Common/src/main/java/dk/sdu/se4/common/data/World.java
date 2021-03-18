/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

import dk.sdu.se4.common.entity.Entity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author steff
 */
public class World {
   private Map<String, Entity> entityMap = new ConcurrentHashMap<String, Entity>();
   
   
   public void addEntiry(Entity entity){
       this.entityMap.put(entity.getId(), entity);
       
   }
   
   
}
