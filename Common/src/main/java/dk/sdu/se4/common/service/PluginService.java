/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.service;

import dk.sdu.se4.common.data.GameData;
import dk.sdu.se4.common.data.World;

/**
 *
 * @author steff
 */
public interface PluginService {
    
    void load(World world, GameData gamedata);
    void unload(World world, GameData gamedata);
}
