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

    public static void main(String ...args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println("----- PRICES OF EACH DAY -----");
        PrintUtil.printIntArrayWithoutName(prices);
        System.out.println("max profit : " + maxProfit(prices));
    }
}
