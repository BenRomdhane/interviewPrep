package com.interview.prep.graphs;

import java.util.*;

/**
 * Created by Nikitash Pawar on 3/2/2017.
 */
public class KruskalMinSpanningTree {

    static class Edge {
        public Integer weight;
        public Integer startNode;
        public Integer endNode;

        public Edge(Integer weight, Integer startNode, Integer endNode) {

            this.weight = weight;
            this.startNode = startNode;
            this.endNode = endNode;
        }

        @Override
        public String toString() {
            return "weight " + weight + " startNode " + startNode + " endNode " + endNode;
        }

    }


    public static void main(String[] args) {

        List<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(18, 1, 3));
        edges.add(new Edge(10, 1, 2));
        edges.add(new Edge(6, 3, 2));
        edges.add(new Edge(70, 3, 4));
        edges.add(new Edge(20, 2, 5));
        edges.add(new Edge(10, 5, 6));
        edges.add(new Edge(10, 5, 7));
        edges.add(new Edge(5, 7, 6));

        int[] component = new int[8];
        for (int i = 0; i < component.length; i++) {
            component[i] = i;
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        List<Edge> minSpanningTree = new ArrayList<Edge>();
        int i = 0;
        while (minSpanningTree.size() != 6) {
            Edge edge = edges.get(i);
            System.out.println(edge.toString());
            if (component[edge.startNode] != component[edge.endNode]) {
                int temp=component[edge.endNode];
                minSpanningTree.add(edge);
                for (int j = 0; j < component.length; j++) {
                    if(component[j] == temp)
                    {
                        component[j] = component[edge.startNode];
                        System.out.println("Adding Vertex "+j+" to Component"+ component[edge.startNode]);
                    }

                }

            }
            i++;
        }

        for (int j = 0; j < component.length ; j++) {
            System.out.println(" vertexes or Min Spanning Tree "+j+" with component Id "+component[j]);
        }
        for (Edge edge :
                minSpanningTree) {
            System.out.println(edge);

        }


    }
}
