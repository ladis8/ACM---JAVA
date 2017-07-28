package ZS_JUDGES;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Ladis on 19.11.2016.
 */
public class UVA_10926_HowManyDependencies {

    private static ArrayList[] graph;
    
    public static void main (String []args ){

        Scanner sc = new Scanner (System.in);
        int scenario;
        while ((scenario = sc.nextInt()) != 0){

            graph = new ArrayList[scenario+1];
            for (int i = 1; i < scenario+1 ; i++) {
                graph [i] = new ArrayList<Integer>();
                int numofdep = sc.nextInt();
                for (int j = 0; j <numofdep; j++) {
                    graph [i].add(sc.nextInt());
                }
            }
            System.out.println(doBFS());
            //printGraph();
        }

    }

    private static int doBFS() {

        int winningnod =0;
        int maxdep =0;

        for (int i = 1; i <graph.length ; i++) {

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(i);
            boolean [] visited = new boolean[graph.length+1];
            int counter =1;

            while (!(queue.isEmpty())){

                int nod = queue.poll();
                for (int j=0; j < graph [nod].size(); j++) {
                    Integer neigh =(Integer) graph [nod].get(j);
                    if (!(visited [neigh])){
                        queue.add(neigh);
                        visited [neigh] = true;
                        counter++;

                    }
                }

            }
            if (counter > maxdep){
                maxdep =counter;
                winningnod = i;
            }

        }

        return winningnod;



    }


    private static void printGraph(){
        for (int i =1; i< graph.length;i++){
            System.out.print(i + ": ");
            for (int j =0; j < graph[i].size();j++){
                System.out.print(graph [i].get(j) + " ");

            }
            System.out.println();
        }
    }
}
