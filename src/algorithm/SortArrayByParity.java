package algorithm;

import algorithm.util.PrintUtil;

public class SortArrayByParity {

    /*
     * 1. loop each number in nums array.
     * 2. check if each number is even number. Note: a number is even if it's divisible by 2. In other word ( number % 2 == 0 ) ? then it is even
     * 3. otherwise it is odd.
     * 4. using two pointers technique. one pointing beginning of the array and the other one at the end. move them accordingly.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/sort-array-by-parity/
     * https://www.youtube.com/watch?v=y8ZlZNG4T8Y&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=56
     */
    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int p1 =0;
        int p2 = n-1;

        for(int i=0; i< n; i++){
            if(nums[i] % 2 == 0){
                result[p1] = nums[i];
                p1++;
            }
            else{
                result[p2] = nums[i];
                p2--;
            }
        }

        return result;
    }

    public static void main(String ...args){
        int[] nums = {0,2,1};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("----- SORTED ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(sortArrayByParity(nums));

    }
}
