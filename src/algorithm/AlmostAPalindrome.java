package algorithm;

public class AlmostAPalindrome {

    /*
     * 1. using two pointers approach
     *    a) while one pointer is starting at the beginning of the string
     *    b) another pointer at the end of the string
     * 2. keep moving pointer until two chars that aren't a match are found
     * 3. when two chars aren't a mach,
     *    a) skip a pointer from the left and check if the rest of the substring is a palindrome.
     *    b) skip a pointer from the right and check if the rest of the substring is a palindrome.
     * 4. if one of them is false then this string can't form palindrome by removing one character.
     *
     * Time Complexity : O(N) - even though we have another loop inside isPalindrome private function, the pointer always moves inward and touches each element only once
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/valid-palindrome-ii/
     *
     */
    public static boolean almostPalindromeIterative(String s){
        if(s.length()<3){
            return true;
        }
        int p1 =0 ;
        int p2 = s.length()-1;
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)){
              return isPalindrome(s, p1+1, p2) || isPalindrome(s, p1 , p2-1);
            }
            p1++;
            p2--;
        }


        return true;
    }
    private static boolean isPalindrome(String s, int left, int right){
        while(left< right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    /*
     * Recursive approach.
     * 1. need a private function that will take left, right pointers and depth.
     * 2. set left as 0, right as string length and depth as 0 and call from main function.
     *
     * isPalindrome function
     *  1. base case, return false when depth is greater than 1. This is to stop the move inward by one index function
     *     from being called infitintely.
     * 2. if the character is exactly one and if they are equal then return true. or if the character is empty then return true.
     * 3. if the characters are equal, keep calling the recursive function by moving both pointers inward.
     * 4. if the characters are not equal,
     *    a) move left pointer inward by one and call recursive function with depth 1
     *    b) move right pointer inward by one and call recursive function with depth 1.
     * 5. if 4.a) returns true or 4.b) returns true, then return true. if both of them are false return false.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static boolean almostPalindromeRecursive(String s){
       return isPalindrome(s, 0, s.length()-1, 0);
    }

    private static boolean isPalindrome(String s, int p1, int p2, int depth){
        if(depth > 1)
            return false;
        if((p2 - p1) <= 1 && s.charAt(p1) == s.charAt(p2)) return true;
        if(s.charAt(p1) == s.charAt(p2))
            return isPalindrome(s, p1+1, p2-1, depth);
        return isPalindrome(s, p1+1, p2, depth+1) || isPalindrome(s, p1, p2-1, depth+1);
    }


    public static void main(String ...args){
        String s = "raceacar";
        System.out.println("original string : " + s);
        System.out.println("----- ITERATIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeIterative(s));
        System.out.println("----- RECURSIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeRecursive(s));

        s = "raceaacar";
        System.out.println("original string : " + s);
        System.out.println("----- ITERATIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeIterative(s));
        System.out.println("----- RECURSIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeRecursive(s));

        s = "deeee";
        System.out.println("original string : " + s);
        System.out.println("----- ITERATIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeIterative(s));
        System.out.println("----- RECURSIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeRecursive(s));

        s = "abc";
        System.out.println("original string : " + s);
        System.out.println("----- ITERATIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeIterative(s));
        System.out.println("----- RECURSIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeRecursive(s));

        s ="gmlueuppuclmg";
        System.out.println("original string : " + s);
        System.out.println("----- ITERATIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeIterative(s));
        System.out.println("----- RECURSIVE APPROACH ----- ");
        System.out.println("Is a palindrome? " + almostPalindromeRecursive(s));

    }
}
