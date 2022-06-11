package algorithm;

import algorithm.util.PrintUtil;

public class TwoSumII {
    /*
     * using two pointer technique
     * 1. sum two numbers of left pointer and right pointer
     * 2. if the sum is same as target return the indexes
     * 3. if the sum is less than target then move the start pointer by one
     * 4. if the sum is great than target then move the end pointer by one
     * 5. at the end after checking all the numbers, return {-1, -1} as index
     *
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     *
     */
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if( sum == target)
                return new int[]{start, end};
            else if (sum < target) {
                start++;
            }
            else {
                end--;
            }

        }
        return new int[]{-1,-1};
    }

    public static void main(String ...args){
        int[] numbers = {2,7,11,15};
        int target = 9;

        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(numbers);
        System.out.println("----- indexes of two sum -----");
        PrintUtil.printIntArrayWithoutName(twoSum(numbers, target));
    }
}
