package algorithm;
/*
    Given an array of n integers, find the third largest element. All the elements in the array are distinct integers.
    Example :


    Input: arr[] = {1, 14, 2, 16, 10, 20}
    Output: The third Largest element is 14

    Explanation: Largest element is 20, second largest element is 16
    and third largest element is 14

    Input: arr[] = {19, -10, 20, 14, 2, 16, 10}
    Output: The third Largest element is 16

    Explanation: Largest element is 20, second largest element is 19
    and third largest element is 16

    https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdLargestNumber {
    
    /*
     * O(3N) solution 
     * 1. declare a variable maxNumber then set it to first array item
     * 2. loop through array and find maximum number
     * 3. declare a variable called secondMax and assign min integer
     * 4. loop through array, if current number is greater than secondMax and less than maxNumber then you found your secondMax
     * 5. declare a variable thirdMax then set it to min integer
     * 6. loop through array, if current number is greater than thirdMax and less than secondMax then you found your thirdMax
     * 7. return thirdMax if it exists otherwise return maxNumber
     */
    public static int findThirdLargesOrMaxNumberMethod1(Integer[] numbers){
        Integer maxNumber = Integer.MIN_VALUE;
        Integer secondMax= Integer.MIN_VALUE;
        Integer thirdMax= Integer.MIN_VALUE;

        // find maximum number
        for(Integer number: numbers){
            if(number > maxNumber)
                maxNumber = number;
        }

        //find second largest number
        for(Integer number: numbers){
            if(number > secondMax && number < maxNumber)
                secondMax = number;
        }

        for(Integer number: numbers){
            if(number > thirdMax && number < secondMax)
                thirdMax = number;
        }
        return (thirdMax > Integer.MIN_VALUE) ? thirdMax : maxNumber ;
    }

    public static int findThirdLargesOrMaxNumberMethod2(Integer[] numbers){
        Integer maxNumber = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for(Integer number: numbers){
            if(maxNumber == null || number > maxNumber){
                maxNumber = number;
            }else if( secondMax == null || (number < maxNumber && number > secondMax) ){
                secondMax = number;
            }else if( thirdMax == null  || (number < secondMax && number > thirdMax)){
                thirdMax = number;
            }
        }

        return (thirdMax != null) ? thirdMax : maxNumber;
    }
    public static void main(String ...args){
        Integer[] numbers = {3, 2, 1};
        System.out.println("third max number is " + findThirdLargesOrMaxNumberMethod1(numbers));
        Integer[] numbers2 = {1,2};
        System.out.println("third max number is " + findThirdLargesOrMaxNumberMethod1(numbers2));
        System.out.println("---------------------------");
        System.out.println("third max number is " + findThirdLargesOrMaxNumberMethod2(numbers));
        System.out.println("third max number is " + findThirdLargesOrMaxNumberMethod2(numbers2));
    }
}
