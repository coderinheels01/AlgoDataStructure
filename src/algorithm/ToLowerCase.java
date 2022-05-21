package algorithm;
import java.util.stream.Collectors;

public class ToLowerCase {

    /*
     * Upper-cased string to lower-cased string.
     * 1. convert input string to char array
     * 2. loop the char array and check if each char is upper case.
     *    a) if yes, them adding 32 to character will convert the upper case char to lower case char. Then append the
     *       upper-cased char to result string.
     *    b) if no, then just append the char to the result string.
     *
     * Time Complexity : O(N)
     * Space Complexity: O(1)
     *
     * https://www.youtube.com/watch?v=6TGpf6ySgHo&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=18
     *
     */
    public static String toLowerCase(String input){
        String result = "";
        for(char c : input.toCharArray()){
            if(Character.isUpperCase(c)){
                result += (char) (c + 32);
            }
            else{
                result += c;
            }
        }
        return result;
    }
    public static String toLowerCaseStreamAPI(String input){
        return input.chars().mapToObj(c -> {
            if(Character.isUpperCase(c)){
                return String.valueOf( (char)( c + 32));
            }
            else{
                return String.valueOf( (char)( c ));
            }
        }).collect(Collectors.joining());
    }
    public static void main(String ...args){
        String original = "EICHOCHOAUNG";

        System.out.println("----- METHOD 1 ( using stream API )----- ");
        System.out.println("convert upper-cased String " + original + " to lower-cased " + toLowerCaseStreamAPI(original));
        System.out.println("----- METHOD 2 ( using normal for loop )----- ");
        System.out.println("convert upper-cased String " + original + " to lower-cased " + toLowerCase(original));

    }
}
