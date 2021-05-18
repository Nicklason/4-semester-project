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
    private int totalBullets;
    private int magazineSize;
    private int currentMagazine;
    private float fireRate;

    public WeaponPart(boolean type, int totalBullets, int magazineSize, float fireRate) {
        this.type = type;
        this.totalBullets = totalBullets;
        this.magazineSize = magazineSize;
        this.currentMagazine = magazineSize;
        this.fireRate = fireRate;
    }

    public boolean getType() {
        return type;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }
    
    public void removeBullet() {
        totalBullets -= 1;
        currentMagazine -= 1;
    }
    
    public void addBullets(int bullets) {
        this.totalBullets = bullets;
    }

    public int getCurrentMagazine() {
        return currentMagazine;
    }

    public int getMagazineSize() {
        return magazineSize;
    }

    public int getTotalBullets() {
        return totalBullets;
    }

    public void reload() {
        currentMagazine = magazineSize;
    }
    
    //getAmmo() return 
    public String getAmmo() {
        return currentMagazine + "/" + (totalBullets - currentMagazine);
    }
    

    @Override
    public void process(Entity entity) {
    }
    
    public float getFireRate() {
        return fireRate;
    }

}
