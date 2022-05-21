package algorithm;

public class LongestPalindromicSubstring {
    public static void main(String... args){
        String s = "racecar";
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstring(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstringBruteForce(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicDynamicProgramming(s));
        s = "babad";
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstring(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstringBruteForce(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicDynamicProgramming(s));
        s = "cbbd";
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstring(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstringBruteForce(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicDynamicProgramming(s));
        s = "a";
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstring(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstringBruteForce(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicDynamicProgramming(s));
        s = "ac";
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstring(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicSubstringBruteForce(s));
        System.out.println("longest palindromic substring for string "+ s + " is " + longestPalindromicDynamicProgramming(s));
    }

    /*
     * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
     */
    public static String longestPalindromicSubstringBruteForce(String s){
        int maxLength= 1;
        int startIndex = 0;
        int endIndex =0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                int currentLength = checkPalindrome(s, i, j);
                if(currentLength > maxLength){
                    maxLength = currentLength;
                    startIndex = i;
                    endIndex = j;
                }

            }
        }

        return s.substring(startIndex, endIndex+1);
    }

    private static int checkPalindrome(String s, int start, int end){
        for(int k = 0; k< (end - start)/2 +1; k++){
            if(s.charAt(start + k) != s.charAt(end - k))
                return 0;
        }
        return end - start +1;
    }

    /*
     * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
     */
    public static String longestPalindromicDynamicProgramming(String s){
        int size = s.length();
        int maxLength =1;
        int start = 0;
        boolean[][] table = new boolean[size][size];

        for(int i= 0; i< size; i++){
            table[i][i] = true;
        }

        for(int i=0; i< size-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for(int k =3; k<= size; k++){
            for(int i=0; i < size - k +1; i++){
                int j = i + k -1;
                if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]){
                    table[i][j] = true;
                    if(k > maxLength){
                        maxLength = k;
                        start = i;
                    }

                }

            }
        }
        return s.substring(start, maxLength);
    }
    /*
     * https://www.youtube.com/watch?v=y2BD4MJqV20&t=607s
     * expand from the middle
     */
    public static String longestPalindromicSubstring(String s){
        int start  = 0;
        int end = 0;

        for(int i=0; i< s.length(); i++){
            int lengthForOdd = expandFromMiddle(s, i, i);
            int lengthForEven = expandFromMiddle(s, i, i+1);
            int currentMaxLength = Math.max(lengthForEven, lengthForOdd);
            int previousMaxLength = end - start;
            if(currentMaxLength > previousMaxLength){
                start = i - ( (currentMaxLength -1)  /2);
                end = i + ((currentMaxLength /2));
            }
        }
        return s.substring(start, end +1);
    }

    private static int expandFromMiddle(String s, int start, int end ){
        if(s == null || start > end ) return 0;

        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        return end - start - 1;
    }
}
