package LS_JUDGES.NOT_SOLVED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by stefk on 6.4.2017.
 */
public class UVA_NOTSOLVED_2827_PhoneHome {

    private static int [][] graph;
    private static int [] colours;

    public static float getdistance(float x1, float x2, float y1, float y2){
        return  (x2-x1) * (x2-x1) + (y2-y1)* (y2-y1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int towers = Integer.parseInt(rd.readLine());
        int test =0;




        while (towers !=0){
            test++;
            /*float [] x = new float[towers];
            float[] y = new float [towers];
            graph = new int [towers] [towers];


            String[] input = rd.readLine().split(" ");
            for (int i = 0; i < towers; i++) {
                x[i] = Float.parseFloat(input[2 * i]);
                y[i] = Float.parseFloat(input [2 * i + 1]);
            }


            for (int i = 0; i < towers-1; i++){
                for (int j = i+1; j < towers; j++){

                    if (getdistance(x[i], x[j], y[i], y[j])<= 400){
                        graph [i] [j] = 1;
                        graph [j] [i]= 1;
                    }
                    else{
                        graph [i] [j] = 0;
                        graph [j] [i]= 0;
                    }
                }
            }*/

            //printgraph(towers);
           // graph = new int[][]{{0, 1, 0,0}, {1, 0, 1,0}, {0, 1,0, 1},{0,0,1,0}};
            graph = new int[][]{{0}};
            towers = 1;
            System.out.printf("The towers in case %d can be covered in %d frequencies.\n", test,countcolors(towers));
            towers = Integer.parseInt(rd.readLine());


        }


    }

    private static void printgraph(int nodes) {
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j <nodes ; j++) {
                System.out.print(graph[i][j] +" ");
            }
            System.out.println();

        }
    }

    private static boolean colournext(int nodes, int current, int maxcolours, int depth) {

        int currentcolour = colours[current];


        for (int i = 0; i < nodes; i++) {

            if (graph[current][i] == 1) { //neighbour
                if (colours[i] == colours[current]) {//matching colours
                    return false;
                }
                if (colours[i] == -1) {//not coloured
                    for (int nextcolour = 0; nextcolour < maxcolours; nextcolour++) {
                        if (nextcolour != currentcolour) {
                            colours[i] = nextcolour;
                            if (colournext(nodes, i,maxcolours,depth++))
                                return true;
                        }

                    }
                    colours[i]=-1; //change the colour back
                    return false; //colouring was not successful
                }
            }
        }
        return true;
    }

    private static int countcolors(int nodes) {


        for (int col = 1; col <=4 ; col++) {

            colours = new int [nodes];
            Arrays.fill(colours, -1);
            boolean ispossible=true;
            for (int i = 0; i <nodes ; i++) {
                if (colours[i]==-1){
                    colours [i] = 0; //colour the first node
                    if (!colournext(nodes,i,col,0)){
                        ispossible=false;
                        break;
                    }
                }
            }
            if (ispossible){
                return col;
            }
        }
        return 5;

        }

}
