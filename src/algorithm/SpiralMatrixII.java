package algorithm;

import algorithm.util.PrintUtil;

public class SpiralMatrixII {
    static int count= 1;

    /*
     * 1. create a global int called count starting from 1.
     * 2. create a result array of length and height n.
     * 3. create a seen array of length and height n.
     * 4. call dfs function with a flag going up as false.
     * 5. inside the dfs call
     *    a) check the boundaries of the array and check if the cell is already been seen.
     *    b) otherwise, populate the result array with count
     *    c) mark the cell as seen.
     *    d) keep calling dfs function if the goingUp flag is true. in up direction.
     *    e) call dfs function and move y to right by incrementing it by 1
     *    f) call dfs function and move x to down by incrementing it by 1
     *    g) call dfs function and move y to left by decrementing it by 1
     *    h) call dfs function and move x to up by decrementing it by 1.
     *       goingUP flag must be true when moving upward to keep moving that direction
     *
     * Input: n = 3
     * Output: [[1,2,3],[8,9,4],[7,6,5]]
     *
     * Input: n = 1
     * Output: [[1]]
     *
     * Time Complexity : O(N)
     * Space Complexity: O(N)
     *
     * https://leetcode.com/problems/spiral-matrix-ii/
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        if(n  <= 0)
            return result;
        generateDFS(result, seen, 0, 0, n, n, false);
        return result;
    }

    private static void generateDFS(int[][] result, boolean[][] seen, int x, int y, int rows, int cols, boolean goingUp ){
        if(x < 0 || x >= rows || y <0 || y >= cols || seen[x][y])
            return;

        result[x][y] = count;
        count++;
        seen[x][y] = true;

       if(goingUp)
           generateDFS(result, seen, x-1, y, rows, cols, true);
        generateDFS(result, seen, x, y+1, rows, cols, false);
        generateDFS(result, seen, x+1, y, rows, cols, false);
        generateDFS(result, seen, x, y-1, rows, cols, false);
        generateDFS(result, seen, x-1, y, rows, cols, true);
    }

    public static void main(String ...args){
        int n = 3;
        System.out.println("matrix for number " + n);
        int[][] result = generateMatrix(n);
        PrintUtil.printTwoDIntArray(result);

    }
}
