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
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author steff
 */
public class MenuPart implements EntityPart{
    private final static Logger logger = LoggerFactory.getLogger(MenuPart.class);
    private Map<String, FileHandle> datastorage =new HashMap<>();
   

    private Texture texture = null;

    public MenuPart() {
    }
    

    public void add(String name, File file) {
        if (file.canExecute() || file==null){
            logger.error("{} is null ", file.toString());   
        }
        datastorage.put(name, new FileHandle(file));
        
        
            
        
    }
    public Texture getTextur(String name){
        Pixmap p = new Pixmap(this.datastorage.get(name));
        Texture T= new Texture(p);
        if (T == null){
            logger.error("{} is null ", T.toString());   
        }
        return T;
    }

    @Override
    public void process(Entity entity) {
       
    }
    
}
