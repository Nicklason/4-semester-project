/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
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
public class ServicesStorageIT {

    public ServicesStorageIT() {
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
     * Test of updateProcessServices method, of class ServicesStorage.
     */
    @Test
    public void testUpdateProcessServices() {
        ServicesStorage instance = new ServicesStorage();
        PostProcessorService testPostProcessorService = new TestPostProcessorService();
        ProcessorService testProcessorService = new TestProcessorService();
        instance.addPostProcessorService(testPostProcessorService);
        instance.addProcessorService(testProcessorService);
        instance.updateProcessServices();

    }

}
