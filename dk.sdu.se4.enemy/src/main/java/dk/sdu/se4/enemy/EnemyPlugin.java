/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.AnimationPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.LifePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import java.awt.Point;
import java.io.File;
import org.osgi.framework.BundleContext;

/**
 *
 * @author steff
 */
public class EnemyPlugin extends EnemyCore implements PluginService {

    private Entity[] enemy = new Enemy[10];
    private BundleContext bundle;
    
    private String[] frames = {"ers_1s", "ers_2s", "ers_3s", "ers_4s", "ers_5s", "ers_4s", "ers_3s", "ers_2s"};
    private String filePath = "../dk.sdu.se4.enemy/src/main/resources/img/";

    @Override
    public void load() {
        if (this.mapService != null) {
            for (int i = 0; i < enemy.length; i++) {
                enemy[i] = new Enemy();
                int x = (int) (Math.random() * 800) + 1;
                int y = (int) (Math.random() * 600) + 1;
                enemy[i].addPart(new PositionPart(x, y));
                enemy[i].addPart(new MovingPart(1));
                enemy[i].addPart(new LifePart(100));
                
                //File file = new File("/C:/Users/marti/Google Drev/Billeder/81ff0d61-cece-4b8b-af79-1e0a5a3542ea.png");
                //File file = new File("../dk.sdu.se4.enemy/src/main/resources/img/zombi.png");
                //enemy[i].addPart(new ImagePart(file, 150, 150));
                
                enemy[i].addPart(new AnimationPart(frames, filePath, 256, 256));
                this.mapService.addEntity(enemy[i]);
            }

        }

    }

    @Override
    public void unload() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Enemy.class)) {
                for (int i = 0; i < enemy.length; i++) {
                    if (e.equals(enemy[i])) {
                        this.mapService.removeEntity(e);
                    }
                }
            }
        }

    }

}
