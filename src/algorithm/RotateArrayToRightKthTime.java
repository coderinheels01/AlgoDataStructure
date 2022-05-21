package algorithm;

import algorithm.util.PrintUtil;
/*
 * https://www.baeldung.com/java-two-pointer-technique
 * https://www.youtube.com/watch?v=iCzPkkpakd0
 */
public class RotateArrayToRightKthTime {

    public static void main(String... args){
        int[] input1 = new int[]{1,2, 3, 8, 9,10 };
        int k1 = 3;
        int[] input2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k2 = 4;
        PrintUtil.printIntArray(rotateArrayMethod1(input1, k1), "Method 1");
        PrintUtil.printIntArray(rotateArrayMethod2(input2, k2), "Method 2");
    }

    public static int[] rotateArrayMethod1(int[] numbers, int k){
        int temp;
        while(k > 0){
            temp = numbers[numbers.length-1];
            for(int i= numbers.length-1; i>0; i--){
                numbers[i] = numbers[i-1];
            }
            numbers[0] = temp;
            k--;
        }
        return numbers;
    }

    public static int[] rotateArrayMethod2(int[] numbers, int k ){
        reverse(numbers, 0, numbers.length-1);
        reverse(numbers, 0, k-1);
        reverse(numbers, k, numbers.length-1);
        return numbers;
    }
    private static void reverse(int[] numbers, int start, int end){
        int temp;
        while(start < end){
            temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

}
