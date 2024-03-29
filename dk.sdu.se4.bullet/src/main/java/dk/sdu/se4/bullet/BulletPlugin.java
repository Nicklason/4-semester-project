package dk.sdu.se4.bullet;

import dk.sdu.se4.commonbullet.Bullet;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;

public class BulletPlugin extends BulletCore implements PluginService {
    @Override
    public void load() {}

    @Override
    public void unload() {
        if(this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Bullet.class)) {
                this.mapService.removeEntity(e);
            }
        }
    }
}
