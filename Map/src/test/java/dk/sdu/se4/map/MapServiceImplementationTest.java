/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.map;

import dk.sdu.se4.common.entity.Entity;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickl
 */
public class MapServiceImplementationTest {
    
    public MapServiceImplementationTest() {
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
     * Test of getHeight method, of class MapServiceImplementation.
     */
    @Test
    public void testGetHeight() {
        MapServiceImplementation instance = new MapServiceImplementation();
        int expResult = 600;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class MapServiceImplementation.
     */
    @Test
    public void testGetWeight() {
        MapServiceImplementation instance = new MapServiceImplementation();
        int expResult = 600;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntity method, of class MapServiceImplementation.
     */
    @Test
    public void testAddEntity() {
        MapServiceImplementation instance = new MapServiceImplementation();
        
        assertTrue(instance.getEntities().isEmpty());
        assertEquals(0, instance.getEntities().size());
        
        Entity entity = new Entity();
        instance.addEntity(entity);
        
        assertTrue(!instance.getEntities().isEmpty());
        assertEquals(1, instance.getEntities().size());
        assertEquals(entity, instance.getEntities().toArray()[0]);
    }

    /**
     * Test of getEntities method, of class MapServiceImplementation.
     */
    @Test
    public void testGetEntities_0args() {
        MapServiceImplementation instance = new MapServiceImplementation();
        Collection<Entity> result = instance.getEntities();
        assertEquals(0, result.size());
    }

    /**
     * Test of getEntities method, of class MapServiceImplementation.
     */
    @Test
    public void testGetEntities_Class() {
        MapServiceImplementation instance = new MapServiceImplementation();
        Collection<Entity> expResult = new ArrayList();
        Collection<Entity> result = instance.getEntities(Entity.class);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeEntity method, of class MapServiceImplementation.
     */
    @Test
    public void testRemoveEntity() {
        MapServiceImplementation instance = new MapServiceImplementation();
        
        Entity entity = new Entity();
        
        instance.addEntity(entity);
        
        assertTrue(!instance.getEntities().isEmpty());
        
        instance.removeEntity(entity);
        
        assertTrue(instance.getEntities().isEmpty());
    }

    /**
     * Test of removeEntities method, of class MapServiceImplementation.
     */
    @Test
    public void testRemoveEntities() {
        Collection<Entity> removeEntities = new ArrayList();
        MapServiceImplementation instance = new MapServiceImplementation();
        instance.removeEntities(removeEntities);
    }
    
}
