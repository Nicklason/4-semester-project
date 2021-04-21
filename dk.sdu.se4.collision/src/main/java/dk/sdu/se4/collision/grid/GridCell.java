package dk.sdu.se4.collision.grid;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.FriendlyPart;
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
            
            FriendlyPart friendlyPart = entity.getPart(FriendlyPart.class);
            
            if (friendlyPart == null) {
                return;
            }
            
            if (friendlyPart.isFriendly()) {
                friendlyCount++;
            } else {
                enemyCount++;
            }
        }
    }
    
    public void removeEntity(Entity entity) {
        if (entities.containsKey(entity.getId())) {
            entities.remove(entity.getId());

            FriendlyPart friendlyPart = entity.getPart(FriendlyPart.class);
            
            if (friendlyPart == null) {
                return;
            }
            
            if (friendlyPart.isFriendly()) {
                friendlyCount--;
            } else {
                enemyCount--;
            }
        }
    }
}
