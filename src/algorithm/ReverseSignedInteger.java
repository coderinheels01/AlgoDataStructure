package algorithm;

/*
 * https://leetcode.com/problems/reverse-integer/
 * https://www.youtube.com/watch?v=tm1Yrb_SfBM
 */
public class ReverseSignedInteger {
    public static void main(String... args){
        int input = 123;
        System.out.println("reversed number of " + input + " is " + reverse(input));
    }

    public static int reverse(int input){
        int result = 0;
        int newResult =0;
        while(input != 0){
            newResult = (newResult * 10 ) + (input % 10 );
            if( (newResult - (input  % 10) )/10!= result)
                return 0;

            input /= 10;
            result = newResult;
        }
        return result;
    }
}
