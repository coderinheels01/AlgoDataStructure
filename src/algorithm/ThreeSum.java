package algorithm;
import algorithm.util.PrintUtil;
import java.util.*;

public class ThreeSum {

    /*
     * Do a nested for loop.
     * 1. sort the input array
     * 2. for each number in the array. (outside loop)
     * 3. check if number in outside array are not dupes , then find two sum in nested loop
     * 4. In the nested loop, using two pointers, keep moving the pointers inward as long as dupes are there.
     *
     * Note: this algorithm removes duplicates from outer loop with continue if found and with while loop on two pointers left and right to get rid of
     *       the dupes inside nested loop.
     *
     * Time Complexity : O(N^2) , because the while loop inside nested while loop is just moving the left and right pointers
     * Space Complexity: O(N) - varies on the language used.
     *
     * https://www.youtube.com/watch?v=jeim_j8VdiM
     * https://leetcode.com/problems/3sum/
     *
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // -4, -1, -1, 0, 1, 2,
        for(int i=0; i< nums.length-2; i++){
               if(  i > 0 && nums[i] == nums[i-1]){
                    continue;
               }
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[right] + nums[left];
                if( sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;
                    left++;
                }
                else if ( sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }

//    private static void twoSumWithSet(int[] nums, int i, int target, List<List<Integer>> result) {
//        Set<Integer> lookup = new HashSet<>();
//        for(int j = i+1; j< nums.length; j++){
//            int compliment = target - nums[j];
//            if(!lookup.contains(compliment)){
//                lookup.add(nums[j]);
//            }
//            else if(lookup.contains(compliment)){
//                result.add(Arrays.asList(nums[i], compliment, nums[j]));
//                while( j < nums.length-1 && nums[j] == nums[j+1]) j++;
//            }
//        }
//    }

    public static void main(String ...args){
         int[]  nums = {-1,0,1,2,-1,-4};
        // -4, -1, -1, 0, 1, 2,
        System.out.println(" -----  ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(nums);
        List<List<Integer>> result = threeSum(nums);
        System.out.println(" -----  RESULT----- ");
        for(List<Integer> r : result){
            PrintUtil.printIntArrayList(r);
        }


        int[] nums1 = {0,2,2,3,0,1,2,3,-1,-4,2};
        //int[]  nums1 = {0, 0, 0};
        System.out.println(" -----  ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(nums1);
        System.out.println(" -----  RESULT  ----- ");
        List<List<Integer>> result1 = threeSum(nums1);
        for(List<Integer> r : result1){
            PrintUtil.printIntArrayList(r);
        }

        int[] nums3 = {-1,-1,-1,-1,0,0,1,1,1};
        //int[]  nums1 = {0, 0, 0};
        System.out.println(" -----  ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(nums3);
        System.out.println(" -----  RESULT  ----- ");
        List<List<Integer>> result2 = threeSum(nums3);
        for(List<Integer> r : result2){
            PrintUtil.printIntArrayList(r);
        }
    }
}
