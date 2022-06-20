package algorithm;

import algorithm.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    /*
     * Modify the original array and mark them ass seen by making the element value to negative. The trick is each element is an index since they
     * can't be greater than n.
     * 1. loop each element and get the current index with formula Math.abs(nums[i]) -1. This will ensure that we don't
     *    get negative index value if we have already marked the elements as seen.
     * 2. Check if current element is negative, then we can say for sure that we've seen that element.
     * 3. flip the element value by assigning it with negative number.
     * 4. return the result.
     *
     * Time Complexity : O(N).
     * Space Complexity : O(1).
     *
     * https://leetcode.com/problems/find-all-duplicates-in-an-array/
     * https://www.youtube.com/watch?v=aMsSF1Il3IY
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i< nums.length; i++){
            int index = Math.abs(nums[i]) -1;

            if(nums[index]  <0 )
                result.add(index+1);

            nums[index] = -nums[index];
        }
        return result;
    }

    public static void main(String ...args){
        int[] nums ={4,3,2,7,8,2,3,1};

        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(nums);
        System.out.println("----- DUPLICATES -----");
        findDuplicates(nums).forEach(x -> System.out.print(x + ", "));
    }
}
