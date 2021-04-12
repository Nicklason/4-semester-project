package dk.sdu.se4.commoncollision;

import dk.sdu.se4.common.entity.Entity;

public interface CollisionService {
    /**
     * Method is called when a new entity has been added to the game
     * @param entity The enemy to add
     */
    void addEntity(Entity entity);
    
    /**
     * Method is called when an entity has been removed
     * @param entity The enemy to remove
     */
    void removeEntity(Entity entity);
    
    /**
     * Method is called when an entity has been moved
     * @param entity The entity that has moved
     * @param previousX The previous x coordinate
     * @param previousY The previous y coordinate
     */
    void entityMoved(Entity entity, int previousX, int previousY);
}
