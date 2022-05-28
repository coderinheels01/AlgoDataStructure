package algorithm;

import algorithm.util.PrintUtil;


public class DFSIn2DArray {

    //this direction order is very important.
    static int[][] directions = new int[][]{
            {-1, 0}, // up
            {0, 1}, //right
            {1, 0}, // down
            {0, -1}}; // left



    public static int[] dfs(int[][] input){
        int rows = input.length;
        int cols = input[0].length;
        boolean[][] seen = new boolean[rows][cols];
        int[] result = new int[rows * cols];
        explore(input, seen, result, 0, 0, rows, cols, 0);
        return result;
    }
    private static void explore(int[][] input, boolean[][] seen, int[] result, int x, int y, int rows, int cols, int currentIndex){
        if( x >= cols || y >= rows|| y < 0 || x < 0 || seen[x][y])
            return;

        seen[x][y] = true;
        result[currentIndex] = input[x][y];
        currentIndex++;

        for(int i = 0; i < directions.length; i++){
            int xVal = x + directions[i][0];
            int yVal = y + directions[i][1];
            explore(input, seen, result, xVal, yVal, rows, cols, currentIndex);
        }
    }


    private static  int[][] fill(int rows, int cols){
        int[][] input = new int[rows][cols];
        int count = 1;
        for(int i=0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                input[i][j] = count;
                count++;
            }
        }
        return input;
    }

    public static void main(String ...args){
        int[][] input = fill(3, 3);
        System.out.println("----- ORIGINAL 2D ARRAY -----");
        PrintUtil.printTwoDIntArray(input);
        int[] result = dfs(input);
        System.out.println("----- RESULT -----");
        //1, 2, 3, 6, 9, 8, 5, 4, 7
        //1, 2, 3, 6, 9, 8, 7, 4, 5
        PrintUtil.printIntArrayWithoutName(result);

    }
}
