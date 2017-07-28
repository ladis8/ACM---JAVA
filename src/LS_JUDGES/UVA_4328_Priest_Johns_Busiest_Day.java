package LS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class UVA_4328_Priest_Johns_Busiest_Day
{
        private static int[][] s;



        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub


            BufferedReader rd = new BufferedReader (new InputStreamReader(System.in));
            String line = rd.readLine();


            while (!(line.equals("0"))){

                int m = Integer.parseInt(line);
                s = new int[m][4];

                for(int i = 0; i < m; i++){
                    String[] l =rd.readLine().split(" ");



                    s[i][1] = Integer.parseInt(l[0]);
                    s[i][2] = Integer.parseInt(l[1]);
                    s[i][3] = (s[i][2] - s[i][1])/2+1;
                    s[i][0] =  s[i][1] + s[i][3];
                }
                System.out.println(count()? "YES" :"NO");
                line = rd.readLine();
            }
        }



        private static boolean count() {

            Arrays.sort(s, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    Integer a = o1[0];
                    Integer b = o2[0];
                    return a.compareTo(b);
                }
            });

            int midpoint = s[0][0];
            for(int i= 1;i < s.length;i++){

                //the next occasion is far away
                if (s[i][1] >= midpoint ){
                    midpoint = s[i][0];
                }
                else if (midpoint + s[i][3] <= s[i][2]){
                    midpoint += s[i][3];
                }
                else return false;



                //System.out.println("mid"+ s[i][0] + "s" +s[i][1] + "e" + s[i][2]);
            }
            return true;
        }





}
