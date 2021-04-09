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
public class ImagePart implements EntityPart {

    private FileHandle fileHandle;
    private int width;
    private int hight;
    private Texture texture = null;

    public ImagePart(File file, int width, int hight) {
        this.fileHandle = new FileHandle(file);
        this.hight=hight;
        this.width=width;
        
    }

    public Texture getTexture() {
        if (texture==null){
            Pixmap old = new Pixmap(fileHandle);
            Pixmap newimg = new Pixmap(this.width, this.hight, old.getFormat());
            newimg.drawPixmap(old, 0, 0, old.getWidth(), old.getHeight(), 0, 0, newimg.getWidth(), newimg.getHeight());
            this.texture= new Texture(newimg);
        }
        return this.texture;
        
    }

    @Override
    public void process(Entity entity) {

    }

}
