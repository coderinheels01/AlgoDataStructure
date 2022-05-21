package algorithm;
/*
 * find a pivot index where the sum of left sub array is equal to the sum of right sub array.
 *
 * https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1/
 */
public class EquilibriumPoint {
    /*
     * brute force method to find the index where it's left sum is equal to right sum
     * 1. start with index 1 and look left then look right. loop left side and right side to find sum
     * 2. compare left sum with right sum.
     * 3. make sure to exclude current index from the left sum and right sum.
     *
     * Time complexity : O(N^2)
     * Space complexity: O(1)
     */
    public static int findEquilibriumPointMethod1(Integer[] input){
        for(int i= 1; i < input.length; i++){
            int left = 0;
            int right = 0;
            for(int j=1; j <= i; j++){
                left+= input[j-1];
            }
            for(int k=i+1; k < input.length; k++){
                right+= input[k];
            }
            if(left == right){
                return i;
            }
        }

        return -1;
    }
    /*
     * improved method for time complexity but this has space complexity cost
     * 1. calculate sum of all the indexes from left side and save in new array called prefix
     * 2. calculate sum of all the indexes from right side and save in new array called postfix
     * 3. loop postfix and prefix array and compare values at each index. if they both are equal then
     *    the equilibrium index point is found.
     *
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public static int findEquilibriumPointMethod2(Integer[] input){
        Integer[] prefixSum = new Integer[input.length];
        Integer[] postfixSum = new Integer[input.length];

        prefixSum[0] = input[0];
        for(int i=1; i< input.length; i++){
            prefixSum[i] = prefixSum[i-1] + input[i];
        }

        postfixSum[input.length-1] = input[input.length-1];
        for(int j = input.length-2; j >= 0; j--){
            postfixSum[j] = postfixSum[j+1] + input[j];
        }

        for(int k =0; k < input.length; k++){
            if(prefixSum[k] == postfixSum[k])
                return k;
        }
        return -1;
    }
    /*
     * Improved method for both time and space complexity
     * 1. sum all the elements in the right of index 0. ( so exclude index 0)
     * 2. loop the input array with two different indexes starting from 0 and 1.
     * 3. minus the value of higher array index from right sum and add the value of
     *    lower index to left sum.
     * 4. if the left sum and right sum are equal, we have found pivot point. otherwise, keep
     *    incrementing the index
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static int findEquilibriumPointMethod3(Integer[] input){
        int rightSum =0, leftSum = 0;

        for(int i= 1; i< input.length; i++){
            rightSum += input[i];
        }

        for(int i=0, j= 1; j< input.length; i++, j++){
            rightSum -= input[j];
            leftSum += input[i];

            if(leftSum == rightSum)
                return j;
        }

        return -1;
    }

    public static void main(String ...args){
        Integer[] input= {1,3,5,2,2};

        int index =  findEquilibriumPointMethod1(input);
        System.out.println(" ------------------- METHOD 1 ( Bruteforce Time: O(N^2), Space: O(1) ) ------------------- " );
        System.out.println(" the pivot index where left sum is equal to right sum is  " );
        System.out.println(index);

        index =  findEquilibriumPointMethod2(input);
        System.out.println(" ------------------- METHOD 2 ( Improved Time: O(N), Space: O(N) ) ------------------- " );
        System.out.println(" the pivot index where left sum is equal to right sum is  " );
        System.out.println(index);

        index =  findEquilibriumPointMethod3(input);
        System.out.println(" ------------------- METHOD 3 ( Improved Time: O(N), Space: O(1) ) ------------------- " );
        System.out.println(" the pivot index where left sum is equal to right sum is  " );
        System.out.println(index);
    }
}
