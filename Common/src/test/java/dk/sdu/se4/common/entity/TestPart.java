/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity;

import dk.sdu.se4.common.data.GameData;
import dk.sdu.se4.common.data.World;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.parts.EntityPart;

/**
 *
 * @author steff
 */
public class TestPart implements EntityPart {

    private String name = "TestPart";

    public TestPart() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TestPart{" + "name=" + name + '}';
    }

    public void process(Entity entity) {

    }

}
