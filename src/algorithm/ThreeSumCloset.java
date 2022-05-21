package algorithm;

import algorithm.util.PrintUtil;

import java.util.Arrays;

public class ThreeSumCloset {
    /*
     *
     * https://www.youtube.com/watch?v=qBr2hq4daWE&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=31
     * https://leetcode.com/problems/3sum-closest/
     *
     *
     */
    public static int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[nums.length-1];
        int left;
        int right;
        int currentSum;

        Arrays.sort(nums);
        for(int i=0; i< nums.length -2; i++){
            left = i+1;
            right = nums.length-1;

            while(left < right){
                currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum > target){
                    right--;
                }
                else if(currentSum < target){
                    left++;
                }
                if(Math.abs(sum - target) > Math.abs(currentSum - target)){
                    sum = currentSum;
                }
            }
        }

        return sum;
    }

    public static void main(String ...args){
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("----- closet sum of 3 numbers is ----");
        System.out.println(threeSumClosest(nums, target));

        //0,0,0
//
//        int[] nums1 = {0,1,2};
//        target = 0;
//        System.out.println("----- ORIGINAL ARRAY ----- ");
//        PrintUtil.printIntArrayWithoutName(nums1);
//        System.out.println("----- closet sum of 3 numbers is ----");
//        System.out.println(threeSumClosest(nums1, target));
//
//        int[] nums3 = {0,0,0};
//        target = 0;
//        System.out.println("----- ORIGINAL ARRAY ----- ");
//        PrintUtil.printIntArrayWithoutName(nums3);
//        System.out.println("----- closet sum of 3 numbers is ----");
//        System.out.println(threeSumClosest(nums3, target));
    }
}
