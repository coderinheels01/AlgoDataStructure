package algorithm;
import algorithm.util.PrintUtil;

import java.util.Arrays;

public class ArrayPartitionI {

    /*
     *
     * https://leetcode.com/problems/array-partition-i/
     * https://www.youtube.com/watch?v=Qmh3k8l-bIc&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=59
     *
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i< nums.length-1; i+=2){
            sum += nums[i];
        }
        return sum;
    }
    public static void main(String ...args){
        int[] nums = {1,4,3,2};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("maximized sum : " + arrayPairSum(nums));

        int[] nums2 = {6,2,6,5,1,2};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums2);
        System.out.println("maximized sum : " + arrayPairSum(nums2));
    }
}
