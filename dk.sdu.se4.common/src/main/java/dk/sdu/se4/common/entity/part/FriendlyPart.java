/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author kjalris and nicklason
 */
public class FriendlyPart implements EntityPart {

    
    private boolean friendly;

    public FriendlyPart(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isFriendly() {
        return friendly;
    }
    
    
    
    @Override
    public void process(Entity entity) {
       
    }
    
}
