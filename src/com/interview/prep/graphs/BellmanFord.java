package com.interview.prep.graphs;

import java.util.*;

/**
 * Created by Nikitash Pawar on 2/26/2017.
 */
public class BellmanFord {
    /*
    1. not greedy like dijkstras
    2. it ssays: dont try to find a perticular sequence, rather in general find all sequqnces of updates
    3. Algo
     -initialize D[s]=0
     -initialize D[u]=0
     - update all edges n-1 times. If N nodes then N-1 Edges, if more than N-1 Edges then there is a loop
     */

    public static class GraphNode{
        public int value;
        public int distance;

        public GraphNode(int value,int distance)
        {
            this.value = value;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        Map<Integer,List<GraphNode>> adjacencyList=new TreeMap<Integer, List<GraphNode>>();

        adjacencyList.put(1, Arrays.asList(new GraphNode[]{new GraphNode(8,8),new GraphNode(2,10)}));
        adjacencyList.put(2, Arrays.asList(new GraphNode[]{new GraphNode(6,2)}));
        adjacencyList.put(3, Arrays.asList(new GraphNode[]{new GraphNode(2,1),new GraphNode(4,1)}));
        adjacencyList.put(4, Arrays.asList(new GraphNode[]{new GraphNode(5,3)}));
        adjacencyList.put(5, Arrays.asList(new GraphNode[]{new GraphNode(6,-1)}));
        adjacencyList.put(6, Arrays.asList(new GraphNode[]{new GraphNode(3,-2)}));
        adjacencyList.put(7, Arrays.asList(new GraphNode[]{new GraphNode(2,-4),new GraphNode(6,-1)}));
        adjacencyList.put(8, Arrays.asList(new GraphNode[]{new GraphNode(7,1)}));

        int [] distance= new int[adjacencyList.size()+1];
        int [] parent= new int[adjacencyList.size()+1];
        Set<Integer> visitedNodes=new HashSet<Integer>();
        for (int i = 0; i < distance.length; i++) {
            distance[i]=Integer.MAX_VALUE;
        }

        distance[1]=0;
        Set<Integer> vertices = adjacencyList.keySet();

        //for all edges N-1 times
        // as a shortest path between N has atmost N-1 edges
        for (int i = 1; i < vertices.size(); i++) {
            //visiting every edge to update the distance
            for (Integer vertex:vertices) {
                List<GraphNode> edges = adjacencyList.get(vertex);
                for (GraphNode edge :edges) {
                    if(distance[vertex]!=Integer.MAX_VALUE &&
                            distance[vertex]+edge.distance < distance[edge.value])
                    {
                    distance[edge.value]=distance[vertex]+edge.distance;
                    }
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            System.out.println("Node "+i+" value "+distance[i]);
        }

    }
}