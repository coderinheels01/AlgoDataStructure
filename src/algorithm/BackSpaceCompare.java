package algorithm;

import java.util.Stack;

public class BackSpaceCompare {
    /*
     * Nested loop required
     * 1. move pointers of each string one by one, check if the char is #.
     *    if yes then mark the skip. if the skip is there, keep decrementing
     *    otherwise, break out of the loop
     * 2. check if the pointers are not negative values, and check if the chars are the same. if not
     *    return false
     * 3. if both pointers are not positive number or both negative numbers, they are not the same
     *
     *
     * https://www.youtube.com/watch?v=vgog1EuEJYQ&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=21
     *
     * Time Complexity : O(N)
     * Space Compleixyt : O(1)
     */
    public static boolean backspaceCompare(String s, String t) {
        int sPointer = s.length()-1;
        int tPointer = t.length()-1;
        int sSkip  = 0;
        int tSkip = 0;

        while(sPointer >= 0 || tPointer >= 0){
            while(sPointer >= 0){
                if(s.charAt(sPointer) == '#'){
                    sSkip++;
                    sPointer--;
                }
                else if( sSkip > 0){
                    sPointer--;
                    sSkip--;
                }
                else{
                    break;
                }
            }
            while(tPointer >= 0){
                if(t.charAt(tPointer) == '#'){
                    tSkip++;
                    tPointer--;
                }
                else if( tSkip > 0){
                    tPointer--;
                    tSkip--;
                }
                else{
                    break;
                }
            }

            if(sPointer >=0 && tPointer >=0 && s.charAt(sPointer) != t.charAt(tPointer))
                return false;

            if(sPointer >=0 != tPointer >=0)
                return false;

            sPointer--;
            tPointer--;
        }

        return true;
    }

    /*
     * compare if two stacks are equal
     */
    public static boolean backspaceCompareStack(String s, String t) {
        return strip(s).equals(strip(t));
    }
    /*
     * 1. for each character in string, check if it's #.
     *    if yes, then pop the stack if not empty
     * 2. otherwise add the char to stack
     */
    private static Stack<Character> strip(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) != '#'){
                stack.push(s.charAt(i));
            }
            else if( s.charAt(i) == '#' && !stack.isEmpty()){
                stack.pop();
            }
        }
        return stack;
    }

    public static void main(String ...args){
        String s = "ab#c", t = "ad#c";
        System.out.println(" ----- ORIGINAL STRINGS ----- ");
        System.out.println(" s = " + s);
        System.out.println(" t = " + t);
        System.out.println("----- METHOD 1 -----");
        System.out.println("Are they the same ? " + backspaceCompareStack(s, t));
        System.out.println("----- METHOD 2 -----");
        System.out.println("Are they the same ? " + backspaceCompare(s, t));

        s = "ab##";
        t = "c#d#";
        System.out.println(" ----- ORIGINAL STRINGS ----- ");
        System.out.println(" s = " + s);
        System.out.println(" t = " + t);
        System.out.println("----- METHOD 1 -----");
        System.out.println("Are they the same ? " + backspaceCompareStack(s, t));
        System.out.println("----- METHOD 2 -----");
        System.out.println("Are they the same ? " + backspaceCompare(s, t));

        s = "a#c";
        t = "b";
        System.out.println(" ----- ORIGINAL STRINGS ----- ");
        System.out.println(" s = " + s);
        System.out.println(" t = " + t);
        System.out.println("----- METHOD 1 -----");
        System.out.println("Are they the same ? " + backspaceCompareStack(s, t));
        System.out.println("----- METHOD 2 -----");
        System.out.println("Are they the same ? " + backspaceCompare(s, t));

        s= "bxj##tw"; // btw
        t = "bxj###tw";// tw
        System.out.println(" ----- ORIGINAL STRINGS ----- ");
        System.out.println(" s = " + s);
        System.out.println(" t = " + t);
        System.out.println("----- METHOD 1 -----");
        System.out.println("Are they the same ? " + backspaceCompareStack(s, t));
        System.out.println("----- METHOD 2 -----");
        System.out.println("Are they the same ? " + backspaceCompare(s, t));

    }
}
