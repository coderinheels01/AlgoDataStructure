package algorithm;


import algorithm.util.PrintUtil;

public class BinaryRangeSearch {

    /*
     * 1. find the first posiiton of the target.
     * 2. expand the binary search on left sub array and right subarray, as long as the return index
     *    is not -1. ( when the binary search returns -1 we know that the value is not found)
     * 3. be sure to store the previous left and previous Right indexes.
     * 
     * Time Complexity : O(logn) ( technically this is O(LogN) + O(LogN) + O(LongN) because we do binary search once to find the mid/first position
     *                   of the target. second we do another binary search on first half and third binary search on second half. so technically it is
     *                   3O(LogN) but we can ignore the constant here.
     *
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     */
    public static int[] searchRangeOptimized(int[] nums, int target) {
        if(nums.length <= 0)
            return new int[]{-1, -1};
        int mid = binarySearch(nums, 0, nums.length-1, target);
        int left = mid;
        int right = mid;
        int prevLeft = -1, prevRight = -1;

        if(mid < -1)
            return new int[]{prevLeft, prevRight};

        while(left != -1){
            prevLeft = left;
            left = binarySearch(nums, 0, left -1 , target);
        }

        while(right != -1){
            prevRight = right;
            right = binarySearch(nums, right +1, right  , target);

        }
        return new int[]{prevLeft, prevRight};
    }
    private static int binarySearch(int[] nums, int left, int right, int target){
        if(left < 0 || right > nums.length -1  || left > right)
            return -1;
        int mid = (left + right) /2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            return binarySearch(nums, left, mid-1, target);
        }
        else{
            return binarySearch(nums, mid+1, right, target);
        }
    }

    public static void main(String ...args){
        int[] nums = {5,7,7,8,8,10}; int target = 8;
        System.out.println(" ----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(nums);
        int[] range = searchRangeOptimized(nums, target);
        System.out.println("target " +target + " is found within range" );
        PrintUtil.printIntArrayWithoutName(range);

       int[] nums1 = {5,7,7,8,8,10} ;  target = 6;
        System.out.println(" ----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(nums1);
        range = searchRangeOptimized(nums1, target);
        System.out.println("target " + target + " is found within range" );
        PrintUtil.printIntArrayWithoutName(range);
    }
}
