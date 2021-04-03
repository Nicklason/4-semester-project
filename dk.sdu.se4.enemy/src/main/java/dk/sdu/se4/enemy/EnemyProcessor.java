/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.service.ProcessorService;

/**
 *
 * @author steff
 */
public class EnemyProcessor extends EnemyCore implements ProcessorService{

    @Override
    public void process() {
       
        System.out.println("enemy processing");
    }
    
    
    
}
