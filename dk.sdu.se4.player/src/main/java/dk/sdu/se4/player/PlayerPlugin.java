
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.commonweapon.Weapon;

/**
 *
 * @author Kasper
 * @author Lucas
 */
public class PlayerPlugin extends PlayerCore implements PluginService {
    
    @Override
    public void load() {
        if (this.mapService != null) {
            Entity player = createPlayer();
            Entity weapon = createWeaponForPlayer(player);
            
            this.mapService.addEntity(player);
            this.mapService.addEntity(weapon);
        }
    }

    @Override
    public void unload() {
        if(this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Player.class)) {
                this.mapService.removeEntity(e);
            }
        }
    }
    
    public Entity createPlayer() {
        Player player = new Player();
        int x = 0;
        int y = 0;
        
        player.addPart(new PositionPart(x, y));
        player.addPart(new MovingPart(10));
        player.addPart(new DirectionPart(false, false, false, false));
        player.addPart(new LifePart(100));
        player.addPart(new SpritePart("Player/player.png",16,16,1));
        player.addPart(new CollisionPart(128, 128));
        player.addPart(new FriendlyPart(true));
        player.addPart(new TypePart(Type.PLAYER));
        
        
        return player;
    }
    
    public Entity createWeaponForPlayer(Entity player) {
        Entity weapon = new Weapon();
        
        PositionPart playerPositionPart = player.getPart(PositionPart.class);
        DirectionPart playerDirectionPart = player.getPart(DirectionPart.class);
        
        // The weapon should have the same position and direction as the player
        // it is attached to
        weapon.addPart(playerPositionPart);
        weapon.addPart(playerDirectionPart);
        // true means shooting gun gun
        weapon.addPart(new WeaponPart(true, 100, 20, 5));
        return weapon;
    }
    
}

