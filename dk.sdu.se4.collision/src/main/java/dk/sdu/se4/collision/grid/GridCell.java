package dk.sdu.se4.collision.grid;

import dk.sdu.se4.common.entity.Entity;
import java.util.HashMap;
import java.util.Map;

public class GridCell {
    private final Map<String, Entity> entities = new HashMap<String, Entity>();
    
    private int enemyCount = 0;
    private int friendlyCount = 0;
    
    public GridCell() {}
    
    public boolean hasEntities() {
        return !entities.isEmpty();
    }
    
    public boolean hasPossibleCollision() {
        return enemyCount != 0 && friendlyCount != 0;
    }
    
    public void addEntity(Entity entity) {
        if (!entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);

            if (entity.isFriendly()) {
                friendlyCount++;
            } else {
                enemyCount++;
            }
        }
    }
    
    public void removeEntity(Entity entity) {
        if (entities.containsKey(entity.getId())) {
            entities.remove(entity.getId());

            if (entity.isFriendly()) {
                friendlyCount--;
            } else {
                enemyCount--;
            }
        }
    }
}
