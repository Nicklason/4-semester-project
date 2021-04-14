package dk.sdu.se4.bullet;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commonbullet.Bullet;

public class BulletProcessor extends BulletCore implements ProcessorService {

    @Override
    public void process() {
        if(this.mapService != null) {
            for(Entity e : this.mapService.getEntities(Bullet.class)) {
                MovingPart movingPart = e.getPart(MovingPart.class);
                TimePart timePart = e.getPart(TimePart.class);

                movingPart.process(e);
                timePart.process(e);
            }
        }
    }
}