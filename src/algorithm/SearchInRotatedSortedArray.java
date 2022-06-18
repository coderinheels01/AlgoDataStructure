package algorithm;

import algorithm.util.PrintUtil;

public class SearchInRotatedSortedArray {

    /*
     *  using binary search,
     * 1. is the target found in mid? then return the index.
     * 2. see if the numbers from mid to left is sorted? if yes then we check ( this mean we are in left sorted array)
     *    a) is the target less than left most item? if yes then we discard items from left of mid and  search in right sub-array.
     *    b) is the target greater than mid? if yes then we discard items from left of mid and search in right sub-array.
     * 3. otherwise, the numbers on the left of mid are not sorted.
     *    a) is the target greater than right most item? if yes then we discard items from right of mid and search in left sub-array.
     *    b) is the target less than mid? then we discard items from right of mid and search in left sub-array.
     *
     * Time Complexity : O(logN)
     * Space Complexity: O(1)
     *
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * https://www.youtube.com/watch?v=U8XENwh8Oy8
     *
     */
    public static int search(int[] nums, int target) {
        int left =0; int right =nums.length-1;
        int mid;
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid]){
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else{
                if (target > nums[right] || target < nums[mid]) {
                    // go to left
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

        }
        return -1;
    }
    public static void main(String ...args){
        int[] a = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("index of " + target + " is " + search(a,target));

        target = 0;
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("index of " + target + " is " + search(a,target));

        target = 3;
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("index of " + target + " is " + search(a,target));

        int[] b = {3, 1};
        target = 3;
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(b);
        System.out.println("index of " + target + " is " + search(b,target));

        int[] c = {4,5,6,7,8,1,2,3};
        target = 8;
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(c);
        System.out.println("index of " + target + " is " + search(c,target));
    }
}
