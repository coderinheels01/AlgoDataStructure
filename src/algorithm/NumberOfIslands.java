package algorithm;

import java.util.LinkedList;
import java.util.Queue;
public class NumberOfIslands {

    /*
     * DFS explanation here
     * use recursion but no extra space
     * https://www.youtube.com/watch?v=U6-X_QOwPcs&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-
     */
    public static int findIslandsMethod1(int[][] input){
        int islands = 0;
        int rows = input.length;
        int cols = input[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(input[i][j] == 1){
                    islands++;
                    dfs(input, i, j);
                }
            }
        }
        return islands;
    }

    private static void dfs(int[][] input, int i, int j){
        if(i < 0 || i >= input.length || j < 0 || j >= input[0].length || input[i][j] != 1){
            return;
        }

        input[i][j] = 0;
        dfs(input, i - 1 , j); // up
        dfs(input, i + 1, j); // down
        dfs(input, i, j -1);// left
        dfs(input, i, j + 1); // right
    }
    /*
     * BFS explanation here
     * extra space using Queue
     * https://www.youtube.com/watch?v=HS7t2i9ldmE
     */
    public static int findIslandsMethod2(int[][] input){
        int islands = 0;
        int rows = input.length;
        int cols = input[0].length;

        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(input[i][j] == 1){
                    islands++;
                    bfs(input, i, j);
                }
            }
        }

        return islands;
    }

    private static void bfs(int[][] input, int i, int j){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{i,j});
        int numOfRows = input.length;
        int numOfCols = input[0].length;
        input[i][j] = 0;
        while(!queue.isEmpty()){
            Integer[] rowAndCol = queue.poll();
            int row = rowAndCol[0];
            int col = rowAndCol[1];

            int x = row-1;
            int y = col;
            if(x > -1 && x < numOfRows && y > -1 &&  y < numOfCols  && input[x][y] == 1){
                input[x][y] = 0;
                queue.add(new Integer[]{x, y});
            }
            x = row+1;
            y = col;
            if(x >-1 && x < numOfRows && y > -1 && y < numOfCols && input[x][y] == 1){
                input[x][y] = 0;
                queue.add(new Integer[]{x, y});
            }

            x = row ;
            y = col-1;
            if( x > -1 && x < numOfRows && y > -1 && y < numOfCols && input[x][y] == 1){
                input[x][y] = 0;
                queue.add(new Integer[]{x, y});
            }
            x = row ;
            y = col+1;
            if( x > -1 && x < numOfRows && y < numOfCols && input[x][y] == 1){
                input[x][y] = 0;
                queue.add(new Integer[]{x, y});
            }
        }

    }

    public static void main(String ...args){
     int[][] input1 = new int[][]{
             { 1,1,1,1,0 },
             { 1,1,0,1,0 },
             { 1,1,0,0,0 },
             { 0,0,0,0,0 },
     };

     int[][] input2 = new int[][]{
             { 1,1,0,0,0 },
             { 1,1,0,0,0 },
             { 0,0,1,0,0 },
             { 0,0,0,1,1 }
     };

        System.out.println(" -------- METHOD 1 (DFS) -------- ");
        System.out.println("number of islands for input 1 is " + findIslandsMethod1(input1));
        System.out.println("number of islands for input 2 is " + findIslandsMethod1(input2));

        System.out.println(" -------- METHOD 2 (BFS) -------- ");
        System.out.println("number of islands for input 1 is " + findIslandsMethod2(input1));
        System.out.println("number of islands for input 2 is " + findIslandsMethod2(input2));
    }
}
