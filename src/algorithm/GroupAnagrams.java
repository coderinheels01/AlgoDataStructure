package algorithm;

import java.util.*;

public class GroupAnagrams {

    /*
     * 1. create a HashMap of String key and list String value
     * 2. loop the input strings one by one.
     * 3. create a 26 char map of each string.
     * 4. convert it into String format. This is important because Java will think two char arrays are not the same
     *    even if they have the same values but two different objects.
     * 5. check if the converted version of string is in the HashMap, if yes then add the current String to the map.
     * 6. return the new ArrayList with map.values(), this will return nested array list
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N);
     *
     * https://leetcode.com/problems/group-anagrams/
     *
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }
            String str= String.valueOf(hash);

            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String ...args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println("----- ORIGINAL STRINGS -----");
        Arrays.stream(strs).forEach(s -> System.out.print(s + " , "));

        groupAnagrams(strs).stream().forEach(
                list -> {
                    list.stream().forEach(s -> System.out.print(s + ","));
                    System.out.println();
                }
        );


    }
}
