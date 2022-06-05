package algorithm;

import algorithm.util.PrintUtil;

public class PeakIndexInMountainArray {

    /*
     * do a binary search on the array.
     * 1. set left as 0. and right as the lenght of the arrary.
     * 2. find mid point (right + left ) / 2
     * 3. compare element at mid point with element at mid point plus one.
     * 4. if element at mid point is less than element at mid+1, we are still in the increasing order.
     *    so we move the left index to mid +1;
     * 5. otherwise we move the right index to mid.
     *
     * Time Complexity : O(logN)
     * Space Complexity: O(1)
     *
     * input :  mountain = [0,1,0]
     * output:  1
     *
     *
     * https://leetcode.com/problems/peak-index-in-a-mountain-array/
     * https://www.youtube.com/watch?v=LHfS7bA6dCA&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=48
     *
     */
    public static int peakIndexInMountainArray(int[] mountain){
        int peakIndex = -1;

        peakIndex = binarySearch(mountain);

        return peakIndex;
    }

    private static int binarySearch(int[] mountain){
        int left =0;
        int right = mountain.length;

        while(left < right){
            int mid =  (int) Math.floor((float)(right + left) /2);
            if(mountain[mid] <= mountain[mid+1]){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }

    public static void main(String ...args){
        int[] mountain = {0,1,0};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(mountain);
        System.out.println("peak of the index is : " + peakIndexInMountainArray(mountain));

        int[] mountain1  = {18,29,38,59,98,100,99,98,90};
        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printIntArrayWithoutName(mountain1);
        System.out.println("peak of the index is : " + peakIndexInMountainArray(mountain1));
    }
}
