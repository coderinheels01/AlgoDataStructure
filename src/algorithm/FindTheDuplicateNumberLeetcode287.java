package algorithm;

import algorithm.util.PrintUtil;

public class FindTheDuplicateNumberLeetcode287 {

    /*
     * find duplicate of the array without modifying original array and without using extra space and exactly O(N) time complexity;
     * using loop detection Floyd's algorithm.
     * 1. have two pointers to slow and fast to find the intersection. jump slow by one pointer, fast by two pointer.
     *    since the array elements are index of the array themself, they will meet at one point.
     * 2. break out of the loop once they meet.
     * 3. create another slow pointer starting from the beginning of the array index 0.
     *     move the slow pointer two by one from the beginning and slow pointer by one from the intersection.
     *     they will meet after jumping the exact same amount of hops. break out of the loop once it's found
     * 4. return the slow pointer.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/find-the-duplicate-number/
     * https://www.youtube.com/watch?v=wjYnzkAhcNk
     *
     */
    public static int findDuplicate(int[] nums) {
        int slow =0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }

        int slow2 = 0;

        while(true){
            slow2 = nums[slow2];
            slow = nums[slow];
            if(slow == slow2)
                break;
        }

        return slow;
    }
    public static void main(String ...args){
        int[] nums = {1,3,4,2,2};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("duplicate in the array is " + findDuplicate(nums));
    }
}
