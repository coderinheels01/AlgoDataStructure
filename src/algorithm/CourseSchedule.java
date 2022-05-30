package algorithm;

import java.util.*;
import java.util.stream.IntStream;

public class CourseSchedule {

    /*
     * bfs approach
     *
     * for each course, visit all the neighbour nodes and the neighbour of the neighbours
     * 1. put each vertex that is not seen in q.
     * 2. visit the neighbours and mark them as seen
     * 3. if the current node is same as the parent node, then we have a cycle so we return false.
     * 4. otherwise continue visiting neighbours of each child vertex.
     *
     * Time Complexity : O(N ^ 3)
     * Space Complexity : O(N ^ 3)
     */
    public static boolean canFinishBruteForce(int numCourses, int[][] prerequisites) {

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> courseMap = buildCourseMap(prerequisites);

        for(int course= 0; course < numCourses; course++){
              List<Integer> neighbours = courseMap.get(course);
              boolean[] seen = new boolean[numCourses];
              if(neighbours != null){
                  for(int v : neighbours){
                      q.add(v);
                  }
              }
            while(!q.isEmpty()){
                int v = q.remove();
                seen[v] = true;
                if(v == course)
                    return false;

                List<Integer> neighbours2 = courseMap.get(v);
                if(neighbours2 != null){
                    for(int v2 : neighbours2){
                        if(!seen[v2])
                            q.add(v2);
                    }
                }

            }

        }

        return true;
    }

    private static Map<Integer, List<Integer>> buildCourseMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
            for(int i=0; i< prerequisites.length; i++){
                int prerequisite = prerequisites[i][1];
                int course = prerequisites[i][0];
                if(courseMap.get(prerequisite) == null){
                    List<Integer> courseList = new ArrayList<>();
                    courseList.add(course);
                    courseMap.put(prerequisite,courseList);
                }
                else{
                    courseMap.get(prerequisite).add(course);
                }
            }
        return courseMap;
    }


    /*
     * topological sort ( solves the directed graph problems without a cycle )
     * 1. count all the incoming edges for each vertex, put them in inDegreeArray.
     * 2. pick the vertex from inDegreeArray with 0 edge
     * 3. visit all the neighbours of the vertex picked and decrement count of each neighbour from inDegreeArray.
     * 4. repeat the process.
     * 5. once out of the loop see if all values in inDegreeArray are -1. if no then return false;
     *
     * Note edge cases:
     *    if the vertex of zero inDegree cant be found initially, we have a cyclic graph and return false;
     *  https://leetcode.com/problems/course-schedule/
     *
     * Time Complexity : O(N^2)
     * Space Complexity: O(N^2)
     *
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = buildCourseMap(prerequisites);
        int[] inDegreeArray = buildInDegreeArray(numCourses, prerequisites);

        Queue<Integer> q = new LinkedList<>();
        int vertex = findVertexWithZeroInDegree(inDegreeArray);
        q.add(vertex);
        boolean[] seen = new boolean[numCourses];

        if(vertex == -1)
            return false;
        while(!q.isEmpty()){
            int v = q.remove();
            List<Integer> neighbours = courseMap.get(v);
            seen[v] = true;
            if(neighbours != null){
                for(int n : neighbours){
                    inDegreeArray[n]--;
                }
            }
            int nextVertex = findVertexWithZeroInDegree(inDegreeArray);
            if(nextVertex == -1 )
                break;
            if(!seen[nextVertex])
                q.add(nextVertex);

        }

        for(int i=0; i< inDegreeArray.length; i++){
            if(inDegreeArray[i]>-1)
                return false;
        }
        return true;
    };


    private static int findVertexWithZeroInDegree(int[] inDegreeArray){
        for(int i=0; i< inDegreeArray.length; i++){
            if(inDegreeArray[i] == 0){
                inDegreeArray[i] = -1;
                return i;
            }
        }
        return -1;
    }

    private static int[] buildInDegreeArray(int numCourses, int[][] prerequisites){
        int[] inDegreeArray = new int[numCourses];

        for(int i=0; i< prerequisites.length; i++){
            int course = prerequisites[i][0];
            inDegreeArray[course]++;
        }

        return inDegreeArray;
    }

    public static void main(String ...args){
        int numCourses = 6;

//        /*
//         *  0 --- 3 --- 4
//         *   \    |   /
//         *    1    5
//         *     \   |
//         *         2
//         * is there a cycle? no
//         */
//
//        int[][] prerequisites = new int[][]{
//                {1, 0},
//                {2, 1},
//                {2, 5},
//                {0, 3},
//                {4, 3},
//                {3, 5},
//                {4, 5}
//        };
//        System.out.println(" ----- METHOD 1 -----");
//        System.out.println("can finish? " + canFinishBruteForce(numCourses, prerequisites));
//        System.out.println(" ----- METHOD 2 -----");
//        System.out.println("can finish? " + canFinish(numCourses, prerequisites));
//        numCourses = 7;
//
//        /*
//         *       3                     4
//         *     /                     /   \
//         *    0  --- 1 --- 2        5 --- 6
//         *
//         * is there a cycle ? yes
//         */
//        int[][] prerequisites2 = new int[][]{
//                {0, 3},
//                {1, 0},
//                {2, 1},
//                {4, 5},
//                {6, 4},
//                {5, 6}
//                };
//        System.out.println(" ----- METHOD 1 -----");
//        System.out.println("can finish? " + canFinishBruteForce(numCourses, prerequisites2));
//        System.out.println(" ----- METHOD 2 -----");
//        System.out.println("can finish? " + canFinish(numCourses, prerequisites2));
//        numCourses = 2;
//        /*
//         * 1 -> 0
//         *
//         * is there a cycle ? no
//         */
//        int[][] prerequisites3 = new int[][]{
//                {0, 1}
//        };
//        System.out.println(" ----- METHOD 1 -----");
//        System.out.println("can finish? " + canFinishBruteForce(numCourses, prerequisites3));
//        System.out.println(" ----- METHOD 2 -----");
//        System.out.println("can finish? " + canFinish(numCourses, prerequisites3));

        numCourses =2;
        int[][] prerequisites4 = {{1,0},{0,1}};

        /*
         *   _______
         *   |     |
         *   0---> 1
         */
        System.out.println(" ----- METHOD 1 -----");
        System.out.println("can finish? " + canFinishBruteForce(numCourses, prerequisites4));
        System.out.println(" ----- METHOD 2 -----");
        System.out.println("can finish? " + canFinish(numCourses, prerequisites4));
    }
}
