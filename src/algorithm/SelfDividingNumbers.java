package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    /*
     * 1. loop in incremental order starting from left to right.
     * 2. check each number if it's divisible by it's own and all the digits inside it by calling the private funciton
     * 3. inside isSelfDivisible function
     *    a)
     *
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for(int n= left; n <= right; n++){
            if(isSelfDivisible(n)){
                result.add(n);
            }
        }
        return result;
    }

    private static boolean isSelfDivisible(int num){
        int n = num;
        while( num != 0 ){
            int divideBy = num % 10;
            if(divideBy == 0 || (n % divideBy )!= 0 ){
                return false;
            }

            num = num / 10;
        }
        return true;
    }


    public static void main(String ...args){
        /*
        *
        * Input: left = 1, right = 22
        * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
        */
        int left = 1;
        int right = 22;

        System.out.println("Self divisible numbers that are between "+ left + " and " + right + " are");
        selfDividingNumbers(left, right).stream().forEach(x -> System.out.print(x + ", "));
    }
}
