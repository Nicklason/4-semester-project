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
public interface WaveListener {

    /**
     * Method called when a wave has started
     */
    void waveStarted();

    /**
     * Method called when a wave has ended
     */
    void waveEnded();
}
