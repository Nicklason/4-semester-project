package dk.sdu.se4.collision.grid;

import dk.sdu.se4.common.entity.Entity;
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
        
        if (positionPart == null) {
            return;
        }
        
        int x = positionPart.getX();
        int y = positionPart.getY();
        
        int gridIndexX = getGridIndexXByCoordinate(x);
        int gridIndexY = getGridIndexYByCoordinate(y);
        
        GridCell gridCell = cells[gridIndexX][gridIndexY];
        
        if (gridCell == null) {
            gridCell = new GridCell();
            cells[gridIndexX][gridIndexY] = gridCell;
        }
        
        gridCell.addEntity(entity);
    }
    
    public void removeEntity(Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        
        if (positionPart == null) {
            return;
        }
        
        int x = positionPart.getX();
        int y = positionPart.getY();
        
        int gridIndexX = getGridIndexXByCoordinate(x);
        int gridIndexY = getGridIndexYByCoordinate(y);
        
        GridCell gridCell = cells[gridIndexX][gridIndexY];
        
        if (gridCell != null) {
            gridCell.removeEntity(entity);
            
            if (!gridCell.hasEntities()) {
                cells[gridIndexX][gridIndexY] = null;
            }
        }
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
        
            if (previousGridCell != null) {
                previousGridCell.removeEntity(entity);

                if (!previousGridCell.hasEntities()) {
                    cells[previousGridIndexX][previousGridIndexY] = null;
                }
            }
            
            // Add entity
            GridCell currentGridCell = cells[currentGridIndexX][currentGridIndexY];
        
            if (currentGridCell != null) {
                currentGridCell.removeEntity(entity);

                if (!currentGridCell.hasEntities()) {
                    cells[currentGridIndexX][currentGridIndexY] = null;
                }
            }
        }
    }
}
