/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.service;

/**
 *
 * @author steff
 */
public interface PluginService {
    /**
     * Method called when the service has been loaded
     */
    void load();
    
    /**
     * Method called when the service has been unloaded
     */
    void unload();
}
