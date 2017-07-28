package ZS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Ladis on 2.12.2016.
 */
public class SPOJ_BYTESM2_PhilosophersStone {
    
    private static int [] [] pattern;
    private static int column, row;
    
    public static void main (String [] args)throws IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numoftestcases = Integer.parseInt(in.readLine());

        for (int test = 0; test < numoftestcases; test++) {

            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            row = Integer.parseInt(tokenizer.nextToken());
            column  = Integer.parseInt(tokenizer.nextToken());

            pattern = new int [row][column];
            for (int i = 0; i < row; i++) {
                tokenizer = new StringTokenizer(in.readLine());
                for (int j = 0; j < column; j++) {
                    if (tokenizer.hasMoreTokens())
                        pattern [i] [j] = Integer.parseInt(tokenizer.nextToken());

                }
            }

            countTheBiggest();
        }
        
        
        
    }

    public static void countTheBiggest(){
        //copy the first row

        int [][] distancearray = new int [row][column];

        for (int i = 0; i < column; i++) {
            distancearray [0] [i] = pattern [0] [i];
        }

        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j <column ; j++) {
                for (int x=-1;x <=1;x++){

                    if (j+x >=0 && j+x < column) {
                       // System.out.println(x);
                        if (distancearray [i+1][j+x] < distancearray [i][j] + pattern [i+1][j+x] ){
                            distancearray [i+1][j+x] = distancearray [i][j] + pattern [i+1][j+x];
                        }
                    }
                }

            }
            //printA(distancearray);
        }
        int max = 0;
        for (int i = 0; i < column; i++) {
            if (max < distancearray [row-1][i]){
               max = distancearray [row-1] [i];
            }

        }

        System.out.println(max);

    }

    private static void printA (int [][]a ){
        System.out.println();
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j <a [0].length ; j++) {
                System.out.print(a [i][j] + " ");

            }
            System.out.println();

        }
    }
}
