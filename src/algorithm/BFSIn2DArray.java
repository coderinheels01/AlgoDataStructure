package algorithm;

import algorithm.util.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class BFSIn2DArray {

    static int[][] directions = new int[][]{
            {0, -1}, //up
            {1 , 0}, //right
            {0, 1}, // down
            {-1, 0} //left
    };


    /*
     * start from the middle of the 2 d array and traverse closest neighbour in this direction up, right, down, left.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static int[] bfs(int[][] input){
        int rows = input.length;
        int cols = input[0].length;

        boolean[][] seen = new boolean[rows][cols];

        int midX = (int) Math.floor((float)rows/2);
        int midY = (int) Math.floor((float)cols/2);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{midX, midY});
        seen[midX][midY] = true;

        int[] result = new int[input.length * input[0].length];
        result[0] = input[midX][midY];
        int currentIndex = 1;

        while(!q.isEmpty()){
            int[] current = q.remove();
            for(int i =0; i< directions.length; i++){
                int[] direction = directions[i];
                int newX = current[0]+ direction[0];
                int newY = current[1]+direction[1];
                if(newX >=0 && newY >= 0 && newX <input.length && newY < input[0].length && !seen[newX][newY]){
                    result[currentIndex] = input[newX][newY];
                    q.add(new int[]{newX ,newY});
                    seen[newX][newY] = true;
                    currentIndex++;
                }
            }
        }

        return result;
    };

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
        int[][] input = fill(4, 4);
        System.out.println("----- ORIGINAL 2D ARRAY -----");
        PrintUtil.printTwoDIntArray(input);
        int[] result = bfs(input);
        System.out.println("----- RESULT ARRAY -----");
        PrintUtil.printIntArrayWithoutName(result);
    }

}
