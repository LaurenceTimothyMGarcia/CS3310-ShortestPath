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

        int graph[][] = new int[][];
    }

    public static int keyboardInput(Scanner kb)
    {
        int input = 0;

        System.out.println("Please input quantity of vertices in graph");
        input = kb.nextInt();

        return input;
    }
}