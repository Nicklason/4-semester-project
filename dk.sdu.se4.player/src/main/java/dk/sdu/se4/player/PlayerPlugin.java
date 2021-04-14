/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import java.awt.Point;
import java.io.File;
/**
 *
 * @author Kasper
 * @author Lucas
 */
public class PlayerPlugin extends PlayerCore implements PluginService {

    private Player player;
    
    @Override
    public void load() {
        if (this.mapService != null) {
            player = createPlayer();
            this.mapService.addEntity(player);
        }
    }

    @Override
    public void unload() {
        if(this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Player.class)) {
                if (e.equals(player)) {
                    this.mapService.removeEntity(e);
                }
            }
        }
    }
    
    public Player createPlayer() {
        player = new Player();
        int x = 200;
        int y = 200;
        
        player.addPart(new PositionPart(x, y));
        player.addPart(new MovingPart(10));
        player.addPart(new DirectionPart(false, false, false, false));
        player.addPart(new LifePart(100));
        player.addPart(new ImagePart(new File("../dk.sdu.se4.player/src/main/resources/img/player.png"), 50, 50));
        return player;
    }
    
}
