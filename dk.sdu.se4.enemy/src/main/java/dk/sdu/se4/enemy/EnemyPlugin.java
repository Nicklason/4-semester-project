/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import java.awt.Point;

/**
 *
 * @author steff
 */
public class EnemyPlugin extends EnemyCore implements PluginService{
    
    
    private Entity enemy;

    @Override
    public void load() {
        System.out.println("loading Enemy");
        if (this.mapService!=null){
            enemy = new Enemy();
            enemy.addPart(new PositionPart(new Point(10, 10)));
            enemy.addPart(new MovingPart());
            enemy.addPart(new LifePart(100));
            this.mapService.addEntity(new Enemy());
            System.out.println("Loading Enemy to "+this.mapService.toString());
        }
        else{
            System.out.println("Map is Null");
        }
        
        
    }

    @Override
    public void unload() {
        if (this.mapService!=null){
            for(Entity e :this.mapService.getEntities()){
                if(e.equals(this.enemy)){
                    this.mapService.removeEntity(e);
                }
            }
        }
        
    }
  
    
}
