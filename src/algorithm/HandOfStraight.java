package algorithm;

import algorithm.util.PrintUtil;
import java.util.TreeMap;

public class HandOfStraight {
    /*
     * 1. base case:  if the cards length is not divisible by group size
     * 2. loop through all cards and put them in a TreeMap with key as the card and their count as the value. Using TreeMap here because we want the cards
     *    to be sorted.
     * 3. while the cards TreeMap size is not zero. we get the first card of the tree and loop for the group size in incremental order.
     * 4. if the cards does not contain the card then return false.
     * 5. otherwise,
     *   a) check if the card count is 1, if yes remove from the cards map
     *   b) check if the card count is greater than 1, if yes then decrement the card count by 1.
     *
     * Time Complexity : O(N^2)
     * Space Complexity : O(N)
     *
     *
     * https://leetcode.com/problems/hand-of-straights/submissions/
     * https://www.youtube.com/watch?v=amnrMCVd2YI
     * https://www.youtube.com/watch?v=6JF-fxiDjIc&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=34
     */
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> cards = new TreeMap<>();

        for(int card: hand){
            if(!cards.containsKey(card)){
                cards.put(card, 1);
            }
            else{
                cards.put(card, cards.get(card)+1);
            }
        }

        int firstCard;
        int cardCount;

        while(cards.size() > 0){
            firstCard =  cards.firstKey();

            for(int card = firstCard; card < firstCard+groupSize; card++){
                if(!cards.containsKey(card)){
                    return false;
                }
                else{
                    cardCount =  cards.get(card);
                    if(cardCount == 1)
                        cards.remove(card);
                    else{
                        cards.replace(card, cardCount-1);
                    }
                }
            }

        }

     return true;
    }
    public static void main(String ...args){
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int  groupSize = 3;

        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(hand);
        System.out.println("can it be grouped for the size of "+ groupSize +" ? " + isNStraightHand(hand, groupSize));

        int[] hand2 =  {1,2,3,4,5};
        int groupSize2 = 4;

        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printIntArrayWithoutName(hand2);
        System.out.println("can it be grouped for the size of "+ groupSize +" ? " + isNStraightHand(hand2, groupSize2));
    }
}
