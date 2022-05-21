package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public static void main(String... args){
        String input = "pwwkew";
//        System.out.println("Longest sub-string for input "+ input +" is " + findLongestSubstring(input));
//        System.out.println("Longest sub-string length for input "+ input +" is " + findLongestSubstringLength(input));
     //   input = "abcabcbb";
    //        System.out.println("Longest sub-string for input "+ input +" is " +
    // findLongestSubstring(input));
    //        System.out.println("Longest sub-string length for input "+ input +" is " +
    // findLongestSubstringLength(input));
      //      input = "bbbbb";
      //        input = "dvdfd";
    //        System.out.println("Longest sub-string for input "+ input +" is " +
    // findLongestSubstring(input));
    //        System.out.println("Longest sub-string length for input "+ input +" is " +
    // findLongestSubstringLength(input));
    System.out.println(longestSubstring(input));
    }

    public static int longestSubstring(String s){
        String maxSubString = "";
        String currentSubstring = "";
        int i =0;
        int startIndex = 0;
        while( i < s.length() ){
            if( i < s.length()  && i > 0 && currentSubstring.indexOf(s.charAt(i)) != -1 ){
                startIndex = i-1;
                i = startIndex+1;
            }
            if(currentSubstring.indexOf(s.charAt(i)) == -1 )
                 currentSubstring = s.substring( startIndex, i+1);
            if( currentSubstring.length() > maxSubString.length() ){
                maxSubString = currentSubstring;
                i++;
            }
        }
        return maxSubString.length();
    }

    public static int findLongestSubstringLength(String input){
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();
        int slowPointer = 0;
        int fastPointer = 0;

        while(fastPointer < input.length()){
            char value = input.charAt(fastPointer);
            if(!seen.contains(value)){
                seen.add(value);
                fastPointer++;
                maxLength = Math.max(maxLength, seen.size());
            }
            else{
                seen.remove(input.charAt(slowPointer));
                slowPointer++;
            }
        }

        return maxLength;
    }

    public static String findLongestSubstring(String input){
        String longestSubstring = "";
        String substring = "";
        Map<String, Integer> lookupMap= new HashMap<>();
        int lastIndex =0;

        for(int i =0; i< input.length(); i++){
            String current = input.substring(i, i+1);
            if(lookupMap.containsKey(current)){
                substring =input.substring(lastIndex, i);
                if( substring.length() > longestSubstring.length() )
                    longestSubstring = substring;
                lastIndex = i;
            }
            else{
                lookupMap.put(current, i);

            }
        }
        return longestSubstring;
    }
}
