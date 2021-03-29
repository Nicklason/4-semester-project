/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.data.GameSpace;
import dk.sdu.se4.common.services.IFunktionProcessingService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author steff
 */

@ServiceProvider(service = IFunktionProcessingService.class)
public class EnemyProcessing implements IFunktionProcessingService{

    @Override
    public void funktionProcess(GameSpace gameSpace) {
        System.out.println("ENEMY funktionprocessor");
    }
    
}
