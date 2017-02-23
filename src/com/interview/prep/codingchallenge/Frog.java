package com.interview.prep.codingchallenge;

import java.util.*;

/**
 * Created by Nikitash Pawar on 2/22/2017.
 */
public class Frog {

    public static void main(String[] args) {

        int[][] map= {{3,4},
                {1,1,1,2},
                {3,1,1,1},
                {1,1,1,2},
                {2,2,2,1},
                {1,1,2,2},
                {1,1,2,2}};

        Map<Integer,List<Integer>> adjacencyList = construct(map);
        Queue<Integer> queue=new LinkedList<Integer>();
        int[] visited=new int[(map[0][0]*map[0][1])+1];
        int[] parent=new int[(map[0][0]*map[0][1])+1];
        List<Integer> linkedNodes = adjacencyList.get(1);

        for (Integer linkedNode:linkedNodes) {
            queue.add(linkedNode);
            visited[linkedNode]=1;
        }

        while (queue.size()!=0){
            Integer pop = queue.remove();
            List<Integer> links = adjacencyList.get(pop);
            for (Integer link:links) {
                if (visited[link]==0){
                    queue.add(link);
                    parent[link]=pop;
                    visited[link]=1;
                }

            }
        }

        for (int i = 1; i < parent.length; i++) {
            System.out.println("Parent of "+i+" is "+parent[i]);
        }
        int pathSize=1;
        int currNode=map[0][0]*map[0][1];
        while (parent[currNode]!=0){
            currNode=parent[currNode];
            pathSize++;
        }
        System.out.println(pathSize);

    }

    private static Map<Integer, List<Integer>> construct(int[][] map) {

        int rows=map[0][0];
        int cols = map[0][1];
        int k=1;
        Map<Integer, List<Integer>> adjacencyList=new TreeMap<Integer, List<Integer>>();

        System.out.println(rows+" "+cols);

        for (int i = 1; i <= (map.length - 1)/2; i++) {
            for (int j = 0; j < map[1].length; j++,k++) {
                //System.out.println("For "+i+" and "+j+" value is: "+map[i][j]);
                System.out.println("Node "+k+" is linked to "+(getRightNodes(k,map[i][j],rows*cols)));
                if(adjacencyList.get(k)!=null)
                {
                    adjacencyList.get(k).addAll(getRightNodes(k,map[i][j],rows*cols));

                }else{
                    adjacencyList.put(k, (getRightNodes(k,map[i][j],rows*cols)));
                }

            }
        }

        k=1;
        for (int i = ((map.length - 1)/2)+1; i < map.length ; i++) {
            for (int j = 0; j < map[1].length; j++,k++) {
                //System.out.println("For "+i+" and "+j+" value is: "+map[i][j]);
                System.out.println("Node "+k+" is linked to "+getDownNodes(k,map[i][j],cols,rows*cols));
                if(adjacencyList.get(k)!=null)
                {
                    adjacencyList.get(k).addAll(((getDownNodes(k,map[i][j],cols,rows*cols))));

                }else{
                    adjacencyList.put(k, (getDownNodes(k,map[i][j],cols,rows*cols)));
                }
            }

        }



        return adjacencyList;
    }

    private static List<Integer> getDownNodes(int node, int jumpSize,int colSize,int cap) {
        List<Integer> list=new ArrayList<Integer>();
        int counter=1;
        while (counter<=jumpSize && (node+(counter*colSize)) <=cap){
            list.add(node+(counter*colSize));
            counter++;
        }
        return list;
    }

    private static List<Integer> getRightNodes(int k,int jumpSize,int cap) {

        List<Integer> list=new ArrayList<Integer>();

        while (jumpSize!=0 && k+jumpSize <=cap){
            list.add(k+jumpSize);
            jumpSize--;
        }
        return list;
    }

}
