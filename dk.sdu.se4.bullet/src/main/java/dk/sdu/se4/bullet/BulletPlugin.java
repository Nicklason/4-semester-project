package dk.sdu.se4.bullet;

import dk.sdu.se4.commonbullet.Bullet;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;

public class BulletPlugin extends BulletCore implements PluginService {
    @Override
    public void load() {
        Entity bullet = new Bullet();
        bullet.addPart(new SpritePart("Bullets/bullet.png", 16,16,2));
        bullet.addPart(new PositionPart(-999999, -999999));
        bullet.addPart(new TimePart(0.01f));
        bullet.addPart(new DirectionPart(false,false, false, false));
        bullet.addPart(new MovingPart(0));
        bullet.addPart(new CollisionPart(16, 16));
        bullet.addPart(new FriendlyPart(true));
        this.mapService.addEntity(bullet);

    }

    @Override
    public void unload() {
        if(this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Bullet.class)) {
                this.mapService.removeEntity(e);
            }
        }
    }
}
