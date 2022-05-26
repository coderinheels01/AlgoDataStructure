package algorithm;

import algorithm.util.PrintUtil;

public class KthLargestElementUsingQuickSelect {

    public static int findKthLargestNumber(int[] nums, int k){
        int indexToFind = nums.length - k;
        if(indexToFind < 0)
            return -1;
        int n = nums.length;
        quickSelect(nums, 0, n-1, indexToFind);
        return nums[indexToFind];
    }

    /*
     * quick select is like quick sort but it will not sort the whole array. It will only sort part of the array that
     * the index to find is in.
     */
    private static void quickSelect(int[] nums, int left, int right, int indexToFind){
        if(left < right){
            int partitionIndex = partition(nums, left, right);
            if( partitionIndex == indexToFind)
                return;
            else if( indexToFind > partitionIndex )
                quickSelect(nums, partitionIndex + 1, right, indexToFind);
            else if(indexToFind < partitionIndex){
                quickSelect(nums, left, partitionIndex-1, indexToFind);
            }
        }
    }

    private static int partition(int[] nums, int left, int right){
        int partitionIndex = left;
        int j = left;
        while(j < right){
            if(nums[j] <= nums[right]){
                swap(nums, partitionIndex, j);
                partitionIndex++;
            }
            j++;
        }
        swap(nums, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String ...args){
        int[] a = {3,2,1,5,6,4};
        System.out.println("----- original array ----- ");
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("----- sorted array ----- ");
        System.out.println("2nd largest number is " + findKthLargestNumber(a, 2));
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("3rd largest number is " + findKthLargestNumber(a, 3));
        PrintUtil.printIntArrayWithoutName(a);
        System.out.println("4th largest number is " + findKthLargestNumber(a, 4));
        PrintUtil.printIntArrayWithoutName(a);
    }
}
