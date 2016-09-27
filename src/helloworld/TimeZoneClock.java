/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import static kiss.API.abs;
import static kiss.API.pause;

/**
 *
 * @author bwstevens
 */
public class TimeZoneClock extends Clock {
    double timezoneShift = 0.0;
    @Override
    double getHour(){
        return 0;
    }
    
    void testGetTime(){
        Clock clock = new TimeZoneClock();
        double hours = clock.getHours();
        double minutes = clock.getMinutes();
        double seconds = clock.getSeconds();
    }
    
    void testGetCorrectTime(){
        Clock clock = new TimeZoneClock();
        clock.setHours(6.50);
        assert clock.getHours() == 6.50;
        assert clock.getMinutes() == 30.0;
        assert clock.getSeconds() == 0.0;
        
    }
    
    void testGetFlowingTime(){
        Clock clock = new TimeZoneClock();
        clock.setHours(1.00);
        clock.start();
        pause(1.0);
        double now = clock.getHours();
        double shouldBe = 1.00 + 1.0/3600.0;
        assert abs(now-shouldBe) < 1.0/3600.0;
    }
}
