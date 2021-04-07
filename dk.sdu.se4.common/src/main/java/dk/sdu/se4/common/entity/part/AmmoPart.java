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

// TODO: Make the weapon have a limited amount of bullets to shoot

public class AmmoPart implements EntityPart {
    
    private int numberOfBullets;
    private int magazinesSize;

    public AmmoPart(int numberOfBullets, int magazinesSize) {
        this.numberOfBullets = numberOfBullets;
        this.magazinesSize = magazinesSize;
    }

    
    public int getNumberOfBullets() {
        return this.numberOfBullets;
    }

    public void setNumberOfBullets(int numberOfBullets) {
        this.numberOfBullets = numberOfBullets;
    }

    public int getMagazines() {
        return this.magazinesSize;
    }

    public void setMagazines(int magazines) {
        this.magazinesSize = magazinesSize;
    }
    
    
    

    @Override
    public void process(Entity entity) {
      
    }
    
}