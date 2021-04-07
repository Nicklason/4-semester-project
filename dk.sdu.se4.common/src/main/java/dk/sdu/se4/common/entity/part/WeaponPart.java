/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author kjalris and denbedste
 */
public class WeaponPart implements EntityPart {
    private boolean type;

    public WeaponPart(boolean type) {
        this.type = type;
    }

    public boolean getType() {
        return type;
    }
    

    @Override
    public void process(Entity entity) {
    }
    
    
}
