/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.AnimationPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.player.PlayerEnums.AnimationState;
import dk.sdu.se4.player.PlayerEnums.Orientation;
import java.awt.Point;
import java.io.File;
import java.util.HashMap;
/**
 *
 * @author Kasper
 * @author Lucas
 */
public class PlayerPlugin extends PlayerCore implements PluginService {

    private Entity player;
    
    // init to do with sprites    
    final HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();
    TextureAtlas textureAtlas;
    
    int col = 5;
    
    /*
     * All sprites are apreviations:
     * 1st letter = character
     * 2rd letter = animationState
     * 3rd letter = orientation
     * 4th number = frame of animation nr.
    */
    String[] playerSpritesNorth = {"prn_1", "prn_2", "prn_3", "prn_4", "prn_5"};
    String[] playerSpritesSouth = {"prs_1", "prs_2", "prs_3", "prs_4", "prs_5"};
    String[] playerSpritesEast  = {"pre_1", "pre_2", "pre_3", "pre_4", "pre_5"};
    String[] playerSpritesWest  = {"prw_1", "prw_2", "prw_3", "prw_4", "prw_5"};
    
    String[] testArray = {"strom"};
    
    
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
    
    public Entity createPlayer() {
        player = new Player();
        int x = 500;
        int y = 500;
        
        
        player.addPart(new PositionPart(x, y));
        player.addPart(new MovingPart(5));
        player.addPart(new LifePart(100));
        //player.addPart(new AnimationPart(testArray, new File("../dk.sdu.se4.player/src/main/resources/img/sprites.txt")));
        //player.addPart(new ImagePart(new File("../dk.sdu.se4.player/src/main/resources/img/player.png"), 50, 50));
        return player;
    }
    
    
    
    
    public String drawPlayer(Orientation orientation, AnimationState animationState, int time) {
        int tempInt = time%col;
        switch(orientation) {
            case NORTH:
                if (animationState == AnimationState.STILL) {
                    return "psn";
                } else {
                    return playerSpritesNorth[tempInt];
                }
            case SOUTH:
                if (animationState == AnimationState.STILL) {
                    return "pss";
                } else {
                    return playerSpritesSouth[tempInt];
                }
            case EAST:
                if (animationState == AnimationState.STILL) {
                    return "pse";
                } else {
                    return playerSpritesEast[tempInt];
                }
            case WEST:
                if (animationState == AnimationState.STILL) {
                    return "psw";
                } else {
                    return playerSpritesWest[tempInt];
                }
        }
        return "pss";
    }
    
}
