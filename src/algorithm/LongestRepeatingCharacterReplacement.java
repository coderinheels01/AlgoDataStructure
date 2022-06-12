package algorithm;


public class LongestRepeatingCharacterReplacement {
    /*
     * Using two pointers sliding window technique.
     * 1. Set left pointer at 0 and right pointer at 0.
     * 2. count characters at each index and store in the char count array.
     * 3. loop the 26 chars and check what maximum frequency is
     * 4. using the formula ( current window size - most frequently seen char ) is greater than k then
     *    we will need to slide our left window by 1 and decrement the count of that char from char count array.
     * 5. check current window size is greater than previously seen window size. if yes then save that value.
     * 6. move the right pointer by 1.
     *
     * Time Complexity : O(N * 26). 26 is for the nested char loop and we ignore that.
     * Space Complexity : O(26)
     *
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     * https://www.youtube.com/watch?v=gqXU1UyA8pk
     *
     */
    public static int characterReplacement(String s, int k) {
        int result = 0;
        int left =0;
        int right =0;
        int n = s.length();
        char[] counts = new char[26];
        int maxFrequency= 0;

        while(left < n && right < n){
            char c = s.charAt(right);
            counts[c - 'A']++;
            for(int i=0; i<26 ; i++){
                if(maxFrequency < counts[i]){
                    maxFrequency = counts[i];
                }
            }
            if( right- left - maxFrequency +1 > k){
                counts[s.charAt(left) -'A']--;
                left++;
            }
            result = Math.max(result, right- left  +1);
            right++;
        }

        return result;
    }

    /*
     * Optimized method using two pointers sliding window technique. Everything is the same as non-optimized version except
     * to find maxFrequency, we won't be looping all 26 character counts. Instead we will always compare maxFrequency with count at
     * current char at right index. store whichever is greater.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1) because 26 char count array is negligible.
     * https://www.youtube.com/watch?v=gqXU1UyA8pk
     */
    public static int characterReplacementOptimized(String s, int k) {
        int maxWindow =0;
        int left =0;
        int right =0;
        char[] count = new char[26];
        int n= s.length();
        int maxFrequency =0;
        int currentWindow =0;

        while(left < n && right < n){
            char c = s.charAt(right);
            count[c - 'A']++;
            maxFrequency = Math.max(maxFrequency, count[c -  'A']);
            currentWindow = right - left +1;
            if( currentWindow - maxFrequency > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            currentWindow = right - left +1;
            maxWindow = Math.max(currentWindow, maxWindow);
            right++;
        }
        return maxWindow;
    }
    public static void main(String ...args){
        String s = "ABAB";
        int k = 2;
        System.out.println("----- Not OPTIMIZED -----");
        System.out.println("original string : " + s + " can replace up to: "+ k+ " characters. max window is : " + characterReplacement(s, k));
        System.out.println("----- OPTIMIZED -----");
        System.out.println("original string : " + s + " can replace up to: "+ k+ " characters. max window is : " + characterReplacementOptimized(s, k));

        s = "AABABBA";
        k = 1;
        System.out.println("----- Not OPTIMIZED -----");
        System.out.println("original string : " + s + " can replace up to: "+ k+ " characters. max window is : " + characterReplacement(s, k));
        System.out.println("----- OPTIMIZED -----");
        System.out.println("original string : " + s + " can replace up to: "+ k+ " characters. max window is : " + characterReplacementOptimized(s, k));
    }
}
