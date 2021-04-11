/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.MenuPart;
import dk.sdu.se4.common.entity.part.VisibilityPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.ProcessorService;

/**
 *
 * @author steff
 */
public class MenuProcessing implements ProcessorService{
    
    private MapService mapService=null;
    
    

    @Override
    public void process() {
        for (Entity e : mapService.getEntities(Menu.class)){
            MenuPart mp = e.getPart(MenuPart.class);
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                VisibilityPart v = e.getPart(VisibilityPart.class);
                v.setVisibility(false);
            } 
            if(Gdx.input.isButtonPressed(Input.Buttons.BACK)){
                VisibilityPart v = e.getPart(VisibilityPart.class);
                v.setVisibility(true);
            } 
        }
        
    }
    
    public void addMapService(MapService mapService){
        this.mapService=mapService;
    }
    
    public void removeMapService(MapService mapService){
        this.mapService=null;
    }
    
}
