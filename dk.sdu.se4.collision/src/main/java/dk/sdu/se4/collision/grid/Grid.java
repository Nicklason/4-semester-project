package dk.sdu.se4.collision.grid;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.PositionPart;

public class Grid {
    private int width;
    private int height;
    private final int gridWidth;
    private final int gridHeight;
    
    private final GridCell[][] cells;
    
    public Grid(int gridWidth, int gridHeight, int width, int height) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.width = width;
        this.height = height;
        
        this.cells = new GridCell[gridWidth][gridHeight];
        for (int i=0; i < this.gridHeight; i++) {
            for (int j=0; j<this.gridWidth; j++) {
                this.cells[j][i] = new GridCell();
            }
        }
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    private int getGridIndexXByCoordinate(int x) {
        int gridSize = width / gridWidth;
        return x / gridSize;
    }
    
    private int getGridIndexYByCoordinate(int y) {
        int gridSize = width / gridWidth;
        return y / gridSize;
    }
    
    public GridCell getGridByCoordinates(int x, int y) {
        int gridIndexX = getGridIndexXByCoordinate(x);
        int gridIndexY = getGridIndexYByCoordinate(y);
        
        return cells[gridIndexX][gridIndexY];
    }    
    
    public void addEntity(Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        CollisionPart collisionPart = entity.getPart(CollisionPart.class);
        
        // if the entitit´y has no position, dont create it
        if (positionPart == null) {
            return;
        }
        
        // If the entity has no collision, dont create it
        if (collisionPart == null) {
            return;
        }
        
        int x = positionPart.getX();
        int y = positionPart.getY();
        
        int gridIndexX = getGridIndexXByCoordinate(x);
        int gridIndexY = getGridIndexYByCoordinate(y);
        
        GridCell gridCell = cells[gridIndexX][gridIndexY];     
        
        gridCell.addEntity(entity);
    }
    
    public void removeEntity(Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        CollisionPart collisionPart = entity.getPart(CollisionPart.class);
        
        // if the entitit´y has no position, dont create it
        if (positionPart == null) {
            return;
        }
        
        // If the entity has no collision, dont create it
        if (collisionPart == null) {
            return;
        }
        
        int x = positionPart.getX();
        int y = positionPart.getY();
        
        int gridIndexX = getGridIndexXByCoordinate(x);
        int gridIndexY = getGridIndexYByCoordinate(y);
        
        GridCell gridCell = cells[gridIndexX][gridIndexY];
        

        gridCell.removeEntity(entity);
        
    }
    
    public void entityMoved(Entity entity, int previousX, int previousY) {
        // Remove entity from old GridCell
        int previousGridIndexX = getGridIndexXByCoordinate(previousX);
        int previousGridIndexY = getGridIndexYByCoordinate(previousY);

        // Add entity to new GridCell
        PositionPart positionPart = entity.getPart(PositionPart.class);
        
        if (positionPart == null) {
            return;
        }
        
        int x = positionPart.getX();
        int y = positionPart.getY();

        int currentGridIndexX = getGridIndexXByCoordinate(x);
        int currentGridIndexY = getGridIndexYByCoordinate(y);
        
        if (previousGridIndexX != currentGridIndexX || previousGridIndexY != currentGridIndexY) {
            // Remove entity from old GridCell and add to new GridCell

            // Remove entity
            GridCell previousGridCell = cells[previousGridIndexX][previousGridIndexY];
        
            previousGridCell.removeEntity(entity);

            
            // Add entity
            GridCell currentGridCell = cells[currentGridIndexX][currentGridIndexY];
        

            currentGridCell.removeEntity(entity);
        }
    }
}
