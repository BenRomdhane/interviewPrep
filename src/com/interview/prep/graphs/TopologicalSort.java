package com.interview.prep.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nikitash Pawar on 2/21/2017.
 */
public class TopologicalSort {
    // for a directed acyclic graph
    // find longest path to the node
    //topological sort based on indegree

    public static void main(String[] args) {

        Map<Integer, List<Integer>> adjacencyList = new TreeMap<Integer, List<Integer>>();
        adjacencyList.put(1, Arrays.asList(new Integer[]{3,4,5}));
        adjacencyList.put(2, Arrays.asList(new Integer[]{3,8}));
        adjacencyList.put(3, Arrays.asList(new Integer[]{6}));
        adjacencyList.put(4, Arrays.asList(new Integer[]{6,8}));
        adjacencyList.put(5, Arrays.asList(new Integer[]{8}));
        adjacencyList.put(6, Arrays.asList(new Integer[]{7}));
        adjacencyList.put(7, Arrays.asList(new Integer[]{8}));
        adjacencyList.put(8, Arrays.asList(new Integer[]{}));

        int[] indegree= new int[9];
        int[] topology=new int[9];
        int[] longestPath=new int[9];


        for (Integer key: adjacencyList.keySet()) {
            for (Integer integer : adjacencyList.get(key)) {
                indegree[integer]++;
            }
        }

        int k=0;

        for (int node=1; node < indegree.length && indegree[node]==0; node++) {
            System.out.println("Computing for Node "+ node);
            indegree[node]=-1;
            topology[k]=node;
            k++;
            List<Integer> links = adjacencyList.get(node);
            System.out.println("Links for Node "+links.toString());
            for (Integer link:links) {
                System.out.println("Indegree for "+link+" is "+indegree[link]);
                System.out.println("Longest Path to "+link+" is "+longestPath[link]);

                indegree[link]--;
                if(longestPath[link] < (longestPath[node]+1))
                {
                    longestPath[link]=(longestPath[node]+1);
                    System.out.println("Longest Path to "+link+" is now "+longestPath[link]);
                }
                System.out.println("New Indegree for "+link+" is "+indegree[link]);
            }
        }


        for (int i = 1; i < topology.length; i++) {
            System.out.print(topology[i]+" ,");
        }
        System.out.println();

        for (int i = 1; i < longestPath.length; i++) {
            System.out.print(longestPath[i]+" ,");
        }
    }
}
