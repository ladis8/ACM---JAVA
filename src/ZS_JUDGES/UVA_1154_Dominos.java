package ZS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Ladis on 19.11.2016.
 */
public class UVA_1154_Dominos {

   static boolean [] graphVIS;
    static ArrayList [] graph;
    public static void main (String [] args) throws IOException {


        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int numoftestcases =Integer.parseInt(sc.readLine());

        for (int i = 0; i < numoftestcases; i++){

            String [] input =sc.readLine().split(" ");
            int vertex = Integer.parseInt(input [0]);
            int domino = Integer.parseInt(input [1]);

            //MAKING GRAPH
            graph = new ArrayList[vertex+1];
            graphVIS = new boolean [vertex+1];
            for (int j =0; j < vertex+1; j++){
                graph [j] = new ArrayList <Integer>();
            }

            //FILLING GRAPH
            for (int x =0; x < domino; x++) {

                input = sc.readLine().split(" ");
                int ver1 = Integer.parseInt(input[0]);
                int ver2 = Integer.parseInt(input[1]);

                graph[ver1].add(ver2);
                graph[ver2].add(ver1);

            }
            //OUTPUT
            int counter =0;
            for (int b =1; b < graph.length; b++){
                if (graphVIS [b] ==false){
                    doBFS(b, graph);
                    counter++;
                }
            }
            System.out.println(counter);

        }
    }


    private static void doBFS(int start, ArrayList<Integer>[] graph) {


        Queue<Integer> fronta = new LinkedList<Integer>();

        //do for start
        fronta.add(start);
        graphVIS [start] = true;

        //do for all others
        while (!(fronta.isEmpty())){

            int proccessed = fronta.poll();

            for (int neighbour : graph [proccessed]){

                if (!(graphVIS [neighbour])){
                    fronta.add(neighbour);
                    graphVIS [neighbour] = true;
                }
            }
        }

    }
}
