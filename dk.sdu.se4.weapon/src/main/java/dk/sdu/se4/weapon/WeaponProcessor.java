/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.weapon;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
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
    private SpritePart sp = new SpritePart("Bullets/bullet.png", 16,16,2);
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
                        bullet.addPart(sp);
                        bullet.addPart(new TimePart(3));
                        bullet.addPart(new DirectionPart(dp.getMovingUp(), dp.getMovingDown(), dp.getMovingLeft(), dp.getMovingRight()));
                        bullet.addPart(new MovingPart(15));
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
