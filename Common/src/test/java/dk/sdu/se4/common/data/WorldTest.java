/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

import dk.sdu.se4.common.entity.Entity;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steff
 */
public class WorldTest {
    
    public WorldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class World.
     */
    @Test
    public void testGetInstance() {
        World expResult = World.getInstance();
        World result = World.getInstance();
        assertSame(expResult, result);
        assertNotNull(result);
    }

    /**
     * Test of addEntity method, of class World.
     */
    @Test
    public void testAddEntity() {
        Entity entity = new Entity();
        World instance = World.getInstance();
        instance.addEntity(entity);
        assertTrue("Entity add to map", instance.getEntityMap().containsKey(entity.getId()));
        assertSame(instance.getEntityMap().get(entity.getId()), entity);
        
    }

    /**
     * Test of reomveEntity method, of class World.
     */
    @Test
    public void testReomveEntity() {
        Entity entity = new Entity();
        World instance = World.getInstance();
        instance.addEntity(entity);
        assertTrue("Entity add to map", instance.getEntityMap().containsKey(entity.getId()));
        instance.reomveEntity(entity);
        assertTrue("Entity removed from map", !instance.getEntityMap().containsKey(entity.getId()));
    }

    /**
     * Test of getEntityMap method, of class World.
     */
    @Test
    public void testGetEntityMap() {
        World instance = World.getInstance();
        Map<String, Entity> expResult = instance.getEntityMap();
        Map<String, Entity> result = instance.getEntityMap();
        assertEquals(expResult, result);
    }
}
