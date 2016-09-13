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
        //try with resources
        try (Close out = outExpect("Hello World!")) { run(); 
        }
        
        outExpect("Hello World!");
        run();
        outClose();
    }
    
    void run() {
        println("Hello World!");
    }
    
    void testBooleans(){
        assert true != false;
        assert true == true;
        assert false == false;
        try (Close out = outExpect("true")) { println(true);
        }
         try (Close out = outExpect("false")) { println(false);
        }
         
         // not
         
         assert !true == false;
         assert !false == true;
         
         // and
         
         assert (true && true) == true;
         assert (true && false) == false;
         assert (false && true) == false;
         assert (false && false) == false;
         
         assert (false && (random(0,1) == 1)) == false;
         assert (false && (random(0,1) == 1)) == false;
         assert (false && (random(0,1) == 1)) == false;
         
         assert (false && (1/0 ==3)) == false;
        
         // or
         
         assert (true || true) == true;
         assert (true || false) == true;
         assert (false || true) == true;
         assert (false || false) == false;
         
         assert (true || (random(0,1) == 1)) == true;
         assert (true || (random(0,1) == 1)) == true;
         assert (true || (random(0,1) == 1)) == true;
         
         assert (true || (1/0 == 3)) == true;
         
      
    
    }
 
    void sideEffect(int y) {
        println(y);
    }
    void testInts(){
        assert Integer.MAX_VALUE == Math.pow(2,31)-1;
        println(Integer.MAX_VALUE);
        assert Integer.MAX_VALUE == 2_147_483_647;
        assert Integer.MAX_VALUE == 0b0111_1111_1111_1111_1111_1111_1111_1111;
        
        
        assert Integer.MIN_VALUE == -Math.pow(2,31);
        assert Integer.MIN_VALUE == -2_147_483_648;
        assert Integer.MIN_VALUE == 0b01000_0000_0000_0000_0000_0000_0000_0000;
        
        assert Integer.MIN_VALUE - 1 == Integer.MAX_VALUE;
        assert Integer.MAX_VALUE + 1 == Integer.MIN_VALUE;
        
        
        int x = 3;
        //hex
        int y = 0xffff;
        //binary
        int z = 0b10_01;
        
        assert x == 3;
        assert y == 65_535;
        // same as
        assert y == 65535;
        assert z == 9;
         // .eqauls compare object references
         //Integer is a class that comes with cool stuff
       assert Integer.toString(x,10).equals("3");
       assert Integer.toString(y,16).equals("ffff");
       assert Integer.toString(z,2).equals("1001");
       
       assert 17/5 == 3;
       assert ((double) 17)/((double) 5) == 3.4;
       // convert then divide
       
       assert 17 % 5 == 2;
       assert -7 % 5 == -2;
       
       
       int a = 1;
       ++a;
       
       try(Close out = outExpect("2")) {println(a); }
       
       try(Close out = outExpect("3")) { println(++a); }
       try(Close out = outExpect("3")) { println(a); }
       
       try(Close out = outExpect("3")) { println(a++); }
       try(Close out = outExpect("4")) { println(a); }
       
       //~ is bitwise not
       assert ~0b0000_0000_0000_0000_0000_0000_1111_0000
            == 0b1111_1111_1111_1111_1111_1111_0000_1111;
       
       ///single & is a bitwise and. use to force certain things off
       assert (0b1111_0000 
            &  0b1010_1010) == 
               0b1010_0000;
       
       //bitwise or use to force certain thing on
       assert (0b111_0000
             | 0b1010_1010) ==
               0b1111_1010;
       
       //bit shift operator
       assert (0b1010_1111_0000 >> 4) ==
                    0b1010_1111;
       
       //bit shift operator
       assert (0b1010_1111_0000 << 4) ==
          0b1010_1111_0000_0000;
       
       //seed(); re seeds the random generator. In kiss framework 
       //it will always generate the same sequence so its the same number for tests
       int b = random(0, 1_000_000);
       assert ((b >> 1) == b/2 );
       assert (((-b) >> 1) == -b/2 );
       assert ((b << 1) == 2*b);
       assert (((-b) << 1) == 2*(-b));
       
       int c = random(-1_000_000, 1_000_000);
       assert ((~c)+1) == -c;
       
       assert -2 ==        0b1111_1111_1111_1111_1111_1111_1111_1110;
        //right shifts shift the sign bit in (which is the highest order bit)
       assert (-2 >> 1) == 0b1111_1111_1111_1111_1111_1111_1111_1111;
       println(Integer.toString(-2,2));
       
       
    }
    
    void testConvert(){
        byte x = -1;
        assert x == (byte) 0b1111_1111;
        int y = x;
        assert y == -1;
        assert 0b1111_1111_1111_1111_1111_1111_1111_1111 == 
                                (int) (byte) 0b1111_1111;
    }
    
    //loops
    void testLoop(){
        
    }
 }

       
    

