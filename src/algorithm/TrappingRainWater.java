package algorithm;

import algorithm.util.PrintUtil;

public class TrappingRainWater {
    /*
     *
     * 1. at every index scan it's left to find max number on left.
     * 2. at every index scan it's right to find max number on it's right.
     * 3. total water is min of maxLeft and maxRight minus current value at index.
     *
     * https://leetcode.com/problems/trapping-rain-water/
     *
     * Time Complexity : O(N^2)
     * Space Complexity : O(1)
     */
    public static  int trap(int[] height) {
        int total =0;
        int maxLeft;
        int maxRight;

        for(int i =0; i< height.length; i++){
            maxLeft = 0;
            maxRight = 0;

            for(int j =0; j < i+1; j++){
                if(height[j] > maxLeft)
                    maxLeft = height[j];
            }
            for(int k = i ; k< height.length; k++){
                if(height[k] > maxRight)
                    maxRight = height[k];
            }
            total+= Math.min(maxLeft, maxRight) - height[i];
        }

        return total;
    }
    /*
     * 1. calculate max number for each index from start index to end index. ( this will give
     *    the max left number at each index.
     * 2. calculate max number for each index from end index to start index. ( this will give
     *    the max right number at each index.
     * 3. loop original array. At each index, get the number from left array and get the number from right
     *    array. Compare the two and take the minimum number from the two. then substract current value at
     *    original array from the lesser number and then add that to total.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://www.geeksforgeeks.org/trapping-rain-water/
     *
     */
    public static int trapMethod2(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int total = 0;

        left[0] = height[0];

        //[4,2,0,3,2,5]
        //[4,4,4,4,4,5]
        for(int i= 1; i < n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[n-1] = height[n-1];

        //[4,2,0,3,2,5]
        //[5,5,5,5,5,5]
        for(int i= n-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }


        int current =0;
        //left :  [4,4,4,4,4,5]
        //right:  [5,5,5,5,5,5]
        //height: [4,2,0,3,2,5]
        //.        0,2,4,1,2,0
        for(int i=0; i< n; i++){
            total += Math.min(left[i], right[i]) - height[i];
        }

        return total;
    }

    public static void main(String ...args){
      int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("original array ");
        PrintUtil.printIntArrayWithoutName(height);
        System.out.println("----- METHOD 1 -----");
        System.out.println("total water = " + trap(height));
        System.out.println("----- METHOD 2 -----");
        System.out.println("total water = " + trapMethod2(height));
    }
}
