package algorithm;

import algorithm.util.PrintUtil;

public class FindMinimumInRotatedSortedArray {

    /*
     * using binary search.
     *
     * 1. find a mid point where mid+1 is less than mid. Then we found min value which is mid+1;
     * 2. if the mid number is greater than left than we are in left sorted array, so we search in right sub-array.
     * 3. otherwise we search in left sub-array.
     * 4. if the mid is the last element of the array then our min value is the first element, otherwise we return mid+1 value.
     *
     * Time Complexity: O(log N)
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * https://www.youtube.com/watch?v=nIVW4P8b1VA
     *
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if( mid >= nums.length-1 || nums[mid] > nums[mid+1]){  //make sure mid+1 is not out of bound.
                break;
            }
            else if(nums[mid] >= nums[left]){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }

            return mid >= nums.length-1 ? nums[0] : nums[mid+1];
        }
    public static void main(String ...args){
        int[] a= {3,4,5,1,2};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("min value : " + findMin(a));

        int[] b = {4,5,6,7,0,1,2};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(b);
        System.out.println("min value : " + findMin(b));

        int[] c = {11,13,15,17};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(c);
        System.out.println("min value : " + findMin(c));

        int[] d = {3, 1, 2};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(d);
        System.out.println("min value : " + findMin(d));
    }
}
