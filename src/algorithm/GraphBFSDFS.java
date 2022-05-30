package algorithm;

import algorithm.util.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFSDFS {

    private static List<List<Integer>>  buildGraph(){
        List<List<Integer>> graph = new ArrayList<>(){
            {
                add( new ArrayList<>(){
                    {
                        add(1);
                        add(3);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(0);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(3);
                        add(8);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(0);
                        add(2);
                        add(4);
                        add(5);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(3);
                        add(6);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(3);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(4);
                        add(7);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(6);
                    }
                });
                add( new ArrayList<>(){
                    {
                        add(2);
                    }
                });
            }
        };
        return graph;
    }


    public static int[] bfs(List<List<Integer>> graph){
        boolean[] seenVertices = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[graph.size()];
        q.add(0);
        int vertex;
        int currentIndex =0;
        while(!q.isEmpty()){
            vertex = q.remove();

            result[currentIndex] = vertex;
            seenVertices[vertex] = true;
            currentIndex++;
            List<Integer> neighbours = graph.get(vertex);
            for(int v : neighbours){
                if(!seenVertices[v])
                    q.add(v);
            }
        }
        return result;
    }

    public static int[] dfs(List<List<Integer>> graph){
        int[] result = new int[graph.size()];
        boolean[] seen = new boolean[graph.size()];
        dfsExplore(graph, result, seen, 0);
        return result;
    }

    static int CURRENT = 0;
    private static void dfsExplore(List<List<Integer>> graph , int[] result,boolean[] seen ,int vertex){
        result[CURRENT++] = vertex;
        seen[vertex] = true;

        List<Integer> neighbours = graph.get(vertex);

        for(int v: neighbours){
            if(!seen[v]){
                dfsExplore(graph, result, seen, v );
            }
        }
    }

    public static void main(String ...args){
        List<List<Integer>> graph = buildGraph();
        System.out.println("----- adjacent list graph ----- ");
        PrintUtil.printNestedArrayList(graph);
        System.out.println("----- bfs result -----");
        PrintUtil.printIntArrayWithoutName(bfs(graph));
        System.out.println("----- dfs result -----");
        PrintUtil.printIntArrayWithoutName(dfs(graph));
    }
}
