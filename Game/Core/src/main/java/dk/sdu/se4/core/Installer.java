/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {
    
    private static Game game;

    @Override
    public void restored() {
        this.game = new Game();
    }

}
