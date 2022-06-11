package algorithm;

public class ValidPalindrome {
    /*
     * using two pointers
     * 1. from start index to end index. move the pointers while the chars are special character or space
     * 2. if start and end pointers are still within boundary and lower cased chars at both indexes are not the same
     *    the return false
     * 3. otherwise return true always
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            while(start <= end && isNotValidChar(s.charAt(start))){
                start++;
            }
            while(start <= end  && isNotValidChar(s.charAt(end))){
                end--;
            }

            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            else{
                start++;
                end--;
            }
        }

        return true;
    }

        private static boolean isNotValidChar(char c){
            return !Character.isLetter(c) && !Character.isDigit(c) || Character.isSpaceChar(c) ;
        }
    public static void main(String ...args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Original String : " + s);
        System.out.println("Is it palindrome? " + isPalindrome(s));

        s = ".,";
        System.out.println("Original String : " + s);
        System.out.println("Is it palindrome? " + isPalindrome(s));

    }
}
