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
public class Clock extends java.lang.Object implements Comparable<Clock> {
    
    //instance variables
    private double hours=0;
    private double minutes=0;
    private double seconds=0;
    private boolean started = false;
    private double t0;
    
    void start(){
        started = true;
        t0=time();
    }
    void setHours(double _hours){
        hours=_hours;
    }
    
    double getHours(){
        return started ? (hours + (time()-t0)/3600.0) : hours;
    }
    
    double getMinutes(){
        double _hours = getHours();
        return (_hours-Math.floor(_hours))*60.0;
    }
    
    double getSeconds(){
        double _minutes = getMinutes();
        return (_minutes-Math.floor(_minutes))*60.0;
    }
    
    void testGetTime(){
        Clock clock = new Clock();
        double hours = clock.getHours();
        double minutes = clock.getMinutes();
        double seconds = clock.getSeconds();
    }
    
    void testGetCorrectTime(){
        Clock clock = new Clock();
        clock.setHours(6.50);
        assert clock.getHours() == 6.50;
        assert clock.getMinutes() == 30.0;
        assert clock.getSeconds() == 0.0;
        
    }
    
    void testGetFlowingTime(){
        Clock clock = new Clock();
        clock.setHours(1.00);
        clock.start();
        pause(1.0);
        double now = clock.getHours();
        double shouldBe = 1.00 + 1.0/3600.0;
        assert abs(now-shouldBe) < 1.0/3600.0;
    }
    //overload
    public boolean equals(Clock clock){
        return compareTo(clock) == 0;
    }
    @Override
    public boolean equals(Object object){
      return (object instanceof Clock) && equals((Clock) object);
       
    }
    
    //eqauls compare two objects memory adresses
    void testEquals(){
        Clock clock1 = new Clock();
        Clock clock2 = clock1;
        Clock clock3 = new Clock();
        
        clock1.setHours(1.00);
        clock3.setHours(1.00);
        assert clock1.equals(clock2) == true;
        assert clock2.getHours() == 1.00;
        assert (clock1 == clock2) == true;
        assert clock1.equals(clock3) == true;
        assert (clock1 == clock3) == false;
    }

    @Override
    public int compareTo(Clock clock) {
        double delta = getHours()-clock.getHours();
        if (delta < 0) return -1;
        if (delta == 0) return 0;
        return 1;
    }
    
    
}
