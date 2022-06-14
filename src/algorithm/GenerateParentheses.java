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
        backtrack(0, 0, n, stack, result);
        return result;
    }

    private static void backtrack(int openN, int closeN, int n, Stack<String> stack, List<String> result ){
        if(openN == closeN && closeN == n)
            result.add(
                    stack.toString()
                            .replaceAll(",", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", ""));
        if(openN < n){
            stack.push(OPEN_BRACKET);
            backtrack(openN+1, closeN, n, stack, result);
            stack.pop();
        }
        if(closeN < openN){
            stack.push(CLOSE_BRACKET);
            backtrack(openN, closeN+1, n, stack, result);
            stack.pop();
        }

    }

    public static void main(String ...args){

        System.out.println("----- GENERATE PARENTHESIS -----");
        int n= 3;
        generateParenthesisUsingStack(n).stream().forEach(System.out::println);

    }
}
