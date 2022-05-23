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
    /*
     * sliding window approach
     *
     * 1. while the right pointer is less than string length
     * 2. if character is seen before, and it falls within current window,
     *    then move the left pointer to the index right after the seen character.
     * 3. mark character as seen and put it in the hash map.
     * 4. calculate longest substring but comparing previous longest substring length with current substring length ( right - left ) + 1
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     *
     */
    public static int longestSubStringOptimized2(String s){
        if(s.length() <= 1) return s.length();

        int longestSubstr =0;

        int rightPointer = 0;
        int leftPointer = 0;

        Map<Character, Integer> seen = new HashMap<>();

        while(rightPointer < s.length()){
            Integer index = seen.get(s.charAt(rightPointer));
            if(index!= null && index >= leftPointer){
                leftPointer = index +1;
            }
            seen.put(s.charAt(rightPointer), rightPointer );
            longestSubstr = Math.max(rightPointer - leftPointer +1, longestSubstr);
            rightPointer++;
        }

        return longestSubstr;
    };


    public static int longestSubStringBruteForce(String s){
        if(s.length() <= 1)
            return s.length();

        int longestSubstr = 0;
        boolean[] seen;



        for(int i=0; i< s.length(); i++){
            int currentSubStr = 0;
            seen = new boolean[127];
            for(int j= i ; j < s.length(); j++){
                if(seen[s.charAt(j)]){
                    break;
                }
                else{
                    seen[s.charAt(j)] = true;
                    currentSubStr++;
                    if(currentSubStr > longestSubstr)
                        longestSubstr = currentSubStr;
                }
            }
        }
        return longestSubstr;
    };

    public static int longestSubStringOptimized(String s){
        if(s.length() <= 1) return s.length();

        int longestSubstr =0;
        int currentSubstr =0;
        Map<Character, Integer> seen = new HashMap<>() ;
        int index =0;

        while(index < s.length()){
            if(seen.get(s.charAt(index)) != null){
                index = seen.get(s.charAt(index));
                seen.clear();
                currentSubstr =0;
            }
            else{
                seen.put(s.charAt(index), index);
                currentSubstr++;
                longestSubstr = Math.max(currentSubstr, longestSubstr);
            }
            index++;
        }


        return longestSubstr;
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
