package algorithm;

public class StairCase {

    /*
     *  return min value of stepping two steps + stepping one step
     */
    public static int minCostClimbingStairsRecursion(int[] cost) {
        int n = cost.length;

        return Math.min(jump(cost, n-1), jump(cost, n-2));
    }
    private static int jump(int[] cost, int steps){
        if(steps < 0){
            return 0;
        }
        if(steps == 0 || steps ==1)
            return cost[steps];

        return  cost[steps] + Math.min(jump(cost, steps-1),  jump(cost, steps-2));
    }


    public static int minCostClimbingStairsRecursionDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        jump(cost, n-1, dp);

        return Math.min(dp[n-1] , dp[n-2]);
    };

    private static int jump(int[] cost, int n, int[] dp){
        if(n < 0)
            return 0;
        if(n == 0 || n == 1)
            dp[n] = cost[n];
        dp[n] = cost[n] + Math.min(jump(cost, n-1, dp) , jump(cost, n-2, dp));
        return dp[n];
    }

    public static int minCostClimbingStairsDynamicProgramming1(int[] cost){

        int n = cost.length;

        if(n == 0 || n == 1){
            return cost[n];
        }

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i< n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }


    public static void main(String ...args){
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairsRecursion(cost));
        System.out.println(minCostClimbingStairsDynamicProgramming1(cost));
        System.out.println(minCostClimbingStairsRecursionDP(cost));

        int[] cost1 = new int[]{10,15,20};
        System.out.println(minCostClimbingStairsRecursion(cost1));
        System.out.println(minCostClimbingStairsDynamicProgramming1(cost1));
        System.out.println(minCostClimbingStairsRecursionDP(cost1));
    }

}
