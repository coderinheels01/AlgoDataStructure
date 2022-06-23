package algorithm;
import java.util.*;


/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * https://www.youtube.com/watch?v=DfljaUwZsOk
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        int left =0;
        int right =0;
        int n = nums.length;

        while(right < n){
            int currentWindow = (right - left)+1;
            while(!q.isEmpty() && nums[q.getLast()] < nums[right]){
                q.removeLast();
            }
            q.add(right);
            if(left > q.getFirst()){
                q.removeFirst();
            }
            if(currentWindow  == k){
                int currentMax = nums[q.peek()];
                result.add(currentMax);
                left++;
            }
            right++;
        }

        int[] resultArray = result.stream().mapToInt(Integer::intValue).toArray();
        return resultArray;
    }
    public static void main(String ...args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("max values of each window size " + k);
        Arrays.stream(maxSlidingWindow(nums, k)).forEach(x -> System.out.print(x + " , "));

        int[] nums1 = {1};
        k = 1;
        System.out.println("\nmax values of each window size " + k);
        Arrays.stream(maxSlidingWindow(nums1, k)).forEach(x -> System.out.print(x + " , "));

        int[] nums3 = {1, -1};
         k = 1;
        System.out.println("\nmax values of each window size " + k);
        Arrays.stream(maxSlidingWindow(nums3, k)).forEach(x -> System.out.print(x + " , "));

        int[] nums4 = {1, 3, 1, 2, 0, 5};
        k = 3;
        System.out.println("\nmax values of each window size " + k);
        Arrays.stream(maxSlidingWindow(nums4, k)).forEach(x -> System.out.print(x + " , "));

        int[] nums5 = {-7,-8,7,5,7,1,6,0};
        k= 4;
        //[7,7,7,7,7]
        System.out.println("\nmax values of each window size " + k);
        Arrays.stream(maxSlidingWindow(nums5, k)).forEach(x -> System.out.print(x + " , "));

        int[] nums6 = {9,10,9,-7,-4,-8,2,-6};
        k = 5;
        //[10,10,9,2]
        System.out.println("\nmax values of each window size " + k);
        Arrays.stream(maxSlidingWindow(nums6, k)).forEach(x -> System.out.print(x + " , "));
    }
}
