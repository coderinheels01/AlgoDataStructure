package algorithm;

import algorithm.util.PrintUtil;

public class KthLargestElement {

    /*
     * quick sort and return k-th largest number.
     *
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     */
    public static int kthLargestNumber(int[] nums, int k){
        if(k > nums.length)
            return -1;
        QuickSort.sort(nums);
        return nums[nums.length - k];
    }
    public static void main(String ...args){
        int[] a = {3,2,1,5,6,4};
        System.out.println("----- original array ----- ");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("2nd largest element is " + kthLargestNumber(a, 2));
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("3rd largest element is " + kthLargestNumber(a, 3));
    }
}
