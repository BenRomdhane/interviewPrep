package com.interview.prep.graphs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Nikitash Pawar on 2/21/2017.
 */
public class GraphAdjacencyMatrix {

    private final int MAX_NO_OF_VERTICES;
    private int adjacency_matrix[][];

    private GraphAdjacencyMatrix(int number_of_vertices){

        MAX_NO_OF_VERTICES = number_of_vertices;
        adjacency_matrix = new int[MAX_NO_OF_VERTICES + 1][MAX_NO_OF_VERTICES + 1];
    }

    public static void main(String[] args) {

        init();

    }

    public static void init() {
        int number_of_vertices, count = 1;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        GraphAdjacencyMatrix adjacencyMatrix;

        try
        {
            System.out.println("Enter the Number of Vertices");
            number_of_vertices = scan.nextInt();
            System.out.println("Enter the Number of Edges");
            int number_of_edges = scan.nextInt();
            adjacencyMatrix = new GraphAdjacencyMatrix(number_of_vertices);

            System.out.println("Enter The Graph Egdes :<source> <destination>");
            while (count <= number_of_edges)
            {
                source = scan.nextInt();
                destination = scan.nextInt();
                adjacencyMatrix.setEdge(source, destination, 1);
                count++;
            }
            System.out.println("The adjacency matrix for given graph is");
            for (int i = 1; i <= number_of_vertices; i++)
                System.out.print(i);

            System.out.println();
            for (int i = 1; i <= number_of_vertices; i++)
            {
                System.out.print(i);
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    System.out.print(adjacencyMatrix.getEdge(i, j));
                }
                System.out.println();
            }
        } catch (InputMismatchException inputMisMatch)
        {
            System.out.println("Error in Input Format.<source index> <destination index>");
        }
        scan.close();
    }

    private int getEdge(int i, int j) {
        try
        {
            return adjacency_matrix[i][j];
        } catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("the vertex entered is not present");
        }
        return -1;    }

    private void setEdge(int source, int destination, int i) {
        try
        {
            adjacency_matrix[source][destination] = i;
        } catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("the vertex entered is not present");
        }    }

}
