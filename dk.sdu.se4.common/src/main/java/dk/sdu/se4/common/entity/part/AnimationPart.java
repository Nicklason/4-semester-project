/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import dk.sdu.se4.common.entity.Entity;
import java.io.File;

/**
 *
 * @author marti
 */
public class AnimationPart implements EntityPart{
    
    TextureAtlas textureAtlas;
    Sprite sprites[];
    int frames = 0;
    int startFrame = 1;
    
    public AnimationPart(String[] animationSprites, File atlas) {
        this.textureAtlas = new TextureAtlas(atlas.getPath());
        this.sprites = new Sprite[animationSprites.length];
        
        for (int i=0; i < animationSprites.length; i++) {
            this.sprites[i] = textureAtlas.createSprite(animationSprites[i]);
        }
        
    }
    
    public void setAnimation(int frames, int startFrame) {
        this.frames = frames;
        this.startFrame = startFrame;
    }
    
    public Sprite getAnimation(int animationTimer) {
        int tempInt = (int)(startFrame + animationTimer % frames);
        
        //sprites[tempInt].setPosition(posX, posY);
        
        return sprites[tempInt];
    }
    
    
    @Override
    public void process(Entity entity) {
       
    }
}
