/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.data.GameSpace;
import dk.sdu.se4.common.services.IPluginService;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author steff
 */
@ServiceProviders(value = {
    @ServiceProvider(service = IPluginService.class),})
public class EnemyPlugin implements IPluginService{

    @Override
    public void load(GameSpace gameSpace) {
        System.out.println("Enemy Load");
    }

    @Override
    public void unload(GameSpace gameSpace) {
        System.out.println("Enemy Unload");
    }
    
}
