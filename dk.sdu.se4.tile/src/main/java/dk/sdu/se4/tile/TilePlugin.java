/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.tile;

import dk.sdu.se4.commontile.Tile;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.entity.part.SpritePart;

/**
 *
 * @author Kasper
 */
public class TilePlugin extends TileCore implements PluginService {
    
    int numberOfTiles = 20;
    Tile tile;
    
    @Override
    public void load() {
       if(this.mapService != null) {
           SpritePart sp = new SpritePart("Tile/grass.png", 64, 44, 0);
           for(int i = 0; i < numberOfTiles; i++) {
               int x = i * 64;
               for (int j = 0; j < numberOfTiles; j++) {
                   int y = j * 44;
                   tile = new Tile();
                   tile.addPart(new PositionPart(x, y));
                   tile.addPart(sp);
                   this.mapService.addEntity(tile);
               }
           }
       }
    }

    @Override
    public void unload() {
        if(this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Tile.class)) {
                this.mapService.removeEntity(e);
            }
        }
    }
    
}
