package com.techelevator;

import java.util.*;

public class Example1 {

    /*
     Given a List of Strings and an Array of Strings, return the index numbers of all matching elements, i.e.
        indexes with the same value at the same index in both the List and the Array.

      findMatchingIndexes( ["foo", "bar"], ["foo", "bar"] ) → [0, 1]
      findMatchingIndexes( ["foo", "bar", "baz", "qux"], ["boo", "far", "baz", "lux"] ) → [2]
      findMatchingIndexes( ["foo", "bar"], ["bar", "foo"] ) → []
     */
    public List<Integer> findMatchingIndexes(List<String> stringList, String[] stringArray) {
        List<Integer> myIndexes = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringList.get(i).equals(stringArray[i])) {
                myIndexes.add(i);
            }
        }
        return myIndexes;
    }



    /*
     Given a List of Strings and an Array of Strings, return the elements that occur in both the List and the Array.

      findMatchingIndexes( ["foo", "bar"], ["foo", "bar"] ) → ["foo", "bar"]
      findMatchingIndexes( ["foo", "bar", "baz", "qux"], ["boo", "far", "baz", "lux"] ) → ["baz"]
      findMatchingIndexes( ["foo", "bar"], ["bar", "foo"] ) → ["foo", "bar"]
     */
    public List<String> findCommonElements(List<String> stringList, String[] stringArray) {
        List<String> myElements = new ArrayList<>();
        List<String> stringArrayToList = new ArrayList<>(Arrays.asList(stringArray));
        for (int i = 0; i < stringList.size(); i++) {
            if (stringArrayToList.contains(stringList.get(i))) {
                myElements.add(stringList.get(i));
            }
        }
        return myElements;
    }



    /*
     Given a List of Strings and an Array of Strings, return a Map whose keys are the elements of the List and
        whose values are the elements of the Array.

      mapAllElements( ["foo", "bar"], ["foo", "bar"] ) → {"foo":"foo", "bar":"bar"}
      mapAllElements( ["foo", "bar", "baz", "qux"], ["boo", "far", "baz", "lux"] ) → {"foo":"boo", "bar":"far", "baz":"baz", "qux":"lux"}
      mapAllElements( ["foo", "bar"], ["bar", "foo"] ) → {"foo":"bar", "bar":"foo"}
     */
    public Map<String, String> mapAllElements(List<String> stringList, String[] stringArray) {
        Map<String, String> output = new HashMap<>();
        for (int i = 0; i < stringList.size(); i++) {
            output.put(stringList.get(i), stringArray[i]);
        }
        return output;
    }
}
