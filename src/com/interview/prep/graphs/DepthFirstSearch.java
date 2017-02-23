package com.interview.prep.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nikitash Pawar on 2/21/2017.
 */
public class DepthFirstSearch {

    public static void main(String[] args) {

        /*
        1. not best for finding the shortest path
        2. can be used with pre and post counters for every node- this information
        helps idntify few properties of the array- DFS Numbering - helps to identify if the graph is cyclic
        if there is a cut vertex- a vertex that disconnects 2 graphs if removed
         */
        Map<Integer, List<Integer>> adjacencyList = new TreeMap<Integer, List<Integer>>();
        Integer NumberOfVertices=10;

        int[] visited=new int[15];

        adjacencyList.put(1, Arrays.asList(new Integer[]{2, 3, 4}));
        adjacencyList.put(2, Arrays.asList(new Integer[]{1, 3}));
        adjacencyList.put(3, Arrays.asList(new Integer[]{1, 2}));
        adjacencyList.put(4, Arrays.asList(new Integer[]{1, 8, 6, 5}));
        adjacencyList.put(5, Arrays.asList(new Integer[]{4, 6, 7}));
        adjacencyList.put(6, Arrays.asList(new Integer[]{8, 9, 7, 5}));
        adjacencyList.put(7, Arrays.asList(new Integer[]{6, 5}));
        adjacencyList.put(8, Arrays.asList(new Integer[]{4, 6, 9}));
        adjacencyList.put(9, Arrays.asList(new Integer[]{10, 8, 6}));
        adjacencyList.put(10, Arrays.asList(new Integer[]{9}));
        adjacencyList.put(11, Arrays.asList(new Integer[]{12,13,14}));

        visited[1]=1;
        traversal(adjacencyList,visited,1);
        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i]+" "+i+" ,");

        }

    }

    private static void traversal(Map<Integer, List<Integer>> adjacencyList, int[] visited,int i) {
        System.out.println("Traversal for Node "+i);
        if (adjacencyList.get(i)==null)
        {
            return;
        }
        for (Integer node:adjacencyList.get(i)) {
            if (visited[node]!=1){
                visited[node]=1;
                System.out.println("Marking "+node+" as visited. Suspending exec");
                traversal(adjacencyList,visited,node);
                System.out.println("Restarting exec for node "+node);
            }
        }
    }
}
