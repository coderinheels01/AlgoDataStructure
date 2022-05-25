package algorithm;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /*
     * 1. check if the string length is even, if not we can't form pairs of brackets. so return false.
     * 2. crate a map with hard-coded parenthesis
     * 3. create a stack.
     * 4. traverse the string and check each character
     *    a) if the current parenthesis is a vaid one it will be in the map as a key. put the value into the stack.
     *    b) if the current parenthesis is not in the map as a key, then pop the stack and compare the value with the
     *      current character. if they are not equal return false.
     * 5. if the string only contains closing brackets, then it should return false. "}}" or "))" or "]]"
     * 6. if the stack is not empty then return false.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/valid-parentheses/
     */
    public static boolean isValid(String s) {
        if(s.length()%2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
              '[',']',
              '(', ')',
             '{', '}'
        );

        for(int i=0; i< s.length(); i++ ){
            if(map.containsKey(s.charAt(i))){
                stack.push(map.get(s.charAt(i)));
            }
            else if(!stack.isEmpty()){
                char bracket = stack.pop();
                if(bracket != s.charAt(i))
                    return false;
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    };

    public static void main(String ...args){
        String s = "()[]{}";
        System.out.println("----- ORIGINAL STRING ----- ");
        System.out.println(s);
        System.out.println("is it valid ? " + isValid(s));
        s = "()";
        System.out.println("----- ORIGINAL STRING ----- ");
        System.out.println(s);
        System.out.println("is it valid ? " + isValid(s));
        s = "()[}";
        System.out.println("----- ORIGINAL STRING ----- ");
        System.out.println(s);
        System.out.println("is it valid ? " + isValid(s));
        s = "}}";
        System.out.println("----- ORIGINAL STRING ----- ");
        System.out.println(s);
        System.out.println("is it valid ? " + isValid(s));
    }
}
