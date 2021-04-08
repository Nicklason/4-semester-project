package dk.sdu.se4.Equipment;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;
import java.awt.Point;

public class BulletPlugin extends EquipmentCore implements PluginService {
    private Entity bullet;

    @Override
    public void load() {
         if(this.mapService != null) {
             bullet = create();
             this.mapService.addEntity(bullet);
             System.out.println(bullet.toString());
        } else {
            System.out.println("mapservice null load");
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
        } else {
            System.out.println("mapservice null unload");
        }
    }

    private Entity create() {
        bullet = new Bullet();
        float x = 300;//this.mapService.getWidth() / 2;
        float y = 300;//this.mapService.getHeight() / 2;
        System.out.println(x + " : " + y);
        float angle = 3.14f / 2;

        bullet.addPart(new PositionPart(new Point((int)x, (int)y)));
        bullet.addPart(new TimePart(3));
        bullet.addPart(new MovingPart());
        bullet.addPart(new ImagePart(new File("../dk.sdu.se4.Equipment/src/main/resources/img/bullet.png"), 100, 50));
        return bullet;
    }
}
