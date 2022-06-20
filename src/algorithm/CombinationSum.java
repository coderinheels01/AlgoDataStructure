package algorithm;

import algorithm.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /*
     * 1. at each step we are going to make a decision to or not to include each element.
     * 2. base case if succeed, we will add a copy of current result to result list if the total is same as the target value. Then
     *    we return from the recursive call.
     * 3. base case if failed, we will return from this recursive call if total becomes greter than target or index becomes out of bound.
     * 4. first decision when we decide to add current element.
     *    a) add current element to current list.
     *    b) calculate current total by adding current element to total.
     *    c) make a recursive call with current index because we can include the same number.
     * 5. second decision when we decide to remove current element.
     *    a) remove last element from current list. since last element is the element we just added.
     *    b) decrement total with current element value. ( we do this because we are excluding current element)
     *    c) make a recursive call with index + 1 because we are not including the same number again.
     *
     * Time Complexity : O(N 2^N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/combination-sum/
     * https://www.youtube.com/watch?v=GBKI9VSKdGg
     *
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        generateCombination(0, 0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombination(int index, int total, int target, int[] candidates, List<Integer> current, List<List<Integer>> result){
        if(total == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(total > target || index >= candidates.length)
            return;

        current.add(candidates[index]);
        total = total + candidates[index];
        generateCombination(index , total  , target, candidates, current, result);

        current.remove(current.size() -1);
        total = total - candidates[index];
        generateCombination(index+1 , total, target, candidates, current, result);

    }

    public static void main(String ...args){
        int[] candidates = {2,3,6,7}; int target = 7;
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(candidates);
        System.out.println("subsets for target " +target);

        List<List<Integer>> result  = combinationSum(candidates, target);
        for(List<Integer> r : result){
            r.forEach(x -> System.out.print(x + ", "));
            System.out.println();
        }
    }
}
