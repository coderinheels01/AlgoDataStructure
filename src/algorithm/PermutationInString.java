package algorithm;

import java.util.Arrays;

public class PermutationInString {
    /*
     * two pointer sliding window technique.
     * 1. set left and right pointer starting at 0
     * 2. create two hashsets of size 26 chars for both string
     * 3. fill in the first hashset with chars counts from string 1.
     * 4. using sliding window technique. if the size is greater than string 1 size
     *    we will reduce the current window size by incrementing left pointer and decrementing
     *    count of the char at left array.
     * 5. otherwise, keep incrementing char count at the right pointer.
     * 6. if the window size is same as s1. then check if two char arrays are same. if yes then return true.
     * 7. at the end return false
     *
     * Time Complexity : O(N * 26) where 26 being char size to check if the chars count hash arrays are equal.
     * Space Complexity : O(26 + 26) reduced to O(1) because they are constants.
     *
     * https://leetcode.com/problems/permutation-in-string/
     * https://www.youtube.com/watch?v=UbyhOgBN834
     *
     */
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2 ) return false;

        char[] count1 = new char[26];
        char[] count2 = new char[26];
        int left =0;
        int right =0;

        char c1;
        char c2;
        for(int i=0; i< n1; i++){
            c1 = s1.charAt(i);
            count1[c1 - 'a']++;
        }

        while( left < n2 && right < n2){
            c2 = s2.charAt(right);
            int windowSize =  right - left +1;
            count2[c2 - 'a']++;
            if(windowSize == n1){
                boolean includes =Arrays.equals(count1, count2);
                if(includes)
                    return  true;
            }
            if(windowSize >= n1){
                count2[s2.charAt(left) - 'a']--;
                left++;
            }
            right++;

        }
        return false;
    };

    /*
     * using two pointer sliding window technique.
     * 1. initialize two char arrays of size 26.
     * 2. populate both char count arrays with values from s1 and s2 only up to the size of s1.
     * 3. loop up to 26 chars and check if the values at count1 and count2 are equal, if they are, we increment matches.
     * 4. now we gonna do sliding window, set left pointer with 0. right pointer with the size of s1 because we already
     *    populated s2 char array with the counts up to the size of s1.
     * 5. if the matches is equal to 26 then we return true.
     * 6. check char at right index for s2 and increment count2.
     *    a) after incrementing count2 we will check if the count2 value at that char is still the same as count1 value at the same char
     *       if yes then increment matches.
     *    b) otherwise decrement matches.
     * 7. check char at left index for s2 and decrement count2. ( this is an attempt to decrement the window size)
     *    a) after decrementing count2, we will check if the count2 value at that char is still the same as count2 value at the same char.
     *       if yes then increment matches.
     *    b) otherwise decrement matches.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static boolean checkInclusionOptimized(String s1, String s2) {
        int n1= s1.length();
        int n2= s2.length();
        if(n1 > n2) return false;

        char[] count1 = new  char[26];
        char[] count2 = new  char[26];
        char c1;
        char c2;
        int left =0;
        int right = n1;

        int matches = 0;
        for(int i=0; i< n1; i++){
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            count1[c1 - 'a']++;
            count2[c2 - 'a']++;
        }

        for(int i=0; i< 26; i++){
            if(count1[i] == count2[i])
                matches++;
        }

        int index;

        while(right < n2){
            if(matches == 26) return true;
            index = s2.charAt(right) - 'a';
            count2[index]++;
            if(count1[index] == count2[index]){
                matches++;
            }
            else {
                matches--;
            }

            index = s2.charAt(left) - 'a';
            count2[index]--;
            if(count1[index] == count2[index]){
                matches++;
            }
            else {
                matches--;
            }
            left++;
            right++;
        }
        return false;
    };


    public static void main(String ...args){
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println("string : " + s1 + " s2 " + s2 + " does s2 contains permutation of s1? " + checkInclusion(s1, s2) );
        System.out.println("(OPTIMIZED)string : " + s1 + " s2 " + s2 + " does s2 contains permutation of s1? " + checkInclusionOptimized(s1, s2) );

        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println("string : " + s1 + " s2 " + s2 + " does s2 contains permutation of s1? " + checkInclusion(s1, s2) );
        System.out.println("(OPTIMIZED)string : " + s1 + " s2 " + s2 + " does s2 contains permutation of s1? " + checkInclusionOptimized(s1, s2) );
    }
}
