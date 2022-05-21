package algorithm;

import algorithm.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;
/*
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSumLeetcode {
    public static void main(String... args){
        int[] numbers = {2,7,11,15};
        int target = 9;

        PrintUtil.printIntArray(calculateTwoSumMethod1(numbers, target), "Method 1");
        PrintUtil.printIntArray(calculateTwoSumMethod2(numbers, target), "Method 2");
        PrintUtil.printIntArray(calculateTwoSumSortedArray(numbers, target), "Method 3");

    }

    private static int[] calculateTwoSumMethod1(int[] numbers, int target){
        for(int i=0; i< numbers.length-1; i++){
            for(int j=i+1; j< numbers.length; j++){
                if(numbers[i] +numbers[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    };
    private static int[] calculateTwoSumMethod2(int[] numbers, int target){
        Map<Integer, Integer> lookupMap = new HashMap<>();

        for(int i =0; i< numbers.length; i++ ){
           int complement = target - numbers[i] ;
           if(lookupMap.containsKey(complement))
               return new int[]{i, lookupMap.get(complement)};
           else
               lookupMap.put(numbers[i], i);
        }
        return new int[]{};
    };
    /*
     * This solution works only with sorted array.
     *
     * 1. loop the sorted input array
     * 2. create two pointers at the upper end and lower end.
     * 3. sum the two numbers of upper end and lower end,
     *    if the sum is bigger than target, move the upper pointer
     *    if the sum is smaller than target, move the lower pointer
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static int[] calculateTwoSumSortedArray(int[] numbers, int target){
      int pointerOne = 0;
      int pointerTwo = numbers.length -1;

      while(pointerOne < pointerTwo){
          int sum = numbers[pointerOne] + numbers[pointerTwo];
          if(sum > target){
              pointerTwo--;
          }
          else if(sum < target){
            pointerOne++;
          }
          else{
              return new int[]{pointerOne+1, pointerTwo+1};
          }
      }
      return new int[]{};
    };
}
