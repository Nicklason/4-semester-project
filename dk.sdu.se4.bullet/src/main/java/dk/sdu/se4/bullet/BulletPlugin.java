package dk.sdu.se4.bullet;

import dk.sdu.se4.commonbullet.Bullet;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;

public class BulletPlugin extends BulletCore implements PluginService {
    @Override
    public void load() {}

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
}
