/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity;

import dk.sdu.se4.common.entity.parts.EntityPart;
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
public class EntityTest {
    
    public EntityTest() {
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
     * Test of getId method, of class Entity.
     */
    @Test
    public void testGetId() {
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getId();
        System.out.println(result);
        assertNotEquals(expResult, result);
        assertNotNull(instance);
        
        
    }

    /**
     * Test of addPart method, of class Entity.
     */
    @Test
    public void testAddPart() {
        Entity instance = new Entity();
        instance.addPart(new TestPart());
        TestPart testPart = instance.getPart(TestPart.class);
        assertNotNull("Map null", testPart);
    }

    /**
     * Test of removePart method, of class Entity.
     */
    @Test
    public void testRemovePart() {
        TestPart partClass = new TestPart();
        Entity instance = new Entity();
        instance.addPart(partClass);
        assertNotNull("Map  null", instance.getPart(TestPart.class));
        instance.removePart(partClass.getClass());
        assertNull("Map not null", instance.getPart(TestPart.class));
        
        
    }

    /**
     * Test of getPart method, of class Entity.
     */
    @Test
    public void testGetPart() {
        EntityPart partClass = new TestPart();
        Entity instance = new Entity();
        instance.addPart(partClass);
        EntityPart expResult = partClass;
        TestPart result = instance.getPart(TestPart.class);
        assertSame(expResult, result);
        
    }
    
}
