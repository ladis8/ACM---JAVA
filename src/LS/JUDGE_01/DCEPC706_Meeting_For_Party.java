package LS.JUDGE_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ladislav on 14/03/17.
 */
public class DCEPC706_Meeting_For_Party {



        static int [][] map;
        static Integer [][] distances1;
        static Integer [][] distances2;
        static Integer [][] distances3;
        static ArrayList<Integer[][]> distances;
        static int startx1,startx2,startx3;
        static int starty1,starty2,starty3;


        public static void main(String[] args) throws IOException {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            int tests = Integer.parseInt(rd.readLine());


            while (tests--> 0){

                String [] c = rd.readLine().split(" ");
                int m  =Integer.parseInt(c[0]); int n = Integer.parseInt(c[1]);
                map = new int [m+4][n+4];
                distances1 = new Integer [m+4] [n+4];
                distances2 = new Integer[m+4] [n+4];
                distances3 = new Integer[m+4] [n+4];
                distances = new ArrayList<Integer[][]>();
                distances.add(distances1);
                distances.add(distances2);
                distances.add(distances3);

                for (int i = 0; i < map[0].length; i++) {
                    map [0][i]=0;
                    map [1][i]=1;
                    map[m+2][i]=1;
                    map[m+3][i]=0;
                }
                for (int i = 0; i < map.length; i++) {
                   if (i!= 0 && i!=m+3){
                    map[i] [1]=1;
                    map[i][n+2] =1;
                   }

                    map [i][0] = 0;
                    map [i][n+3]=0;
                }

                for (int i = 2; i < m+2; i++) {
                    String line = rd.readLine();
                    for (int j = 2; j < n+2 ; j++) {
                        switch (line.charAt(j-2)){
                            case '.':
                                map [i][j]= 1;
                            break;
                            case '#':
                                map [i][j]= 0;
                            break;
                            case '1':
                                startx1 = i; starty1=j;
                                map [i][j]= 1;

                            break;
                            case '2':
                                startx2 = i; starty2=j;
                                map [i][j]= 1;
                            break;
                            case '3':
                                startx3 = i; starty3=j;
                                map [i][j]= 1;
                            break;
                        }
                    }
                }
                //printA(map);
                System.out.println(BFS());
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

            for (int i = 0; i < distances1.length; i++) {
                Arrays.fill(distances1[i], -1);
                Arrays.fill(distances2[i], -1);
                Arrays.fill(distances3[i], -1);
            }

            int [] dx = {1,0,0,-1};
            int [] dy = {0,1,-1,0};


            Integer[] coor;
            int nx, ny, people;

            Queue<Integer []> q = new LinkedList<Integer[]>();
            q.add(new Integer[] {startx1,starty1,1});
            q.add(new Integer[] {startx2,starty2,2});
            q.add(new Integer[] {startx3,starty3,3});

            distances1 [startx1] [starty1] = 0;
            distances2 [startx2] [starty2] = 0;
            distances3 [startx3] [starty3] = 0;


            while (!q.isEmpty()){
                coor =  q.poll();
                //printA(distances);
                int x = coor[0];
                int y = coor[1];
                int p = coor[2];

                if (distances1[x][y]!=-1 &&distances2[x][y]!=-1 && distances3[x][y]!=-1){
                    return Math.max(distances1[x][y],Math.max(distances2[x][y],distances3[x][y]));
                }

                for (int i=0; i < dx.length; i++){

                    nx = x +dx[i];
                    ny = y +dy[i];


                        if (distances.get(p-1)[nx][ny]==-1 && map [nx][ny]==1){
                            distances.get(p-1)[nx][ny]=distances.get(p-1)[x][y] +1;
                            q.add(new Integer[]{nx,ny,p});
                        }
                    }
                }


            return -1;
        }

}


