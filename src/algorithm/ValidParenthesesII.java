package algorithm;


import java.util.Stack;

public class ValidParenthesesII {


    /**
     * 1. iterate from left to right.
     * 2. checke if the character is opening bracket '(', if yes push the index into stack
     * 3. if the character is closing bracket ')', then if stack is not empty pop the stack
     * 4. if the character is a closing bracket but there is no opening bracket before that then mark it with '*'
     * 5. if the stack is not empty, then get the index from the stack and set with '*'
     * 6. convert the string builder into a string and replace all the '*' with "" empty string.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static String isValid(String s){
        Character OPEN = '(';
        Character CLOSE =')';
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == OPEN){
                stack.push(i);
            }
            else if(c == CLOSE){
                if(!stack.isEmpty()) stack.pop();
                else{
                    sb.setCharAt(i, '*');
                }
            }
        }

        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(), '*');
        }

        return sb.toString().replaceAll("\\*" , "");
    };
    public static void main(String ...args){
        String s ="a)bc((d)))";
        System.out.println("original string : " + s);
        System.out.println("the valid string : " + isValid(s));

        s ="))((";
        System.out.println("original string : " + s);
        System.out.println("the valid string : " + isValid(s));

        s ="lee(t(c)o)de";
        System.out.println("original string : " + s);
        System.out.println("the valid string : " + isValid(s));


        s ="())()(((";
        System.out.println("original string : " + s);
        System.out.println("the valid string : " + isValid(s));
    }
}
