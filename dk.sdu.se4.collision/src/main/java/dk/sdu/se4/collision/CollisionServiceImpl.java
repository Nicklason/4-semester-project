package dk.sdu.se4.collision;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.FriendlyPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PostProcessorService;
import java.util.Collection;

public class CollisionServiceImpl implements PostProcessorService {
    private MapService mapService = null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
    }
    
    public void removeMapService(MapService mapService) {
        this.mapService = null;
    }
    
    @Override
    public void process() {
        if (this.mapService == null) {
            return;
        }
        
        Collection<Entity> entities = this.mapService.getEntities();
        
        for (Entity a: entities) {
            CollisionPart aCollisionPart = a.getPart(CollisionPart.class);
            PositionPart aPositionPart = a.getPart(PositionPart.class);
            FriendlyPart aFriendlyPart = a.getPart(FriendlyPart.class);
            if (aCollisionPart == null || aPositionPart == null || aFriendlyPart == null) {
                continue;
            }
            
            for (Entity b: entities) {
                if (a.equals(b)) {
                    continue;
                }
                
                CollisionPart bCollisionPart = b.getPart(CollisionPart.class);
                PositionPart bPositionPart = b.getPart(PositionPart.class);
                FriendlyPart bFriendlyPart = b.getPart(FriendlyPart.class);
                
                if (bCollisionPart == null || bPositionPart == null || bFriendlyPart == null) {
                    continue;
                }
                
                if (aFriendlyPart.isFriendly() == bFriendlyPart.isFriendly()) {
                    continue;
                }
                
                // Figure out if a overlaps b
                
                if (aPositionPart.getX() < bPositionPart.getX() + bCollisionPart.getWidth() &&
                    aPositionPart.getX() + aCollisionPart.getWidth() > bPositionPart.getX() &&
                    aPositionPart.getY() < bPositionPart.getY() + bCollisionPart.getHeight() &&
                    aPositionPart.getY() + aCollisionPart.getHeight() > bPositionPart.getY()) {
                }
            }
        }
    }
}
