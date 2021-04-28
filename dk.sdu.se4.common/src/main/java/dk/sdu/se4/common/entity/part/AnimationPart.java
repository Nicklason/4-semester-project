/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.se4.common.entity.Entity;
import java.io.File;

/**
 *
 * @author marti
 */
public class AnimationPart implements EntityPart{
    
    private FileHandle[] textureArray;
    private Texture[] texturesArray;
    private Texture texture = null;
    
    boolean isFull = false;
    
    private int width;
    private int height;
    
    
    public AnimationPart(String[] sprites, String filePath, int width, int height) {
        System.out.println("Animation Part Constructor");
        this.width = width;
        this.height = height;
        this.textureArray = new FileHandle[sprites.length];
        this.texturesArray = new Texture[sprites.length];
        for (int i = 0; i < sprites.length; i++) {
            File file = new File(filePath + sprites[i] + ".png");
            textureArray[i] = new FileHandle(file);
        }
    }
    
    private Texture createImage(FileHandle file, int width, int hight) {
        Pixmap old = new Pixmap(file);
        
        Pixmap newimg = new Pixmap(width, hight, old.getFormat());
        
        newimg.drawPixmap(old,0, 0, old.getWidth(), old.getHeight(),0, 0, newimg.getWidth(), newimg.getHeight());
        this.texture = new Texture(newimg);
        
        return this.texture;
    }
    
    
    
    
    public void nullTexture() {
        this.texture = null;
    }
    
    
    public Texture getAnimationFrame(int startFrame, int numberOfFrames, int animationTimer) {
        
        int tempInt = (int) startFrame + (animationTimer % numberOfFrames);
        
        if (!isFull) {
            texture = createImage(textureArray[tempInt], this.width, this.height);
            texturesArray[tempInt] = texture;
            return texture;
        } else {
            return texturesArray[tempInt];
        }
    }
    
    
    /*
     * Old code
     * 
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
*/
    
    
    @Override
    public void process(Entity entity) {
       
    }
}
