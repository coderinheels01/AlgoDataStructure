package algorithm;

import algorithm.util.PrintUtil;

public class SingleNumber {

    /*
     * The solution wants O(N) Time complexity  with O(1) space complexity.
     * so we are using XOR bit manipulation.
     *
     * 0 ^ 1 = 1  ( then set to result )
     * 1 ^ 1 = 0  ( if we see 1 again XOR will gives 0)
     *
     * Input: nums = [2,2,1]
     * Output: 1
     *
     * Time Complexity : O(N)
     * Space Complexity: O(1)
     *
     * https://leetcode.com/problems/single-number/
     * https://www.youtube.com/watch?v=eXl0HBm2RrA&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=57
     */
    public static int singleNumber(int[] nums) {
        int result =0;
        for(int n : nums){
            result ^= n;
        }
        return result;
    }
    public static void main(String ...args){
        int[] nums = {2,2,1};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("the number that is not duplicate is : " + singleNumber(nums));

        int[] nums2 = {4,1,2,1,2};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums2);
        System.out.println("the number that is not duplicate is : " + singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums3);
        System.out.println("the number that is not duplicate is : " + singleNumber(nums3));
    }
}
