package LS.JUDGE_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ladislav on 13/03/17.
 */
public class UVA_11573_Ocean_Currents {

    static int [][] map;
    static int [][] distances;
    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String [] c = rd.readLine().split(" ");
        int m  =Integer.parseInt(c[0]); int n = Integer.parseInt(c[1]);
        map = new int [m][n];
        distances = new int [m] [n];


        for (int i = 0; i < m; i++) {
            String line = rd.readLine();
            for (int j = 0; j < n ; j++) {
                map [i][j] = line.charAt(j) - '0';
            }
        }
        int t = Integer.parseInt(rd.readLine());
        //printA(map);

        while (t--> 0){
            c = rd.readLine().split(" ");

            System.out.println(BFS (Integer.parseInt(c[0]) -1, Integer.parseInt(c[1])-1,Integer.parseInt(c[2]) -1, Integer.parseInt(c[3]) -1));

        }


    }

    private static void printA (int [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length ; j++) {
                if (array [i] [j] ==Integer.MAX_VALUE)
                    System.out.print("X ");

                else
                    System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static int BFS(int startx, int starty, int goalx, int goaly) {

        int c[]=        {0,  1,1,1,0,-1,-1,-1};
        int r[]=        {-1,-1,0,1,1, 1, 0,-1};
        int flows[] =   {0,  1,2,3,4, 5, 6, 7};

        for (int i = 0; i < distances.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        Integer[] coor;
        int nx, ny;

        Queue <Integer []> q = new LinkedList<Integer[]>();
        q.add(new Integer[] {startx,starty});
        distances [startx] [starty] = 0;

        Integer [] priority= null;

        while (!q.isEmpty()){
            coor = (priority == null)? q.poll(): priority;
            //printA(distances);

            if (coor [0] == goalx && coor[1] == goaly){
                return distances[goalx] [goaly];
            }
            boolean pr = false;
            for (int i=0; i < r.length; i++){

                nx = coor[0] +r[i];
                ny = coor[1] +c[i];
                if (nx>=0 && ny>=0 && nx< map.length && ny< map[0].length){

                    if (map[coor[0]] [coor[1]] == flows [i] && distances [nx] [ny] > distances [coor[0]] [coor[1]]){
                        distances [nx] [ny] = distances[coor[0]] [coor[1]];
                        priority = new Integer[] {nx,ny};
                        pr = true;
                    }
                    else if (distances [nx] [ny] > distances [coor[0]] [coor[1]]+1){

                        distances [nx] [ny] = distances [coor[0]] [coor[1]]+1;
                        q.add(new Integer [] {nx,ny});
                    }

                }
            }
            //System.out.println(priority [0]+" "+ priority[1]);
            if (!pr) {
                priority=null;
            }

        }

        return -1;
    }

}
