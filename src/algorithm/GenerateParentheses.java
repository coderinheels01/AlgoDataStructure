package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    /*
     * 1. the key is to keep track of how may open and closing brackets we have so far.
     * 2. if we have more open brackets then we can add close brackets. push close bracket to stack
     *    and call recursive function with closeN+1.
     * 3. if our open bracket is less than n then we can add more open bracket. push open bracket to stack and call recursive
     *    function with openN+1;
     * 4. we will have stack to keep track of current string. The stack needs to be cleared after every recursive call to form a
     *    new string.
     * 5. base case add to result when open, close and n are the same numbers. We can use toString method on stack but be sure to
     *    replace comma with empty space.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/generate-parentheses/
     * https://www.youtube.com/watch?v=s9fokUqJ76A
     *
     */
    public static List<String> generateParenthesisUsingStack(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrackStack(0, 0, n, stack, result);
        return result;
    }

    private static void backtrackStack(int openN, int closeN, int n, Stack<String> stack, List<String> result ){
        if(openN == closeN && closeN == n)
            result.add(
                    stack.toString()
                            .replaceAll(",", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", ""));
        if(openN < n){
            stack.push(OPEN_BRACKET);
            backtrackStack(openN+1, closeN, n, stack, result);
            stack.pop();
        }
        if(closeN < openN){
            stack.push(CLOSE_BRACKET);
            backtrackStack(openN, closeN+1, n, stack, result);
            stack.pop();
        }

    }

    /*
     * backtracking without using stack.
     * 1. call the recursive function with the result list, open and close and the original string.
     * 2. if the current string length is two times n then we have our result and add to the result string.
     * 3. if the open brackets are less than n then we can keep adding open brackets.
     * 4. if the close brackets are less than open brackets then we can keep adding close brackets.
     * 5. return the final result.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * https://www.youtube.com/watch?v=qBbZ3tS0McI
     */
    public static List<String> generateParenthesisOptimized(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, 0, 0, n, "");
        return result;
    };

    private static void backtrack(List<String> result, int open, int close, int n, String s){
        if(s.length() == n*2){
            result.add(s);
        }
        if(open < n ) backtrack(result, open+1, close, n, s+OPEN_BRACKET);
        if(close < open ) backtrack(result, open, close+1, n, s+CLOSE_BRACKET);
    }

    public static void main(String ...args){

        System.out.println("----- GENERATE PARENTHESIS -----");
        int n= 3;
        generateParenthesisUsingStack(n).stream().forEach(System.out::println);
        System.out.println("\n-----OPTIMIZED -----");
        generateParenthesisOptimized(n).stream().forEach(System.out::println);

    }
}
