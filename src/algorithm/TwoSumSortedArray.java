package algorithm;

import algorithm.util.PrintUtil;

/*
 * https://www.baeldung.com/java-two-pointer-technique
 */
public class TwoSumSortedArray {
    public static void main(String... args){
        int[] input = new int[]{1, 5, 6, 8, 99};
        int target = 104;

        PrintUtil.printIntArray(calculateTwoSumMethod1(input, target), "Method 1");
        PrintUtil.printIntArray(calculateTwoSumMethod2(input, target), "Method 2");
    }

    private static int[] calculateTwoSumMethod1(int[] numbers, int target){
        for(int i =0; i< numbers.length; i++){
            for(int j = i+1; j< numbers.length ; j++){
                if(numbers[i] + numbers[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{};
    }

    private static int[] calculateTwoSumMethod2(int[] numbers, int target){
        int startPointer = 0;
        int endPointer = numbers.length -1;

        while(startPointer < endPointer){
            if(numbers[startPointer]+ numbers[endPointer] == target)
                return new int[]{startPointer, endPointer};
            else if(numbers[startPointer]+ numbers[endPointer] < target )
                startPointer++;
            else
                endPointer--;
        }
        return new int[]{};
    }

}
