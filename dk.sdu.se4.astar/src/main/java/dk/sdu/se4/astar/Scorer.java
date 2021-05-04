/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.part.PositionPart;

/**
 *
 * @author steff
 */
public interface Scorer {
    
    float calculate(PositionPart from, PositionPart to);
}
