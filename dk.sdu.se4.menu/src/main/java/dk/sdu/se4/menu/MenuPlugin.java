/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.menu;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.EntityType;
import dk.sdu.se4.common.entity.part.EntityTypePart;
import dk.sdu.se4.common.entity.part.MenuPart;
import dk.sdu.se4.common.entity.part.VisibilityPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;

/**
 *
 * @author steff
 */
public class MenuPlugin implements PluginService{
    
    private Entity menu;
    private MapService mapService=null;

    
    @Override
    public void load() {
        
        menu = new Menu();
        menu.addPart(new VisibilityPart(true));
        menu.addPart(new EntityTypePart(EntityType.MENUENTITY));
        MenuPart menuPart = new MenuPart();
        File f1 = new File("../dk.sdu.se4.menu/src/main/resources/img/Background.png");
        menuPart.add("Background",f1 );
        File f2 = new File("../dk.sdu.se4.menu/src/main/resources/img/HeadLine.png");
        menuPart.add("Headline", f2);
        File f3 = new File("../dk.sdu.se4.menu/src/main/resources/img/Playbtn.png");
        menuPart.add("Playbtn",f3);
        File f4 = new File("../dk.sdu.se4.menu/src/main/resources/img/Exitbtn.png");
        menuPart.add("Exitbtn",f4);
        menu.addPart(menuPart);
        this.mapService.addEntity(menu);
       
    }

    @Override
    public void unload() {
        
    }
    
    public void addMapService(MapService mapService){
        this.mapService=mapService;
    }
    
    public void removeMapService(MapService mapService){
        this.mapService=null;
    }
}
