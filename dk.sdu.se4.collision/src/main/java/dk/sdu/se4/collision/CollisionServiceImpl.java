package dk.sdu.se4.collision;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.FriendlyPart;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.commonbullet.Bullet;
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
                    

                    boolean aIsBullet = a.getClass().equals(Bullet.class);

                    // Detect if bullet collides with enemy
                    if (aIsBullet || b.getClass().equals(Bullet.class)) {
                        // Bullet is colliding with enemy
                        
                        // Get health parts for both a and b
                        
                        LifePart enemyLifePart = (aIsBullet ? b : a).getPart(LifePart.class);
                        
                        if (aIsBullet) {
                            this.mapService.removeEntity(a);
                        } else {
                            this.mapService.removeEntity(b);
                        }
                        
                        enemyLifePart.removeHealth(1);
                        
                        if (!enemyLifePart.isAlive()) {
                            if (aIsBullet) {
                                this.mapService.removeEntity(b);
                            } else {
                                this.mapService.removeEntity(a);
                            }
                            break;
                        }
                        
                        break;

                        // Deal damage to enemy
                        // Deal damage to bullet
                        
                        // Remove bullet / enemy if they have 0 health
                    }
                }
            }
        }
    }
}
