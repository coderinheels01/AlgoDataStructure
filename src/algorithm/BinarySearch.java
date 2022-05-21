package algorithm;
import java.util.Arrays;

public class BinarySearch {

    /*
     * Iterative approach.
     * Note: Binary Search only work on sorted array.
     *
     * 1. create two variables for left index and right index.
     * 2. as long as left index is less than right index.
     * 3. find the value at mid index, compare with target
     *    a) if the value at mid is same as target value then we found a match
     *    b) if the value at mid is greater than target value, then target is on the left half of the array, so move the
     *       right index to current middle.
     *    c) if the value at mid is less than target value, then target is on the right half of the array. so move the left
     *       index to current middle
     * 4. return -1 if value is not found.
     *
     * youtube.com/watch?v=9q0k3OyCKPY&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=17
     *
     * Time Complexity : O(N LogN)
     * Space Complexity : O(1)
     *
     */
    public static int binarySearchIterative(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        int mid;
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            else if( nums[mid] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] nums, int target){
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private static int binarySearch(int[] nums, int left, int right, int target){
        if(left < 0 || right > nums.length -1 )
            return -1;
        int mid = (left + right) /2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target){
            return binarySearch(nums, left, mid-1, target);
        }
        else{
            return binarySearch(nums, mid+1, right, target);
        }
     }
    public static void main(String ...args){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.println(" ----- ORIGINAL ARRAY ----- ");
        Arrays.stream(nums).forEach(a -> System.out.print(a + ","));
        System.out.println("\nfind the number " + target);
        System.out.println(" ----- METHOD 1 ( Iterative )-----");
        System.out.println("found at index : " + binarySearchIterative(nums, target));
        System.out.println(" ----- METHOD 2 ( Recursive )-----");
        System.out.println("found at index : " + binarySearchRecursive(nums, target));
    }
}


