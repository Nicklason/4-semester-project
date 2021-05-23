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
    private int enemyCount = 10;

    @Override
    public void load() {
        if (this.mapService != null) {
            for (int i = 0; i < enemyCount; i++) {
                Enemy enemy = new Enemy();
                int x = (int) (Math.random() * 800) + 1;
                int y = (int) (Math.random() * 600) + 1;
                enemy.addPart(new EntityTypePart(EntityType.MOVINGENTITY));
                enemy.addPart(new PositionPart(x, y));

                float speed = (float)(Math.random() + 0.2);
                enemy.addPart(new MovingPart(speed));
                enemy.addPart(new DirectionPart(false, false, false, false));
                enemy.addPart(new LifePart(5));
                enemy.addPart(new SpritePart("Enemy/zombi.png",16,16,1));
                enemy.addPart(new CollisionPart(16, 16));
                enemy.addPart(new FriendlyPart(false));
                this.mapService.addEntity(enemy);
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