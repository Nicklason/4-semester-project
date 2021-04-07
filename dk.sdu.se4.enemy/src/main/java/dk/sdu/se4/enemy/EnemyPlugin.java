/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import java.awt.Point;
import java.io.File;

/**
 *
 * @author steff
 */
public class EnemyPlugin extends EnemyCore implements PluginService {

    private Entity[] enemy = new Enemy[10];

    @Override
    public void load() {
        System.out.println("loading Enemy");
        if (this.mapService != null) {
           for (int i =0; i<enemy.length;i++){
            enemy[i] = new Enemy();
            int x = (int) (Math.random() * 800) + 1;
            int y = (int) (Math.random() * 600) + 1;
            enemy[i].addPart(new PositionPart(new Point(x, y)));
            enemy[i].addPart(new MovingPart());
            enemy[i].addPart(new LifePart(100));
            // enemy[i].addPart(new ImagePart(new File("C:/Users/steff/OneDrive/Documents/GitHub/4-semester-project/dk.sdu.se4.enemy/src/main/resources/img/zombi.png"), 150, 150));
            this.mapService.addEntity(enemy[i]);
            }
            
            

        }

    }

    @Override
    public void unload() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Enemy.class)) {
                 for (int i =0; i<enemy.length;i++){
                if (e.equals(enemy[i])) {
                    this.mapService.removeEntity(e);
                }
                 }
            }
        }

    }

}
