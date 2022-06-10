package algorithm;

import algorithm.util.PrintUtil;

public class ProductOfArrayExceptSelf {
    /*
     *  left and right product O(N) space solution.
     * 1. assign left[0] with 1 so we won't get zero value when multiplied.
     * 2. starting from index 1, calculate product of left and nums at index - 1 and assign it to left[index].
     * 3. starting from index n-1, calculate product of right and nums at n-1 and assign it to right[n-2];
     * 4. loop the nums once again and assing product of left and right array to the result.
     *
     * Time Complexity : O(N)
     * Space Complexity :O(N)
     *
     * https://leetcode.com/problems/product-of-array-except-self/
     * 
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - i];
        }
        for(int i=0; i< nums.length; i++){
            result[i] = left[i] * right[i];
        }

        return result;
    };

    /*
     * Optimized version. O(1) space solution
     * 1. assign result[0] with 1.
     * 2. calculate right value by multiplying numbers[i] into right.
     * 3. at the next round copy to result[i]
     * 4. return result
     *
     * Time Complexity : O(N)
     * Space Complexity :O(1)
     */
    public static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for(int i =1; i< n; i++){
            result[i] =  result[i-1] *  nums[i-1];
        }

        int right = 1;

        for(int i = n-1; i >=0; i--){
            result[i] *= right;
            right *= nums[i];
        }
      return result;
    };

    public static void main(String ...args){
        int[] nums = {1,2,3,4};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("----- RESULT ARRAY -----");
        PrintUtil.printIntArrayWithoutName(productExceptSelf(nums));
        System.out.println("----- RESULT ARRAY OPTIMIZED-----");
        PrintUtil.printIntArrayWithoutName(productExceptSelfOptimized(nums));
    }
}
