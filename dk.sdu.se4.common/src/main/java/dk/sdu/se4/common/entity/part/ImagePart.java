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
 * @author steff
 */
public class ImagePart implements EntityPart{
    private Texture texture;

    public ImagePart(File file, int width, int hight) {
        Pixmap old = new Pixmap(new FileHandle(file) );
        Pixmap newimg = new Pixmap(width, hight, old.getFormat());
        newimg.drawPixmap(old,0, 0, old.getWidth(), old.getHeight(),0, 0, newimg.getWidth(), newimg.getHeight() );
        this. texture = new Texture(newimg);
        
 
    }

    public Texture getTexture() {
        return texture;
    }
    
    

    @Override
    public void process(Entity entity) {
       
    }
    
}
