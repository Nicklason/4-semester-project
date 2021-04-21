/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.node;

import dk.sdu.se4.common.entity.part.NodePart;
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
public class NodePlugin extends NodeCore implements PluginService {

    private Entity[][] nodes;
    private int height;
    private int width;


    private final int x = 32;
    private final int y = 32;

    public NodePlugin() {
    }
    
    
    
    @Override
    public void load() {
        if(this.mapService != null) {
            this.height = this.mapService.getHeight();
            this.width = this.mapService.getWidth();
            nodes = new Entity[(this.height/32)][(this.width/32)];
            for(int i = 0; i < nodes.length; i++) {
                for(int j = 0;j<nodes[i].length;j++){
                    nodes[i][j] = new Node();
                    int x1=x*i;
                    int y1=y*j;
                    PositionPart p = new PositionPart(x1, y1);
                    NodePart np = new NodePart();
                    np.setState(NodePart.State.UNVISITED);
                    nodes[i][j].addPart(p);
                    nodes[i][j].addPart(np);
                    this.mapService.addEntity(nodes[i][j]);
                }

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

}
