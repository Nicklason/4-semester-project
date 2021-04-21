package dk.sdu.se4.collision;

import dk.sdu.se4.collision.grid.Grid;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.commoncollision.CollisionService;

public class CollisionServiceImpl implements CollisionService, PostProcessorService {
    // Hardcode size right now
    // TODO: use the game.size function to create grid (or whatever the function will be named)
    private final Grid grid = new Grid(100, 100, 800, 600);
    
    @Override
    public void addEntity(Entity entity) {
        grid.addEntity(entity);
    }
    
    @Override
    public void removeEntity(Entity entity) {
        grid.removeEntity(entity);
    }
    
    @Override
    public void entityMoved(Entity entity, int previousX, int previousY) {
        grid.entityMoved(entity, previousX, previousY);
    }

    @Override
    public void process() {
        // TODO: Get all grid cells that have both friendly and enemies
        // TODO: Loop through all friendly entities and then all enemy entities inside each grid cell
        // TODO: Detect collision between collision parts of friendly and enemy
        // TODO: Remove health from friendly if enemy attack collides with friendly
        // TODO: Remove health from enemy if friendly attack collides with enemy
    }
}
