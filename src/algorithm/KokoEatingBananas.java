package algorithm;

import algorithm.util.PrintUtil;

public class KokoEatingBananas {

    /*
     * 1. find the max banana from the piles. ( reason being is because if koko can eat max pile in one
     *    hour, then she can each all the piles less than max pile in one hour, since h >= piles.length always,
     *    we can gaurantee that koko will be able to finish all the piles in less than given h if she eats at the speed
     *    of k being max(piles).
     * 2. we will do binary search from k = 1 to k = max(pile). The reason k being 1 is because ko ko will have to eat at
     *    lease 1 banana at at time.
     * 3. first we find mid value between 1 and max(pile). see if koko can finish the pile in given hour, if she can then we
     *    store that value as minK then move our pointer to the left sub-array so we can find smaller k value.
     * 4. if koko can't eat at the rate k=mid to finish all the piles in given h hour then we have to increase koko's eating speed
     *    and find a value she can finish eating all the piles in given hour by searching the right sub-array.
     *
     * 5. return minK stored.
     *
     * Time Complexity : O(P Log max(P)) so O(NLogN)
     * Space Complexity : O(1).
     *
     * https://leetcode.com/problems/koko-eating-bananas/
     * https://www.youtube.com/watch?v=U2SozAs9RzA
     *
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int max = max(piles);

        int left =1; int right = max;
        int hours;
        int minK = Integer.MAX_VALUE;

        while(left <= right){
            int k = ( left + right) /2;
            hours = 0;
            for(int p :  piles){
                hours += Math.ceil( (float) p /k);
            }
            if( hours <= h){
                minK = Math.min(minK, k);
                right = k - 1;
            }
            else{
                left = k+1;
            }

        }

        return minK;
    }

    private static int max(int[] pile){
        int maxValue = Integer.MIN_VALUE;

        for(int i=0; i< pile.length; i++){
            maxValue = Math.max(maxValue, pile[i]);
        }
        return maxValue;
    }
    public static void main(String ...args){
        int[] pile = {3,6,7,11};
        int h = 8;
        System.out.println(" ----- PILES OF BANANA ----- ");
        PrintUtil.printIntArrayWithoutName(pile);
        System.out.println("minimum banana ko ko should be eating to eat all the piles in less than" + h +" hours is "+ minEatingSpeed(pile, h));
    }
}
