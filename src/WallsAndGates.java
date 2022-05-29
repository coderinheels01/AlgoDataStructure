import algorithm.util.PrintUtil;

public class WallsAndGates {
    static int ROOM = Integer.MAX_VALUE;
    static int GATE =0;
    static int WALL = -1;

    static int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    /*
     * 1. traverse the matrix and find the Gate.
     * 2. do dfs from the GATE and span outward.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * https://leetcode.com/problems/walls-and-gates/
     *
     */
    public static int[][] minSteps(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;
         for(int i=0; i< matrix.length; i++){
             for(int j= 0; j< matrix[0].length; j++){
                if(matrix[i][j]== GATE){
                    dfs(matrix, i, j,  matrix[i][j]);
                }

             }
         }


        return matrix;
    }
    private static void dfs(int[][] matrix, int x, int y , int previousStep){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || previousStep > matrix[x][y] ){
            return;
        }

        matrix[x][y] = previousStep;
        for(int i = 0; i < directions.length; i++){
            int xVal = x + directions[i][0];
            int yVal = y + directions[i][1];
            dfs(matrix, xVal, yVal, previousStep +1);
        }
    }

    public static void main(String ...args){
        int[][] matrix = new int[][]{
                {ROOM, WALL, GATE, ROOM},
                {ROOM, ROOM, ROOM, WALL},
                {ROOM, WALL, ROOM, WALL},
                {GATE, WALL, ROOM, ROOM}

        };
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printTwoDIntArray(matrix);
        System.out.println("----- MIN STEPS ARRAY -----");
        PrintUtil.printTwoDIntArray(minSteps(matrix));

        int[][] matrix2 = new int[][]{
                {ROOM, WALL, GATE, ROOM},
                {WALL, ROOM, ROOM, WALL},
                {ROOM, WALL, ROOM, WALL},
                {GATE, WALL, ROOM, ROOM}
        };
        System.out.println("----- ORIGINAL ARRAY -----");
        PrintUtil.printTwoDIntArray(matrix2);
        System.out.println("----- MIN STEPS ARRAY -----");
        PrintUtil.printTwoDIntArray(minSteps(matrix2));
    }
}
