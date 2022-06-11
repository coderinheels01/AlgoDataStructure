package algorithm;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    /*
     * 1. prefix each word with it's length and # to mark end of each word. for example: leet would be 4#leet
     * 2. append each encoded string to string builder then return toString() value of StringBuilder
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * https://www.lintcode.com/problem/659/
     * https://www.youtube.com/watch?v=B1k_sxOSgv8
     *
     */
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()+ "#"+ s);
        }

        return sb.toString();
    }
    /*
     * 1. while start index is less than n, look at each character #
     * 2. until the # is found save the chars before that because those will be converted into digits.
     * 3. parse the string using substring start index and end index and add to result
     * 4. return result
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     */
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder length = new StringBuilder();
        int n = str.length();
        int i =0;

         while( i< n){
            char c = str.charAt(i);
            while(c != '#'){
               length.append(c);
               i++;
               c = str.charAt(i);
            }
            int len = Integer.parseInt(length.toString());
            length.setLength(0);
            result.add(str.substring(i+1, i+ len +1));
            i+= len+1;
        }
        return result;
    };

    public static void main(String ...args){
        List<String> input = new ArrayList<>(){{
            add("lint");
            add("code");
            add("love");
            add("you");
        }};
        String encodedValue = encode(input);
        System.out.println("encoded message : "+ encodedValue);
        System.out.println(" decoded values ");
        decode(encodedValue).stream().forEach(s -> System.out.print(s + ", "));
    }
}
