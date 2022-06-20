package algorithm;

import algorithm.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
     * 1. at each element we are going to decide if we should include current number or not.
     * 2. base case, when the index reaches current numbs.length then save the current subset to the result list and return.
     * 3. first add the current element to current subset and move the the index by 1.
     * 4. second remove the current element from current subset and move the index by 1.
     *
     * Time Complexity : O(N * 2^N)
     * Space Complexity : O(N) where N being the height of the decision tree
     *
     * https://leetcode.com/problems/subsets/
     * https://www.youtube.com/watch?v=REOH22Xwdkk
     *
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    };

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result){
        if(index >= nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSubsets(index+1, nums, current, result);

        current.remove(current.size()-1);
        generateSubsets(index+1, nums, current, result);
    }
    public static void main(String ...args){
        int[] nums = {1,2,3};
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        List<List<Integer>> result = subsets(nums);

        for(List<Integer> r : result){
            r.forEach(x -> System.out.print(x + ", "));
            System.out.println();
        }
    }
}
