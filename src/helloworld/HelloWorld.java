/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import static kiss.API.*;

/**
 *
 * @author bwstevens
 */
public class HelloWorld {
    void testRun(){
        outExpect("Hello World!");
        run();
        outClose();
    }
    
    void run() {
        println("Hello World!");
    }
    }

       
    

