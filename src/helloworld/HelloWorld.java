/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import static kiss.API.*;

/**
 *
 * @author bwstevens
 */
//Blake Stevens
public class HelloWorld {

    void testRun() {
        //try with resources
        try (Close out = outExpect("Hello World!")) {
            run();
        }

        outExpect("Hello World!");
        run();
        outClose();
    }

    void run() {
        println("Hello World!");
    }

    void testBooleans() {
        assert true != false;
        assert true == true;
        assert false == false;
        try (Close out = outExpect("true")) {
            println(true);
        }
        try (Close out = outExpect("false")) {
            println(false);
        }

        // not
        assert !true == false;
        assert !false == true;

        // and
        assert (true && true) == true;
        assert (true && false) == false;
        assert (false && true) == false;
        assert (false && false) == false;

        assert (false && (random(0, 1) == 1)) == false;
        assert (false && (random(0, 1) == 1)) == false;
        assert (false && (random(0, 1) == 1)) == false;

        assert (false && (1 / 0 == 3)) == false;

        // or
        assert (true || true) == true;
        assert (true || false) == true;
        assert (false || true) == true;
        assert (false || false) == false;

        assert (true || (random(0, 1) == 1)) == true;
        assert (true || (random(0, 1) == 1)) == true;
        assert (true || (random(0, 1) == 1)) == true;

        assert (true || (1 / 0 == 3)) == true;

    }

    void sideEffect(int y) {
        println(y);
    }

    void testInts() {
        assert Integer.MAX_VALUE == Math.pow(2, 31) - 1;
        println(Integer.MAX_VALUE);
        assert Integer.MAX_VALUE == 2_147_483_647;
        assert Integer.MAX_VALUE == 0b0111_1111_1111_1111_1111_1111_1111_1111;

        assert Integer.MIN_VALUE == -Math.pow(2, 31);
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
        assert Integer.toString(x, 10).equals("3");
        assert Integer.toString(y, 16).equals("ffff");
        assert Integer.toString(z, 2).equals("1001");

        assert 17 / 5 == 3;
        assert ((double) 17) / ((double) 5) == 3.4;
        // convert then divide

        assert 17 % 5 == 2;
        assert -7 % 5 == -2;

        int a = 1;
        ++a;

        try (Close out = outExpect("2")) {
            println(a);
        }

        try (Close out = outExpect("3")) {
            println(++a);
        }
        try (Close out = outExpect("3")) {
            println(a);
        }

        try (Close out = outExpect("3")) {
            println(a++);
        }
        try (Close out = outExpect("4")) {
            println(a);
        }

        //~ is bitwise not
        assert ~0b0000_0000_0000_0000_0000_0000_1111_0000
                == 0b1111_1111_1111_1111_1111_1111_0000_1111;

        ///single & is a bitwise and. use to force certain things off
        assert (0b1111_0000
                & 0b1010_1010)
                == 0b1010_0000;

        //bitwise or use to force certain thing on
        assert (0b111_0000
                | 0b1010_1010)
                == 0b1111_1010;

        //bit shift operator
        assert (0b1010_1111_0000 >> 4)
                == 0b1010_1111;

        //bit shift operator
        assert (0b1010_1111_0000 << 4)
                == 0b1010_1111_0000_0000;

        //seed(); re seeds the random generator. In kiss framework 
        //it will always generate the same sequence so its the same number for tests
        int b = random(0, 1_000_000);
        assert ((b >> 1) == b / 2);
        assert (((-b) >> 1) == -b / 2);
        assert ((b << 1) == 2 * b);
        assert (((-b) << 1) == 2 * (-b));

        int c = random(-1_000_000, 1_000_000);
        assert ((~c) + 1) == -c;

        assert -2 == 0b1111_1111_1111_1111_1111_1111_1111_1110;
        //right shifts shift the sign bit in (which is the highest order bit)
        assert (-2 >> 1) == 0b1111_1111_1111_1111_1111_1111_1111_1111;
        println(Integer.toString(-2, 2));

    }

    void testConvert() {
        byte x = -1;
        assert x == (byte) 0b1111_1111;
        int y = x;
        assert y == -1;
        assert 0b1111_1111_1111_1111_1111_1111_1111_1111
                == (int) (byte) 0b1111_1111;
    }

