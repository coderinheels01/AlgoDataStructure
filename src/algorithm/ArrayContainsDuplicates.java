package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Check if Array contains dupes. LeetCode 217
 *
 * https://www.youtube.com/watch?v=4oZsPXG9B94&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=3
 *
 */
public class ArrayContainsDuplicates {

    /*
     * Bruteforce method to check if array contains dupes;
     *
     * 1. sort the array using build in java sort method.
     * 2. check if two elements in adjacent indices are the same, if yes return true
     *
     * Time Complexity : O(N Log N)
     * Space Complexity : O(1)
     */
    public static boolean findDupesMethod1(int[] input){
        Arrays.sort(input);

        for(int i=0; i< input.length-1; i++){
            if(input[i] == input[i+1]){
                return true;
            }
        }
        return false;
    }

    /*
     * Improved method to check if array contains dupes;
     *
     * 1. create a set.
     * 2. loop the array elements and add each one tot he set. The add method of Set returns
     *    false if the element is already in the set. then return false
     *
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     */
    public static boolean findDupesMethod2(int[] input){
        Set<Integer> lookup = new HashSet<>();

        for(int num : input){
            if(!lookup.add(num)){
                return true;
            }
        }

        return false;
    }


    public static void main(String ...args){

    }
}
