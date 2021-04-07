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

/**
 *
 * @author steff
 */
public class WeaponProcessor extends WeaponCore implements ProcessorService, KeyboardInputImpl {

    @Override
    public void process() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Weapon.class)) {
                MovingPart mp = e.getPart(MovingPart.class);
                WeaponPart wp = e.getPart(WeaponPart.class);
                if (wp.getType() &&  ) {
                    // Add bullet here
                    
                }
                else {
                    // Add melee here
                }

                mp.process(e);
            }

        }
    }

}
