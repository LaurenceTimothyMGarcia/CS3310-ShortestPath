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
    }

    public static int keyboardInput(Scanner kb)
    {
        int input = 0;

        System.out.println("Please input quantity of vertices in graph");
        input = kb.nextInt();

        return input;
    }

    //Builds random graph in a matrix
    public static int[][] buildGraph(graph[][], size)
    {
        Random rand = new Random();

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (i == j)
                {
                    graph[0][0] = 0;
                }
            }
        }

        return graph;
    }
}