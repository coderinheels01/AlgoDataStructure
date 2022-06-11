package algorithm;

import algorithm.util.PrintUtil;

public class BestTimeToBuySellStock {

    /*
     * 1. if there is a price lower than maxPrice then save that value.
     * 2. otherwise calculate max profit by subtracting price[i] from minPrice. compare with previous maxProfit. if current profit
     *    is larger then store that value
     * 3. return the max profit saved.
     *
     * Time Complexity: O(N)
     * Space Complexity :O(1)
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * https://www.youtube.com/watch?v=3RHCb8LY-X4&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=66
     *
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i< prices.length; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            else if( prices[i]-minPrice > maxProfit ){
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    };

    /*
     * using two pointer technique. both left and right pointers starting at 0.
     *  left pointer = buy, right pointer = sell
     * 1. initialize left and right pointers with 0 but one will be looking for low price and the other will look for high price.
     * 2. check if price at left index is higher than right pointer then we move left pointer to find the low price. on first day, both are pointing
     *    at zero index so we will always start with moving the right pointer to the next value.
     * 3. otherwise keep moving right index and calculate profit at that index, then compare to maxProfit and replace maxProfit if the profit of the day is
     *    higher.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public static int maxProfitTwoPointer(int[] prices) {
        int left =0;
        int right =0;
        int n = prices.length;
        int maxProfit = 0;

        while(left < n &&  right < n){
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            if(prices[left] > prices[right]){
                left++;
            }
            else{
                right++;
            }
        }

        return maxProfit;
    };

    public static void main(String ...args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println("----- PRICES OF EACH DAY -----");
        PrintUtil.printIntArrayWithoutName(prices);
        System.out.println("max profit : " + maxProfit(prices));
        System.out.println("(two pointer solution ) max profit : " + maxProfitTwoPointer(prices));
    }
}
