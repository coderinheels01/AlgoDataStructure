package algorithm;
import algorithm.util.PrintUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheapestFlightWithKStops {

    /*
     * Find the cheapest flight with k stops on the way. We will solve this using Belleman-Ford algorithm.
     * 1. we will need price table for each node, filled with Infinity value.
     * 2. except the source node. The source node will be 0.
     * 3. create a while loop with k.
     * 4. inside the while loop
     *    a) we will copy the price array and work on the copy then clone it back to original price array.
     *    b) we will loop 2D flight array. ( we don't need nested loop here because we know the size of
     *    the nested array will be 3. ( index 0 being source, index 1 being destination and index 2 being distance aka weight)
     * 5. skip the node if the value of the price is Infinity.
     * 6. Otherwise calculate the weight from source to destination.
     *    weight at source could be more than 0 because it is cost to travel to current source from original source if there is any.
     *    so price[source] + distance = p[destination]
     * 7
     *
     * Time Complexity : O(N)
     * Space Complexity: O(N)
     *
     * https://www.youtube.com/watch?v=5eIK3zUdYmE
     * https://leetcode.com/problems/cheapest-flights-within-k-stops/
     *
     */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        while(k >=0 ){
            int[] tempPrices = prices.clone();
            for(int i=0; i< flights.length; i++){
                int source = flights[i][0];
                int destination = flights[i][1];
                int distance = flights[i][2];

                if(prices[source] == Integer.MAX_VALUE)
                    continue;
                if(prices[source] + distance < tempPrices[destination])
                    tempPrices[destination] = prices[source] + distance;
            }
            prices = tempPrices.clone();
            k--;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    private static Map<Integer, Map<Integer, Integer>> buildAdjacencyMap(int[][] flight){
        Map<Integer, Map<Integer, Integer>> adjacencyMatrix = new HashMap<>();
        for(int i=0; i< flight.length; i++){
            adjacencyMatrix.putIfAbsent(flight[i][0], new HashMap<>());
            adjacencyMatrix.get(flight[i][0]).put(flight[i][1], flight[i][2]);
        }
        return adjacencyMatrix;
    };
    public static void main(String ...args){

        /*     (100)       (600)
         *   0 ------> 1 ------> 3
         *   /\(100)  / (100)   /
         *    \    \/         /
         *       2 ----------(200)
         */
        int n = 4;
        int[][]flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}};
        int src = 0, dst = 3, k = 1;

//        System.out.println("----- SOURCE TO DESTINATION MATRIX ----- ");
//        PrintUtil.printTwoDIntArray(flights);
//        System.out.println("cheapest price from source " + src + " to "+ dst + " is " +findCheapestPrice(n,flights,src, dst, k) );

        src = 1; dst = 3; k=1;
        System.out.println("----- SOURCE TO DESTINATION MATRIX ----- ");
        PrintUtil.printTwoDIntArray(flights);
        System.out.println("cheapest price from source " + src + " to "+ dst + " is " +findCheapestPrice(n,flights,src, dst, k) );
    }
}
