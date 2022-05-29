package algorithm;

import algorithm.util.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    static int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    /*
     * 1. scan the entire gird, count the fresh oranges ( 1s ) and find the
     *    positions of rotten oranges ( 2s). Add the positions of rotten oranges
     *    into a queue.
     * 3. while q is not empty. process each elements at position
     * 4. inside the while loop,
     *    1. we need to process the coordinates put inside the queues level by level. Becuase we can
     *       rot only adjacent fresh oranges at a time.
     *    2. remove first coordinates to process from queue
     *    3. move up, down, left, right from those positions, check for fresh oranges and mark them as processed with 2.
     *       Be sure to keep in mind the boundaries of the array while marking them. At the same time decrement the fresh oranges count.
     *       We do this to save having to scan through the whole grid to find if there is any left over fresh oranges. Be sure not to count
     *       the very last level when increasing the minute.
     *    4. return -1 if there are fresh oranges left. Otherwise, return minutes.
     *
     * Time Complexity : O(N) - even though we have nested for loops we only touches each orange once.
     * Space Complexity : O(N) - at worst case scenario, the entire grid is filled with rotten oranges ( 2 ) and we will
     *                    have to push all the oranges into the queue.
     *
     */
    public static int orangesRotting(int[][] grid) {
        if(grid  == null || grid.length == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i< grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    freshOranges++;
                else if(grid[i][j] == 2 ){
                    q.add(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0 ){
                int[] position = q.remove();
                for(int i =0; i < directions.length; i++){
                    int newI = position[0] + directions[i][0];
                    int newJ = position[1] + directions[i][1];
                    if(newI >=0 && newI < grid.length && newJ >=0 && newJ < grid[0].length && grid[newI][newJ] == 1){
                        q.add(new int[]{newI, newJ});
                        grid[newI][newJ] = 2;
                        freshOranges--;
                    }
                }
                size--;
            }
            if(!q.isEmpty())
                minutes++;
        }

        return  (freshOranges) > 0 ? -1 : minutes ;
    }


    public static void main(String ...args) {
        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println(" original grid ");
        PrintUtil.printTwoDIntArray(grid);
        System.out.println("total number of minutes to rot all oranges : " + orangesRotting(grid));

        int[][] grid1 = new int[][]{
                {2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
        System.out.println(" original grid ");
        PrintUtil.printTwoDIntArray(grid1);
        System.out.println("total number of minutes to rot all oranges : " + orangesRotting(grid1));
         int[][] grid2 = {{0,2,2}};

        System.out.println(" original grid ");
        PrintUtil.printTwoDIntArray(grid2);
        System.out.println("total number of minutes to rot all oranges : " + orangesRotting(grid2));

         int[][] grid3 = {{0}};
        System.out.println(" original grid ");
        PrintUtil.printTwoDIntArray(grid3);
        System.out.println("total number of minutes to rot all oranges : " + orangesRotting(grid3));

        int[][] grid4 = {
                 {2,1,1}
                ,{1,1,1}
                ,{0,1,2}};
        System.out.println(" original grid ");
        PrintUtil.printTwoDIntArray(grid4);
        System.out.println("total number of minutes to rot all oranges : " + orangesRotting(grid4));

    }
}
