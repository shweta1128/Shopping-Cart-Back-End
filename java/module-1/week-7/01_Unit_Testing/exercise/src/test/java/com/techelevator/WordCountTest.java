package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    @Test
    public void method_returns_no_of_times_the_strings_appears(){
        WordCount stringOfArrays = new WordCount();
      Map<String, Integer> actualResult = stringOfArrays.getCount(new String[]{"ba","ba","black","sheep"});
     // Map <String, Integer> actualResult1 = stringOfArrays.getCount( new String[]{"ba:2", "black:1", "sheep:1"}));
      Map<String , Integer> actualResult1 = new HashMap<>();
      actualResult1.put("ba", 2);
      actualResult1.put("black", 1);
      actualResult1.put("sheep", 1);

       Assert.assertEquals(actualResult, actualResult1);
    }
    @Test
    public void method_returns_no_of_times_the_strings_appears_for_empty_array(){
        WordCount stringOfArrays = new WordCount();
        Map<String, Integer> actualResult = stringOfArrays.getCount(new String[]{ });
         Map <String, Integer> expectedMap = Map.of( );


        Assert.assertEquals(actualResult, expectedMap);
    }
    @Test
    public void method_returns_no_of_times_the_strings_appears_single_letter_array(){
        WordCount stringOfArrays = new WordCount();
        Map<String, Integer> actualResult = stringOfArrays.getCount(new String[]{"a","b","c","a","c"});
        Map <String, Integer> expectedMap = Map.of("a",2,"b",1,"c",2 );


        Assert.assertEquals(actualResult, expectedMap);
    }
}

