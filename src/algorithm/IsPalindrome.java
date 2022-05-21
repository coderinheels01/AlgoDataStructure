package algorithm;

public class IsPalindrome {
    /*
     * https://leetcode.com/problems/valid-palindrome/
     *
     * 1. strip out non-digit chars and convert them to lower case
     * 2. with two indexes which point to start and end, check if chars are the same, if not return false
     * 3. otherwise return true;
     *
     * Time Complexity: O(N)
     * Space Complexity : O(1)
     *
     * https://www.youtube.com/watch?v=rYyn9Vc-dBQ&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=24
     *
     */
    public static boolean isPalindrome(String s){
        String newString ="";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c))
                newString += Character.toLowerCase(c);
        }
        int i = 0;
        int j = newString.length()-1;
         while(i < j){
             if(newString.charAt(i) != newString.charAt(j)){
                 return false;
             }
             i++;
             j--;
         }
         return true;
    }

    public static boolean isPalindromeRegex(String s) {

        String parsed = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder builder = new StringBuilder();
        builder.append(parsed);
        builder.reverse();

        String reversed = builder.toString();

        return parsed.equals(reversed);
    }

    public static boolean isPalindromeFaster(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String ...args){
        String  s = "A man, a plan, a canal: Panama";
        System.out.println(" ----- ORIGINAL STRING ----- " + s );
        System.out.println("Is the String palindrome ? " +  isPalindrome(s));
        System.out.println("Is the String palindrome ? " +  isPalindromeRegex(s));
        System.out.println("Is the String palindrome ? " +  isPalindromeFaster(s));

        s = "race a car";
        System.out.println(" ----- ORIGINAL STRING ----- " + s );
        System.out.println("Is the String palindrome ? " +  isPalindrome(s));
        System.out.println("Is the String palindrome ? " +  isPalindromeRegex(s));
        System.out.println("Is the String palindrome ? " +  isPalindromeFaster(s));

        s = " ";
        System.out.println(" ----- ORIGINAL STRING ----- " + s );
        System.out.println("Is the String palindrome ? " +  isPalindrome(s));
        System.out.println("Is the String palindrome ? " +  isPalindromeRegex(s));
        System.out.println("Is the String palindrome ? " +  isPalindromeFaster(s));
    }
}
