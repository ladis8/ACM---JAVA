package ZS_JUDGES; /**
 * Created by Ladis on 19.11.2016.
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class UVA_929_NumberMaze {

    Stack <Integer []> st0 = new Stack<Integer[]>();
    Stack <Integer []> st1 = new Stack<Integer[]>();
    Stack <Integer []> st2 = new Stack<Integer[]>();
    Stack <Integer []> st3 = new Stack<Integer[]>();
    Stack <Integer []> st4 = new Stack<Integer[]>();
    Stack <Integer []> st5 = new Stack<Integer[]>();
    Stack <Integer []> st6 = new Stack<Integer[]>();
    Stack <Integer []> st7 = new Stack<Integer[]>();
    Stack <Integer []> st8 = new Stack<Integer[]>();
    Stack <Integer []> st9 = new Stack<Integer[]>();



    public static void main (String [] args){


        Scanner sc = new Scanner (System.in);
        int numoftestcases =Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numoftestcases; i++){

            int row = Integer.parseInt(sc.nextLine());
            int column = Integer.parseInt(sc.nextLine());
            int [][] maze = new int [row][column];

            for (int j = 0; j < row; j++) {
                String [] input =sc.nextLine().split(" ");
                for (int k =0; k< column; k++){
                    maze [j] [k] =Integer.parseInt(input [k]);
                }
            }

            //printMaze(maze);
            System.out.println(dijkstra(maze));

        }

    }

    private static void printMaze(int [][]maze){
        for (int i =0; i< maze.length;i++){
            System.out.print(i + ": ");
            for (int j =0; j< maze[0].length;j++){
                System.out.print(maze [i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int dijkstra(int [][] graph) {


        boolean[][] xx = new boolean[graph.length][graph[0].length];
        int[][] distancesx = new int[graph.length][graph[0].length];
        for (int[] dis : distancesx) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
        distancesx[0][0] = graph [0][0];

        int startx = 0;
        int starty = 0;


        while (true) {

            if (startx + 1 < graph.length && !xx[startx + 1][starty]) {

                if (distancesx[startx + 1][starty] > (graph[startx + 1][starty] + distancesx[startx][starty]))
                    distancesx[startx + 1][starty] = (graph[startx + 1][starty] + distancesx[startx][starty]);

            }
            if (startx - 1 >= 0 && !xx[startx - 1][starty]) {
                if (distancesx[startx - 1][starty] > (graph[startx - 1][starty] + distancesx[startx][starty]))
                    distancesx[startx - 1][starty] = (graph[startx - 1][starty] + distancesx[startx][starty]);

            }
            if (starty - 1 >= 0 && !xx[startx][starty - 1]) {
                if (distancesx[startx][starty - 1] > (graph[startx][starty - 1] + distancesx[startx][starty]))
                    distancesx[startx][starty - 1] = (graph[startx][starty - 1] + distancesx[startx][starty]);

            }
            if (starty + 1 < graph[0].length && !xx[startx][starty + 1]) {
                if (distancesx[startx][starty + 1] > (graph[startx][starty + 1] + distancesx[startx][starty]))
                    distancesx[startx][starty + 1] = (graph[startx][starty + 1] + distancesx[startx][starty]);
            }


            int minx = -1, miny = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (min > distancesx[i][j] && xx [i][j] == false) {
                        min = distancesx[i][j];
                        minx = i;
                        miny = j;

                    }
                }

            }

            if (min == Integer.MAX_VALUE)
                return -1;

            else if (minx == graph.length - 1 && miny == graph[0].length - 1)
                return distancesx[minx][miny];

            else {
                xx[startx][starty] = true;
                startx = minx;
                starty = miny;
            }

        }
    }

}
