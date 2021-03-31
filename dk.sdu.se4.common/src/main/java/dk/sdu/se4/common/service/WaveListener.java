package dk.sdu.se4.common.service;

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
