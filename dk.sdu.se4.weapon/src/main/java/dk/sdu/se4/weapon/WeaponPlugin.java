/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.weapon;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.MovingPart;
// import dk.sdu.se4.common.entity.part.AmmoPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.WeaponPart;
import dk.sdu.se4.common.service.PluginService;
import java.awt.Point;
import java.io.File;

/**
 *
 * @author steff
 */
public class WeaponPlugin extends WeaponCore implements PluginService  {

    private Entity weapon = new Weapon();

    @Override
    public void load() {
        System.out.println("loading Weapon");
        if (this.mapService != null) {
            weapon = new Weapon();
            int x = (int) 200;
            int y = (int) 200;
            weapon.addPart(new PositionPart(x, y));
            weapon.addPart(new MovingPart(2));
            // true means shooting gun gun
            weapon.addPart(new WeaponPart(true, 100, 20, 5));
            // weapon.addPart(new ImagePart(new File("C:/Users/steff/OneDrive/Documents/GitHub/4-semester-project/dk.sdu.se4.enemy/src/main/resources/img/zombi.png"), 150, 150));
            this.mapService.addEntity(weapon);
        }

    }

    @Override
    public void unload() {
        if (this.mapService != null) {
            for (Entity e : this.mapService.getEntities(Weapon.class)) {
                this.mapService.removeEntity(e);
            }
        }
    }
}
