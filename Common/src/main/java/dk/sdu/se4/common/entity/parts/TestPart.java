/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.parts;

import dk.sdu.se4.common.data.GameData;
import dk.sdu.se4.common.data.World;
import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author steff
 */
public class TestPart implements EntityPart{    
    private String name="TestPart";

    public TestPart() {
    }
    
    public void process(World world, GameData gameData) {
        System.out.println("TEST Call");
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "TestPart{" + "name=" + name + '}';
    }
    
}