    //loops
    void testLoop() {
        try (Close out = outExpect(0, EOL, 1, EOL, 2, EOL, 3, EOL)) {
            int n = 4;
            int i = 0;
            while (i < n) {
                println(i);
                ++i;
             }
            }
        //cotinue goes right back to the conditional statment and run again
             try (Close out = outExpect(0, EOL, 1,EOL, 3, EOL)) {
            int n = 4;
            int i = 0;
            while (i < n) {
                if (i == 2) { ++i; continue;}
                 println(i);
                ++i;
             }
            }
             
             try (Close out = outExpect(0, EOL, 1, EOL)) {
            int n = 4;
            int i = 0;
           while (i < n) {
               if (i == 2){ 
                   break;
               }
                 println(i);
              ++i;
             }
           } 
        
              try (Close out = outExpect(0, EOL, 1, EOL, 2, EOL, 3, EOL)) {
            int n = 4;
            for (int i = 0; i < n; ++i) {
                println(i);
            }
           }
              //continue for a for loop  already know what the bump statemnet is
               try (Close out = outExpect(0, EOL, 1, EOL, 3, EOL)) {
            int n = 4;
            for (int i = 0; i < n; ++i) {
                 if (i == 2) continue;
                println(i);
            }
           }
               //break stops it and doesnt go to case 3
               try (Close out = outExpect(0, EOL, 1, EOL)) {
            int n = 4;
            for (int i = 0; i < n; ++i) {
                 if (i == 2) break;
                println(i);
            }
           }
               
               String [] words = new String[] { "this", "that", "other"};
               assert words[0].equals("this");
               assert words[1].equals("that");
               assert words[2].equals("other");
               assert words.length == 3;
               
               String [] nouns = new String[2];
               assert nouns[0] == null;
               assert nouns[1] == null;
               assert nouns.length == 2;
               
             try (Close out = outExpect("this", EOL, "that", EOL, "other", EOL)){
               for (int i = 0; i<words.length; ++i) {
                   println(words[i]);
               }
             }
             
             try (Close out = outExpect("this", EOL, "that", EOL, "other", EOL)){
               for (String word : words) {
                   println(word);
               }
             }
        }
    
        //local stays at 1 because its on stack and every call its 
        //a new "localValue starting at zero" (its on the stack)
        //instanceValue increments because its on the hep not the stack
        int instanceValue = 0;
        
        void methodExample() {
        int localValue = 0;
        ++instanceValue;
        ++localValue;
        println("I",instanceValue,"L",localValue);
        }
        
        long factorial(int n){
            if (n > 1){
                return n*factorial(n-1);
            } else {
                return 1;
            }
        }
        
        void testFunctions(){
            try (Close out = outExpect(
                    "I",1,"L",1,EOL,
                    "I",2,"L",1,EOL,
                    "I",3,"L",1,EOL)) {
            methodExample();
            methodExample();
            methodExample();
          }
            
            assert factorial(1) == 1;
            assert factorial(5) == 120;
        }
        
        void testString(){
        String hi = "hello";
        assert hi.length() == 5;
        assert hi.substring(1,3).equals("el"); //[a,b)
        
        hi = hi +"wolrd";
        
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("world");
        sb.append(" #");
        sb.append(13);
        String hw = sb.toString();
        
        println(hw);      
      }
        
        void testClock(){
            Clock clock = test(new Clock());
        }
        
        void testTimeZoneClock(){
            TimeZoneClock tzClock = testAlways(new TimeZoneClock());
        }
        
        void testBoxing(){
            Integer x = new Integer(3);
            Integer y = x;
            ++x;
            //x = new Integer(x.intValue()+1);
            assert x == 4;
            assert y == 3;
            assert y != new Integer(3);
            assert y.equals(new Integer(3));
            assert y.compareTo(new Integer(3)) == 0;
        }
        
