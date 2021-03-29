/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.services;

import com.badlogic.gdx.Screen;
import dk.sdu.se4.common.data.ScreenHolder;

/**
 *
 * @author Steffen Vitten
 */
public interface IGameScreenService extends Screen{
    
    String getScreenName();
    
    
    void ScreenProcessor(ScreenHolder screenHolder);
    
}
