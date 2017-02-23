package com.interview.prep.graphs;

import com.interview.prep.util.PrintArray;

import java.util.*;

/**
 * Created by Nikitash Pawar on 2/21/2017.
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        /**
         * can be used to find the shortest path and if a graph is cyclic
         *
         * Edges that BFS uses form a Tree.
         *
         * AFter the traversal if there are still some edges that have not been used
         * then the graph is a cyclic graph.
         * non-tree edge - edge not used by BFS - indicated presence of a cycle in a graph
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

        Queue<Integer> queue = new LinkedList<>();

        //find neighbour and push in queue
        //mark as neighbour visited
        //once finished exploring a vertex go back to the queue and pop out entry and then
        // explore that entry- push into queue the node that is not yet

        // explores level by level

            queue.add(1);
            visited[1]=1;
            System.out.println("Initializing queue with 1 and marking it as visited");
            while (queue.size() >0){
                Integer pop = queue.remove();
                System.out.println("Removing "+pop+" from Q");
                List<Integer> integers = adjacencyList.get(pop);
                System.out.println("Fetching neighbours for "+pop+" neighbours:"+integers.toString());
                for (Integer node:integers) {
                    if (visited[node]!=1)
                    {
                        queue.add(node);
                        visited[node]=1;
                        System.out.println("Marking "+node+" as visited and pushing to Q");
                    }

                }
            }
        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i]+" "+i+" ,");

        }
    }
}