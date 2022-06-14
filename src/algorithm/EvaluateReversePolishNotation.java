package algorithm;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    /*
     * 1. check each string in the token.
     * 2. If they are operators, pop two numbers from stack and perform operations on two numbers in reverse order, and push the result into the stack.
     * 3. If they are numbers push them into the stack.
     * 4. return the last number from the stack.
     *
     * Time Complexity : O(N)
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     * https://www.youtube.com/watch?v=iu0082c4HDE
     *
     */
    public static int evalRPN(String[] tokens) {

        Set<String> operations = Set.of("+", "-", "*","/");
        Stack<Integer> stack= new Stack<>();

        for(String token : tokens){
            if(operations.contains(token) && !stack.isEmpty()){
                int n1 = stack.pop();
                int n2= stack.pop();
                stack.push(performOperations(token,n2,n1)); // note: passing n2 as a and n1 as b? We want the operations to be performed in that order
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }


        return stack.pop();
    }

    private static int performOperations(String operation, int a, int b){
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    public static void main(String ...args){
        String[] tokens = {"2","1","-","3","/"};
        System.out.println("result is "+ evalRPN(tokens) );

        String[] tokens2 = {"4","13","5","/","+"};
        System.out.println("result is "+ evalRPN(tokens2) );

        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("result is "+ evalRPN(tokens3) );
    }
}
