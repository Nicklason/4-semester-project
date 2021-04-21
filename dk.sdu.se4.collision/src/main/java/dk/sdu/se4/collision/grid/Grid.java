package dk.sdu.se4.collision.grid;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Grid {
    private int width;
    private int height;
    private final int gridWidth;
    private final int gridHeight;
    
    private final GridCell[][] cells;
    
    /**
     * Creates a new Grid
     * @param gridWidth Number of grid cells wide
     * @param gridHeight Number of grid cells tall
     * @param width Width of grid in pixels
     * @param height Height of grid in pixels
     */
    public Grid(int gridWidth, int gridHeight, int width, int height) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.width = width;
        this.height = height;
        
        this.cells = new GridCell[gridWidth][gridHeight];
        for (int i = 0; i < this.gridWidth; i++) {
            for (int j = 0; j < this.gridHeight; j++) {
                this.cells[i][j] = new GridCell();
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
        int gridSize = height / gridHeight;
        return y / gridSize;
    }
    
    public GridCell getGridByCoordinates(int x, int y) {
        int gridIndexX = getGridIndexXByCoordinate(x);
        int gridIndexY = getGridIndexYByCoordinate(y);
        
        return cells[gridIndexX][gridIndexY];
    }

    /**
     * Find all grid cells that a square overlaps
     * @param x x coordinate
     * @param y y coordinate
     * @param width Width of square
     * @param height Height of square
     * @return Collection of GridCell the square overlaps
     */
    private Collection<GridCell> getOverlappingGridCells(int x, int y, int width, int height) {
        Collection<GridCell> overlappingCells = new ArrayList<>();
        
        // Get x and y index of grid that the entity is inside (bottom left)
        int gridXStart = getGridIndexXByCoordinate(x);
        int gridYStart = getGridIndexYByCoordinate(x);
        
        int overlapWidthEnd = x + width;
        int overlapHeightEnd = y + height;
        
        int gridXEnd = getGridIndexXByCoordinate(overlapWidthEnd);
        int gridYEnd = getGridIndexYByCoordinate(overlapHeightEnd);
        
        for (int i = 0; i <= gridXEnd - gridXStart; i++) {
            int gridX = i + gridXStart;
            
            if (gridX >= gridWidth) {
                // We are outside of the grid, break out of the loop
                break;
            }
            
            for (int j = 0; j <= gridYEnd - gridYStart; j++) {
                int gridY = j + gridYStart;
                
                if (gridY >= gridHeight) {
                    // We are outside of the grid, break out of the loop
                    break;
                }
                
                overlappingCells.add(this.cells[gridX][gridY]);
            }
        }
        
        return overlappingCells;
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
        
        Collection<GridCell> overlappingGridCells = this.getOverlappingGridCells(
            positionPart.getX(),
            positionPart.getY(),
            collisionPart.getWidth(),
            collisionPart.getHeight()
        );
        
        Iterator<GridCell> iterator = overlappingGridCells.iterator();
        while (iterator.hasNext()) {
            GridCell gridCell = iterator.next();
            gridCell.addEntity(entity);
        }
    }
    
    public void removeEntity(Entity entity) {
        // We can't guarentee that the entity still has position part and
        // collision part
        for (int i = 0; i < this.gridWidth; i++) {
            for (int j = 0; j < this.gridHeight; j++) {
                GridCell gridCell = this.cells[i][j];
                gridCell.removeEntity(entity);
            }
        }
    }
    
    public void entityMoved(Entity entity, int previousX, int previousY) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        CollisionPart collisionPart = entity.getPart(CollisionPart.class);
        
        if (positionPart == null || collisionPart == null) {
            // Entity does not have positionpart or collisionpart, remove it
            // from grid
            this.removeEntity(entity);
            return;
        }
        
        int currentX = positionPart.getX();
        int currentY = positionPart.getY();

        int width = collisionPart.getWidth();
        int height = collisionPart.getHeight();
        
        Collection<GridCell> previousOverlappingGridCells = this.getOverlappingGridCells(
            previousX,
            previousY,
            width,
            height
        );
        
        Collection<GridCell> currentOverlappingGridCells = this.getOverlappingGridCells(
            currentX,
            currentY,
            width,
            height
        );

        Iterator<GridCell> previousIterator = previousOverlappingGridCells.iterator();
        while (previousIterator.hasNext()) {
            GridCell gridCell = previousIterator.next();
            
            if (currentOverlappingGridCells.contains(gridCell)) {
                // Entity is currently inside this GridCell, skip it
                continue;
            }
            
            gridCell.removeEntity(entity);
        }
        
        Iterator<GridCell> currentIterator = currentOverlappingGridCells.iterator();
        while (currentIterator.hasNext()) {
            GridCell gridCell = currentIterator.next();
            
            if (previousOverlappingGridCells.contains(gridCell)) {
                // Entity was also in this GridCell last frame, skip it
                continue;
            }
            
            gridCell.addEntity(entity);
        }
    }
}
