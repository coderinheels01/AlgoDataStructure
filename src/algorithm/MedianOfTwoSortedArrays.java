package algorithm;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 *
 * 1 2 3 4
 * 5 6 7 8
 */
public class MedianOfTwoSortedArrays {

    public static void main(String... args){
        int[] input1 = {1,3};
        int[] input2 = {2};
        System.out.println("Median of inputs " + findMedian(input1, input2));
    }

    public static double findMedian(int[] input1, int[] input2){
        double result = 0.0;
        if(input1.length > input2.length){
            return findMedian(input2, input1);
        }

        int input1Length = input1.length;
        int input2Length = input2.length;

        int low = 0;
        int high = input1Length;

        while(low <= high){
            int pivotInput1 = ( low + high ) /2;
            int pivotInput2 = ( input1Length + input2Length + 1) / 2 - pivotInput1;

            int maxLeftInput1 = pivotInput1 == 0 ? Integer.MIN_VALUE : input1[pivotInput1-1];
            int minRightInput1 = pivotInput1 == input1Length ? Integer.MAX_VALUE : input1[pivotInput1];

            int maxLeftInput2 = pivotInput2 ==  0 ? Integer.MIN_VALUE : input2[pivotInput2-1];
            int minRightInput2 = pivotInput2 == input2Length ? Integer.MAX_VALUE : input2[pivotInput2];

            if(maxLeftInput1 <= minRightInput2 && maxLeftInput2 <= minRightInput1){
                    if( (input1Length + input2Length) % 2 == 0){
                      return (double)( Math.max(maxLeftInput2, maxLeftInput1) + Math.min(minRightInput2 ,minRightInput1) ) /2;
                     }
                    else {
                    return Math.max(maxLeftInput2, maxLeftInput1);
                  }

            }
            else if( maxLeftInput1 > minRightInput2)
                high = pivotInput1 - 1;
            else
                low = pivotInput1 + 1;

        }
        return result;
    }

}
