package JUDGE_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ladislav on 03/04/17.
 */
public class UVA_11624_Fire {




    static int [][] map;
    static Integer [][] distancesfire;
    static Integer [][] distancesjoe;

    static int startxjoe,startyjoe;
    static ArrayList<Integer> startxfire= new ArrayList<Integer>();
    static ArrayList<Integer> startyfire= new ArrayList<Integer>();
  


    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(rd.readLine());


        while (tests--> 0){

            String [] c = rd.readLine().split(" ");
            int m  =Integer.parseInt(c[0]); int n = Integer.parseInt(c[1]);
            map = new int [m][n];
            distancesfire = new Integer [m+2] [n+2];
            distancesjoe = new Integer[m+2] [n+2];


            for (int i = 0; i < m; i++) {
                String line = rd.readLine();
                for (int j = 0; j < n ; j++) {
                    switch (line.charAt(j)){
                        case '.':
                            map [i][j]= 1;
                            break;
                        case '#':
                            map [i][j]= 0;
                            break;
                        case 'J':
                            startxjoe = i; startyjoe=j;
                            map [i][j]= 1;

                            break;
                        case 'F':
                            startxfire.add(i); startyfire.add(j);
                            map [i][j]= 1;
                            break;

                    }
                }
            }
            //printA(map);
            int a;

            System.out.println((a =BFS())==-1 ? "IMPOSSIBLE" : a);
            startxfire.clear();
            startyfire.clear();
        }



    }

    private static void printA (int [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length ; j++) {
                if (array [i] [j] ==Integer.MAX_VALUE)
                    System.out.print("X");

                else
                    System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static int BFS() {

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(distancesfire[i], -1);
            Arrays.fill(distancesjoe[i], -1);
        }

        int [] dx = {1,0,0,-1};
        int [] dy = {0,1,-1,0};
        int m = map.length;
        int n = map[0].length;

        Integer[] coor;
        int nx, ny;

        Queue<Integer []> q = new LinkedList<Integer[]>();
        for (int i = 0; i< startxfire.size(); i++){
            q.add(new Integer[] {startxfire.get(i),startyfire.get(i),1}); //fire goes first
            distancesfire [startxfire.get(i)] [startyfire.get(i)] = 0;
        }
        q.add(new Integer[] {startxjoe,startyjoe,2});
        distancesjoe [startxjoe] [startyjoe] = 0;


        while (!q.isEmpty()){
            coor =  q.poll();
            //printA(distances);
            int x = coor[0];
            int y = coor[1];
            int p = coor[2];

            if (p==2 && (x== 0 || y==0 || x==m-1 || y==n-1)){
                return distancesjoe[x][y]+1;
            }

            for (int i=0; i < dx.length; i++){

                nx = x +dx[i];
                ny = y +dy[i];

                if (nx <0 || ny <0 || nx> m-1 || ny> n-1 || map [nx][ny] ==0) //passable point
                    continue;


                if (p==1 && distancesfire[nx][ny]==-1){
                    distancesfire[nx][ny]=distancesfire[x][y] +1;
                    q.add(new Integer[]{nx,ny,1});
                }
                else if (p==2 && distancesfire[nx][ny]==-1 && distancesjoe[nx][ny]==-1){
                    distancesjoe[nx][ny]=distancesjoe[x][y]+1;
                    q.add(new Integer[]{nx,ny,2});
                }
            }
        }


        return -1;
    }
}
