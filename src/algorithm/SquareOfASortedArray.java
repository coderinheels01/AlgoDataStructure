package algorithm;

import algorithm.util.PrintUtil;

public class SquareOfASortedArray {

    /*
     * 1. using two pointers, one pointer pointing the beginning of the array
     * and another pointing the end of the array.
     * 2. loop while pointer i is less than equal to pointer j.
     * 3. check if the square of one number is greater than the other,
     *    if yes then put the bigger number at the end of the result array.
     *    and increment relevant pointer.
     * 4. always increment the result array pointer.
     * 5. return the result array.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
     * https://www.youtube.com/watch?v=PN68qx-Qkdw&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=29
     *
     */
    public static int[] sortedSquare(int[] nums){
        int i=0, j = nums.length-1;
        int[] result = new int[nums.length];
        int k= nums.length-1;
        int squareNumber1;
        int squareNumber2;

        while(i <= j){
            squareNumber1 = nums[i] * nums[i];
            squareNumber2= nums[j] * nums[j];
            if( squareNumber1 > squareNumber2){
                result[k]= squareNumber1;
                i++;
            }
            else{
                result[k]= squareNumber2;
                j--;
            }
            k--;
        }
        return result;
    }
    public static void main(String ...args){
        int[]  nums = {-4,-1,0,3,10};
        System.out.println(" ----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArray(nums, "original");
        PrintUtil.printIntArray(sortedSquare(nums), "square");

        int[] nums2 = {-7,-3,2,3,11};
        System.out.println(" ----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArray(nums2, "original");
        PrintUtil.printIntArray(sortedSquare(nums2), "square");
    }
}
