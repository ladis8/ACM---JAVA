package ZS_JUDGES.NOT_SOLVED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Ladis on 5.11.2016.
 */
public class SPOJ_PT07Z_LongestPathinTree {

    private static ArrayList[] graph;
    private static int [][] graph2;
    private static boolean [][] processed;

    public static void main (String [] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int numoftestcases = Integer.parseInt(sc.readLine());


        for (int test = 0; test < numoftestcases; test++) {

            String[] linecor = sc.readLine().split(" ");
            int m = Integer.parseInt(linecor[0]);
            int n = Integer.parseInt(linecor[1]);

            int[][] array = new int[m][n];
           processed = new boolean[m][n];


            for (int i = 0; i < m; i++) {
                String line = sc.readLine();
                for (int j = 0; j < n; j++) {
                    if (line.charAt(j) == '.') {
                        array[i][j] = 1;
                        processed [i][j] = false;
                    } else if (line.charAt(j - 1) == '#') {
                        array[i][j] = 0;
                        processed [i][j] = true;

                    }
                }
            }
            int longestpath = 0;

            for (int i = array.length-1; i >= 0; i--) {
                for (int j = array[0].length-1; j >= 0; j--) {
                    if (!processed[i][j]) {
                        int path = doBFS(new Integer[]{i, j}, array);

                        if (path > longestpath)
                            longestpath = path;
                    }

                }

            }
            System.out.println(longestpath);
        }
    }


            ///GETTING ARRAY OF NODS
           /*int[][] array = new int[m + 2][n + 2];

            int nodnumber = 0;
            for (int i = 1; i <= m; i++) {
                String line = sc.nextLine();
                for (int j = 1; j <= n; j++) {
                    if (line.charAt(j - 1) == '.') {
                        nodnumber++;
                        array[i][j] = nodnumber;

                    } else if (line.charAt(j - 1) == '#') {
                        array[i][j] = 0;
                    }
                }
            }*/

           /* graph2= new int [nodnumber][];
            for (int i=0; i < nodnumber; i++){

                graph2 [i] = new
            }*/


            ///MAKING GRAPH FROM ARRAY OF BOOLANS
           /* graph = new ArrayList[nodnumber + 1];
            for (int i = 1; i <= nodnumber; i++) {
                graph[i] = new ArrayList<Integer>();
            }*/


            /*for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {

                    if (array[i][j] != 0) {

                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                if (array[i + x][j + y] != 0 && array[i + x][j + y] != array[i][j]) {
                                    graph[array[i][j]].add(array[i + x][j + y]);
                                    // graph2 [array [i][j]-1][array [i+x] [j+y]-1] =1;
                                }
                            }
                        }
                    }
                }
            }*/

            //printArray(array);
            //System.out.println();
            //printArray(graph2);
            //System.out.println();


            /*
            int longestpath = 0;

            boolean[] processed = new boolean[nodnumber + 1];

            for (int i = 1; i <= nodnumber; i++) {

                if (!(processed[i])) {
                    int pointers[] = doBFS(1, i, graph);

                    if (pointers[i] != 0) {
                        int pointer = pointers[i];
                        int path = 1;
                        while (pointer != 1) {
                            processed[pointer] = true;
                            pointer = pointers[pointer];
                            path++;
                        }

                        if (path > longestpath)
                            longestpath = path;


                    }

                }

            }
            System.out.println(longestpath);
        }
    }

   /* private static void FloydWarshall (){
        for (int k = 1; k < graph2.length; k++) {

            for (int i = 1; i < graph2.length; i++) {

                for (int j = 0; j < graph2.length; j++) {

                    if (graph2[i][k] == Integer.MAX_VALUE || graph2[k][j] == Integer.MAX_VALUE) {
                        continue;

                    }

                    if (graph2[i][j] > graph2[i][k] + graph2[k][j]) {

                        graph2[i][j] = graph2[i][k] + graph2[k][j];


                    }
                }
            }
        }
    }*/


    private static void printGraph(){
        for (int i =1; i< graph.length;i++){
            System.out.print(i + ": ");
            for (int j =0; j< graph[i].size();j++){
                System.out.print(graph [i].get(j) + " ");

            }
            System.out.println();
        }
    }

    private static void printArray(int array [] []){

        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array [i].length ; j++) {
                if (array [i][j] ==Integer.MAX_VALUE)

                    System.out.print(". ");
                else
                    System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int  doBFS(Integer [] start, int [][]array ) {

        int goalx = 0;
        int goaly =0;

        boolean[][] graphVIS = new boolean[array.length][array [0].length];
        int [][] distances = new int [array.length][array[0].length];
        Queue<Integer[]> fronta = new LinkedList<Integer[]>();

        //do for start
        fronta.add(start);
        graphVIS[start[0]] [start [1]] = true;


        //do for all others
        while (!(fronta.isEmpty())) {

            Integer [] proccessed = fronta.poll();

           int i= proccessed [0];
           int j= proccessed [1];
            if (proccessed[0] == goalx && proccessed [1] ==goaly)
                return distances [goalx][goaly];

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if ((x !=0 || y!=0)&& i+x >= 0 && j+y >=0 && i+x < array.length && j+y <array [0].length){
                        if (array[i+ x][j + y] != 0  && !graphVIS [i+x] [j+y]) {
                            fronta.add(new Integer[] {i+ x, j+y});
                            graphVIS [i+x] [j+y] = true;
                            processed [i+x] [j+y] = true;
                            distances[i+x][j+y]=distances[i][j]+1;

                        }
                    }


                }
            }
        }
        return -1;

    }


    /*private static int [] doBFS(int start, int goal, ArrayList<Integer>[] graph ) {

        int [] pointers = new int [graph.length];
        boolean [] graphVIS = new boolean[graph.length];
        Queue<Integer> fronta = new LinkedList<Integer>();

        //do for start
        fronta.add(start);
        graphVIS [start] = true;

        //do for all others
        while (!(fronta.isEmpty())){

            int proccessed = fronta.poll();
            if (proccessed == goal)
                break;


            for (int neighbour : graph [proccessed]){

                if (!(graphVIS [neighbour])){

                    fronta.add(neighbour);
                    graphVIS [neighbour] = true;
                    pointers [neighbour] = proccessed;
                }
            }
        }



        return pointers;
        /*if (pointers [goal] == 0){
            return 0;
        }
        else {
            int pointer = pointers [goal];
            int path =1;
            while (pointer != start){

                pointer = pointers [pointer];
                path++;

            }
            return path;
        }*/

   // }


}
