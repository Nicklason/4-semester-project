/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.commonplayer.Player;

public class PlayerPlugin implements PluginService {
    private MapService map;

    public void load() {
        Entity player = createPlayer();
        map.addEntity(player);
    }

    public Entity createPlayer(){
        Entity player = new Player();
        
        return player;
    }
    
    public void unload() {
        if (map!=null) {
            this.map.getEntities(Player.class);
        }
    }
}
