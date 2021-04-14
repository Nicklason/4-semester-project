/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.weapon;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.service.PluginService;

import dk.sdu.se4.commonweapon.Weapon;

/**
 *
 * @author steff
 */
public class WeaponPlugin extends WeaponCore implements PluginService  {

    @Override
    public void load() {}

    @Override
    public void unload() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Weapon.class)) {
                this.mapService.removeEntity(e);
            }
        }
    }
}
