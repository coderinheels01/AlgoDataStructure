package algorithm;

import algorithm.util.PrintUtil;

public class QuickSort {

    /*
     * only need this function to call quick sort recursion function with left and right indexes.
     */
    public static void sort(int[] nums){
        int n = nums.length;
        quickSort(nums, 0, n-1);
    }

    /*
     * 1. as long as left is still less than right index, find the partition index
     * 2. run quick sort on left side from the partition index
     * 3. run quick sort on right side from the partition index.
     */
    private static void quickSort(int[] nums, int left, int right){
        if( left < right){
            int partitionIndex = partition(nums, left, right);
            quickSort(nums,left, partitionIndex -1);
            quickSort(nums, partitionIndex, right );
        }

    }
    /*
     * 1. pick a pivot, in this case is the right most element
     * 2. pick index left and right, first start from left most element.
     * 3. check if element at right is less than element at pivot? then swap element at left and right.
     *    and then increment left;
     * 4. at the end, swap element at pivot and element at left.
     * 5. return left as the partition
     */
    private static int partition(int[] nums, int left, int right){
        int partitionIndex = left;
        int j = left;
        while(j < right){
            if(nums[j] < nums[right]){
                swap(nums, partitionIndex, j);
                partitionIndex++;
            }
            j++;
        }
        swap(nums, partitionIndex, right);
        return partitionIndex;
    }
    private static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String ...args){
        int[] a = {3,2,1,5,6,4};
        System.out.println("----- original array ----- ");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("----- sorted array ----- ");
        sort(a);
        PrintUtil.printIntArrayWithoutName(a);
    }
}
