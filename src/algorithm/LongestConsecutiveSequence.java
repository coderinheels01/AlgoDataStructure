package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
     * 1. put the numbers into a set.
     * 2. loop through the input array. Check if n-1 element is there.
     *    If not this is the start of our subsequent. so we store the start number and the
     *    initialize current length.
     * 3. increment current number by 1 each loop and search for all the subsequent numbers and increment the length.
     * 4. store the longest length and return it.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/longest-consecutive-sequence/
     * https://www.youtube.com/watch?v=P6RZZMu_maU
     */
    public static int longestConsecutive(Integer[] nums) {
        Set<Integer> unique = new HashSet<>(Arrays.asList(nums));
        int longest = 0;
        for(int n : nums){
            if(!unique.contains(n-1)){
                int start = n;
                int length = 1;

                while(unique.contains(start+1)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    };
    public static void main(String ...args){
        int[] nums = {100,4,200,1,3,2};
    }
}
