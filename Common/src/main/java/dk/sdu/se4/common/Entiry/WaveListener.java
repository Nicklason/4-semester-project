/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.Entiry;

import dk.sdu.se4.common.Data.GameData;
import dk.sdu.se4.common.Data.World;

/**
 *
 * @author steff
 */
public interface WaveListener {
    void Started(World world, GameData gameData);
    void Ended(World World, GameData gameData);
}
