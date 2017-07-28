package LS_JUDGES;

import java.io.*;
import java.util.*;

/**
 * Created by Ladis on 12.3.2017.
 */
public class UVA_532_DungeonMaster {



        private static int [][][] array;
        private static int [] goal, start;

        public static void main (String [] args) throws IOException {

           BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
           String in = sc.readLine();

           while (!(in.equals("0 0 0"))) {

                String[] des = in.split(" ");
                int l = Integer.parseInt(des[0]);
                int m = Integer.parseInt(des[1]);
                int n = Integer.parseInt(des[2]);

               array = new int[m][n][l];

                for (int x =0; x < l;x++){
                    for (int i = 0; i < m; i++) {
                        in = sc.readLine();
                        for (int j = 0; j < n; j++) {
                            if (in.charAt(j) == '.')
                                array[i][j][x] = -1;
                            else if (in.charAt(j) == '#')
                                array[i][j][x] = 0;
                            else if (in.charAt(j)=='S'){
                                start = new int []{i,j,x};
                                array[i][j][x] = 0;

                            }
                            else if (in.charAt(j)=='E'){
                                goal = new int[]{i,j,x};
                                array[i][j][x] = -1;
                            }
                        }
                    }
                    sc.readLine();
                }
               //printArray();
               int out = doBFS();
               if (out != -1)
                   System.out.printf("Escaped in %d minute(s).\n",out);
               else
                   System.out.println("Trapped!");

               //printArray();
               in = sc.readLine();
            }
        }

        private static void printArray(){
            for (int x =0; x < array[0][0].length;x++) {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {

                        System.out.print(array[i][j][x] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
    }

        private static int doBFS( ) {


            Queue<Integer[]> fronta = new ArrayDeque<Integer[]>();

            Integer[] s = {start[0],start[1],start[2]};
            fronta.add(s);

            int r,c,l;
            Integer[] temp;
            while (!(fronta.isEmpty())) {

                Integer [] proccessed = fronta.poll();
                int [][] coor = {{1,0,0},{0,1,0},{-1,0,0},{0,-1,0},{0,0,1},{0,0,-1}};

                //System.out.println(goal[0]+" "+ goal[1]+ " "+ goal[2]);
                //System.out.println(proccessed[0]+" "+ proccessed[1]+ " "+ proccessed[2]);
                if (proccessed[0] == goal[0] && proccessed [1]==goal[1] && proccessed [2]==goal[2])
                    return array[proccessed[0]][proccessed[1]][proccessed[2]];

                    for (int [] co:coor){
                        r = proccessed[0] + co[0];
                        c =proccessed[1] + co[1];
                        l = proccessed[2] +co[2];
                        try{
                            // if ((r >= 0 && r < array.length)&& (c >=0 && c < array[0].length) && (l>=0 && l< array[0][0].length)){
                            if (array [r][c][l]== -1) {
                                fronta.add(new Integer[]{r,c,l});
                                array[r][c][l] = array[proccessed[0]][proccessed[1]][proccessed[2]] +1;
                            }
                        }
                        catch(Exception e) {
                        }
                    }
                }
            return -1;

        }

}
