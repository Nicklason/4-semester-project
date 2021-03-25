/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

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
public class GameDataTest {

    public GameDataTest() {
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
     * Test of getInstance method, of class GameData.
     */
    @Test
    public void testGetInstance() {
        GameData instance = GameData.getInstance();
        GameData expResult = GameData.getInstance();
        GameData result = instance.getInstance();
        assertEquals(expResult, result);
        assertSame(expResult, result);
        assertNotNull(result);
    }
}
