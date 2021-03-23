/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.service;

import dk.sdu.se4.common.entity.Entity;
import java.util.Collection;

/**
 *
 * @author steff
 */
public interface MapService {
    int getHeight();
    int getWeight();

    /**
     * Add entity to the map
     * @param entity The entity to add
     */
    void addEntity(Entity entity);
    
    /**
     * Get all entities
     * @return Collection of all entities
     */
    Collection<Entity> getEntities();
    
    /**
     * Get entities by entity type
     * @param <E> Entity class
     * @param entityType The entity type to filter for
     * @return A collection of entities with the same entity type
     */
    <E extends Entity> Collection<Entity> getEntities(Class<E> entityType);
}
