package dk.sdu.se4.common.service;

import dk.sdu.se4.common.entity.Entity;
import java.util.Collection;

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
    
    /**
     * Remove an entity from the map
     * @param entity The entity to remove
     */
    void removeEntity(Entity entity);
    
    /**
     * Remove a collection of entities
     * @param entities The collection of entities
     */
    void removeEntities(Collection<Entity> entities);
}
