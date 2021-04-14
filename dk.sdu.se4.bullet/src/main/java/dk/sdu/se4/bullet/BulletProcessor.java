package dk.sdu.se4.bullet;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commonbullet.Bullet;

public class BulletProcessor extends BulletCore implements ProcessorService {

    @Override
    public void process() {
        if(this.mapService != null) {
            for(Entity e : this.mapService.getEntities(Bullet.class)) {
                PositionPart positionPart = e.getPart(PositionPart.class);
                MovingPart movingPart = e.getPart(MovingPart.class);
                DirectionPart directionPart = e.getPart(DirectionPart.class);
                TimePart timePart = e.getPart(TimePart.class);
            
                directionPart.setMovingUp(true);
                directionPart.setMovingDown(false);
                directionPart.setMovingRight(false);
                directionPart.setMovingLeft(false);

                positionPart.process(e);
                movingPart.process(e);
                timePart.process(e);
            }
        }
    }
}