/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steff
 */
public class ServicesStorage {
    private static final List<PluginService> pluginservicesList = new ArrayList<PluginService>();
    private static final List<ProcessorService> processorServicesList = new ArrayList<ProcessorService>();
    private static final List<PostProcessorService> postProcessorServicesList = new ArrayList<PostProcessorService>();

    public ServicesStorage() {
    }
    
    
    
    public void addPluginService(PluginService pluginService){
        this.pluginservicesList.add(pluginService);
        pluginService.load();
    }
    
    public void addPostProcessorService(PostProcessorService postProcessorService){
        this.postProcessorServicesList.add(postProcessorService);
    }
    
    public void addProcessorService(ProcessorService processorService){
        this.processorServicesList.add(processorService);
        
    }
    public void removePluginService(PluginService pluginService){
        this.pluginservicesList.add(pluginService);
        pluginService.load();
    }
    
    public void removePostProcessorService(PostProcessorService postProcessorService){
        this.postProcessorServicesList.add(postProcessorService);
    }
    
    public void removeProcessorService(ProcessorService processorService){
        this.processorServicesList.add(processorService);
        
    }
    
    public void updateProcessServices(){
        for (PostProcessorService postProcessorService: this.postProcessorServicesList){
            postProcessorService.process();
        }
        for (ProcessorService processorService: this.processorServicesList){
            processorService.process();
        }
        
    }
    
}
