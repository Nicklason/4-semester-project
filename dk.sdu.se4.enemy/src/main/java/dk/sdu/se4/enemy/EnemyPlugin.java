/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;


import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.EntityType;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.PluginService;


/**
 *
 * @author steff
 */
public class EnemyPlugin extends EnemyCore implements PluginService {
    private Entity[] enemy = new Enemy[10];




    @Override
    public void load() {
        if (this.mapService != null) {
            for (int i = 0; i < enemy.length; i++) {
                enemy[i] = new Enemy();
                int x = (int) (Math.random() * 800) + 1;
                int y = (int) (Math.random() * 600) + 1;
                enemy[i].addPart(new EntityTypePart(EntityType.MOVINGENTITY));
                enemy[i].addPart(new PositionPart(x, y));
                enemy[i].addPart(new MovingPart(10));
                enemy[i].addPart(new DirectionPart(false, false, false, false));
                enemy[i].addPart(new LifePart(100));
                enemy[i].addPart(new ScorePart(10));
                enemy[i].addPart(new SpritePart("Enemy/zombi.png",16,16,1));
                enemy[i].addPart(new CollisionPart(50, 50));
                enemy[i].addPart(new FriendlyPart(false));
                this.mapService.addEntity(enemy[i]);
            }
        } else {
            log.error("mapService is null in {}", this.getClass());
        }

    }

    @Override
    public void unload() {
        log.debug("Unload {}", this.getClass().getName());
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Enemy.class)) {
                this.mapService.removeEntity(e);
            }
        } else {
            log.error("mapService is null in {}", this.getClass());
        }

    }

}
