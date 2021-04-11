/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author steff
 */
public class VisibilityPart implements EntityPart{

    private boolean VisibilityPart;

    public VisibilityPart(boolean VisibilityPart) {
        this.VisibilityPart = VisibilityPart;
    }

    public boolean isVisibility() {
        return VisibilityPart;
    }

    public void setVisibility(boolean VisibilityPart) {
        this.VisibilityPart = VisibilityPart;
    }
    
    
    
    

    @Override
    public void process(Entity entity) {
      
    }
    
}
