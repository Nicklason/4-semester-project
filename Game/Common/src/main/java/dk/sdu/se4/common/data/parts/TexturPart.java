/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data.parts;


import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.se4.common.data.GameObject;
import java.awt.Point;
import java.io.File;

/**
 *
 * @author steff
 */
public class TexturPart implements IGameObjectPart{
    private Texture texture;
    private int h;
    private int w;
    private Point position;

    public TexturPart(File file,Point position, int h, int w ) {
        this.h=h;
        this.w=w;
        this.position = position;
        this.texture = new Texture(new FileHandle(file));
        
       
        
    }

    public Texture getTexture() {
        return texture;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public Point getPosition() {
        return position;
    }
    
    

    @Override
    public void partProcess(GameObject gameObject) {
        
    }
    
}
