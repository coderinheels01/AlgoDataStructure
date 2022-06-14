package algorithm;

import algorithm.util.PrintUtil;

import java.util.Stack;

public class DailyTemperatures {

    /*
     * 1. traverse the temperature array backward.
     * 2. inside the loop, try to find the temp greater than current temp inside the stack by popping the stack.
     * 3. once out of the stack. if the stack is not empty, peek the stack and calculate the number of days by substracting current index
     *    from the index of higher temp.
     * 4. always push the temperatures and current index into the stack.
     * 5. return the result array.
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/daily-temperatures/
     * https://www.youtube.com/watch?v=cTBiBSnjO3c
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i=n-1; i >=0 ;i--){
            while(!stack.isEmpty() && stack.peek()[1]<= temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty() ){
                int[] next = stack.peek();
                if(next[1] > temperatures[i]){
                    result[i] = next[0] - i;
                }
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return result;
    }

    public static void main(String ...args){
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(temp);
        System.out.println("----- result -----");
        PrintUtil.printIntArrayWithoutName(dailyTemperatures(temp));

        int[] temp2 = {89,62,70,58,47,47,46,76,100,70};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(temp2);
        System.out.println("----- result -----");
        PrintUtil.printIntArrayWithoutName(dailyTemperatures(temp2));

    }
}