        //inner class
       public class Reverse implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
        return -a.compareTo(b);
        }
       }
        
        void testArrayListInt(){
            ArrayList<Integer> ages = new ArrayList<Integer>();
            ages.add(3);
            ages.add(17);
            ages.add(100);
            
            for(int age : ages){
                println(age);
            }
            
            ages.sort(new IntegerReverse()); //just a class
            ages.sort(new Reverse()); // inner class
            ages.sort(new Comparator<Integer>() { //anonymous inner class
                 @Override
                 public int compare(Integer a, Integer b){
                    return -a.compareTo(b);
                 }
            });
            
            ages.sort((a,b) -> { return -a.compareTo(b);}); //lambda (anonymous funciton)
               for(int age : ages){
                println(age);
            }
        }
       
       void testSet(){
        Set<String> pets = new HashSet<String>();
        
        pets.add("fluffy");
        pets.add("pookie");
        pets.add("pupper");
        pets.add("doge");
        pets.add("pepe");
        
        try (Close out = outExpect("pupper",EOL,"doge",EOL,"pookie",EOL,"fluffy",EOL,"pepe",EOL)){
        
        for( String pet: pets) {
            println(pet);
         }
        }
       }
       
       void testTreeSet(){
                Set<String> pets = new TreeSet<String>();
        
        pets.add("fluffy");
        pets.add("pookie");
        pets.add("pupper");
        pets.add("doge");
        pets.add("pepe");
        
        try (Close out = outExpect("doge",EOL,"fluffy",EOL,"pepe",EOL,"pookie",EOL,"pupper",EOL)){
        
        for( String pet: pets) {
            println(pet);
         }
        }
       }
       
       void testHashMap(){
           Map<String, Integer> petAges = new HashMap<String, Integer>();
           
           petAges.put("fluffy", 7);
           petAges.put("pookie", 2);
           petAges.put("pupper", 100);
           petAges.put("doge", 3);
           petAges.put("pepe", 83);
           
           try (Close out = outExpect("petAges[pupper]=100",EOL,"petAges[doge]=3",
                   EOL,"petAges[pookie]=2",EOL,"petAges[fluffy]=7",EOL,"petAges[pepe]=83",EOL)) {
           for (String key : petAges.keySet()) {
               println("petAges[" + key + "]=" + petAges.get(key));
           }
           }
           
            for (String key : petAges.keySet()) {
               petAges.put(key,petAges.get(key)+1);
               
           }
            
            try (Close out = outExpect("petAges[pupper]=101",EOL,"petAges[doge]=4",
                   EOL,"petAges[pookie]=3",EOL,"petAges[fluffy]=8",EOL,"petAges[pepe]=84",EOL)) {
                 for (String key : petAges.keySet()) {
               println("petAges[" + key + "]=" + petAges.get(key));
           }
          }
       }
       
              void testTreeMap(){
           Map<String, Integer> petAges = new TreeMap<String, Integer>();
           
           petAges.put("fluffy", 7);
           petAges.put("pookie", 2);
           petAges.put("pupper", 100);
           petAges.put("doge", 3);
           petAges.put("pepe", 83);
           
           try (Close out = outExpect("petAges[doge]=3",EOL,"petAges[fluffy]=7",
                   EOL,"petAges[pepe]=83",EOL,"petAges[pookie]=2",EOL,"petAges[pupper]=100",EOL)) {
           for (String key : petAges.keySet()) {
               println("petAges[" + key + "]=" + petAges.get(key));
           }
           }
           
            for (String key : petAges.keySet()) {
               petAges.put(key,petAges.get(key)+1);
               
           }
            
            try (Close out = outExpect("petAges[doge]=4",EOL,"petAges[fluffy]=8",
                   EOL,"petAges[pepe]=84",EOL,"petAges[pookie]=3",EOL,"petAges[pupper]=101",EOL)) {
                 for (String key : petAges.keySet()) {
               println("petAges[" + key + "]=" + petAges.get(key));
           }
          }
       }
              
       void doStuff() throws IOException {
           throw new IOException("bad stuff happened");
       };
       void doOtherStuff() {};
       
       void testException(){
           try {
               doStuff();
           } catch (IOException ex) {
               
           }
       }      
       
       void testException2() throws IOException {
           doStuff();
       }
       void testLinkedList(){
           List<String> names = new LinkedList<String>();
           
           boolean pass = false;
           try {
               println(names.get(0));
           } catch (IndexOutOfBoundsException ex) {
              pass = true;
           }
           assert pass == true;
           
           names.add("doge");
           names.add("fluffy");
           names.add("pepe");
           names.get(names.size()-1);
           assert names.get(names.size()-1).equals("pepe");
           
           String[] a = new String[3];
           a[0]="doge";
           assert (a[0].equals("doge"));
           assert (a[1] == null);
           assert (a[2] == null);
       }
       
       void testCollection(){
           Collection<Integer> c = new LinkedList<Integer>();
           c.add(3);
           c.add(3);
           c.add(1);
           c.add(7);
           c.add(2);
           
           assert c.contains(3) == true;
           
           c.remove(3);
           
           //assert c.contains(3) == false;
           
           /*try (Close out = outExpect(1,EOL,7,EOL,2,EOL)){
           Iterator<Integer> i = c.iterator();
           while(i.hasNext()) {
               Integer value = i.next();
               println(value);
           }
        }
           
           try (Close out = outExpect(1,EOL,7,EOL)){
               for (Integer value : c){
                   println(value);
               }
           } */
     }
            
    }
