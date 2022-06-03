
package algorithm;

import java.util.*;

public class Dijkstra {

    public static int shortestPathOptimized(int[][] times, int N, int K){
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){

            //{{2,1,1},{2,3,1},{3,4,1}}
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
            System.out.println();
        }

        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N+1];
        int res = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
    }

    public static int shortestPath(int[][] times, int n, int k){
        Map<Integer, List<Integer[]>> matrix = buildAdjacencyMatrix(times);
        //{{2,1,1},{2,3,1},{3,4,1}}
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        minHeap.add(new int[]{0, k});
        boolean[] seen = new boolean[n+1];
        int shortestPath = 0;

        while(!minHeap.isEmpty()){
            int[] current = minHeap.remove();
            int currentVertex = current[1];
            int currentWeight = current[0];
            if(seen[currentVertex]) continue;
            seen[currentVertex] = true;
            shortestPath = currentWeight;
            n--;
            List<Integer[]> neighbours = matrix.get(currentVertex);
            if(neighbours != null){
                for(Integer[]  neighbour : neighbours){
                    minHeap.add(new int[]{currentWeight + neighbour[0], neighbour[1]});
                }
            }

        }
         return n== 0 ? shortestPath : -1;
    };

    private static Map<Integer, List<Integer[]>>  buildAdjacencyMatrix(int[][] times){
        Map<Integer, List<Integer[]>> adjacencyList = new HashMap<>();
        for(int i=0; i < times.length; i++){
           int from =  times[i][0];
           int to =  times[i][1];
           int weight =  times[i][2];

            if(adjacencyList.get(from) == null){
                List<Integer[]> neighbours = new ArrayList<>();
                neighbours.add(new Integer[]{ weight, to});
                adjacencyList.put(from, neighbours);
            }
            else{
                adjacencyList.get(from).add(new Integer[]{ weight, to});
            }
        }
        return adjacencyList;
    };

    public static void main(String ...args){
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(shortestPathOptimized(times, n, k));
        System.out.println(shortestPath(times, n, k)    );

        int[][] times2 = {{1, 2, 9}, {1, 4, 2}, {2, 5, 1}, {4, 2, 4}, {4, 5, 6}, {3, 2, 3}, {5, 3, 7}, {3, 1, 5}};
        n = 5;
        k = 1;
        System.out.println(shortestPathOptimized(times2, n, k));
        System.out.println(shortestPath(times2, n, k));


    }
}

