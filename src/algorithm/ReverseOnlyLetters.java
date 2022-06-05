package algorithm;

import java.util.Stack;

public class ReverseOnlyLetters {

    /*
     * reverse the string.
     * 1. loop the string, push characters into the stack if they are letters.
     * 2. loop the string again, if the character is a letter, then pop from stack otherwise push the
     *    character into StringBuilder.
     *
     * Time Complexity : O(N)
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/reverse-only-letters/
     * https://www.youtube.com/watch?v=M2TwbZCpJpw&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=50
     *
     */
    public static String reverseUsingStack(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length() ){
            if(Character.isLetter(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            i++;
        }
        i=0;
        while(i < s.length()){
            if(Character.isLetter(s.charAt(i))){
                sb.append(stack.pop());
            }
            else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    };

    /*
     * 1. convert the string into char array.
     * 2. traverse the string from both end using two pointers.
     * 3. shift the pointer if they are not letters.
     * 4. if they are letters, swap and move both pointers inward.
     * 5. return the String of the characters.
     *
     * Time Complexity: O(N)
     * Space Complexity : O(N)
     *
     */
    public static String reverse(String s){
        char[] chars = s.toCharArray();
        int i =0;
        int j = s.length()-1;

        while(i < j){
            if(!isLetter(s.charAt(j))){
                chars[j] = s.charAt(j);
                j--;
            }
            else if(!isLetter(s.charAt(i))){
                chars[i] = s.charAt(i);
                i++;
            }
            else if (isLetter(s.charAt(i)) && isLetter(s.charAt(j))){
                swap(chars, i, j);
                i++;
                j--;
            }

        }
        return String.valueOf(chars);
    }
    private static boolean isLetter(char c){
        return Character.isLetter(c);
    }
    private static void swap(char[] chars, int i, int j ){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static void main(String ...args){
        String s = "ab-cd";
        System.out.println("original string : " + s);
        System.out.println("reversed string : " + reverseUsingStack(s));
        System.out.println("reversed string : " + reverse(s));

        s = "a-bC-dEf-ghIj";
        System.out.println("original string : " + s);
        System.out.println("reversed string : " + reverseUsingStack(s));
        System.out.println("reversed string : " + reverse(s));
    }
}
