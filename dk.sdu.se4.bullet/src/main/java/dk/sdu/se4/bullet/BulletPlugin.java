package dk.sdu.se4.bullet;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;
import java.awt.Point;

public class BulletPlugin extends BulletCore implements PluginService {
    private Entity bullet;

    @Override
    public void load() {
         if(this.mapService != null) {
             bullet = create();
             this.mapService.addEntity(bullet);
        }
    }

    @Override
    public void unload() {
        if(this.mapService != null) {
            for(Entity e : this.mapService.getEntities(Bullet.class)) {
                TimePart timePart = e.getPart(TimePart.class);
                if(timePart.getTime() == 0) {
                    this.mapService.removeEntity(e);
                }
            }
        }
    }

    private Entity create() {
        bullet = new Bullet();
        int x = 300;
        int y = 300;

        bullet.addPart(new PositionPart(x, y));
        bullet.addPart(new TimePart(3));
        bullet.addPart(new MovingPart(2));
        bullet.addPart(new ImagePart(new File("../dk.sdu.se4.Equipment/src/main/resources/img/bullet.png"), 100, 50));
        bullet.addPart(new CollisionPart(10,10));
        return bullet;
    }
}
