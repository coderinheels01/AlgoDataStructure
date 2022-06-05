package algorithm;

import algorithm.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
     * dfs solution
     *
     * 1. create a new result array to store final result
     * 2. create seen boolean 2D array to mark already visited indexes
     * 3. call dfs function with, x=0, y=0, seen 2D array, original input array and boolean value called goingUp.
     * 4. going up boolean is important here because this will ensure that the pointer keeps moving upward and in that direction
     *    when dfs function is being called recursively.
     * 5. inside dfs function
     *    a) base case:  make sure the indexes are within boundary. and make sure the element isn't seen yet.
     *    b) mark seen array as true.
     *    c) add the element into the result list.
     *    d) call dfs function in right direction, down direction, left direction and up direction.
     *      IMPORTANT: when called up direction, we need to pass a flag as true to ensure the pointer keeps moving upward.
     *
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * Time complexity : O(N) because all elements get visited only once
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/spiral-matrix/
     *
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] seen = new boolean[rows][cols];
        dfs(matrix, seen, result, 0, 0, rows-1, cols-1, false);
        return result;
    };

    private static void dfs(int[][] matrix, boolean[][] seen, List<Integer> result,  int x, int y, int rows, int cols, boolean goingUp){
        if( x < 0 || x > rows || y < 0 || y > cols || seen[x][y])
            return;

        seen[x][y] = true;
        result.add(matrix[x][y]);

        if(goingUp){
            dfs(matrix, seen, result, x-1, y, rows, cols, true);
        }

        dfs(matrix, seen, result, x, y+1, rows, cols, false);
        dfs(matrix, seen, result, x + 1, y, rows, cols, false);
        dfs(matrix, seen, result, x, y-1, rows, cols, false);
        dfs(matrix, seen, result, x-1, y, rows, cols, true);

    }
    public static void main(String ...args){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        System.out.println("----- ORIGINAL MATRIX ----- ");
        PrintUtil.printTwoDIntArray(matrix);
        System.out.println("----- SPIRAL MATRIX  -----");
        spiralOrder(matrix).stream().forEach(x -> System.out.print(x + ", "));

        int[][] matrix1 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        System.out.println("----- ORIGINAL MATRIX ----- ");
        PrintUtil.printTwoDIntArray(matrix1);
        System.out.println("----- SPIRAL MATRIX  -----");
        spiralOrder(matrix).stream().forEach(x -> System.out.print(x + ", "));

    }
}
