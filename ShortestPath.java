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

        //Stopwatch related variables
        long start = 0;
        long end = 0;

        //Arrays for results of graphs
        int[] dijkstra;
        int[][] warshall;

        //Setting up graph
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
        System.out.println();


        /*** Dijkstra's Algorithm ***/
        //Times and runs Dijkstra's Algorithm
        start = System.nanoTime();
        dijkstra = dijkstraAlgorithm(graph, graphSize);
        end = System.nanoTime();

        //Prints out Dijkstra's Algorithm
        System.out.println("Dijkstra's Algorithm");
        System.out.println((double) ((end - start) / 1000000.0) + " Milliseconds");
        printResults(dijkstra);
        System.out.println();


        /*** Floyd-Warshall Algorithm ***/
        //Times and runs Floyd-Warshall Algorithm
        start = System.nanoTime();
        warshall = FWarshallAlgorithm(graph, graphSize);
        end = System.nanoTime();

        //Prints out Floyd-Warshall Algorithm
        System.out.println("Floyd-Warshall Algorithm");
        System.out.println((double) ((end - start) / 1000000.0) + " Milliseconds");
        printGraph(warshall);
        System.out.println();
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

    /*** Prints out array for debugging ***/
    public static void printArray(int[] graph)
    {
        for (int i = 0; i < graph.length; i++)
        {
            System.out.print(graph[i] + " ");
        }

        System.out.println();
    }

    /*** Prints Results of Algorithms ***/
    public static void printResults(int[] result)
    {
        System.out.println("Results from Dijkstra's Algorithm");
        for (int i = 1; i < result.length; i++)
        {
            System.out.printf("1 -> %d: %d\n", i + 1, result[i]);
        }
    }


    /*** Dijkstras Algorithm ***/
    public static int[] dijkstraAlgorithm(int[][] graph, int size)
    {
        int[] shortPath = new int[size];
        int selNode = 0;
        int prevSmallVal = 0;

        //Adds pathways from starting node
        for (int i = 0; i < size; i++)
        {
            shortPath[i] = graph[0][i];
        }

        //Dijkstras
        for (int i = 0; i < size; i++)
        {
            int smallNode = 0;
            int smallVal = 0;

            for (int j = 0; j < size; j++)
            {
                if (graph[selNode][j] != 0) //Checks node/vertex if empty
                {
                    if (smallVal == 0)  //Checks if small val has no value yet 
                    {
                        smallVal = graph[selNode][j] + prevSmallVal;
                        smallNode = j;
                    }

                    if (smallVal > graph[selNode][j])   //Checks if small val is smaller or larger
                    {
                        smallVal = graph[selNode][j];
                        smallNode = j;
                    }
                }
                
            }

            selNode = smallNode;
            prevSmallVal += smallVal;

            //Checks if node is bigger or empty to add
            if (shortPath[selNode] > prevSmallVal || shortPath[selNode] == 0)
            {
                shortPath[selNode] = prevSmallVal;  //places smallest value into graph
            }

            //Debugging
            /*System.out.println("SelNode: " + selNode);
            System.out.println("Previous Small Value: " + prevSmallVal);
            System.out.println("Shortest Path nodes: ");
            printArray(shortPath);
            System.out.println();*/
        }

        return shortPath;
    }

    /*** Floyd Warshall Algorithm ***/
    public static int[][] FWarshallAlgorithm (int[][] graph, int size)
    {
        int[][] shortPath = graph;

        for (int k = 0; k < size; k++)
        {
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    if (i == j)
                    {
                        continue;
                    }

                    if (shortPath[i][j] > shortPath[i][k] + shortPath[k][j] || shortPath[i][j] == 0)
                    {
                        shortPath[i][j] = shortPath[i][k] + shortPath[k][j];
                    }
                }
            }
        }

        return shortPath;
    }
}