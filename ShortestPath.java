//Laurence Timothy M. Garcia
//CS 3310.01
//Professor Huong Luu
//Project 2 - Shortest Path

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class ShortestPath
{
    public static void main(String[] args)
    {
        //Keyboard input
        Scanner kb = new Scanner(System.in);

        int graphSize = keyboardInput(kb);

        int graph[][] = new int[graphSize][graphSize];

        graph = buildGraph(graph, graphSize);

        System.out.println("Graph: ");
        printGraph(graph);
    }

    public static int keyboardInput(Scanner kb)
    {
        int input = 0;

        System.out.println("Please input quantity of vertices in graph");
        input = kb.nextInt();

        return input;
    }

    /*** Builds random graph in a matrix ***/
    public static int[][] buildGraph(int graph[][], int size)
    {
        Random rand = new Random();

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (i == j)
                {
                    graph[i][j] = 0;
                }
                else
                {
                    graph[i][j] = rand.nextInt(10);
                }
            }
        }

        return graph;
    }

    /*** Prints out the graph in matrix form ***/
    public static void printGraph(int[][] graph)
    {
        for (int i = 0; i < graph.length; i++)
        {
            for (int j = 0; j < graph[i].length; j++)
            {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}