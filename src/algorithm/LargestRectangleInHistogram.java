package algorithm;

import algorithm.util.PrintUtil;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /*
     * 1. if current height is greater than top of the stack then keep pushing the current height and it's current index location.
     * 2. while current height is less than top of the stack and stack is not empty, keep popping the stack, calculate current area and save the maxArea
     *    and then store the index of last popped element because that index will be the index of current height. This should give us area of current index from it's
     *    left.
     * 3. push the start index and current height into the stack. ( start index could be either i or index of last popped stack).
     * 4. after going through all the heights and we still have some elements in the stack, we need to keep popping and calculate current area and compare with maxArea. and update maxArea if it's greater.
     * 5. return maxArea.
     *
     * Time complexity : O(N)
     * Space Complexity :O(N)
     *
     * https://leetcode.com/problems/largest-rectangle-in-histogram/
     * https://www.youtube.com/watch?v=zx5Sw9130L0
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea =0;
        stack.push(new int[]{0, heights[0]});

        for(int i=1; i< heights.length; i++){
            int currentHeight = heights[i];
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > currentHeight){
                int[] currentMax = stack.pop();
                int currentArea = (i - currentMax[0]) * currentMax[1];
                maxArea = Math.max(currentArea, maxArea);
                start = currentMax[0];
            }

            stack.push(new int[]{start, currentHeight});
        }
        int totalWidth = heights.length;
        while(!stack.isEmpty()){
            int[] currentMax =  stack.pop();
            int currentArea = (totalWidth - currentMax[0] ) * currentMax[1];
            maxArea = Math.max(currentArea, maxArea);
        }

        return maxArea;
    }
    public static void main(String ...args){
        int[] height = {2,1,5,6,2,3};
        System.out.println("----- HISTOGRAM -----");
        PrintUtil.printIntArrayWithoutName(height);
        System.out.println(" max area "+ largestRectangleArea(height));

        int[] height1 = {4,2,0,3,2,5};
        System.out.println("----- HISTOGRAM -----");
        PrintUtil.printIntArrayWithoutName(height1);
        System.out.println(" max area "+ largestRectangleArea(height1));
    }
}
