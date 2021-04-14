/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.weapon;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.DirectionPart;
import dk.sdu.se4.common.entity.part.TimePart;
import dk.sdu.se4.common.entity.part.WeaponPart;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commonbullet.Bullet;
import dk.sdu.se4.commongameinput.GameInput;
import dk.sdu.se4.commongameinput.GameInputKeys;
import dk.sdu.se4.commonweapon.Weapon;
import java.io.File;

/**
 *
 * @author steff
 */
public class WeaponProcessor extends WeaponCore implements ProcessorService {
    
    private GameInput gameInput = null;
    
    public void addGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
    }
    
    public void removeGameInput(GameInput gameInput) {
        this.gameInput = null;
    }
    
    @Override
    public void process() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Weapon.class)) {
                WeaponPart wp = e.getPart(WeaponPart.class);
                PositionPart pp = e.getPart(PositionPart.class);
                DirectionPart dp = e.getPart(DirectionPart.class);
                if(this.gameInput.isPressed(GameInputKeys.SPACE)) {
                    //TODO use wp firerate for shooting interval
                    if (wp.getType()) {
                        if(wp.getTotalBullets() == 0) {
                            //Weapon out of ammo
                            System.out.println("out of bullets");
                            continue;
                        }
                        if(wp.getCurrentMagazine() == 0) {
                            wp.reload();
                        }
                        wp.removeBullet();

                        // Add bullet here
                        Entity bullet = new Bullet();
                        bullet.addPart(new PositionPart(pp.getX(), pp.getY()));
                        bullet.addPart(new ImagePart(new File("../dk.sdu.se4.bullet/src/main/resources/img/bullet.png"), 10, 10));
                        bullet.addPart(new DirectionPart(dp.getMovingUp(), dp.getMovingDown(), dp.getMovingLeft(), dp.getMovingRight()));
                        bullet.addPart(new MovingPart(15));
                        bullet.addPart(new TimePart(3));
                        this.mapService.addEntity(bullet);
                    }
                    else {
                        // Add melee here
                    }
                }
            }

        }
    }

}
