/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primes;
import static kiss.API.*;
/**
 *
 * @author bwstevens
 */
public class Primes {
    void testSmallPrimes(){
        Primes primes = new Primes();
        assert primes.isPrime(2) == true;
        assert primes.isPrime(3) == true;
        assert primes.isPrime(5) == true;
    }
    void testSmallComposites(){
        Primes primes = new Primes();
        assert primes.isPrime(4) == false;
        assert primes.isPrime(6) == false;
    }
    
    boolean isPrime(int x){
        return true;
    }
    
    void testHi(){
        println("Hi");
    }
}