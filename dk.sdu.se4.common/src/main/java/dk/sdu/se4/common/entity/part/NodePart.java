/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steff
 */
public class NodePart implements EntityPart{
    private Entity state;
    private Entity parentNode;
    private int depth;
    private float heuristics;
    private float cost;

    public NodePart(Entity state, float heuristics, float cost ) {
        this.state = state;
        this.parentNode = null;
        this.depth = 0;
        this.heuristics = heuristics;
        this.cost = cost;
        
    }

    public NodePart(Entity state, Entity parentNode, int depth, float heuristics, float cost) {
        this.state = state;
        this.parentNode = parentNode;
        this.depth = depth;
        this.heuristics = heuristics;
        this.cost = cost;
    }
    
    

    private List<Entity> path(Entity target){
        Entity current_node = state;
        List<Entity> path = new ArrayList<>();
        NodePart np = current_node.getPart(this.getClass());
        while ( np.getParentNode()!=null){
            current_node = np.getParentNode();
            path.add(current_node);
            
//            if(current_node.getPart(this.getClass()).equals(target.getPart(this.getClass()))){
//                return path;
//            }
        }
        return path;
    }

    public Entity getState() {
        return state;
    }

    public void setState(Entity state) {
        this.state = state;
    }

    public Entity getParentNode() {
        return parentNode;
    }

    public void setParentNode(Entity parentNode) {
        this.parentNode = parentNode;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getHeuristics() {
        return heuristics;
    }

    public void setHeuristics(float heuristics) {
        this.heuristics = heuristics;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    
    
    
    @Override
    public void process(Entity entity) {
       
    }
    
}
