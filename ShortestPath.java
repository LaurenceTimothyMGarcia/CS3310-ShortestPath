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

        System.out.println("Would you like to create your own graph or build a random one? (1 for build, 2 for random): ");
        int choice = kb.nextInt();

        while (!(choice == 1 || choice == 2))
        {
            System.out.print("Please choose 1 for build or 2 for random: ");
            choice = kb.nextInt();
        }

        if (choice == 1)
        {
            graph = buildGraph(graph, graphSize, kb);
        }
        else if (choice == 2)
        {
            graph = buildRandomGraph(graph, graphSize);
        }

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

    /*** User builds their own adjency matrix graph ***/
    public static int[][] buildGraph(int graph[][], int size, Scanner kb)
    {
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
                    System.out.printf("What is edge weight of [%d] to [%d]: ", i + 1, j + 1);
                    graph[i][j] = kb.nextInt();
                }
            }
        }

        System.out.println();

        return graph;
    }

    /*** Builds random graph in a matrix ***/
    public static int[][] buildRandomGraph(int graph[][], int size)
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


    /*** Dijkstras Algorithm ***/
    public static void dijkstraAlgorithm(int[][] graph, int size)
    {
        int[] shortPath = new int[size];

        //Adds pathways from starting node
        for (int i = 0; i < size; i++)
        {
            shortPath[i] = graph[0][i];
        }

        for (int i = 0; i < size; i++)
        {

        }
    }

    /*** Floyd Warshall Algorithm ***/
}