/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import dk.sdu.se4.common.service.PostProcessorService;

/**
 *
 * @author steff
 */
public class TestPostProcessorService implements PostProcessorService {

    public void process() {
        System.out.println("PostProcessorService is called");
    }

}
