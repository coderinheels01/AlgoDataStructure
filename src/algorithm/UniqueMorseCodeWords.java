package algorithm;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    /*
     * 1. create a String map of Morse code.
     * 2. loop the word and loop the char of each word.
     * 3. get the Morse code from the map. ( index = c - 'a', that will give the ASCII of the char). append the value to the string builder
     * 4. append each mose code into StringBuilder
     * 5. add each transformation into the set.
     * 6. return the size of the set.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Input: words = ["gin","zen","gig","msg"]
     * Output: 2
     *
     * Input: words = ["a"]
     * Output: 1
     *
     * https://leetcode.com/problems/unique-morse-code-words/
     * https://www.youtube.com/watch?v=ZF7KWiYsI6I&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=54
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueMorseCode = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String word: words){
            for(char c : word.toCharArray()){
                sb.append(MORSE[c-'a']);
            }
            uniqueMorseCode.add(sb.toString());
            sb.setLength(0);
        }

        return uniqueMorseCode.size();
    }

    public static void main(String ...args){
        String[] words = {"gin","zen","gig","msg"};
        System.out.println("number of unique morse code representation : " + uniqueMorseRepresentations(words));
    }
}
