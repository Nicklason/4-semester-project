package dk.sdu.se4.collision;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.FriendlyPart;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.TextPart;
import dk.sdu.se4.common.service.GameDataService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.commonbullet.Bullet;
import java.util.Collection;

public class CollisionServiceImpl implements PostProcessorService {
    private MapService mapService = null;
    private GameDataService gameDataService = null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
    }
    
    public void removeMapService(MapService mapService) {
        this.mapService = null;
    }
    
    public void addGameDataService(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
    }
    
    public void removeGameDataService(GameDataService gameDataService) {
        this.gameDataService = null;
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
                            this.gameDataService.addPoints(1);
                        }

                        break;
                    }
                }
            }
        }
        
        for (Entity e : this.mapService.getEntities()) {
            TextPart tp = e.getPart(TextPart.class);
            if (tp != null && tp.getId().equals("playerScore")) {
                tp.setText(String.valueOf(this.gameDataService.getPoints()));
                break;
            }
        }
    }
}
