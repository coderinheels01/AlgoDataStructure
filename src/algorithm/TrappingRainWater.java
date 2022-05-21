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

    public static void main(String ...args){
      int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("original array ");
        PrintUtil.printIntArrayWithoutName(height);
        System.out.println("total water = " + trap(height));
    }
}
