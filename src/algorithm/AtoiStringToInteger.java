package algorithm;

public class AtoiStringToInteger {
    /*
     * https://leetcode.com/problems/string-to-integer-atoi/
     *
     *
     */
    public static void main(String... args){
        String s = "45";
        System.out.println(" string " + s + " = " + "integer " + atoiStringToInteger(s));
        s = "   -42";
        System.out.println(" string " + s + " = " + "integer " + atoiStringToInteger(s));
        s = "4193 with words";
        System.out.println(" string " + s + " = " + "integer " + atoiStringToInteger(s));
        s = "words and 987";
        System.out.println(" string " + s + " = " + "integer " + atoiStringToInteger(s));
        s = "-91283472332";
        System.out.println(" string " + s + " = " + "integer " + atoiStringToInteger(s));
        s = "91283472332";
        System.out.println(" string " + s + " = " + "integer " + atoiStringToInteger(s));
    }

    /*
     * https://www.youtube.com/watch?v=zwZXiutgrUEs
     */
    public static int atoiStringToInteger(String s){
        int i=0;
        int result = 0;
        int sign = 1;

        if(s.length() == 0 ) return 0;

        while(s.charAt(i) == ' ' ) i++;

        if(s.charAt(i) == '-'){
            i++;
            sign = -1;
        }
        else if(s.charAt(i) == '+'){
            i++;
        }

        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i)<= '9'){
            int digit = s.charAt(i) - '0';
            if(Integer.MAX_VALUE/10 < result || ( result == Integer.MAX_VALUE/10 && digit > 7) ){
                return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return result * sign;

    }
}
