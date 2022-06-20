package algorithm;

public class ClimbingStairs {

    /*
     * using recursions.
     * 1. if n == 0 then we've reached our destination.
     * 2. if n < 0 then we overstepped and went out of bound.
     * 3. return the sum of recursive call of n-1 and n-2 when n-1 being if we jump once and n-2 being if we jump 2
     *
     * Time Complexity : O( 2^n )
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/climbing-stairs/
     * https://www.youtube.com/watch?v=Y0lT9Fck7qI
     *
     */
    public static int climbStairsRecursion(int n) {
        if( n == 0)
            return 1;
        if(n < 0)
            return 0;

        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    };


    /*
     * using dynamic programming
     * 1. if n is less than 1 then return n. Meaning if we don't have at least 2 stairs we won't compute. There are exactly n number of ways to
     *    get to the n-th stairs if n is less than 1.
     * 2. store dp[0] as 1, dp[1] = 2. Note: 0 and 1 are indexes here. They represent n = 1 and n=2.
     * 3. loop starting i= 2 to i<n, we compute dp[i] by summing dp[i-1] + dp[i-2]
     * 4. return dp[n-1]
     *
     * Time Complexity: O(N).
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/climbing-stairs/
     * https://www.youtube.com/watch?v=Y0lT9Fck7qI
     */
    public static int climbStairsDynamicProgramming(int n) {
        if(n <= 1)
            return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    };
    public static void main(String ...args){
        int n =1;
        System.out.println("(Recursion) a number of ways to get to " + n + " stairs is " + climbStairsRecursion(n));
        System.out.println("(Dynamic Programming) a number of ways to get to " + n + " stairs is " + climbStairsDynamicProgramming(n));

        n =2;
        System.out.println("(Recursion) a number of ways to get to " + n + " stairs is " + climbStairsRecursion(n));
        System.out.println("(Dynamic Programming) a number of ways to get to " + n + " stairs is " + climbStairsDynamicProgramming(n));

        n =3;
        System.out.println("(Recursion) a number of ways to get to " + n + " stairs is " + climbStairsRecursion(n));
        System.out.println("(Dynamic Programming) a number of ways to get to " + n + " stairs is " + climbStairsDynamicProgramming(n));

        n =5;
        System.out.println("(Recursion) a number of ways to get to " + n + " stairs is " + climbStairsRecursion(n));
        System.out.println("(Dynamic Programming) a number of ways to get to " + n + " stairs is " + climbStairsDynamicProgramming(n));

        n =10;
        System.out.println("(Recursion) a number of ways to get to " + n + " stairs is " + climbStairsRecursion(n));
        System.out.println("(Dynamic Programming) a number of ways to get to " + n + " stairs is " + climbStairsDynamicProgramming(n));

    }
}
