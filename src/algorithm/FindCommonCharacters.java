package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    /*
     * 1. create a char array of 26 to store all the common char count of all the words
     * 2. fill the char array with Integer.MAX_VALUE.
     * 3. for each word,
     *     a) create a look up char array
     *     b) convert the word to char array
     *     c) for each char in the word, increment the char look up array by one
     * 4. compare the char look up array value and common array value and take the min
     *
     * Time Complexity : O(N * M) where N is the number of words, M is the number of char in each word.
     * Space Complexity: O(1) because we only store up to 26 chars each time which is constant.
     *
     * https://leetcode.com/problems/find-common-characters/
     * https://www.youtube.com/watch?v=k1iowWJimbg&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=60
     *
     */
    public static List<String> commonChars(String[] words) {
        List<String> common = new ArrayList<>();
        int[] chars = new int[26];
        Arrays.fill(chars, Integer.MAX_VALUE);

        for(String word: words){
            int[] char_lookup = new int[26];
            for(char c: word.toCharArray()){
                char_lookup[c - 'a']++;
            };
            for(int i=0; i< 26; i++){
                chars[i] = Math.min(chars[i], char_lookup[i]);
            }
        }

        for(int i=0; i< 26; i++){
            while(chars[i] > 0){
                common.add(""+ (char) (i + 'a'));
                chars[i]--;
            }
        }

        return common;
    };
    public static void main(String ...args){
        String[] words = {"bella","label","roller"};
        System.out.println(" ----- ORIGINAL WORDS ----- ");
        Arrays.stream(words).forEach(w -> System.out.print(w + " , "));
        System.out.println("\ncommon chars are ");
        commonChars(words).stream().forEach(w -> System.out.print(w + " , "));
    }
}
