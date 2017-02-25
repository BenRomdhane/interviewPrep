package com.interview.prep.codingchallenge;

import java.util.*;

/**
 * Created by Nikitash Pawar on 2/24/2017.
 */
public class NumberTriples {


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

        /**
         * 9 1 11
         1 2 5
         5 2 6
         1 3 8
         8 1 11
         1 1 6
         10 1 6
         11 3 6
         10 4 8
         10 1 11
         Sample Output 1:

         YES
         3
         */

        adjacencyList.put(1, Arrays.asList(new GraphNode[]{new GraphNode(5,2),new GraphNode(8,3),new GraphNode(6,1)}));
        adjacencyList.put(5, Arrays.asList(new GraphNode[]{new GraphNode(6,2),new GraphNode(1,2)}));
        adjacencyList.put(6, Arrays.asList(new GraphNode[]{new GraphNode(1,1),new GraphNode(5,2),new GraphNode(10,1),new GraphNode(11,3)}));
        adjacencyList.put(8, Arrays.asList(new GraphNode[]{new GraphNode(1,3),new GraphNode(11,1),new GraphNode(10,4)}));
        adjacencyList.put(10, Arrays.asList(new GraphNode[]{new GraphNode(6,1),new GraphNode(8,4),new GraphNode(11,1)}));
        adjacencyList.put(11, Arrays.asList(new GraphNode[]{new GraphNode(6,3),new GraphNode(10,1),new GraphNode(8,1)}));

        Set<Integer> integerSet = adjacencyList.keySet();
        List<Integer> list=new ArrayList<Integer>(integerSet);
        boolean [] visited= new boolean[12];
        int [] distance= new int[12];
        int [] parent= new int[12];

        for (int i = 0; i < distance.length; i++) {
            distance[i]=Integer.MAX_VALUE;
        }

        distance[1]=0;
        visited[1]=true;
        parent[1]=0;

        Set<Integer> nodesList = adjacencyList.keySet();

        for (Integer node:nodesList ) {

            List<GraphNode> graphNodes = adjacencyList.get(node);
            Collections.sort(graphNodes, new Comparator<GraphNode>() {
                @Override
                public int compare(GraphNode o1, GraphNode o2) {
                    return o1.distance-o2.distance;
                }
            });

            // find the closest node to the source node
            GraphNode least = graphNodes.get(0);

            for (GraphNode temp:graphNodes) {
                System.out.println("Node :"+node+" Neighbour "+temp.value+" with Distance "+temp.distance);
                System.out.println("Possible new distance "+(temp.distance+distance[node]));
                //iterate over the linked nodes
                //find a node that is unvisited
                //update the distance of the node to the least possible distance
                // remember in the beginning distance of every node is initialized to infinity

                if(visited[temp.value]==false && (distance[temp.value] > temp.distance+distance[node]))
                {
                    if(temp.value==least.value)
                    {
                        //mar only the closet node as visited and not other nodes
                        //this allows them to be visited by another path that has a lesser distance
                        visited[temp.value]=true;
                    }
                    //update distance of the node
                    distance[temp.value]=temp.distance+distance[node];
                    System.out.println("At :"+node+" for Neighbour "+temp.value+" updating distance to "+distance[temp.value]);

                }

            }
        }

        for (int i = 1; i <distance.length ; i++) {
            System.out.println("For Node "+i+" distance is "+distance[i]);
        }


    }
}
