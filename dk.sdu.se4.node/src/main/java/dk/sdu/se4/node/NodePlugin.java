/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.node;

import dk.sdu.se4.commonnode.Node;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Kasper
 */
public class NodePlugin implements PluginService {

    private Entity[] nodes;
    private int height;
    private int width;
    protected MapService mapService=null;
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    private int x, y = 32;

    public NodePlugin() {
    }
    
    
    
    @Override
    public void load() {
        if(this.mapService != null) {
            this.height = this.mapService.getHeight();
            this.width = this.mapService.getWidth();
            nodes = new Entity[(this.height/32)*(this.width/32)];
            for(int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node();
                nodes[i].addPart(new ImagePart(new File("../dk.sdu.se4.node/src/main/resources/img/200m.PNG"), 32, 32));
                x*=i;
                y*=i; 
                nodes[i].addPart(new PositionPart(x, y));
                this.mapService.addEntity(nodes[i]);
            }
        }
    }

    @Override
    public void unload() {
        for(Entity e : this.mapService.getEntities(Node.class)) {
            this.mapService.removeEntity(e);
        }
        nodes = null;
    }
    
    public void addMapService(MapService mapService) {
        log.debug("Add Mapservice on {}", this.getClass());
        this.mapService = mapService;
    }

    public void removeMapService(MapService mapService) {
        log.debug("Remove Mapservice from {}", this.getClass());
        this.mapService = null;
    }
}
