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
public class MapServiceImplTest {
    
    public MapServiceImplTest() {
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

    @Test
    public void testGetHeight() {
        MapServiceImpl instance = new MapServiceImpl();
        int expResult = 600;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWeight() {
        MapServiceImpl instance = new MapServiceImpl();
        int expResult = 600;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddEntity() {
        MapServiceImpl instance = new MapServiceImpl();
        
        assertTrue(instance.getEntities().isEmpty());
        assertEquals(0, instance.getEntities().size());
        
        Entity entity = new Entity();
        instance.addEntity(entity);
        
        assertTrue(!instance.getEntities().isEmpty());
        assertEquals(1, instance.getEntities().size());
        assertEquals(entity, instance.getEntities().toArray()[0]);
    }

    @Test
    public void testGetEntities_0args() {
        MapServiceImpl instance = new MapServiceImpl();
        Collection<Entity> result = instance.getEntities();
        assertEquals(0, result.size());
    }

    @Test
    public void testGetEntities_Class() {
        MapServiceImpl instance = new MapServiceImpl();
        Collection<Entity> expResult = new ArrayList<>();
        Collection<Entity> result = instance.getEntities(Entity.class);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveEntity() {
        MapServiceImpl instance = new MapServiceImpl();
        
        Entity entity = new Entity();
        
        instance.addEntity(entity);
        
        assertTrue(!instance.getEntities().isEmpty());
        
        instance.removeEntity(entity);
        
        assertTrue(instance.getEntities().isEmpty());
    }

    @Test
    public void testRemoveEntities() {
        Collection<Entity> removeEntities = new ArrayList();
        MapServiceImpl instance = new MapServiceImpl();
        instance.removeEntities(removeEntities);
    }
    
}