package algorithm;

import algorithm.util.PrintUtil;

public class ContainerWithMostWater {
    /*
     * 1. visit each index.
     * 2. using nested loop.
     * 3. get the min of two heights and multiply with the width. ( Area = height x width )
     *
     * Time Complexity : O(N^2)
     * Space Complexity : O(1)
     *
     * https://www.youtube.com/watch?v=GKJM5eKnl8M
     * https://leetcode.com/problems/container-with-most-water/submissions/
     * https://www.youtube.com/watch?v=6PrIRPpTI9Q&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=30
     */
    public static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;

        for(int i =0; i< height.length; i++){
            for(int j=i+1; j< height.length; j++){
                maxArea = Math.max(maxArea,  Math.min(height[i], height[j]) * (j - i) );
            }
        }
        return maxArea;
    }
    /*f
     * 1. using two pointers, check the height at each pointer.
     * 2. get the lower height and calculate the area then increment the index of the lower height
     * 3. compare newly calculated area and max area. Then get the higher area and save it in maxArea.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://www.youtube.com/watch?v=GKJM5eKnl8M
     * https://leetcode.com/problems/container-with-most-water/submissions/
     * https://www.youtube.com/watch?v=6PrIRPpTI9Q&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=30
     */
    public static int maxArea(int[] height){
        int maxArea = 0;
        int area;
        int i =0, j=height.length-1;

        while(i <= j){
            if(height[i] < height[j]){
                area = height[i] * (j - i);
                maxArea = Math.max(maxArea, area);
                i++;
            }
            else{
                area = height[j] * (j - i);
                maxArea = Math.max(maxArea, area);
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String ...args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(height);
        System.out.println("----- METHOD 1 ( Brute Force ) ----- ");
        System.out.println("Max water = " + maxAreaBruteForce(height));
        System.out.println("----- METHOD 2 ( O(N) faster ) ----- ");
        System.out.println("Max water = " + maxArea(height));
    }
}
