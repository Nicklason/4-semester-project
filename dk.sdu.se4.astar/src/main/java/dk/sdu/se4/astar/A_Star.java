/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.commontile.Tile;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author steff
 */
public class A_Star {
    Queue<Tile> tilelist = new PriorityQueue<>();
    private float totalcost=0;
    private Entity startNode;
    private Entity targetNode;
    private MapService mapService=null;

    public A_Star(Entity startNode, Entity targetNode) {
        this.startNode = startNode;
        this.targetNode = targetNode;
        
        
        
    }
    
    
    private List<Tile> findNeighbors(Tile current){
        List<Tile> neighborsList = new ArrayList<>();
        PositionPart ps =  current.getPart(PositionPart.class);
        if (this.mapService!=null){
            for (Entity entity : this.mapService.getEntities(Tile.class)) {
               PositionPart pse = entity.getPart(PositionPart.class);
               if (pse.getX() >= ps.getX()-44 && pse.getX()<=ps.getX()+44 && 
                       pse.getY()>= ps.getY()-64 && pse.getY()<=ps.getY()+64){
                   neighborsList.add((Tile)entity);
               }
                
            }
        }
        return neighborsList;
    }
    
    
    
   
}
