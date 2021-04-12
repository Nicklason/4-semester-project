package dk.sdu.se4.collision;

import dk.sdu.se4.collision.grid.Grid;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.commoncollision.CollisionService;

public class CollisionServiceImpl implements CollisionService {
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
}
