/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.weapon;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.MovingPart;
import dk.sdu.se4.common.entity.part.WeaponPart;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commongameinput.GameInput;
import dk.sdu.se4.commongameinput.GameInputKeys;

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
                MovingPart mp = e.getPart(MovingPart.class);
                WeaponPart wp = e.getPart(WeaponPart.class);
                mp.process(e);
                if(this.gameInput.isPressed(GameInputKeys.SPACE)) {
                    //TODO use wp firerate for shooting interval
                    if (wp.getType()) {
                        if(wp.getTotalBullets() == 0) {
                            //Weapon out of ammo
                            System.out.print("No more ammo");
                            continue;
                        }
                        if(wp.getCurrentMagazine() == 0) {
                            wp.reload();
                            System.out.println("reloading");
                        }
                        System.out.println("shooting");
                        wp.removeBullet();

                        // Add bullet here
                        //Entity bullet = new Bullet();
                        //this.mapService.addEntity(bullet);
                    }
                    else {
                        // Add melee here
                    }
                }
            }

        }
    }

}
