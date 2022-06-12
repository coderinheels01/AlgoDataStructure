package algorithm;

public class MinimumWindowSubstring {

    /*
     * using two pointers technique.
     * 1. assign left and right pointers with 0.
     * 2. we will have two variables called have and needs. That's the only two variables we will check throughout.
     * 3. we need two char count arrays of size 52 each to handle both upper and lower case.
     * 4. we will need a private method called getIndex to get the right char index for both upper and lower case chars.
     * 5. populate first char array with all the values from t. Remember to only increment need once when the count1[index] value was 0.
     *    that way we don't need to check every single duplicate chars needed.
     * 6. using the sliding window technique.
     *    a) check if the char is in t, so we will check count1 index. if it's not zero then we care about current char at right index.
     *       and increment have if they are exactly the same.
     *    b) while we have same have and need, we will do two things.
     *       i) we will calculate current window size which contains all the chars in t. if it is less than
     *          previous min window, update the min window size and then update left pointer and right pointer. ( remember to add +1 to right pointer because
     *          we are using substring method at the end to return.
     *       ii) we will decrement the count2 index and check if the condition is still met. if not then decrement have. Remember the char counts of count2 at index must be
     *           greater than or equal to char count at count2 otherwise, our condition is not met. We want to consider all dupes inside t.
     *       iii) slide the left pointer to right by 1.
     *       iV) continue with the while loop until condition is not met.
     * 7. right will eventually become greater than s.length(). In this case we return the substring of s.
     *
     *
     * Time Complexity: O(N) even though we have nested while loop it is always used to move the left pointer to the right. so we can ignore that.
     * Space Complexity: O(52 + 52). we ignore the constants so space Compelxity is O(1).
     *
     * https://leetcode.com/problems/minimum-window-substring/
     * https://www.youtube.com/watch?v=jSto0O4AJbM
     *
     */
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int left=0;
        int right =0;
        int need = 0;
        int have =0;
        int n = s.length();
        char[] count1 = new char[52];
        char[] count2 = new char[52];

        int minLength = Integer.MAX_VALUE;
        int minLeft=0;
        int minRight =0;

        int index;
        for(int i=0; i< t.length(); i++){
            index = getIndex(t.charAt(i));
            count1[index]++;
            if(count1[index]-1 == 0)
                need++;
        }

        while(left < n && right < n){
            index = getIndex(s.charAt(right));
            if (count1[index]  !=0) {
                count2[index]++;
                if( count2[index] == count1[index]){
                    have++;
                }
            }
            while(left < n && have == need ){
                if(minLength >  (right - left ) +1){
                    minLength =  (right - left ) +1;
                    minLeft = left;
                    minRight = right+1;
                }

                index = getIndex(s.charAt(left));

                if (count1[index]  !=0 ) {
                    count2[index]--;
                    if(count2[index] < count1[index]){
                        have--;
                    }
                }
                left++;

            }

            right++;

        }
        return s.substring(minLeft, minRight);
    };

    private static  int getIndex(char c){
        return (Character.isUpperCase(c)) ?( c -'A') +26 : c -'a';
    }
    public static void main(String ...args){
        String s = "ADOBECODEBANC"; String t = "ABC";
        System.out.println("sub-string of "+ s +" that is the permutation of " + t +" is " + minWindow(s, t));

        s = "a"; t = "a";
        System.out.println("sub-string of "+ s +" that is the permutation of " + t +" is " + minWindow(s, t));

        s = "a"; t = "aa";
        System.out.println("sub-string of "+ s +" that is the permutation of " + t +" is " + minWindow(s, t));

        s = "ab"; t = "A";
        System.out.println("sub-string of "+ s +" that is the permutation of " + t +" is " + minWindow(s, t));

        s = "aa"; t = "aa";
        System.out.println("sub-string of "+ s +" that is the permutation of " + t +" is " + minWindow(s, t));

        s = "aaaaaaaaaaaabbbbbcdd"; t = "abcdd";
        System.out.println("sub-string of "+ s +" that is the permutation of " + t +" is " + minWindow(s, t));

    }
}
