
import java.util.Map;
import java.util.TreeMap;
import kiss.API;
import static kiss.API.EOL;
import static kiss.API.outExpect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bwstevens
 */
public class BlakeTickList {
    
         void testrouteDescrip(){
        Map<String, Integer> tickList = new TreeMap<String, Integer>();
           
           tickList.put("Questions and Answers 5.10+", 32);
           tickList.put("Caselton Tower, North Face 5.11-", 14);
           tickList.put("Echo Pinnacle, Free Window Route 5.11a", 9);
           tickList.put("Charlie Horse Needle, Sims-Hesse-Hanning Route 5.11", 10);
           tickList.put("The Three Gossips, Be There Or Be Talked About "
                   + "5.11 C1", 16);
           
            try (API.Close out = outExpect("Tick number 14 is Blakes ascent of Caselton "
                    + "Tower, North Face 5.11-",EOL,"Tick number 10 is Blakes ascent "
                            + "of Charlie Horse Needle, Sims-Hesse-Hanning Route 5.11",
                   EOL,"Tick number 9 is Blakes ascent of Echo Pinnacle, Free Window "
                           + "Route 5.11a",EOL,"Tick number 32 is Blakes ascent of "
                                   + "Questions and Answers 5.10+",EOL,
                    "Tick number 16 is Blakes ascent of The Three Gossips, Be There "
                            + "Or Be Talked About 5.11 C1",EOL)) { 
              for(Map.Entry<String,Integer> entry : tickList.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                
                System.out.println("Tick number " + value + " is Blakes ascent of "
                + key);
            }
           }
      }
    
}
