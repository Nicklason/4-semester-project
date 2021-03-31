package dk.sdu.se4.common.service;

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
