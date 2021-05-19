/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.lake;

import dk.sdu.se4.commonlake.Lake;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.entity.part.SpritePart;

/**
 *
 * @author Kasper
 */
public class LakePlugin extends LakeCore implements PluginService {

    @Override
    public void load() {
        if(this.mapService != null) {
            Lake lake = new Lake();
            lake.addPart(new PositionPart(500, 500));
            lake.addPart(new SpritePart("Tile/lake.png", 434, 250, 1));
            this.mapService.addEntity(lake);
        }
    }

    @Override
    public void unload() {
    }
    
}
