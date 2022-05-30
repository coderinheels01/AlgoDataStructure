package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformAllEmployee {

    /*
     *  1. build adjacency list aka orgMatrix with managers and it's subordinates relationship
     *  2. call dfs on manager
     *  3. dfs will traverse the subordinates and add up the total number of time take.
     *     Compare the number gotten from each vertex and get the max value.
     *  https://leetcode.com/problems/time-needed-to-inform-all-employees/
     */
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> orgMatrix = buildAdjacencyList(manager);
        int mins  = dfs(orgMatrix, informTime, headID, 0);
        return mins;
    }

    /*
     * base case, return 0 when it's at the leaf level node.
     * get all the subordinates and traverse through each.
     * find the max value from each subordinate vertex and sum with current time taken.
     */
    private static int dfs(Map<Integer, List<Integer>> orgMatrix,  int[] informTime, int currentManager, int timeTaken){
        if(informTime[currentManager] == 0)
            return 0;

        int maxTime =0;
        for(int v : orgMatrix.get(currentManager)){
            maxTime = Math.max(maxTime,dfs(orgMatrix, informTime, v, timeTaken));
        }
        return maxTime + informTime[currentManager];
    }

    private static Map<Integer, List<Integer>> buildAdjacencyList(int[] manager){
        Map<Integer, List<Integer>> orgMatrix = new HashMap<>();

        for(int i=0; i < manager.length; i++){
            if(orgMatrix.get(manager[i]) == null){
                List<Integer> employees = new ArrayList<>();
                employees.add(i);
                orgMatrix.put( manager[i], employees);
            }
            else{
                orgMatrix.get(manager[i]).add(i);
            }
        }

        return orgMatrix;
    }


    /*
     * graph:
     *                4 (7)
     *        /       /       \
     *      5(3)    2(4)     6(6)
     *     /       /  \        \
     *     7()0 0(0) 1(0)         3 (0)
     */
    public static void main(String ...args){
        int headOfId = 4;
        int n = 8;
        int[] managers = new int[]{2, 2, 4, 6, -1, 4, 4 , 5};
                                  //0, 1, 2, 3,  4,  5,  6,  7,
        int[] informTime = new int[]{ 0, 0, 4, 0, 7, 3, 6, 0 };
                                    //0, 1, 2, 3,  4,  5,  6,  7,
        System.out.println(numOfMinutes(n, headOfId, managers, informTime));;
    }
}
