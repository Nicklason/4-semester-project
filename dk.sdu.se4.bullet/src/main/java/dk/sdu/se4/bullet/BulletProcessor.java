package dk.sdu.se4.bullet;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.service.ProcessorService;

public class BulletProcessor extends BulletCore implements ProcessorService {

    @Override
    public void process() {
        if(this.mapService != null) {
            for(Entity e : this.mapService.getEntities(Bullet.class)) {
                TimePart timePart = e.getPart(TimePart.class);

                if (timePart.getTime() <= 0) {
                    this.mapService.removeEntity(e);
                    continue;
                }

                PositionPart positionPart = e.getPart(PositionPart.class);
                MovingPart movingPart = e.getPart(MovingPart.class);
            
                movingPart.setMovingUp(true);
                movingPart.setMovingDown(false);
                movingPart.setMovingRight(false);
                movingPart.setMovingLeft(false);

                positionPart.process(e);
                movingPart.process(e);
                timePart.process(e);
            }
        }
    }
}