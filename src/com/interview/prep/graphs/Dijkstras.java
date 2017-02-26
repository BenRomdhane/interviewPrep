package com.interview.prep.graphs;

import java.util.*;

/**
 * Created by Nikitash Pawar on 2/24/2017.
 */
public class Dijkstras {

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

/*        adjacencyList.put(1, Arrays.asList(new GraphNode[]{new GraphNode(3,80),new GraphNode(2,10)}));
        adjacencyList.put(2, Arrays.asList(new GraphNode[]{new GraphNode(1,10),new GraphNode(3,6),new GraphNode(5,20)}));
        adjacencyList.put(3, Arrays.asList(new GraphNode[]{new GraphNode(1,80),new GraphNode(2,6),new GraphNode(4,70)}));
        adjacencyList.put(4, Arrays.asList(new GraphNode[]{new GraphNode(3,70)}));
        adjacencyList.put(5, Arrays.asList(new GraphNode[]{new GraphNode(2,20),new GraphNode(7,10),new GraphNode(6,50)}));
        adjacencyList.put(6, Arrays.asList(new GraphNode[]{new GraphNode(5,50),new GraphNode(7,5)}));
        adjacencyList.put(7, Arrays.asList(new GraphNode[]{new GraphNode(6,5),new GraphNode(5,10)}));*/

        adjacencyList.put(1, Arrays.asList(new GraphNode[]{new GraphNode(3,80),new GraphNode(2,10)}));
        adjacencyList.put(2, Arrays.asList(new GraphNode[]{new GraphNode(1,10),new GraphNode(3,6),new GraphNode(5,20)}));
        adjacencyList.put(3, Arrays.asList(new GraphNode[]{new GraphNode(1,80),new GraphNode(2,6),new GraphNode(4,70)}));
        adjacencyList.put(4, Arrays.asList(new GraphNode[]{new GraphNode(3,70)}));
        adjacencyList.put(5, Arrays.asList(new GraphNode[]{new GraphNode(2,20),new GraphNode(7,10),new GraphNode(6,50)}));
        adjacencyList.put(6, Arrays.asList(new GraphNode[]{new GraphNode(5,50),new GraphNode(7,5)}));
        adjacencyList.put(7, Arrays.asList(new GraphNode[]{new GraphNode(6,5),new GraphNode(5,10)}));

        boolean [] visited= new boolean[adjacencyList.size()+1];
        int [] distance= new int[adjacencyList.size()+1];
        int [] parent= new int[adjacencyList.size()+1];

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


            GraphNode least = graphNodes.get(0);

            for (GraphNode temp:graphNodes) {
                System.out.println("Node :"+node+" Neighbour "+temp.value+" with Distance "+temp.distance);
                System.out.println("Possible new distance "+(temp.distance+distance[node]));
                if(visited[temp.value]==false && (distance[temp.value] > temp.distance+distance[node]))
                {
                    if(temp.value==least.value)
                    {
                        visited[temp.value]=true;
                    }
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
